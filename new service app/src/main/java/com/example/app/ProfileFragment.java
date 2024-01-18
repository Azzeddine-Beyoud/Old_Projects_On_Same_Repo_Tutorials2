package com.example.app;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment {
String namevalue,lastnamevalue,phonenumbervalue,EmailValue,wilayavalue;
ImageButton edite;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.profile, container, false);

namevalue=getArguments().getString("name");
lastnamevalue=getArguments().getString("lastname");
phonenumbervalue=getArguments().getString("phonenumber");
EmailValue=getArguments().getString("Email");
wilayavalue=getArguments().getString("wilaya");

        TextView nom=(TextView)view.findViewById(R.id.nameprofile);
        nom.setText(namevalue);

        TextView prenom=(TextView)view.findViewById(R.id.LastNameProfile);
        prenom.setText(lastnamevalue);

        TextView phonenumber=(TextView)view.findViewById(R.id.phonenumberprofile);
        phonenumber.setText(phonenumbervalue);

        TextView Email=(TextView)view.findViewById(R.id.Emailprofile);
        Email.setText(EmailValue);

        TextView wilaya=(TextView)view.findViewById(R.id.wilaya);
        wilaya.setText(wilayavalue);










        return view;
    }
}




