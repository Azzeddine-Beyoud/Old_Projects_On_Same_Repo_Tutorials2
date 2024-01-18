package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.app.Painter.painteritems;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

     String [] job={"Painter","Plumber","Mechanic"};
      String [] type={"Craftsman","User"};

        Button b1=(Button)findViewById(R.id.button);
        final EditText firstname=(EditText)findViewById(R.id.firstname);
        final EditText lastname=(EditText)findViewById(R.id.familyname);
        final EditText phonenumber=(EditText)findViewById(R.id.numberPhone);
        final EditText site=(EditText)findViewById(R.id.site);

        final Intent main=new Intent(this,MainActivity.class);

        final Spinner work=(Spinner)findViewById(R.id.work);
       final Spinner typo=(Spinner)findViewById(R.id.type);

        final DBBcon db=new DBBcon(this);

work.setEnabled(false);





         ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,job);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        work.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapterspinner2=new ArrayAdapter(this,android.R.layout.simple_spinner_item,type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typo.setAdapter(adapterspinner2);

        if(typo.getSelectedItem().toString().equals("Craftsman")){
            work.setEnabled(true);
        } else {
            work.setEnabled(false);
        }






        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(typo.getSelectedItem().toString().equals("Craftsman")){



                    if(work.getSelectedItem().toString().equals("Painter")) {
                       Painter.painteritems.add(new list(firstname.getText().toString(), lastname.getText().toString(), phonenumber.getText().toString(), site.getText().toString()));
                    }else {
                        if (work.getSelectedItem().toString().equals("Plumber")) {
                            Plumber.plumberitems.add(new list(firstname.getText().toString(), lastname.getText().toString(), phonenumber.getText().toString(), site.getText().toString()));

                        } else {
                            if (work.getSelectedItem().toString().equals("Mechanic")) {
                                Mechanic.mechanicitems.add(new list(firstname.getText().toString(), lastname.getText().toString(), phonenumber.getText().toString(), site.getText().toString()));

                            }
                        }
                    }


                }


        //        db.inserttodbb(firstname.getText().toString(),lastname.getText().toString(),site.getText().toString(),phonenumber.getText().toString());



                startActivity(main);

            }
        });




    }
}