package com.example.qlks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.NhanVien;
import com.example.qlks.model.PhieuDangKi;

import java.util.ArrayList;
import java.util.List;

public class PhieudangkiDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public static final String SQL_Phieu_Dang_Ki  = "CREATE TABLE [PhieuDangKi] (\n" +
            "[MaPDK] TEXT  NULL PRIMARY KEY,\n" +
            "[MaKH] TEXT  NULL,\n" +
            "[MaNV] TEXT  NULL,\n" +
            "[NgayDen] TEXT DEFAULT '''1/1/2019''' NULL,\n" +
            "[GioDen] TEXT DEFAULT '''00:00''' NULL,\n" +
            "[NgayDi] TEXT  NULL,\n" +
            "[GioDi] TEXT DEFAULT '''00:00''' NULL,\n" +
            "[NguoiLon] INTEGER DEFAULT '''1''' NULL,\n" +
            "[TreEm] INTEGER DEFAULT '''0''' NULL,\n" +
            "[SoPhong] INTEGER DEFAULT '''1''' NULL,\n" +
            "[TraTruoc] INTEGER DEFAULT '''0''' NULL\n" +
            ")";
    public static final String TABLE_Phieu_Dang_ki ="PhieuDangKi";
    PhieudangkiDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertPhieuDangKi(PhieuDangKi phieuDangKi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaPDK",phieuDangKi.getMaPDK());
        contentValues.put("MaKH",phieuDangKi.getMaKH());
        contentValues.put("MaNV",phieuDangKi.getMaNV());
        contentValues.put("NgayDen",phieuDangKi.getNgayDen());
        contentValues.put("GioDen",phieuDangKi.getGioDen());
        contentValues.put("NgayDi",phieuDangKi.getNgayDi());
        contentValues.put("GioDi",phieuDangKi.getGioDi());
        contentValues.put("NguoiLon",phieuDangKi.getNguoiLon());
        contentValues.put("TreEm",phieuDangKi.getTreEm());
        contentValues.put("SoPhong",phieuDangKi.getSoPhong());
        contentValues.put("TraTruoc",phieuDangKi.getTraTruoc());
        try{
            if (db.insert(TABLE_Phieu_Dang_ki,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }
    public List<PhieuDangKi> getAllPhieuDangKi(){
        List<PhieuDangKi> phieuDangKiArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Phieu_Dang_ki,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            PhieuDangKi phieuDangKi = new PhieuDangKi();
            phieuDangKi.setMaPDK(cursor.getString(0));
            phieuDangKi.setMaKH(cursor.getString(1));
            phieuDangKi.setMaNV(cursor.getString(2));
            phieuDangKi.setNgayDen(cursor.getString(3));
            phieuDangKi.setGioDen(cursor.getString(4));
            phieuDangKi.setNgayDi(cursor.getString(5));
            phieuDangKi.setNgayDi(cursor.getString(6));
            phieuDangKi.setNguoiLon(cursor.getString(7));
            phieuDangKi.setTreEm(cursor.getString(8));
            phieuDangKi.setSoPhong(cursor.getString(9));
            phieuDangKi.setTraTruoc(cursor.getString(10));
            phieuDangKiArrayList.add(phieuDangKi);
            cursor.moveToNext();
        }
        cursor.close();
        return phieuDangKiArrayList;
    }
}
