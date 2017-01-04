package com.example.inspiron.classpractice13.entities;

import com.orm.SugarRecord;

/**
 * Created by INSPIRON on 03-Jan-17.
 */

public class Book extends SugarRecord {


    public String title;
    public String edition;

    public Book(){
    }

    public Book(String title, String edition){
        this.title = title;
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public String getEdition() {
        return edition;
    }

    public String toString(){
        String result = getTitle() +  " " +getEdition();
        return result;

    }
}
