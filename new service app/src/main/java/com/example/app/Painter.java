package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import Controller.myCustomAdapter;
import Modul.ListPerson;


public class Painter extends Fragment {

   public static ArrayList<ListPerson> painteritems = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= getLayoutInflater().inflate(R.layout.painter,container,false);

        ListView painterlist = (ListView)view.findViewById(R.id.painterlist);

        myCustomAdapter adapterpainter=new myCustomAdapter(painteritems,getActivity().getApplicationContext()) ;


        painterlist.setAdapter(adapterpainter);

        return view;
    }
}
