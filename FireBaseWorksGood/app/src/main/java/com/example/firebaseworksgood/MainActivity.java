 package com.example.firebaseworksgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


 public class MainActivity extends AppCompatActivity {

   private Button logOut,add;
    private EditText edit;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit=findViewById(R.id.edit);
        add=findViewById(R.id.add);
        logOut=findViewById(R.id.logOut);
        listView = findViewById(R.id.listview);


        logOut.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,StartActivity.class));
            finish();
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_Name = edit.getText().toString();
                if (txt_Name.isEmpty()){
                    Toast.makeText(MainActivity.this, "No name", Toast.LENGTH_SHORT).show();
                }else {
                    FirebaseDatabase.getInstance().getReference()
                            .child("languages") .child("name").setValue(txt_Name);
                }
            }
        });
      // FirebaseDatabase.getInstance().getReference().child("azzeddinebeyoud").child("android").push().setValue("abcd");
        // FirebaseDatabase.getInstance().getReference().child("souhilabey").child("ios").push().setValue("xcvb");

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_item,list);
        listView.setAdapter(adapter);

        //this line for tak the root hadak l7aja lawala li tkon fiha null m3a lawal
        DatabaseReference reference =
                FirebaseDatabase.getInstance().getReference().child("Information");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list.clear();
                for (DataSnapshot snapshot : datasnapshot.getChildren()){

                    Information info = snapshot.getValue(Information.class);
                    String txt = info.getName() +" : "+ info.getEmail();
                    list.add(txt);

//                    list.add(snapshot.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}

//     //this line for tak the root hadak l7aja lawala li tkon fiha null m3a lawal
//     DatabaseReference reference =
//             FirebaseDatabase.getInstance().getReference().child("Information");
//
//        reference.addValueEventListener(new ValueEventListener() {
// @Override
// public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//         list.clear();
//         for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//
//         Information info = snapshot.getValue(Information.class);
//         String txt = info.getName() +" : "+ info.getEmail();
//         list.add(txt);
//         }
//         adapter.notifyDataSetChanged();
//         }
