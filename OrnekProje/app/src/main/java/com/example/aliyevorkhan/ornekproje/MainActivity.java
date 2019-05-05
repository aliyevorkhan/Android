package com.example.aliyevorkhan.ornekproje;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bGonder;
    Button bDuzenle;
    TextView textView;
    EditText etA;
    EditText etSo;
    EditText etON;
    EditText etSi;
    EditText etEmail;


    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);


    String ad, soyad, email;
    String ogrNum, sinif;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rotateAnimation.setDuration(500);


        bGonder = (Button) findViewById(R.id.bGonder);
        bDuzenle = (Button) findViewById(R.id.bDuzenle);

        textView = (TextView) findViewById(R.id.tvBilg);

        etA = (EditText) findViewById(R.id.etAd);
        etSo = (EditText) findViewById(R.id.etSoyad);
        etON = (EditText) findViewById(R.id.etOgrNum);
        etSi = (EditText) findViewById(R.id.etSinif);
        etEmail = (EditText) findViewById(R.id.etMail);


        bGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = etA.getText().toString();
                soyad = etSo.getText().toString();
                email = etEmail.getText().toString();
                ogrNum = etON.getText().toString();
                sinif = etSi.getText().toString();


                textView.setText("Bilgileriniz:" + "\nAdiniz: " + ad + "\nSoyadiniz: " + soyad + "\nOgr. num: "
                        + ogrNum + "\nE-Mail: " + email + "\nSinif: " +sinif );

                bGonder.setVisibility(View.INVISIBLE);
                etEmail.setVisibility(View.INVISIBLE);
                etSi.setVisibility(View.INVISIBLE);
                etON.setVisibility(View.INVISIBLE);
                etSo.setVisibility(View.INVISIBLE);
                etA.setVisibility(View.INVISIBLE);


                Toast.makeText(MainActivity.this, "Bilgiler Gonderildi!", Toast.LENGTH_LONG).show();
                bGonder.startAnimation(rotateAnimation);
            }
        });

        bDuzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bGonder.setVisibility(View.VISIBLE);
                etEmail.setVisibility(View.VISIBLE);
                etSi.setVisibility(View.VISIBLE);
                etON.setVisibility(View.VISIBLE);
                etSo.setVisibility(View.VISIBLE);
                etA.setVisibility(View.VISIBLE);

                Toast.makeText(MainActivity.this, "Duzenleme acildi!", Toast.LENGTH_LONG).show();
                bDuzenle.startAnimation(rotateAnimation);
            }

        });
    }
}
