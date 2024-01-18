package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Painter extends Fragment {

   public static ArrayList<list> painteritems=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= getLayoutInflater().inflate(R.layout.painter,container,false);

        ListView painterlist=(ListView)view.findViewById(R.id.painterlist);

        myCustomAdapter adapter1=new myCustomAdapter(painteritems,getActivity().getApplicationContext()) ;

        painterlist.setAdapter(adapter1);

        return view;
    }
}
