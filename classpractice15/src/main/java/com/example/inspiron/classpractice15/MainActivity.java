package com.example.inspiron.classpractice15;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Firebase:";
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FirebaseDatabase database;
    private DatabaseReference movies;
    private TextView textView;
    private BroadcastReceiver br_hello, br_hola;
    private IntentFilter if_hello, if_hola;

    private EditText editText_title, editText_genre, editText_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_custom);
        textView.setText("Msg: " + getIntent().getStringExtra("Key"));


        if_hello = new IntentFilter();
        if_hello.addAction("Hello");
        if_hola = new IntentFilter();
        if_hola.addAction("Hello");

        br_hello = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String msg = intent.getStringExtra("Key");
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        };


        br_hola = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String msg = intent.getStringExtra("Key1");
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        };

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        editText_title = (EditText) findViewById(R.id.et_title);
        editText_genre = (EditText) findViewById(R.id.et_genre);
        editText_year = (EditText) findViewById(R.id.et_year);

        //set adapter to recyclerView
        mAdapter = new MoviesAdapter(movieList);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        //firebase
        database = FirebaseDatabase.getInstance();
        movies = database.getReference("Movie");

        //update db
        movies.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Movie value = postSnapshot.getValue(Movie.class);
                    movieList.add(value);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(br_hello,if_hello);
        registerReceiver(br_hola,if_hola);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br_hello);
        unregisterReceiver(br_hola);

    }

    public void AddNewMovie(View view) {

        String title, genre, year;
        title = editText_title.getText().toString();
        genre = editText_genre.getText().toString();
        year = editText_year.getText().toString();

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setYear(year);

//        database = FirebaseDatabase.getInstance();
//        movies = database.getReference("Movie");

        String key = movies.push().getKey();

        movies.child(key).setValue(movie);

        Toast.makeText(this, "Movie Updated", Toast.LENGTH_SHORT).show();

        editText_title.setText("");
        editText_year.setText("");
        editText_genre.setText("");

    }

    public void recyclerVertical(View view) {
    }

    public void recyclerHorizontal(View view) {

        mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
    }

    public void recyclerGrid(View view) {
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
