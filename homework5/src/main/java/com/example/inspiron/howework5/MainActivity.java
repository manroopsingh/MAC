package com.example.inspiron.howework5;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView1, textView2, textView_down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.tv_one);
        textView2 = (TextView) findViewById(R.id.tv_two);
        textView_down = (TextView) findViewById(R.id.tv_download);

        verifyStoragePermissions(this);


    }

    public void PlayMusic(View view) {

        Toast.makeText(this, "Playing", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this, MusicService.class);
        startService(in);
    }


    public void StopMusic(View view) {
        Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();

        Intent in = new Intent(this, MusicService.class);
        stopService(in);
    }

    public void DownloadMusic(View view) {
//        Intent in = new Intent(this, DownloadService.class);
//
//        startService(in);


//        Intent intent = new Intent(this, MyIntentService.class);
//        intent.putExtra(MyIntentService.FILENAME, "index.html");
//        intent.putExtra(MyIntentService.URL,
//                "https://pbs.twimg.com/profile_images/655066410087940096/QSUlrrlm.png");
//        startService(intent);
//        textView_down.setText("Service started");

        new DownloadTask().execute();


    }

    public void TaskOne(View view) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            new TaskOne(textView1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else
            new TaskOne(textView1).execute();

    }


    public void TaskTwo(View view) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            new TaskTwo(textView2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else
            new TaskTwo(textView2).execute();
    }


    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String string = bundle.getString(MyIntentService.FILEPATH);
                int resultCode = bundle.getInt(MyIntentService.RESULT);
                if (resultCode == RESULT_OK) {
                    Toast.makeText(MainActivity.this,
                            "Download complete. Download URI: " + string,
                            Toast.LENGTH_LONG).show();
                    textView_down.setText("Download done");
                } else {
                    Toast.makeText(MainActivity.this, "Download failed",
                            Toast.LENGTH_LONG).show();
                    textView_down.setText("Download failed");
                }
            }
        }
    };


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    /**
     * Checks if the app has permission to write to device storage
     *
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}
