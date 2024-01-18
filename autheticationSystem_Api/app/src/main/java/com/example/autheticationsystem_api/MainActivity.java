  package com.example.autheticationsystem_api;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.autheticationsystem_api.Modul.Book;
import com.example.autheticationsystem_api.SERVER.URLs;
import com.example.autheticationsystem_api.UI.AddData;
import com.example.autheticationsystem_api.UI.LoginActivity;
import com.example.autheticationsystem_api.controler.Adapter;
import com.example.autheticationsystem_api.controler.SessionManager;
import com.example.autheticationsystem_api.controler.VolleySingleton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

  public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static Adapter adapter;
    private List<Book>bookList;
    private RequestQueue queue ;

    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        queue = Volley.newRequestQueue(this);
        if (SessionManager.getInstance(this).isLoggedIn()){

            if (SessionManager.getInstance(this).getToken() != null){
                token= SessionManager.getInstance(this).getToken().getToken();
            }
        }else {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            return;
        }

        recyclerView = findViewById(R.id.recyclarView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookList = new ArrayList<>();
        bookList= getData();
        adapter = new Adapter(this,bookList);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(MainActivity.this, AddData.class);

                startActivity(intent);
                finish();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SessionManager.getInstance(this).userlogout();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public static void notifyAdapter(){
        adapter.notifyDataSetChanged();
    }


    public List<Book> getData(){

        bookList.clear();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, URLs.URL_DELETE_DATA,null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray bookArray = response.getJSONArray("data");

                    for (int i = 0; i < bookArray.length(); i++) {
                        JSONObject bookObj = bookArray.getJSONObject(i);
                        Book book = new Book();
                        book.setId(bookObj.getInt("id"));
                        book.setName(bookObj.getString("name"));
                        book.setAuthor(bookObj.getString("author"));
                        book.setCreated_at(bookObj.getString("created_at"));

                        bookList.add(book);
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }


                } catch (JSONException e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            public Map<String,String> getHeaders(){

                Map<String,String> pramas = new HashMap<>();
                pramas.put("Accept","Application/json");
                pramas.put("Authorisation","bearer  "+token);

                return pramas;
        }
        }

                ;
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        return bookList;

    }






}