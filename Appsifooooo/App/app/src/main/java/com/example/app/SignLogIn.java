package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.app.Painter.painteritems;

public class SignLogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_log_in);

        Button login=(Button)findViewById(R.id.Login);
        Button signup=(Button)findViewById(R.id.signup);

      final   Intent sign=new Intent(this,SignUp.class);
      final   Intent log=new Intent(this,login.class);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(sign);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(log);
            }
        });


    }
}
