package com.example.realtime_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     private EditText edit_name ,position;
    private Button blogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name=findViewById(R.id.emailLog);
        position= findViewById(R.id.passwordLog);
        blogin=findViewById(R.id.login);

        DAOEmployee dao = new DAOEmployee();

        blogin.setOnClickListener(view -> {

            Employee emp = new Employee(edit_name.getText().toString(),position.getText().toString());

            dao.add(emp).addOnSuccessListener(suc ->{

                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();

        }).addOnFailureListener(er->{

                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });
    }
}