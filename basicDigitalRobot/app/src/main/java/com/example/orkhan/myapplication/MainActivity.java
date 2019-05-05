package com.example.orkhan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, EditText.OnEditorActionListener {
    TextView tv;
    TextView tvKarakterOzellikleri;
    Button bSaldir;
    Button bYemek;
    Button bUyu;
    karakter k;
    EditText isim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.mesaj);
        tvKarakterOzellikleri = (TextView) findViewById(R.id.stats);

        //Buttonlar tanimlaniyor..
        bSaldir = (Button) findViewById(R.id.saldir);
        bYemek = (Button) findViewById(R.id.yemek);
        bUyu = (Button) findViewById(R.id.uyu);
        //Listenerlar tanimlaniyor..
        bSaldir.setOnClickListener(this);
        bYemek.setOnClickListener(this);
        bUyu.setOnClickListener(this);
        //oyun baslangicinda  karakter olusturulup
        k = new karakter();
        k.enerji = 20 ;
        k.kilo = 50;
        k.saldiriGucu = 200;
        tvKarakterOzellikleri.setText(k.toString());
        tv.setText("Oyuna hos geldiniz, lutfen bir eylem seciniz!");
        isim = (EditText) findViewById(R.id.karakterIsmi);
        isim.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView tv2, int i, KeyEvent ke){
        tv.setText("Karakterin ismi " + isim.getText() + " olarak atandi");
        k.isim = (String)isim.getText().toString();
        isim.setVisibility(View.INVISIBLE);
        tvKarakterOzellikleri.setText(k.toString());
        tvKarakterOzellikleri.setVisibility(View.VISIBLE);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == bSaldir.getId()){
            tv.setText(k.savas());
        }
        else if(v.getId() == bYemek.getId()){
            tv.setText(k.yemek());
        }
        else if(v.getId() == bUyu.getId()){
            tv.setText(k.uyumak());
        }
        tvKarakterOzellikleri.setText(k.toString());
    }
}
