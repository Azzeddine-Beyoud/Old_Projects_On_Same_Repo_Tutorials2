package com.example.swipe_item_recyclerview.swipe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.swipe_item_recyclerview.R;

import java.util.ArrayList;

public class SwipeSelectionActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    SwipeAdapter adapter ;
    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_selection);

        recyclerView = findViewById(R.id.swipe_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL));
        adapter = new SwipeAdapter(this , employees);
        recyclerView.setAdapter(adapter);

        createList();
    }

    private void createList() {

        employees = new ArrayList<>();
        for ( int i =0 ; i < 20 ; i++){
            Employee employee = new Employee();
            employee.setName("Employee" + (i+1));
            employees.add(employee);
        }
        adapter.setEmployees(employees);
    }
}