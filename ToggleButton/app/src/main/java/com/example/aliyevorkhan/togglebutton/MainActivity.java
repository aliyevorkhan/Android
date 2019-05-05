package com.example.aliyevorkhan.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = (ToggleButton) findViewById(R.id.toggleButton);
        iv = (ImageView) findViewById(R.id.imageView);

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb.isChecked()) {
                    Toast.makeText(MainActivity.this, "Isik acildi", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.acik);
                }else{
                    Toast.makeText(MainActivity.this, "Isik kapandi", Toast.LENGTH_SHORT).show();
                    iv.setImageResource(R.drawable.kapali);
                }

            }
        });
    }
}
