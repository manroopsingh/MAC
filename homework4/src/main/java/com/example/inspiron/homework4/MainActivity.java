package com.example.inspiron.homework4;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myTAG";
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent in = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(in);
            return true;
        }
        if (id == R.id.action_mysettings) {
            Intent in = new Intent(getApplicationContext(), MySettingsActivity.class);
            startActivity(in);
            return true;
        }
        if (id == R.id.action_kill) {
            openDialog();
            return true;
        }
        if (id == R.id.action_mic) {
            Toast.makeText(this,"Voice recognition coming soon..",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void AddFragment(View view) {
        InvisibleFragment invi_frag = new InvisibleFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(invi_frag,"myTag")
                .commit();
    }

    public void openDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_kill);
        dialog.show();
    }

    public void Cancel(View view) {
        dialog.dismiss();
    }

    public void Uninstall(View view) {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:com.example.inspiron.homework4"));
        startActivity(intent);
    }

    public static class InvisibleFragment extends Fragment{
        public InvisibleFragment() {
        }

        @Override
        public void onStart() {
            super.onStart();
            Toast.makeText(getActivity(), "Hello! I'm here! Sorry, I'm invisible.", Toast.LENGTH_SHORT).show();
        }
    }
}
