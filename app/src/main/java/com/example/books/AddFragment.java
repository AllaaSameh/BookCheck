package com.example.books;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    EditText ed_bookname , ed_booktype;
    Button btn_save;


    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_add, container, false);
        ed_bookname = view.findViewById(R.id.ed_bookname);
        ed_booktype = view.findViewById(R.id.ed_booktype);
        btn_save = view.findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                Intent go = new Intent(AddFragment.this.getContext(),BookHome.class);
                startActivity(go);
            }
        });


       return view;
    }


    public void insertData()
    {
        SqliteDataBase db = new SqliteDataBase(AddFragment.this.getContext());
        long r = db.insertData(ed_bookname.getText().toString(),ed_booktype.getText().toString());

        if(r==-1) {
            Toast.makeText(AddFragment.this.getContext(), "Data is not saved", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(AddFragment.this.getContext(), "Data is saved", Toast.LENGTH_SHORT).show();
        }
    }

}
