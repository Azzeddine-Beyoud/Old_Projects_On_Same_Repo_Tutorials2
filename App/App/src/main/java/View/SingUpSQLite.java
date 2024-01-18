package View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.app.MainActivity;
import com.example.app.Mechanic;
import com.example.app.Painter;
import com.example.app.Plumber;
import com.example.app.ProfileFragment;
import com.example.app.R;

import Controller.DatabaseHelper;
import Modul.ListPerson;

public class SingUpSQLite extends AppCompatActivity {

    private  DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_s_q_lite);


        String [] job={"Painter","Plumber","Mechanic"};
        String [] type={"User","Craftsman"};


        final EditText emailaddress=(EditText) findViewById(R.id.emailaddress);
        final EditText name=(EditText)findViewById(R.id.name);
        final EditText lastname=(EditText)findViewById(R.id.lastname);
        final EditText password=(EditText)findViewById(R.id.creatpasssword);
        final EditText phonenumber=(EditText)findViewById(R.id.Phonenumber);
        final EditText age=(EditText)findViewById(R.id.age);
        final EditText site=(EditText)findViewById(R.id.site);
        Button singup=(Button)findViewById(R.id.singup);

        final Spinner work=(Spinner)findViewById(R.id.work);
        final Spinner typo=(Spinner)findViewById(R.id.type);




        final Intent main = new Intent(this, MainActivity.class);

          db = new DatabaseHelper(this);

//          work.setEnabled(false);


        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,job);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        work.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterspinner2=new ArrayAdapter(this,android.R.layout.simple_spinner_item,type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typo.setAdapter(adapterspinner2);



        if(typo.getSelectedItem().toString().equals("Craftsman")){
            work.setVisibility(View.VISIBLE);
            work.setEnabled(true);
        }
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailaddress.getText().toString();
                String namevalue = name.getText().toString();
                String lastnamevalue = lastname.getText().toString();
                String passwordvalue = password.getText().toString();
                String phonenumbervaleu = phonenumber.getText().toString();
                String agevalue = age.getText().toString();
                String city = site.getText().toString();

                if(typo.getSelectedItem().toString().equals("User")){

                   // work.setVisibility(View.INVISIBLE);
                }else {

                    if (typo.getSelectedItem().toString().equals("Craftsman")) {

                        // work.setVisibility(View.VISIBLE);
                        if (work.getSelectedItem().toString().equals("Painter")) {
                            Painter.painteritems.add(new ListPerson( name.getText().toString(), lastname.getText().toString(), phonenumber.getText().toString(), site.getText().toString()));
                        } else {
                            if (work.getSelectedItem().toString().equals("Plumber")) {
                                Plumber.plumberitems.add(new ListPerson( name.getText().toString(), lastname.getText().toString(), phonenumber.getText().toString(), site.getText().toString()));

                            } else {
                                if (work.getSelectedItem().toString().equals("Mechanic")) {
                                    Mechanic.mechanicitems.add(new ListPerson( name.getText().toString(), lastname.getText().toString(), phonenumber.getText().toString(), site.getText().toString()));

                                }
                            }
                        }


                        db.insertData(new ListPerson(email, namevalue, lastnamevalue, passwordvalue, phonenumbervaleu, Integer.parseInt(agevalue), city));

                        main.putExtra("email",email);
                        main.putExtra("namevalue",namevalue);
                        main.putExtra("namevalue",namevalue);
                        main.putExtra("lastnamevalue",lastnamevalue);
                        main.putExtra("phonenumbervaleu",phonenumbervaleu);
                        main.putExtra("age",agevalue);
                        main.putExtra("city",city);


//                        Bundle bundle = new Bundle();
//                        bundle.putString("email",email);
//                        bundle.putString("namevalue",namevalue);
//                        bundle.putString("lastnamevalue",lastnamevalue);
//                        bundle.putString("phonenumbervaleu",phonenumbervaleu);
//                        bundle.putString("age",agevalue);
//                        bundle.putString("city",city);
//                        ProfileFragment profilvalue= new ProfileFragment();
//                        profilvalue.setArguments(bundle);

                        startActivity(main);


                    }
                }


            }
       });

}
}




