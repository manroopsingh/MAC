package com.example.inspiron.classpractice15;

/**
 * Created by INSPIRON on 05-Jan-17.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    public static final String TAG = "Moviessssss:";
    private List<Movie> moviesList;
    MyViewHolder viewHolder;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, year, genre;
        public RelativeLayout relativeLayout;

        public MyViewHolder(final View view) {
            super(view);
            Log.d(TAG, "MyViewHolder: ");
            relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_movie);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);

        }

        @Override
        public void onClick(View v) {
            relativeLayout.setOnClickListener(this);
            title.setOnClickListener(this);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);

        Log.d(TAG, "onCreateViewHolder: ");
        viewHolder = new MyViewHolder(movieView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Movie movie = moviesList.get(position);
        Log.d(TAG, "onBindViewHolder: ");
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

        holder.relativeLayout.setOnClickListener(

                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(v.getContext(), DetailActivity.class);
                in.putExtra("Movie", movie);
                v.getContext().startActivity(in);
            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Hello", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


}
