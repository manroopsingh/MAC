package com.example.inspiron.classpractice13;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Sugarrrrrr";
    EditText booktitle, bookedition;
    String title, edition;
    ListView booklist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarContext.init(this);

        booktitle = (EditText) findViewById(R.id.et1);
        bookedition = (EditText) findViewById(R.id.et2);
        booklist = (ListView) findViewById(R.id.listview_books);


    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }

    //Commenting this code to ignore errors in other module gradle buidling

//    public void AddToList(View view) {
//        title = booktitle.getText().toString();
//        edition = bookedition.getText().toString();
//
//        Book book = new Book(title, edition);
//        book.save();
//        Toast.makeText(this, "Added to List", Toast.LENGTH_SHORT).show();
//
//        booktitle.setText("");
//        bookedition.setText("");
//    }
//
//    public void ViewList(View view) {
//        List<String> bookslist = new ArrayList<>();
//        List<Book> books = new ArrayList<>();
//        books = Book.listAll(Book.class);
//        Log.d(TAG, "Sugar: " + books.size());
//        for(Book b: books ) {
//            Log.d(TAG, b.toString());
//            bookslist.add(b.toString());
//        }
//
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bookslist);
//
//        booklist.setAdapter(adapter);
//    }
}
