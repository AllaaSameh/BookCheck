package com.example.books;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class SqliteDataBase extends SQLiteOpenHelper {
    public SqliteDataBase(@Nullable Context context) {

        //table name : book
        super(context, "Book", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //create table and it has 5 columns
        // id is primary key to can search and get data by it
        // bookname and it will get his data from Edit text is called Book name from Add fragment page
        // booktype  and it will get his data from Edit text is called Book type from Add fragment page
        // numcomment to can count the num of comment when use in Alter dialog of comment (as if num of comments is greater than 1 remove comment and add another 1)

        db.execSQL("create table Book (id Integer PRIMARY KEY AUTOINCREMENT , Bookname Text , BookType Text , read int ,comment text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table IF EXISTS Book");
        onCreate(db);

    }

    // pass 2 variables to can insert data in it then pass to add fragment page and use 2 only because we need 2 edit text(book name - book type)
    // use long to can return -1 so can use it in unsert data in add fragment page to check data is inserted or not
    public long insertData(String bookname, String booktype) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("bookName", bookname);
        data.put("bookType", booktype);
        data.put("comment","comment");
        data.put("read",0);
        long result = db.insert("Book", null, data);
        return result;
    }

    // this method to can retrieve data and send to list fragment to show it there
    public Cursor viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Book ", null);
        return cursor;

    }


    //numcomment to can count the num of comment when use in Alter dialog of comment (as if num of comments is greater than 1 remove comment and add another 1)
    public int updateData( int id, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("comment", comment);
        int r = db.update("Book", data, "id=?", new String[]{String.valueOf(id)});
        return r;

    }

    public int Remove(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int r = db.delete("Book", "id=?", new String[]{String.valueOf(id)});
        return r;
    }


    public long insertcomment(String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("comment", comment);

        long result = db.insert("Book", null, data);
        return result;
    }

}
