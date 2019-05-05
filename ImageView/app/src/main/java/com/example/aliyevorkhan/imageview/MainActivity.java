package com.example.aliyevorkhan.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.android);

        iv.setBackgroundColor(0xff0000ff);
        iv.setImageResource(R.drawable.android);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iv.setImageResource(R.drawable.java);
            }
        });
        
    }
}
