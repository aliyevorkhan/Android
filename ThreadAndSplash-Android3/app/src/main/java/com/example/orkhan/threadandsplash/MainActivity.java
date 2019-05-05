package com.example.orkhan.threadandsplash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread MyScreen = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    //5 saniye sonunda class davet et.
                    startActivity(new Intent(getApplicationContext(),startingPage.class));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    finish();
                }
            }
        };
        MyScreen.start();
    }
    }

