package com.example.inspiron.classpractice9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inspiron.classpractice9.entities.ResultAPus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_TAG";
    EditText editText;
    TextView textView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et);
        textView = (TextView) findViewById(R.id.tv_data);
        listView = (ListView) findViewById(R.id.listview_data);

    }

    public void doMagic(View view) {
        GitHubService gitHubService
                = new GitHubService.Factory().create();

        String username = editText.getText().toString();
        gitHubService.getRepos(username).enqueue(new Callback<List<ResultAPus>>() {
            @Override
            public void onResponse(Call<List<ResultAPus>> call, Response<List<ResultAPus>> response) {
                for(ResultAPus resultAPus : response.body()){
                    Log.d(TAG, "onResponse: "  + resultAPus);
                    //textView.setText(resultAPus.toString());

                    ArrayAdapter<ResultAPus> arrayAdapter = new ArrayAdapter<ResultAPus>(
                            MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            response.body());
                    listView.setAdapter(arrayAdapter);
                }


            }

            @Override
            public void onFailure(Call<List<ResultAPus>> call, Throwable t) {

            }
        });

    }
}
