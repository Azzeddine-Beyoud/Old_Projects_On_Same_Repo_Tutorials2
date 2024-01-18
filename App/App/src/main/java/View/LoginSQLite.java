package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.R;

public class LoginSQLite extends AppCompatActivity {

    private EditText loginPassword,loginUsername;
    private Button logInButton;

    private SharedPreferences sharedPreferences;
    private static final String MYKEY = "secret";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_s_q_lite);

        loginUsername=findViewById(R.id.loginUsername);
        loginPassword=findViewById(R.id.loginUsername);
        logInButton=findViewById(R.id.logInButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(MYKEY,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Username",loginUsername.getText().toString());
                editor.putString("Password",loginPassword.getText().toString());
                editor.commit();
                // commit for confirmation saving data
            }
        });

        SharedPreferences preferences = getSharedPreferences(MYKEY,0);
        if ((preferences.contains("Username")) && (preferences.contains("Password"))){

            String MyUsername=preferences.getString("Username","put your username");
            String MyPassword=preferences.getString("Password","put your password");

            loginUsername.setText(MyUsername);
            loginPassword.setText(MyPassword);
        }
    }
}
