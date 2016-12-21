package com.example.inspiron.classpractice6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.a_main_tv)
    TextView textView;

    @BindView(R.id.a_main_et)
    EditText editText;

    @BindView(R.id.a_main_btn)
    Button button;

    @BindView(R.id.a_main_img)
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);

    }


    @OnClick(R.id.a_main_btn)
    public void buttonClicked(){
        textView.setText(editText.getText().toString());



        }


}
