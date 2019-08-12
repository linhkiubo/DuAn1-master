package com.example.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutNhanVien;
    private LinearLayout layoutDichVu;
    private LinearLayout layoutHoaDon;
    private LinearLayout layoutKhachHang;
    private LinearLayout layoutPhong;
    private LinearLayout layoutThongKe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        onClick();

    }

    private void onClick() {


        layoutNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NhanVienActivity.class));
            }
        });

        layoutKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,KhachHangActivity.class));
            }
        });
        layoutDichVu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DichVuActivity.class));
            }
        });

        layoutPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PhongActivity.class));
            }
        });
        layoutHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HoaDonActivity.class));
            }
        });

    }

    private void anhXa() {

        layoutNhanVien = (LinearLayout) findViewById(R.id.layout_NhanVien);
        layoutDichVu = (LinearLayout) findViewById(R.id.layout_DichVu);
        layoutHoaDon = (LinearLayout) findViewById(R.id.layout_HoaDon);
        layoutKhachHang = (LinearLayout) findViewById(R.id.layout_KhachHang);
        layoutPhong = (LinearLayout) findViewById(R.id.layout_Phong);
        layoutThongKe = (LinearLayout) findViewById(R.id.layoutThongKe);

    }
}
