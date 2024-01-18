package com.example.radiogroup;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView viewopp;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewopp=findViewById(R.id.viewopp);
        radioGroup=findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group,@IdRes int checkedId) {
                radioButton=findViewById(checkedId);

                switch (radioButton.getId()){

                    case R.id.add:{
                        viewopp.setText("add");
                        //Log.d("logid","add");
                    }break;
                    case R.id.sub:{
                        viewopp.setText("sub");
                        //Log.d("logid","sub");
                    }break;
                    case R.id.mult:{
                        viewopp.setText("mult");
                        //Log.d("logid","mult");
                    }break;
                    case R.id.div:{
                        viewopp.setText("div");
                        //Log.d("logid","div");
                    }break;
                }

            }
        });
    }
}
