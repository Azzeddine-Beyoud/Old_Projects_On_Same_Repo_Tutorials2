package com.example.app;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {

    public TextView email , phonenumber;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemview = getLayoutInflater().inflate(R.layout.profile, container, false);
//
        String emailtext = getArguments().getString("email");
//        String namevaluetext = getArguments().getString("namevalue");
//        String lastnamevaluetext = getArguments().getString("lastnamevalue");
        String phonenumbervaleutext = getArguments().getString("phonenumber");
//        String agetext = getArguments().getString("age");
//        String citytext = getArguments().getString("city");

        email = itemview.findViewById(R.id.emailfield);
        phonenumber = itemview.findViewById(R.id.phonefield);

//      return inflater.inflate(R.layout.profile, container, false);

        email.setText(emailtext);
        phonenumber.setText(phonenumbervaleutext);
        return itemview;
    }
}




