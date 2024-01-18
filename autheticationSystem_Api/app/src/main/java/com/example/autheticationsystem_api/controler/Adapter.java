package com.example.autheticationsystem_api.controler;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autheticationsystem_api.Modul.Book;
import com.example.autheticationsystem_api.R;
import com.example.autheticationsystem_api.UI.EditData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<Book> bookList;

    public Adapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_content,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {

        Book book = bookList.get(position);
        holder.name.setText(book.getName());
        holder.author.setText(book.getAuthor());
        holder.timestamp.setText(formatDate(book.getUpdate_at()));

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData(position,book.getId());
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, EditData.class);
                intent.putExtra("id",book.getId());
                intent.putExtra("name",book.getAuthor());
                intent.putExtra("author",book.getName());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name,author,timestamp;
        public ImageView edit,delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTextView);
            author = itemView.findViewById(R.id.authorTextView);
            timestamp = itemView.findViewById(R.id.timeTextView);
            edit = itemView.findViewById(R.id.editImg);
            delete = itemView.findViewById(R.id.deleteImg);
        }
    }

    private String formatDate(String dateStr){
       try {
           SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           Date date = fmt.parse(dateStr);
           SimpleDateFormat fmtOut= new SimpleDateFormat("yyyy/MM/dd");

           return fmtOut.format(date);
       }catch (ParseException e){
           Log.d("error",e.getMessage());
       }
       return "";

    }

    public void deleteData(int position, int id){

    }
}
