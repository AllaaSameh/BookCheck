package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler = new Handler();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent go = new Intent(SplashActivity.this,LoginPage.class);
                startActivity(go);

            }
        };

        handler.postDelayed(run,3000);
    }
}
