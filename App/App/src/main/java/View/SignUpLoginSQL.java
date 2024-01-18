package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.app.R;

import View.LoginSQLite;
import View.SingUpSQLite;


public class SignUpLoginSQL extends AppCompatActivity {
    ViewFlipper v_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_login_s_q_l);

        Button login=(Button)findViewById(R.id.Login);
        Button signup=(Button)findViewById(R.id.signup);

        final   Intent sign = new Intent(this, SingUpSQLite.class);
        final   Intent log = new Intent(this, LoginSQLite.class);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sign);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(log);
            }
        });

        int imageoos[]= {R.drawable.image1,R.drawable.image2,R.drawable.image3};

        v_flipper=findViewById(R.id.v_flipper);

        for(int i=0; i<imageoos.length; i++){
            fillpperimages(imageoos[i]);
        }

    }
    public void fillpperimages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }




}


