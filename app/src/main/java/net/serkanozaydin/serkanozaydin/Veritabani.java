package net.serkanozaydin.serkanozaydin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dvcc on 1/12/17.
 */

public class Veritabani extends SQLiteOpenHelper{
    private static final String DATABASE_NAME="yazi_veritabani";
    private static final String TABLE_NAME="yazi_tablosu";
    private static final int DATABASE_VERSION=1;

    private static final String BASLIK="baslik";
    private static final String TARIH="tarih";
    private static final String RESIM_URL="resim_url";
    private static final String ICERIK="icerik";
    private static final String GIDILECEK_URL="gidilecek_url";


    private static final String ID="_id";



    public Veritabani(Context context) {


        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String tablo_olustur="CREATE TABLE "+TABLE_NAME+
                " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                BASLIK+" TEXT, "+
                TARIH+" TEXT, "+
                RESIM_URL+" TEXT, "+
        ICERIK+" TEXT, "+
        GIDILECEK_URL+" TEXT);";

        db.execSQL(tablo_olustur);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void KayitEkle(Model model) {

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(BASLIK,model.getBaslik());
        cv.put(TARIH,model.getTarih());
        cv.put(RESIM_URL, model.getResim_url());
        cv.put(ICERIK, model.getIcerik());
        cv.put(GIDILECEK_URL, model.getGidilecek_url());


        db.insert(TABLE_NAME,null,cv);

        db.close();
    }

    public List<Model> TumKayitlariGetir() {

        SQLiteDatabase db=this.getReadableDatabase();

        String [] sutunlar=new String[]{BASLIK,TARIH,RESIM_URL,ICERIK,GIDILECEK_URL};

        Cursor c=db.query(TABLE_NAME, sutunlar, null, null, null, null, null);
        //Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        int basliksirano=c.getColumnIndex(BASLIK);
        int tarihsirano=c.getColumnIndex(TARIH);
        int resimsirano=c.getColumnIndex(RESIM_URL);
        int iceriksirano=c.getColumnIndex(ICERIK);
        int gidileceksirano=c.getColumnIndex(GIDILECEK_URL);


        List<Model> modeller=new ArrayList<Model>();

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){

           Model model=new Model();

            model.setBaslik(c.getString(basliksirano));
            model.setTarih(c.getString(tarihsirano));
            model.setResim_url(c.getString(resimsirano));
            model.setIcerik(c.getString(iceriksirano));
            model.setGidilecek_url(c.getString(gidileceksirano));



            modeller.add(model);


        }

        db.close();



        return modeller;
    }
    public void Sil() {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();
    }

}
