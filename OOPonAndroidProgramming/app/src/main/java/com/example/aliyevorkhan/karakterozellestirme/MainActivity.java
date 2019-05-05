package com.example.aliyevorkhan.karakterozellestirme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    TextView istatistik;
    TextView bilgilendirme;
    EditText etIsim;
    EditText etId;
    Button yemek, spor, uyu, calis, mola, zam, okIsim, okId;
    ImageView scala;
    Calisan calisan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        istatistik = (TextView) findViewById(R.id.tvStat);
        bilgilendirme = (TextView) findViewById(R.id.tvBilg);

        etId = (EditText) findViewById(R.id.etId);
        etIsim = (EditText) findViewById(R.id.etIsim);
        okIsim = (Button) findViewById(R.id.okIsim);
        okId = (Button) findViewById(R.id.okId);

        okIsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilendirme.setText("Karakterin ismi " + etIsim.getText() + " olarak atandi!");
                calisan.isim = (String) etIsim.getText().toString();
                etIsim.setVisibility(View.INVISIBLE);
                istatistik.setText(calisan.toString());
                istatistik.setVisibility(View.VISIBLE);
                okIsim.setVisibility(View.INVISIBLE);
            }
        });

        okId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilendirme.setText("Karakterin ismi " + etId.getText() + " olarak atandi!");
                calisan.id = (String) etId.getText().toString();
                etId.setVisibility(View.INVISIBLE);
                istatistik.setText(calisan.toString());
                istatistik.setVisibility(View.VISIBLE);
                okId.setVisibility(View.INVISIBLE);

            }
        });


        scala = (ImageView) findViewById(R.id.ivScala);

        yemek = (Button) findViewById(R.id.btYemek);
        yemek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilendirme.setText(calisan.yemek());
                istatistik.setText(calisan.toString());
            }
        });

        spor = (Button) findViewById(R.id.btSpor);
        spor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilendirme.setText(calisan.spor());
                istatistik.setText(calisan.toString());
            }
        });

        uyu = (Button) findViewById(R.id.uyu);
        uyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilendirme.setText(calisan.uyumak());
                istatistik.setText(calisan.toString());
            }
        });

        calis = (Button) findViewById(R.id.btCalis);
        calis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilendirme.setText(calisan.calis());
                istatistik.setText(calisan.toString());
            }
        });

        mola = (Button) findViewById(R.id.btMola);
        mola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilendirme.setText(calisan.mola());
                istatistik.setText(calisan.toString());
            }
        });

        zam = (Button) findViewById(R.id.btZam);
        zam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilgilendirme.setText(calisan.zamIste());
                istatistik.setText(calisan.toString());
            }
        });

        calisan = new Calisan(100,5, 10, 170, 70,18);
        istatistik.setText(calisan.toString());
        bilgilendirme.setText("Hosgeldiniz lutfen bir eylem seciniz!");
    }
}
