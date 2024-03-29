package com.example.exemple_firestore_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ///////////////// ----- this code for ** Multiple Notes ** -----///////////////////
    private static final String TAG = "MainActivity";

    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private TextView textViewData;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Notebook");
    private DocumentReference noteRef = db.document("Notebook/My First Note");
    //or
    //private DocumentReference noteRef = db.collection("Notebook").document("My First Note");

    //noteRef = db.document("Notebook/My First Note") = db.collection("Notebook").document("My First Note");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        textViewData = findViewById(R.id.text_view_data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (e != null) {
                    return;
                }
                String data = "";
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    Note note = documentSnapshot.toObject(Note.class);
                    note.setDocumentId(documentSnapshot.getId());
                    String documentId = note.getDocumentId();
                    String title = note.getTitle();
                    String description = note.getDescription();
                    data += "ID: " + documentId
                            + "\nTitle: " + title + "\nDescription: " + description + "\n\n";
                }
                textViewData.setText(data);
            }
        });
    }

    public void addNote(View v) {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();

        Note note = new Note(title, description);
        notebookRef.add(note);

    }

    public void loadNote(View v) {
        notebookRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = "";

                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                            Note note = documentSnapshot.toObject(Note.class);

                            note.setDocumentId(documentSnapshot.getId());
                            String documentId = note.getDocumentId();
                            String title = note.getTitle();
                            String description = note.getDescription();
                            data += "ID: " + documentId
                                    + "\nTitle: " + title + "\nDescription: " + description + "\n\n";
                        }
                        textViewData.setText(data);
                    }
                });
    }
}

//    ///////////////// ----- this code for single Note -----///////////////////
//    private static final String TAG = "MainActivity";
//
//    private static final String KEY_TITLE = "title";
//    private static final String KEY_DESCRIPTION = "description";
//
//    private EditText editTextTitle;
//    private EditText editTextDescription;
//    private TextView textViewData;
//
//    private FirebaseFirestore db = FirebaseFirestore.getInstance();
//    private DocumentReference noteRef = db.document("Notebook/My First Note");
//    //or
//    //private DocumentReference noteRef = db.collection("Notebook").document("My First Note");
//
//    //noteRef = db.document("Notebook/My First Note") = db.collection("Notebook").document("My First Note");
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        editTextTitle = findViewById(R.id.edit_text_title);
//        editTextDescription = findViewById(R.id.edit_text_description);
//        textViewData = findViewById(R.id.text_view_data);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        noteRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
//                if (e != null) {
//                    Toast.makeText(MainActivity.this, "Error while loading!", Toast.LENGTH_SHORT).show();
//                    Log.d(TAG, e.toString());
//                    return;
//                }
//                if (documentSnapshot.exists()) {
//                    String title = documentSnapshot.getString(KEY_TITLE);
//                    String description = documentSnapshot.getString(KEY_DESCRIPTION);
//                    textViewData.setText("Title: " + title + "\n" + "Description: " + description);
//                }
//            }
//        });
//    }
//    public void saveNote(View v) {
//        String title = editTextTitle.getText().toString();
//        String description = editTextDescription.getText().toString();
//
//        Map<String, Object> note = new HashMap<>();
//        note.put(KEY_TITLE, title);
//        note.put(KEY_DESCRIPTION, description);
//
////        db.document("Notebook/My First Note");
//        // db.collection("Notebook").document("My First Note").collection("zyada").document(" nchof wach yassra").set(note)
//        // db.collection("Notebook").document("My First Note").set(note)
//
//        noteRef.set(note)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Toast.makeText(MainActivity.this, "Note saved", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, e.toString());
//                    }
//                });
//    }
//
//    public void loadNote(View v) {
//        noteRef.get()
//                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                    @Override
//                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                        if (documentSnapshot.exists()) {
//                            String title = documentSnapshot.getString(KEY_TITLE);
//                            String description = documentSnapshot.getString(KEY_DESCRIPTION);
//                            //Map<String, Object> note = documentSnapshot.getData();
//                            textViewData.setText("Title: " + title + "\n" + "Description: " + description);
//                        } else {
//                            Toast.makeText(MainActivity.this, "Document does not exist", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
//                        Log.d(TAG, e.toString());
//                    }
//                });
//    }