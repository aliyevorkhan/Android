package com.example.aliyevorkhan.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etAd,etSoyad,etTel;
    private Button btnKaydet, btnListele,btnSil,btnDuzenle;
    private ListView VeriListele;
    int idBul = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAd = (EditText) findViewById(R.id.etAd);
        etSoyad = (EditText) findViewById(R.id.etSoyad);
        etTel = (EditText) findViewById(R.id.etTel);
        btnKaydet = (Button) findViewById(R.id.btnKaydet);
        btnListele = (Button) findViewById(R.id.btnListele);
        VeriListele = (ListView) findViewById(R.id.VeriListele);
        btnSil = (Button) findViewById(R.id.btnSil);
        btnDuzenle = (Button) findViewById(R.id.btnDuzenle);

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gelenAd = etAd.getText().toString();
                String gelenSoyad = etSoyad.getText().toString();
                String gelenTel = etTel.getText().toString();

                VeriTabani veriTabani = new VeriTabani(MainActivity.this);
                veriTabani.VeriEkle(gelenAd, gelenSoyad, gelenTel);
                Listele();
            }
        });

        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listele();
            }
        });

        btnSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VeriTabani veriTabani = new VeriTabani(MainActivity.this);
                veriTabani.VeriSil(idBul);
                ListViewItem();
                Listele();
            }
        });
        btnDuzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ListView Tıkladığımızda otomatik dolan EditTextlerimizi Stringlere atıyalım
                String gelenAd = etAd.getText().toString();
                String gelenSoyad = etSoyad.getText().toString();
                String gelenTel = etTel.getText().toString();
                // Veritabanı bağlantımızı açalım ver ardından gerekli bilgileri VeriDuzenle metotuna gönderelim
                VeriTabani vt = new VeriTabani(MainActivity.this);
                vt.VeriDuzenle(idBul,gelenAd,gelenSoyad,gelenTel);
                ListViewItem();
                Listele();
            }
        });


    }


    public void Listele(){
        VeriTabani veriTabani = new VeriTabani(MainActivity.this);
        List<String> list = veriTabani.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, list);
        VeriListele.setAdapter(adapter);
    }

    public void ListViewItem(){
        VeriListele.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = VeriListele.getItemAtPosition(i).toString();
                String[] itemBol = item.split(" - ");
                idBul = Integer.valueOf(itemBol[0].toString());
                etAd.setText(itemBol[1].toString());
                etSoyad.setText(itemBol[2].toString());
                etTel.setText(itemBol[3].toString());
            }
        });
    }
}
