package com.example.aliyevorkhan.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class VeriTabani extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "musteriler";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO_KISILER = "kisiler";
    private static final String ROW_ID = "id";
    private static final String ROW_AD = "ad";
    private static final String ROW_SOYAD = "soyad";
    private static final String ROW_TEL = "tel";

    public VeriTabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLO_KISILER + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_AD + " TEXT NOT NULL, "
                + ROW_SOYAD + " TEXT NOT NULL, "
                + ROW_TEL + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLO_KISILER);
        onCreate(sqLiteDatabase);
    }

    public void VeriEkle(String ad, String soyad, String tel){
        SQLiteDatabase database = this.getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ROW_AD, ad);
            contentValues.put(ROW_SOYAD, soyad);
            contentValues.put(ROW_TEL, tel);
            database.insert(TABLO_KISILER, null, contentValues);
        }catch (Exception e){

        }
        database.close();
    }

    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase database = this.getReadableDatabase();
        try {
            String[] sutunlar = {ROW_ID, ROW_AD, ROW_SOYAD, ROW_TEL};
            Cursor cursor = database.query(TABLO_KISILER, sutunlar, null, null, null, null, null);
            while (cursor.moveToNext()){
                veriler.add(cursor.getInt(0)
                        + "-" + cursor.getString(1)
                        + "-" + cursor.getString(2)
                        + "-" + cursor.getString(3) );
            }
        }catch (Exception e){

        }
        database.close();
        return veriler;
    }

    public void VeriSil(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        try {
            String where = ROW_ID + " = " + id;
            database.delete(TABLO_KISILER, where, null);
        }catch (Exception e){

        }
        database.close();
    }

    public void VeriDuzenle(int id, String ad, String soyad, String tel){
        SQLiteDatabase database = this.getWritableDatabase();
        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put(ROW_AD, ad);
            contentValues.put(ROW_SOYAD, soyad);
            contentValues.put(ROW_TEL, tel);
            String where = ROW_ID + " = " + id;
            database.update(TABLO_KISILER, contentValues, where, null);

        }catch (Exception e){

        }
        database.close();
    }


}
