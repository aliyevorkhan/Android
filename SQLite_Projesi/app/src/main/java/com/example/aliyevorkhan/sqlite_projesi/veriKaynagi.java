package com.example.aliyevorkhan.sqlite_projesi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class veriKaynagi {
    SQLiteDatabase db;
    sqlite_katmani bdb;

    public veriKaynagi(Context context){
        bdb = new sqlite_katmani(context);
    }

    public void ac(){
        db = bdb.getWritableDatabase();
    }

    public void kapat(){
        bdb.close();
    }

    public void kullaniciSil(Kullanici k){
        int id = k.getId();
        db.delete("Kullanici", "id=" +id, null);
    }

    public void kullaniciOlustur(Kullanici k){
//        String isim = "Ali Ahmet";
//        Kullanici k = new Kullanici();
//        k.setIsim(isim);
        ContentValues values = new ContentValues();
        values.put("isim", k.getIsim());
        db.insert("Kullanici", null, values);
    }

    public List<Kullanici>  listele() {
        String kolonlar[] = {"id", "isim"};
        List<Kullanici> liste = new ArrayList<Kullanici>();
        Cursor cursor = db.query("Kullanici", kolonlar, null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){

            int id = cursor.getInt(0);
            String isim = cursor.getString(1);
            String eleman = "" + id + "-" + isim;
            Kullanici k = new Kullanici(isim, id);
            liste.add(k);
            cursor.moveToNext();
        }
        cursor.close();
        return liste;
    }
}

