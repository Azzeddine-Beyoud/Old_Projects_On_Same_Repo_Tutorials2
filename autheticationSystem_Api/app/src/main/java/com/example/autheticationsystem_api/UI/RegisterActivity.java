package com.example.autheticationsystem_api.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class RegisterActivity extends AppCompatActivity {

    private EditText fullname , email , password ;
    private Button buttonRgister;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname =findViewById(R.id.registerNameText);
        email =findViewById(R.id.registerEmailText);
        password =findViewById(R.id.registerPasswordText);
        buttonRgister =findViewById(R.id.buttonRegister);
        progressBar =findViewById(R.id.progressBarRegister);

        buttonRgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    public  void registerUser(){
        final String myName = fullname.getText().toString().trim();
        final String myEmail = email.getText().toString().trim();
        final String mypassword = password.getText().toString().trim();

        if (TextUtils.isEmpty(myName)){
            fullname.setError("Enter your Name please");
            fullname.requestFocus();
            return;
        }

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



        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.VISIBLE);

                        try {
                            JSONObject obj = new JSONObject(response);
                            if (obj.getBoolean("success")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"),
                                        Toast.LENGTH_SHORT).show();

                                //get user information and save that in mobile
                                JSONObject userJson = obj.getJSONObject("data");
                                User user = new User(userJson.getString("token"));

                                //record with sessionManager
                                SessionManager.getInstance(getApplicationContext()).userlogin(user);
                                finish();

                                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                            } else {

                                Toast.makeText(getApplicationContext(), obj.getString("message"),
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
        protected Map<String,String> getParams() throws AuthFailureError{

            Map<String,String> params = new HashMap<>();
            params.put("Content-Type","application/json");
            params.put("name",myName);
            params.put("email",myEmail);
            params.put("password",mypassword);

            params.put("C_password",mypassword);
            return params;
        }
    };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);


    }















}