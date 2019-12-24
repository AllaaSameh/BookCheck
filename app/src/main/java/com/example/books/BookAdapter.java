package com.example.books;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    Context context;
    ArrayList<Book> booklist ;

    public BookAdapter(Context context, ArrayList<Book> bookList) {
        this.context = context;
        this.booklist = bookList;

    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_design, parent, false);
        BookHolder holder = new BookHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, final int position) {

        holder.tx_bookname.setText(booklist.get(position).getBookname());
        holder.tx_booktype.setText(booklist.get(position).getBooktype());
        holder.tx_comment.setText(booklist.get(position).getComment());
        holder.tx_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentMethod(booklist.get(position).getId(), position);
            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SqliteDataBase db = new SqliteDataBase(context);
                //removed from database
                int r = db.Remove(booklist.get(position).getId());
                if (r == 1) {
                    //remove from arraylist to remove from design
                    booklist.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context, "data removed ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "data not removed ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return booklist.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {

        TextView tx_bookname, tx_booktype, tx_comment;
        ImageView img;

        public BookHolder(@NonNull View itemView) {
            super(itemView);
            tx_bookname = itemView.findViewById(R.id.tx_name);
            tx_booktype = itemView.findViewById(R.id.tx_type);
            tx_comment = itemView.findViewById(R.id.tx_comment);
            img = itemView.findViewById(R.id.img_remove);

        }
    }



    public void commentMethod(final int id , final int position) {
        final Dialog d = new Dialog(context);
        d.setContentView(R.layout.custom_dialog);
        final EditText ed_comment = d.findViewById(R.id.ed_comment);
        Button btn_comment = d.findViewById(R.id.btn_comment);
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SqliteDataBase db = new SqliteDataBase(context);
                int r = db.updateData(id,ed_comment.getText().toString());

                if (r ==1) {
                    booklist.get(position).setComment(ed_comment.getText().toString());
                    notifyDataSetChanged();
                    Toast.makeText(context, "Commented", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "not Commented", Toast.LENGTH_SHORT).show();
                }
                d.dismiss();
            }

        });
        d.show();

    }

}
