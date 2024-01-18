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

import Controller.MySecondCustomAdapter;

import Modul.ListPerson;

public class favourite extends Fragment {
public static ArrayList<ListPerson> favoritems=new ArrayList<>();
   public static ListView favor;
   public static MySecondCustomAdapter adapterfavor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view =getLayoutInflater().inflate(R.layout.favourite,container,false);


        favor=(ListView)view.findViewById(R.id.favouritelistivew);
        adapterfavor=new MySecondCustomAdapter(getActivity().getApplicationContext(),favoritems);

        favor.setAdapter(adapterfavor);

      return view;
    }
}
