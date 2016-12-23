package com.example.inspiron.howework5;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class DownloadService extends Service {
    public DownloadService() {
    }

    private static String TAG = "DownloadServiceTAG";
    File song;

    @Override
    public void onCreate() {
        super.onCreate();

        //check if its writable
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            Log.d(TAG, "Writable: True ");
        }
        else {
            Log.d(TAG, "Writable: False");
        }
        //check if writable
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            Log.d(TAG, "Readable: True");
        }
        else
        {
            Log.d(TAG, "Readable: False");
        }


        File file = new File(this.getExternalFilesDir(
                Environment.DIRECTORY_DOWNLOADS), "diljit.txt");
        file.mkdir();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!file.mkdirs()) {
            //Log.e(TAG, String.valueOf(this.getExt) );
            Log.e(TAG, "Directory not created");
        }


        String FILENAME = "hello_file";
        String string = "hello world!";

        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
