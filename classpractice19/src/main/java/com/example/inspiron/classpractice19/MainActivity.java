package com.example.inspiron.classpractice19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText n1,n2;
    TextView result;
    Button btnAdd, btnMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (EditText) findViewById(R.id.et_num1);
        n2 = (EditText) findViewById(R.id.et_num2);
        result = (TextView) findViewById(R.id.result);
//        btnAdd = (Button) findViewById(R.id.btnAdd);
//        btnMul = (Button) findViewById(R.id.btnMul);





    }

    public void testIt(View view) {




    }

    public void addNums(View view) {
        int num1 = Integer.parseInt(n1.getText().toString());
        int num2 = Integer.parseInt(n2.getText().toString());

        Maths math = new Maths();
        int res = math.addition(num1,num2);
        result.setText(String.valueOf(res));

    }

    public void multiplyNums(View view) {
        int num1 = Integer.parseInt(n1.getText().toString());
        int num2 = Integer.parseInt(n2.getText().toString());

        Maths math = new Maths();
        int res = math.multiply(num1,num2);
        result.setText(String.valueOf(res));
    }
}
