package com.example.inspiron.classpractice12;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.orm.SugarRecord;

public class SecondActivity extends AppCompatActivity {

    TextView tv_sugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //sugar database example
        Book book = new Book("Two States", "Chetan Bhagat");
        book.save();

        tv_sugar = (TextView) findViewById(R.id.sugarrecord);

        Book book1 = Book.findById(Book.class, 1);
        tv_sugar.setText(book1.title + " " + book1.edition);
    }

    public class Book extends SugarRecord {
        String title;
        String edition;

        public Book(){
        }

        public Book(String title, String edition){
            this.title = title;
            this.edition = edition;
        }
    }
}
