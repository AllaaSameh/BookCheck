package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        final EditText ed_username ,ed_pass;
        Button btn_login;
        TextView  tx_newaccount;



         ed_username = findViewById(R.id.ed_email);
         ed_pass = findViewById(R.id.ed_pass);
         btn_login = findViewById(R.id.btn_login);

        final SharedPreferences data = getSharedPreferences("file",0);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = data.getString("email","nouser");
                String pass = data.getString("pass","nouser");

                if(email.equals(ed_username.getText().toString()) && pass.equals(ed_pass.getText().toString())) {

                    Intent go = new Intent(LoginPage.this, BookHome.class);
                    startActivity(go);
                    finish();
                }

                else
                {
                    Toast.makeText(LoginPage.this,"User name or Password is incorrect",Toast.LENGTH_SHORT).show();
                }

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
