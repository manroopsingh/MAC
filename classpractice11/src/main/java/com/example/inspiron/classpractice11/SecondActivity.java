package com.example.inspiron.classpractice11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText editText_number, editText_string;
    TextView textView_result;
    int number;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText_number = (EditText) findViewById(R.id.Edittext_number);
        editText_string = (EditText) findViewById(R.id.Edittext_text);
        textView_result = (TextView) findViewById(R.id.textview_result);


    }

    public void doFib(View view) {
        number = Integer.parseInt(editText_number.getText().toString());

        int n1, n2, n3;
        n1 = 1;
        n2 = 1;

        StringBuilder sb = new StringBuilder()
                .append(n1 + " ")
                .append(n2 + " ");

        for (int i = 2; i < number; i++) {
            n3 = n1 + n2;
            sb.append(n3 + " ");

            n1 = n2;
            n2 = n3;

        }

        String result = sb.toString();
        textView_result.setText(result);
    }

    public void revStr(View view) {
        text = editText_string.getText().toString();

        char[] ch;
        ch = text.toCharArray();
        int j = ch.length - 1;
        char temp;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            j--;
            sb.append(ch[i]);

        }

        String result = sb.toString();

        textView_result.setText(result);


    }

    public void revSen(View view) {

        text = editText_string.getText().toString();

        String[] sep = text.split(" ");
        String res = "";

        for (int i = sep.length - 1; i >= 0; i--) {
            res += (sep[i] + " ");

        }

        res.trim();
        textView_result.setText(res);
    }

}
