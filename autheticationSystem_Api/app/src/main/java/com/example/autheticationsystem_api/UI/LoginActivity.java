package com.example.autheticationsystem_api.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.autheticationsystem_api.MainActivity;
import com.example.autheticationsystem_api.Modul.User;
import com.example.autheticationsystem_api.R;
import com.example.autheticationsystem_api.SERVER.URLs;
import com.example.autheticationsystem_api.controler.SessionManager;
import com.example.autheticationsystem_api.controler.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText  email , password ;
    private Button buttonRgister,buttonLogin;
    private ProgressBar progressBar;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email =findViewById(R.id.LogineditText);
        password =findViewById(R.id.logineditText2);
        buttonRgister =findViewById(R.id.button2Register);
        buttonLogin =findViewById(R.id.buttonLogin);
        progressBar =findViewById(R.id.progressBarLogin);

        buttonRgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity( new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void userLogin(){


        final String myEmail = email.getText().toString().trim();
        final String mypassword = password.getText().toString().trim();


        if (TextUtils.isEmpty(myEmail)){
            email.setError("Enter your email please");
            email.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(mypassword)){
            password.setError("Enter your password please");
            password.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_login ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.VISIBLE);

                        try {
                            JSONObject obj = new JSONObject(response);
                            if (obj.getJSONObject("success") != null) {
                                Toast.makeText(getApplicationContext(),"Welcome",
                                        Toast.LENGTH_SHORT).show();

                                //get user information and save that in mobile
                                JSONObject userJson = obj.getJSONObject("success");
                                User user = new User(userJson.getString("token"));

                                //record with sessionManager
                                SessionManager.getInstance(getApplicationContext()).userlogin(user);
                                finish();

                                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                            } else {

                                Toast.makeText(getApplicationContext(), "Login faild",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage() ,
                                Toast.LENGTH_SHORT).show();
                    }
                }
        )
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("Content-Type","application/json");
                params.put("email",myEmail);
                params.put("password",mypassword);

                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);



    }












}