package Controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.favourite;

import java.util.ArrayList;

import Modul.ListPerson;

public class MySecondCustomAdapter extends BaseAdapter {
    ArrayList<ListPerson> listperson;
    Context context;

    public MySecondCustomAdapter(Context context,ArrayList<ListPerson> listperson){
        this.listperson=listperson;
        this.context=context;

    }


    @Override
    public int getCount() {
        return listperson.size();
    }

    @Override
    public Object getItem(int position) {
        return listperson.get(position).name;
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

        txtname.setText(listperson.get(position).name);
        txtlastname.setText(listperson.get(position).Lastname);
        txtphonenumber.setText(listperson.get(position).Phonenumber);
        txtcity.setText(listperson.get(position).city);

        ImageButton call2=(ImageButton)view1.findViewById(R.id.call);
        ImageButton star2=(ImageButton)view1.findViewById(R.id.star);



        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callme=new Intent(Intent.ACTION_DIAL);
                callme.setData(Uri.parse("tel:"+txtphonenumber.getText().toString()));
                callme.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callme);
            }
        });


star2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        favourite.favoritems.remove(favourite.favoritems.get(position));
        favourite.adapterfavor.notifyDataSetChanged();
        Toast.makeText(context,"This item has been Deleted from your favorite",Toast.LENGTH_LONG).show();


    }
});






        return view1;


    }
}
