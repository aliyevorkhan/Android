package com.example.aliyevorkhan.sqlite_projesi;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {
    Button ekle;
    Button sil;
    veriKaynagi vk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vk = new veriKaynagi(this);
        vk.ac();

        List<Kullanici> kullanicilar = vk.listele();
        final ArrayAdapter<Kullanici> adapter =
                new ArrayAdapter<Kullanici>(this, android.R.layout.simple_list_item_1, kullanicilar);
        setListAdapter(adapter);

        ekle = (Button) findViewById(R.id.ekle);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isimler[] = {"Ali", "Ahmet", "Mehmet", "Veli"};
                Random random = new Random();
                int rastgele = random.nextInt(3);
                Kullanici k  = new Kullanici(isimler[rastgele], 1);
                vk.kullaniciOlustur(k);
                adapter.add(k);
            }
        });

        sil = (Button) findViewById(R.id.sil);

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Kullanici k = (Kullanici) getListAdapter().getItem(0);
                vk.kullaniciSil(k);
                adapter.remove(k);
            }
        });

    }

    @Override
    protected void onResume() {
        vk.ac();
        super.onResume();
    }

    protected void onPause(){
        vk.kapat();
        super.onPause();
    }
}
