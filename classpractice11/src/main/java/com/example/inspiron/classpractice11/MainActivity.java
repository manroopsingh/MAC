package com.example.inspiron.classpractice11;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_TAG";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.et_1);

        SharedPreferences settings = getSharedPreferences("File", MODE_PRIVATE);
        editText.setText(settings.getString("Key", "Empty"));


        DatabaseHandler db = new DatabaseHandler(this);


        Log.d(TAG, "Insert: ");
        db.addContact(new Contact("Manny","6508669800"));
        db.addContact(new Contact("Martin","6547893210"));
        db.addContact(new Contact("David","1236547899"));
        db.addContact(new Contact("Siris","3214785691"));

        Log.d(TAG, "Reading: ");
        List<Contact> contacts = db.getAllContacts();

        for(Contact cn: contacts){
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d(TAG, log);

        }




    }

    public void saveSharedPref(View view) {


    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences("File", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Key", editText.getText().toString());
        editor.commit();
    }
}
