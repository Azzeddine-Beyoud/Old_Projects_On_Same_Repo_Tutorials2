package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Welcome extends AppCompatActivity {
static int Time=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
      final Intent home=new Intent(this,MainActivity.class);
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            startActivity(home);
            finish();
        }
    },Time);





    }
}
