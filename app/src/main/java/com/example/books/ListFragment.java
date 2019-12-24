package com.example.books;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListFragment extends Fragment {

     RecyclerView recyclerView;
     ArrayList<Book> booklist = new ArrayList<>();
     SqliteDataBase db = new SqliteDataBase(ListFragment.this.getContext());

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = v.findViewById(R.id.recyclerviwe);
        booklist =  ViewData();
        BookAdapter adapter = new BookAdapter(ListFragment.this.getContext(),booklist);
        recyclerView.setAdapter(adapter);
        //
        recyclerView.setLayoutManager(new LinearLayoutManager(ListFragment.this.getContext()));

        return v;
    }

    public ArrayList<Book> ViewData() {
        ArrayList<Book> booklist = new ArrayList<>();
        db = new SqliteDataBase(ListFragment.this.getContext());
        Cursor c = db.viewData();
        while (c.moveToNext()) {
            Book book = new Book(c.getInt(0), c.getString(1), c.getString(2)
                    , c.getInt(3), c.getString(4));
//            book = new Book();
//            book.setId(c.getInt(0));
//            book.setBookname(c.getString(1));

            booklist.add(book);
        }
        return booklist;
    }


}
