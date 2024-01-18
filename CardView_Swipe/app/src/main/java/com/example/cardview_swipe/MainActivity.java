package com.example.cardview_swipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cardview_swipe.Adapter.MyAdapter;
import com.example.cardview_swipe.Halper.MyButtonClickListener;
import com.example.cardview_swipe.Halper.MySwipeHelper;
import com.example.cardview_swipe.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter ;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_test);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MySwipeHelper swipeHelper = new MySwipeHelper(this,recyclerView,200){

            @Override
            public void instanatiateMybutton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {

                buffer.add(new MyButton(MainActivity.this ,
                        "Delete",30,0, Color.parseColor("#ff3c30"),
                        new MyButtonClickListener(){
                            @Override
                            public void onClick(int pos) {

                                Toast.makeText(MainActivity.this , "Delete click", Toast.LENGTH_SHORT).show();
                            }
                        }));

                buffer.add(new MyButton(MainActivity.this ,
                        "UpDate",30,R.drawable.ic_edit_white_24,
                        Color.parseColor("#FF9502"),
                        new MyButtonClickListener(){
                            @Override
                            public void onClick(int pos) {

                                Toast.makeText(MainActivity.this , "Update click", Toast.LENGTH_SHORT).show();
                            }
                        }));
            }
        };
        
        generateItem();
    }

    private void generateItem() {

        List<Item> itemList = new ArrayList<>();

        for (int i = 0 ; i <50 ; i++){
            itemList.add(new Item("Pie 0"+(i++),"100.000",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fd%2Fd0%2F%2522Mona_Lisa%2522_with_DeepDream_effect_using_VGG16_network_trained_on_ImageNet.jpg&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FDeepDream&tbnid=jvB-uvcyKbgvwM&vet=12ahUKEwitv-6yhtLzAhUDlBoKHZ0zBnoQMygBegQIARA-..i&docid=px7Vaum26P1yPM&w=687&h=1024&q=google%20ai%20services%20dreams&ved=2ahUKEwitv-6yhtLzAhUDlBoKHZ0zBnoQMygBegQIARA-"));

        }

        adapter = new MyAdapter(this , itemList);
        recyclerView.setAdapter(adapter);
    }
}