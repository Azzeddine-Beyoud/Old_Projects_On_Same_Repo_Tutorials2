package Controller;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app.R;
import java.util.List;
import Modul.ListPerson;

class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder>{

    private Context context;
    private List<ListPerson> list;
    private DatabaseHelper databaseHelper;

    public ProfileAdapter(Context context, List<ListPerson> allData) {
        this.context = context;
        this.list = allData;
    }

    public ProfileAdapter(Context context, List<ListPerson> list, DatabaseHelper databaseHelper) {
        this.context = context;
        this.list = list;
        this.databaseHelper = databaseHelper;
    }

    @NonNull
    @Override
    public ProfileAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_content,parent,false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.MyViewHolder holder, final int position) {

        final ListPerson person = list.get(position);

        holder.email.setText(person.getEmail());
        holder.telephone.setText(person.getPhonenumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView email ,telephone;
        public ImageView delete,edit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.email);
            telephone = itemView.findViewById(R.id.telephone);
//            delete = itemView.findViewById(R.id.delete);
//            edit = itemView.findViewById(R.id.edit);

        }
    }


//    private String formatDate(String datestr){
//        try {
//            SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = fmt.parse(datestr);
//            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
//            return fmtOut.format(date);
//
//        } catch (ParseException e) {
//            Log.e("error",e.getMessage());
//            //e.printStackTrace();
//        }
//        return " ";
//    }


}


