package com.example.aliyevorkhan.sqlite_projesi;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite_katmani extends SQLiteOpenHelper {

    public sqlite_katmani(Context context) {
        super(context, "Kullanici", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreate = " create table Kullanici ( id integer primary key autoincrement , isim text not null)";
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlUpgrade = "drop table if exists Kullanici";
        sqLiteDatabase.execSQL(sqlUpgrade);
    }
}
