package com.example.app;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.app.Painter.painteritems;
import static com.example.app.favourite.adapter;
import static com.example.app.favourite.favoritems;


public class myCustomAdapter extends BaseAdapter {
    ArrayList<list> list = new ArrayList<list>();
    Context context;



    myCustomAdapter(ArrayList<list> list, Context context) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position).name;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view1 = inflater.inflate(R.layout.card, null);

        ////////////////////////////////////////////////////////////
        TextView txtname=(TextView)view1.findViewById(R.id.name);
        TextView txtlastname=(TextView)view1.findViewById(R.id.lastname);
        final TextView txtphonenumber=(TextView)view1.findViewById(R.id.phonenumber);
        TextView txtcity=(TextView)view1.findViewById(R.id.city);
        //////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////

        txtname.setText(list.get(position).name);
        txtlastname.setText(list.get(position).Lastname);
        txtphonenumber.setText(list.get(position).Phonenumber);
        txtcity.setText(list.get(position).city);


///////////////////////////////////////////////////////////////





//////////////////////////////////////////////////////////////
ImageButton call=(ImageButton)view1.findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callme=new Intent(Intent.ACTION_DIAL);
                callme.setData(Uri.parse("tel:"+txtphonenumber.getText().toString()));
                callme.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callme);

            }
        });


ImageButton star= view1.findViewById(R.id.star);
star.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        favoritems.add(new list(painteritems.get(position).name,painteritems.get(position).Lastname,painteritems.get(position).Phonenumber,painteritems.get(position).city));
        adapter.notifyDataSetChanged();

    }
});




        return view1;




    }


}
