package com.example.inspiron.howework5;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by INSPIRON on 21-Dec-16.
 */

public class DownloadTask extends AsyncTask<Void,Void,Void> {
    @Override
    protected Void doInBackground(Void... params) {

        String SongURL = "http://ipendu.me/320/Do%20You%20Know-Diljit%20Dosanjh(iPendu.com).mp3";
        String ImageURL = "http://cdn.trendblog.net/wp-content/uploads/2013/06/white-android-logo_00039624.jpg";
        try {
            URL url = new URL(ImageURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(sdcard, "doyouknow.jpg");

            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();

            byte[] buffer = new byte[1024];
            int bufferLength = 0;

            while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                fileOutput.write(buffer, 0, bufferLength);
            }
            fileOutput.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
