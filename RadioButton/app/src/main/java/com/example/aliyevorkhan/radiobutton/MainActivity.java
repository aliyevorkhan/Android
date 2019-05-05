package com.example.aliyevorkhan.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.StringWriter;

public class MainActivity extends AppCompatActivity {

    RadioButton siyah, beyaz, kirmizi;
    Button onayla;
    TextView cikti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siyah = (RadioButton) findViewById(R.id.rbSiyah);
        beyaz = (RadioButton) findViewById(R.id.rbBeyaz);
        kirmizi = (RadioButton) findViewById(R.id.rbKirmizi);

        onayla = (Button) findViewById(R.id.bOnayla);

        cikti = (TextView) findViewById(R.id.tvCikti);

        onayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (siyah.isChecked()){
                    cikti.setText("Sectigini renk : Siyah");
                }else if (beyaz.isChecked()){
                    cikti.setText("Sectigini renk : Beyaz");
                }else if (kirmizi.isChecked()){
                    cikti.setText("Sectigini renk : Kirmizi");
                }else{
                    Log.w("hata!", "bir deger secilmedi!");
                }
            }
        });
    }
}
