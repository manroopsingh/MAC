package com.example.inspiron.homework1;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button_sld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_orientation);
        button_sld = (Button) findViewById(R.id.buttonSLD);

        StateListDrawable sld = new StateListDrawable();
        sld.addState(new int[] {android.R.attr.state_pressed},new ColorDrawable(Color.parseColor("#e3bb87")));
        sld.addState(new int[] { },new ColorDrawable(Color.parseColor("#60ff40")));

        button_sld.setBackground(sld);



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Toast.makeText(this, "Orientation Changed!", Toast.LENGTH_SHORT).show();

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            textView.setText("This is the dope Landscape!!!");

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            textView.setText("This is the standard Portrait!!!");
        }
    }

    public void displayState(View view) {
       // Toast.makeText(this,"Pressed State then back to default state", Toast.LENGTH_SHORT).show();
    }
}
