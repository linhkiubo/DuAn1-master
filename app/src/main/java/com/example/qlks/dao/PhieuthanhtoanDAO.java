package com.example.qlks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.PhieuDangKi;
import com.example.qlks.model.PhieuThanhToan;

import java.util.ArrayList;
import java.util.List;

public class PhieuthanhtoanDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public static final String SQL_Phieu_Thanh_Toan = "CREATE TABLE [PhieuThanhToan] (\n" +
            "[MaPTT] TEXT  NOT NULL PRIMARY KEY,\n" +
            "[MaNV] TEXT  NULL,\n" +
            "[SoNgay] INTEGER DEFAULT '1' NULL,\n" +
            "[NgayThanhToan] TEXT  NULL,\n" +
            "[TongPhaiTra] DOUBLE DEFAULT '10000' NULL,\n" +
            "[TongTien] DOUBLE DEFAULT '10000' NULL\n" +
            ")";
    public static final String TABLE_Phieu_Thanh_Toan ="PhieuThanhToan";
    PhieuthanhtoanDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertPhieuThanhToan(PhieuThanhToan phieuThanhToan){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaPTT",phieuThanhToan.getMaPTT());
        contentValues.put("MaNV",phieuThanhToan.getMaNV());
        contentValues.put("SoNgay",phieuThanhToan.getSoNgay());
        contentValues.put("NgayThanhToan",phieuThanhToan.getNgayThanhToan());
        contentValues.put("TongPhaiTra",phieuThanhToan.getTongPhaiTra());
        contentValues.put("TongTien",phieuThanhToan.getTongTien());

        try{
            if (db.insert(TABLE_Phieu_Thanh_Toan,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }

    public List<PhieuThanhToan> getAllPhieuThanhToan(){
        List<PhieuThanhToan> phieuThanhToanArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Phieu_Thanh_Toan,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            PhieuThanhToan phieuThanhToan = new PhieuThanhToan();
            phieuThanhToan.setMaPTT(cursor.getString(0));
            phieuThanhToan.setMaNV(cursor.getString(1));
            phieuThanhToan.setSoNgay(cursor.getString(2));
            phieuThanhToan.setNgayThanhToan(cursor.getString(3));
            phieuThanhToan.setTongPhaiTra(cursor.getDouble(4));
            phieuThanhToan.setTongTien(cursor.getDouble(5));
            phieuThanhToanArrayList.add(phieuThanhToan);
            cursor.moveToNext();
        }
        cursor.close();
        return phieuThanhToanArrayList;
    }
}
