package View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.app.R;

import Controller.DatabaseHelper;
import Modul.ListPerson;

public class SingUpSQLite extends AppCompatActivity  {


    Intent Login;
    private  DatabaseHelper db;
    public Spinner work,typo,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_s_q_lite);

        String [] job={"Painter","Plumber","Mechanic"};
        String [] type={"Craftsman","User"};
        String [] wilaya={"adrar","Chlef","laghouat","Oum El Bouaghi","Batna","Bejaia","Biskra","Bechar","Bouira","Tamanrasset","Tebessa","Tlemcen","Tiart","Tizi Ouzou","Alger","Djelfa","Jijel","Setif","Saida","Skikda","Sidi Bel Abbes","Annaba","Guelma","Constantine","Medea","Mostaganem","M'sila","Mascara","Ouargla","Oran","Bayadh","illizi","Bordj Bou Arreridj","Boumerdes","Tarf","tindouf","Tissemsilt","Oued","Khenchela","Souk ahras","Tipaza","Mila","Naama","Temouchent","Ghardaia","Relizane"};

        final EditText emailaddress=(EditText) findViewById(R.id.emailaddress);
        final EditText lastname=(EditText)findViewById(R.id.lastname);
        final EditText username=(EditText)findViewById(R.id.username);
        final EditText password=(EditText)findViewById(R.id.creatpasssword);
        final EditText phonenumber=(EditText)findViewById(R.id.phonenumber);
        Button singup=(Button)findViewById(R.id.singup);

         work=(Spinner)findViewById(R.id.work);
         typo=(Spinner)findViewById(R.id.type);
         state=(Spinner)findViewById(R.id.site);

         Login=new Intent(this, LoginSQLite.class);
          db = new DatabaseHelper(this);

////////////////////////////////////
        ////////////////////////////////
        /////////////////////////////////
        //////////////////////////////////
        /////////////////////////////////Creation des Spinners


        ArrayAdapter<CharSequence> adapterwok=new ArrayAdapter(this,android.R.layout.simple_spinner_item,job);
        adapterwok.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        work.setAdapter(adapterwok);

        ArrayAdapter<CharSequence> adaptertype=new ArrayAdapter(this,android.R.layout.simple_spinner_item,type);
        adaptertype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typo.setAdapter(adaptertype);

        ArrayAdapter<CharSequence> adapterwilaya=new ArrayAdapter(this,android.R.layout.simple_spinner_item,wilaya);
        adapterwilaya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(adapterwilaya);




        ////////////////////////////////////
        ////////////////////////////////////
        //////////////////////////////////
        /////////////////////////////////spinner (type de la person ) on Selected Item
  typo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    if(typo.getSelectedItem().toString().equals("Craftsman")){
        work.setVisibility(View.VISIBLE);
    }else{
        work.setVisibility(View.INVISIBLE);
    }
}



      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
  });










  ////////////////////////////////////
        /////////////////////////////////
        ///////////////////////////////
        //////////////////////////////Button On Click


        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailaddress.getText().toString();
                String name = username.getText().toString();
                String lastnamevalue = lastname.getText().toString();
                String passwordvalue = password.getText().toString();
                String phonenumbervaleu = phonenumber.getText().toString();


                if (!emailaddress.getText().toString().equals("")) {
                    if (!lastname.getText().toString().equals("")) {
                        if (!username.getText().toString().equals("")) {
                            if (!phonenumber.getText().toString().equals("")) {
                                if (!password.getText().toString().equals("")) {
                                        if (!db.checkEmail(email)) {
                                            if (!db.checkUserName(name)) {
                                                if (!db.checkPhoneNumber(phonenumbervaleu)) {

                                                    if (typo.getSelectedItem().toString().equals("Craftsman")) {

                                                        if (work.getSelectedItem().toString().equals("Painter")) {
                                                            db.insertDataPainter(new ListPerson(email, passwordvalue, name, lastnamevalue, phonenumbervaleu, state.getSelectedItem().toString(), "Painter"));
                                                        } else {
                                                            if (work.getSelectedItem().toString().equals("Plumber")) {
                                                                db.insertDataPlumber(new ListPerson(email, passwordvalue, name, lastnamevalue, phonenumbervaleu, state.getSelectedItem().toString(), "Plumber"));

                                                            } else {
                                                                if (work.getSelectedItem().toString().equals("Mechanic")) {
                                                                    db.insertDataMechanic(new ListPerson(email, passwordvalue, name, lastnamevalue, phonenumbervaleu, state.getSelectedItem().toString(), "Mechanic"));

                                                                }
                                                            }
                                                        }
                                                        db.insertData(new ListPerson(email, passwordvalue, name, lastnamevalue, phonenumbervaleu, state.getSelectedItem().toString(), work.getSelectedItem().toString()));
                                                        startActivity(Login);


                                                    } else {
                                                        if (typo.getSelectedItem().toString().equals("User")) {
                                                            db.insertData(new ListPerson(email, passwordvalue, name, lastnamevalue, phonenumbervaleu, state.getSelectedItem().toString()));
                                                            startActivity(Login);
                                                        }
                                                    }


                                                } else {
                                                    phonenumber.setText("");
                                                    Toast.makeText(getApplicationContext(), "PhoneNumber Already Taken", Toast.LENGTH_LONG).show();
                                                }
                                            } else {
                                                username.setText("");
                                                Toast.makeText(getApplicationContext(), "UserName Already Taken", Toast.LENGTH_LONG).show();
                                            }
                                        } else {
                                            emailaddress.setText("");
                                            Toast.makeText(getApplicationContext(), "Email has Already Been Taken", Toast.LENGTH_LONG).show();
                                        }


                            } else {
                                Toast.makeText(getApplicationContext(), "you Need to Type your PassWord", Toast.LENGTH_LONG).show();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "you Need to Type your Phone Number", Toast.LENGTH_LONG).show();

                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "you Need to Type your UserName", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "you Need To Type your Last Name", Toast.LENGTH_LONG).show();
                }

            }else

            {


                Toast.makeText(getApplicationContext(), "you Need to Type your Email Address", Toast.LENGTH_LONG).show();
            }



            }///on click
       });//setonclick


    }




}



