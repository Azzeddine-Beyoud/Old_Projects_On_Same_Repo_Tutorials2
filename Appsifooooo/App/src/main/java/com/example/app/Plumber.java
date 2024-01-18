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

public class Plumber extends Fragment {
public static ArrayList<list> plumberitems=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=getLayoutInflater().inflate(R.layout.plumber,container,false);

        ListView plumberlist=(ListView)view.findViewById(R.id.plumberlist);
        myCustomAdapter adapterplumber=new myCustomAdapter(plumberitems,getActivity().getApplicationContext());

plumberlist.setAdapter(adapterplumber);



       return view;
    }
}
