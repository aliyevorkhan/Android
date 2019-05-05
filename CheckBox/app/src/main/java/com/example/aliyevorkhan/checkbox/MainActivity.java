package com.example.aliyevorkhan.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox kitap, muzik, balik, oyun;
    Button onayla;
    TextView cikti;
    String hobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kitap = (CheckBox) findViewById(R.id.cbKitap);
        muzik = (CheckBox) findViewById(R.id.cbMuzik);
        balik = (CheckBox) findViewById(R.id.cbBalik);
        oyun = (CheckBox) findViewById(R.id.cbOyun);

        onayla = (Button) findViewById(R.id.bOnayla);

        cikti = (TextView) findViewById(R.id.tvCikti);


        onayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kitap.isChecked()){
                    hobi += kitap.getText() + "-";
                }
                if (muzik.isChecked()){
                    hobi += muzik.getText()+ "-";
                }
                if (balik.isChecked()){
                    hobi += balik.getText()+ "-";
                }
                if (oyun.isChecked()){
                    hobi += oyun.getText();
                }
             cikti.setText("Hobileriniz: " + hobi);
            }
        });
    }
}
