package com.example.Assignment_ADNC.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.Assignment_ADNC.database.DbHelper;
import com.example.Assignment_ADNC.model.Khoahoc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class KhoahocDAO {
    private SQLiteDatabase db;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public KhoahocDAO(Context context){
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public boolean update(Khoahoc khoahoc){
        ContentValues values = new ContentValues();
        values.put("maKhoahoc", khoahoc.maKhoahoc);
        values.put("tenKhoahoc", khoahoc.tenKhoahoc);
        values.put("soBuoihoc",khoahoc.soBuoihoc);
        values.put("tenGiaovien",khoahoc.tenGiaovien);
        values.put("ngayBatdau",sdf.format(khoahoc.ngayBatdau));
        values.put("ngayKetthuc",sdf.format(khoahoc.ngayKetthuc));
        values.put("ngaythi",sdf.format(khoahoc.ngaythi));
        long r = db.update("KHOAHOC",values,"maKhoahoc=?",new String[]{khoahoc.maKhoahoc});
        if (r <=0 ) return false;
        else return true;
    }
    public boolean insert(Khoahoc khoahoc){
        ContentValues values = new ContentValues();
        values.put("tenKhoahoc", khoahoc.tenKhoahoc);
        values.put("soBuoihoc",khoahoc.soBuoihoc);
        values.put("tenGiaovien",khoahoc.tenGiaovien);
        values.put("ngayBatdau",sdf.format(khoahoc.ngayBatdau));
        values.put("ngayKetthuc",sdf.format(khoahoc.ngayKetthuc));
        values.put("ngaythi",sdf.format(khoahoc.ngaythi));
        long r = db.insert("KHOAHOC",null,values);
        if (r <=0 ) return false;
        else return true;
    }
     public long delete(String maKhoahoc){
        return db.delete("KHOAHOC", "maKhoahoc=?",new String[]{maKhoahoc});
    }
    public List<Khoahoc> getGD(String sql, String...a){
        List<Khoahoc> list = new ArrayList<Khoahoc>();
        Cursor c = db.rawQuery(sql,a);
        while (c.moveToNext()){
            try {
                Khoahoc gd = new Khoahoc();
                gd.tenKhoahoc = c.getString(c.getColumnIndex("tenKhoahoc"));
                gd.tenGiaovien = c.getString(c.getColumnIndex("tenGiaovien"));;
                list.add(gd);
            }catch (Exception e){

            }
        }
        return list;
    }
    //get All
    public List<Khoahoc> getAll1(){
        String sql = "select * from KHOAHOC";
        return getGD(sql);
    }
    public List<Khoahoc> getGD1(String sql, String...a){
        List<Khoahoc> list = new ArrayList<Khoahoc>();
        Cursor c = db.rawQuery(sql,a);
        while (c.moveToNext()){
            try {
                Khoahoc gd = new Khoahoc();
                gd.maKhoahoc = c.getString(c.getColumnIndex("maKhoahoc"));
                gd.tenKhoahoc = c.getString(c.getColumnIndex("tenKhoahoc"));
                gd.soBuoihoc = c.getString(c.getColumnIndex("soBuoihoc"));
                gd.tenGiaovien = c.getString(c.getColumnIndex("tenGiaovien"));
                gd.ngayBatdau = sdf.parse(c.getString(c.getColumnIndex("ngayBatdau")));
                gd.ngayKetthuc = sdf.parse(c.getString(c.getColumnIndex("ngayKetthuc")));
                gd.ngaythi = sdf.parse(c.getString(c.getColumnIndex("ngaythi")));
                list.add(gd);
            }catch (Exception e){

            }
        }
        return list;
    }
    //get All
    public List<Khoahoc> getAll(){
        String sql = "select * from KHOAHOC";
        return getGD1(sql);
    }
}
