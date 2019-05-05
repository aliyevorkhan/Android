package com.example.orkhan.messageapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button gonder_button = (Button) findViewById(R.id.bGonder);
        final EditText numara = (EditText) findViewById(R.id.etNumara);
        final EditText mesaj = (EditText) findViewById(R.id.etMesaj);

        gonder_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SMSgonder(numara.getText().toString(), mesaj.getText().toString());
                Toast.makeText(getApplicationContext(), "SMS gönderildi", Toast.LENGTH_LONG)
                        .show();
                numara.setText("");
                mesaj.setText("");
            }
        });

    }

    private void SMSgonder(String telno, String mesaj){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(telno, null, mesaj, null, null);
    }




}
