package com.example.app;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import Controller.DatabaseHelper;
import Controller.myCustomAdapter;
import Modul.ListPerson;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class Search extends Fragment {
ListView SearchListView;
myCustomAdapter Searchadapter;
ArrayList<ListPerson> SearchItems;
Button Searc;
DatabaseHelper db;
EditText SearchForIt;
String name,lastname,phonenumber,city=null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.search,container,false);

        Searc=(Button)view.findViewById(R.id.Searc);
        SearchForIt=(EditText)view.findViewById(R.id.SearchForIt);

        db=new DatabaseHelper(getActivity().getApplicationContext());
        SearchItems=new ArrayList<>();

        SearchListView=(ListView)view.findViewById(R.id.SearchListView);
        Searchadapter=new myCustomAdapter(SearchItems,getActivity().getApplicationContext());
        SearchListView.setAdapter(Searchadapter);



        Searc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                SearchItems.clear();
                List<ListPerson> DATA = db.getAllRecords(SearchForIt.getText().toString());

        if(DATA==null){
             Toast.makeText(getActivity().getApplicationContext(),"You Need To Type a Name",Toast.LENGTH_SHORT).show();
        }else {

                if(DATA.size()!=0) {
                    for (int j = 0; j < DATA.size(); j++) {



                        SearchItems.add(new ListPerson(DATA.get(j).name, DATA.get(j).Lastname, DATA.get(j).Phonenumber, DATA.get(j).city));

                    }

                }else {


                    if (DATA.size() == 0) {
                        Toast.makeText(getActivity(), "this person Doesn't exist", Toast.LENGTH_LONG).show();
                        SearchForIt.setText("");
                    }
                }
    }
            }

            });


        return view;
        }




    }

