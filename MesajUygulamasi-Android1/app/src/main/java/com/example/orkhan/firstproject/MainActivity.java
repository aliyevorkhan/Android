package com.example.orkhan.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText telno = (EditText) findViewById(R.id.etNum);
        final EditText mesaj = (EditText) findViewById(R.id.etMsj);
        Button  gonder = (Button) findViewById(R.id.bGonder);
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.telephony.SmsManager sms = android.telephony.SmsManager.getDefault();
                sms.sendTextMessage(telno.getText().toString(), null, mesaj.getText().toString(), null, null);
            }
        });
    }
}
