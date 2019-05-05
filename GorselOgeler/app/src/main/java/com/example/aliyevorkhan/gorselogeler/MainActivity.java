package com.example.aliyevorkhan.gorselogeler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Button button;
    EditText editTextK;
    EditText editTextS;
    String kulAdi, pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        editTextK = (EditText) findViewById(R.id.kadi);
        editTextS = (EditText) findViewById(R.id.sifre);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.setImageResource(R.drawable.android);

                kulAdi = editTextK.getText().toString();
                pass = editTextS.getText().toString();

                textView.setText("Resim degistirildi!" + "\n" + kulAdi + "\n" + pass);
            }
        });
    }
}
