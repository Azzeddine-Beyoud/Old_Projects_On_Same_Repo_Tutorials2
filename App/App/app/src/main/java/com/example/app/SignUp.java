package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.app.Painter.painteritems;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button b1=(Button)findViewById(R.id.button);
        final EditText firstname=(EditText)findViewById(R.id.firstname);
        final EditText lastname=(EditText)findViewById(R.id.familyname);
        final EditText phonenumber=(EditText)findViewById(R.id.numberPhone);
        final EditText site=(EditText)findViewById(R.id.site);
final Intent main=new Intent(this,MainActivity.class);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                painteritems.add(new list(firstname.getText().toString(),lastname.getText().toString(),phonenumber.getText().toString(),site.getText().toString()));
                startActivity(main);

            }
        });




    }
}