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

import java.net.Inet4Address;

public class SignUpPage extends AppCompatActivity {

    EditText ed_newname,ed_newemail,ed_pass;
    Button btn_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        ed_newname = findViewById(R.id.ed_newname);
        ed_newemail = findViewById(R.id.ed_newemail);
        ed_pass = findViewById(R.id.ed_newpass);
        btn_save = findViewById(R.id.btn_save);



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SharedPreferences data = getSharedPreferences("file",0);
                SharedPreferences.Editor pin = data.edit();
                pin.putString("username",ed_newname.getText().toString());
                pin.putString("email",ed_newemail.getText().toString());
                pin.putString("pass",ed_pass.getText().toString());
                pin.commit();


                Intent go = new Intent(SignUpPage.this,LoginPage.class);
                startActivity(go);
                finish();


                // to move data between signup page and login

            }
        });

    }
}
