package com.example.inspiron.classpractice15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView title, genre, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = (TextView) findViewById(R.id.tv_title);
        genre = (TextView) findViewById(R.id.tv_genre);
        year = (TextView) findViewById(R.id.tv_year);

        Movie m = getIntent().getExtras().getParcelable("Movie");

        title.setText(m.getTitle());
        genre.setText(m.getGenre());
        year.setText(m.getYear());
    }

}
