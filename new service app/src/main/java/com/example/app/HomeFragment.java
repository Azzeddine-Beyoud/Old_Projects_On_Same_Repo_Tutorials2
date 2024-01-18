package com.example.app;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class HomeFragment extends Fragment {


    private ListView lista;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = getLayoutInflater().inflate(R.layout.home, container, false);




    ImageButton painter=(ImageButton)view1.findViewById(R.id.painter);
    painter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        swaptopainter();
    }
});


    ImageButton Plumber=(ImageButton)view1.findViewById(R.id.plumber);
    Plumber.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        swaptoplumber();
    }
});

    ImageButton Mechanic=(ImageButton)view1.findViewById(R.id.Mechanic);
    Mechanic.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        swaptomechanic();
    }
});


        return view1;

    }



public void swaptopainter() {

        Fragment SelectedFragment=new Painter();
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentframe,SelectedFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void swaptoplumber(){
        Fragment SelectedFragment=new Plumber();
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentframe,SelectedFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void swaptomechanic(){
        Fragment SelectedFragment=new Mechanic();
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentframe,SelectedFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
