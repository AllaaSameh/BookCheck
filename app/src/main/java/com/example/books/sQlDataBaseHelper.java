package com.example.books;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sQlDataBaseHelper extends SQLiteOpenHelper {
    public sQlDataBaseHelper(@Nullable Context context ) {
        super(context, "Book", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Book (id Integer PRIMARY KEY AUTOINCREMENT , Bookname Text , BookType Text , read int , numComment int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table IF EXISTS Book");
        onCreate(db);

    }


}
