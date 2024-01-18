package com.example.swipe_item_recyclerview.swipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.swipe_item_recyclerview.R;

import java.util.ArrayList;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.SwipeViewHolder> {


    private Context context ;
    private ArrayList<Employee> employees ;
    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public SwipeAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees (ArrayList<Employee> employees){

        this.employees = new ArrayList<>();
        this.employees =employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SwipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee_swipe
                ,parent, false);
        return new SwipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SwipeViewHolder holder, int position) {

        viewBinderHelper.setOpenOnlyOne(true);
        viewBinderHelper.bind(holder.swipeRevealLayout,String.valueOf(employees.get(position).getName()));
        viewBinderHelper.closeLayout(String.valueOf(employees.get(position).getName()));
        holder.bindData(employees.get(position));

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class SwipeViewHolder extends RecyclerView.ViewHolder {

        private TextView textView , txtEdit , txtDelete ;
        private SwipeRevealLayout swipeRevealLayout , swipeRevealLayoutLeft;

        public SwipeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            txtEdit = itemView.findViewById(R.id.txtEdit);
            txtDelete = itemView.findViewById(R.id.txtDelete);
            swipeRevealLayout = itemView.findViewById(R.id.swipelayout);


            swipeRevealLayout.setDragEdge(1);
            txtEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Edit is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            txtDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Edit is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }

        void bindData(Employee employee){
            textView.setText(employee.getName());

        }
    }
}
