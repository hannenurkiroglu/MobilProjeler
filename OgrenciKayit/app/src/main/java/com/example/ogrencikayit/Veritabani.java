package com.example.ogrencikayit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannenur on 28.09.2018.
 */

public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "veritabani";
    private static final int DATABASE_VERSİON = 1;
    private static final String OGRENCİLER_TABLE = "ogrenciler";

    public final String ROW_ID = "id";
    public final String ROW_NAME = "ad";
    public final String ROW_MAIL = "mail";
    public final String ROW_ADRES = "adres";

    public Veritabani(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSİON);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + OGRENCİLER_TABLE + "("+ ROW_ID+" INTEGER PRIMARY KEY, "+ROW_NAME+" TEXT NOT NULL, "+ROW_MAIL+" TEXT NOT NULL, "+ROW_ADRES+" TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST " + OGRENCİLER_TABLE);
        onCreate(db);
    }

    public void VeriEkle(String ad, String email, String adres){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_NAME,ad.trim());
        cv.put(ROW_MAIL, email.trim());
        cv.put(ROW_ADRES, adres.trim());
        db.insert(OGRENCİLER_TABLE,null,cv);
        db.close();
    }
    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] sutunlar = {ROW_ID,ROW_NAME,ROW_MAIL,ROW_ADRES};
        Cursor cursor = db.query(OGRENCİLER_TABLE,sutunlar,null,null,null,null,null);
        while(cursor.moveToNext()){
            veriler.add(cursor.getString(1)+" - "+cursor.getString(2)+" - "+ cursor.getString(3));
        }
        return veriler;

    }
}
