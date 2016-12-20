package com.example.inspiron.classpractice4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    private Button login_btn;
    private String user,pass;

    private static final String MYUSERNAME = "manroop";
    private static final String TAG = "MAIN_ACTIVITY_TAG";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.a_main_et_user);
        password = (EditText) findViewById(R.id.a_main_et_pass);
        login_btn = (Button) findViewById(R.id.a_login_btn);

        user = username.getText().toString();
        pass = password.getText().toString();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String reverse = new StringBuffer(user).reverse().toString();

                if(pass.equals(reverse)){
                    Toast.makeText(getApplicationContext(),"Authenticated" ,Toast.LENGTH_SHORT).show();
                }

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("MY_KEY", MYUSERNAME);
                editor.apply();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String saveduser = sharedPreferences.getString("MY_KEY","");
        username.setText(saveduser);

    }

    public void Senduser(View view) {

        user = username.getText().toString();

        Intent in = new Intent();
        in.setAction(Intent.ACTION_SEND);
        in.putExtra(Intent.EXTRA_TEXT,user);
        in.setType("text/plain");
        startActivity(in);

    }
}
