package com.example.orkhan.browsertemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button) findViewById(R.id.bBasla); // activitydeki butonu bul
        button.setOnClickListener(new View.OnClickListener() {
            //butona dinleme olayı ver
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, startingPage.class);
//Butona basinca intent ile bu activityden yeni activitye git
                MainActivity.this.startActivity(intent);//intent’i başlat
                MainActivity.this.finish();
            }
        });
    }
}
