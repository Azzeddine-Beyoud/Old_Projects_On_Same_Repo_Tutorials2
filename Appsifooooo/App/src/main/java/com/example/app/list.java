package com.example.app;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class list  {
    public String name;
    public String Lastname;
    public String Phonenumber;
    public String city;




        list(String name,String Lastname,String phonenumber,String city) {
    this.name = name;
    this.Lastname=Lastname;
    this.Phonenumber=phonenumber;
    this.city=city;

    }




}
