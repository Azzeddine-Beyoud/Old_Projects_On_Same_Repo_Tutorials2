package com.example.firebaseworksgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class StartActivity extends AppCompatActivity {

    private Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        register= findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener(v -> {
            startActivity(new Intent(StartActivity.this , RegisterActivity.class));
            finish();
        });

        login.setOnClickListener(v -> {
            startActivity(new Intent(StartActivity.this , LoginActivity.class));
            finish();
        });

        //FirebaseDatabase.getInstance().getReference().child("azzeddinebeyoud").child("android").setValue("abcd");
        HashMap<String , Object> map = new HashMap<>();
        map.put("Name","xavi");
        map.put("Email","azzo07@hotmail.fr");

        FirebaseDatabase.getInstance().getReference().child("programming").child("multiplevaleus").updateChildren(map);
    }


}