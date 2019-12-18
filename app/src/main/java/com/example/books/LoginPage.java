package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView  tx_newaccount;
        final EditText ed_username ,ed_pass;
        Button btn_login;



         ed_username = findViewById(R.id.ed_username);
         ed_pass = findViewById(R.id.ed_pass);
         btn_login = findViewById(R.id.btn_login);


/*
        final String email = getIntent().getExtras().getString("email");
        final String pass = getIntent().getExtras().getString("pass");

        final String checkname = ed_username.getText().toString();
        final String checkpass =  ed_pass.getText().toString();*/
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                SharedPreferences userDetials = getSharedPreferences("user detials", 0);
                SharedPreferences.Editor edit = userDetials.edit();
                edit.clear();
                edit.commit();*/


               /* if (checkname.equals(email) &&checkpass.equals(pass))
                {
                    Intent go = new Intent(LoginPage.this,BookHome.class);
                    startActivity(go);
                    finish();
                }*/

                Intent go = new Intent(LoginPage.this,BookHome.class);
                startActivity(go);
                finish();

            }
        });








        // create new account
        tx_newaccount = findViewById(R.id.tx_newacc);

        tx_newaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent go = new Intent(LoginPage.this,SignUpPage.class);
                startActivity(go);
            }
        });
    }
}
