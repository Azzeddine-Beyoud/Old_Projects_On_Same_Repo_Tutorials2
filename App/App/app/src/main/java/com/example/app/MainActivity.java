package com.example.app;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.textclassifier.SelectionEvent;
import android.widget.AdapterView;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {
DrawerLayout draw;
NavigationView nav;
Toolbar tool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





   /// first interface  which is Home


Fragment Frag=new HomeFragment();
getSupportFragmentManager().beginTransaction().replace(R.id.contentframe,Frag).commit();






        //bottom navigation
        BottomNavigationView Navi=(BottomNavigationView)findViewById(R.id.bottomnavigation);
        Navi.setOnNavigationItemSelectedListener(navigation);

        Toolbar tool=(Toolbar)findViewById(R.id.toolbarita);
        setSupportActionBar(tool);

        //drawer
    draw=(DrawerLayout) findViewById(R.id.Drawer_1);
    ActionBarDrawerToggle tog=new ActionBarDrawerToggle(this,draw,tool,R.string.open,R.string.close);
    draw.addDrawerListener(tog);
    tog.syncState();



        // Elements of the drawer
        NavigationView viewry=(NavigationView)findViewById(R.id.naviview);
        final Intent settin=new Intent(this,Settings.class);
        final Intent back=new Intent(this,SignLogIn.class);
        viewry.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){
                    case R.id.Settings:
                        startActivity(settin);
                        break;

                    case R.id.logout:
                        startActivity(back);
                }
                return true;
            }
        });

    }


    //bottom navigation buttons perform their functions now

    BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment SelectedFragment =null;


            switch (item.getItemId()) {
                case R.id.GoToHome:
                    SelectedFragment = new HomeFragment();
                    break;

                case R.id.Profile:
                    SelectedFragment = new ProfileFragment();
                    break;
                case R.id.favourite:
                    SelectedFragment=new favourite();

                    break;



            }


      getSupportFragmentManager().beginTransaction().replace(R.id.contentframe,SelectedFragment).commit();

            return true;
        }





    };


}




