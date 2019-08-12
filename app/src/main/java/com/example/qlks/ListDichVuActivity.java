package com.example.qlks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qlks.adapter.DichVuAdapter;
import com.example.qlks.adapter.KhachHangAdapter;
import com.example.qlks.dao.DichvuDAO;
import com.example.qlks.dao.KhachhangDAO;
import com.example.qlks.model.DichVu;
import com.example.qlks.model.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class ListDichVuActivity extends AppCompatActivity {

    private RecyclerView rcDichVu;

    List<DichVu> dichVuList;

    DichvuDAO dichvuDAO;

    DichVuAdapter dichVuAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dich_vu);

        rcDichVu = (RecyclerView) findViewById(R.id.rcDichVu);

        dichVuList = new ArrayList<>();
        dichvuDAO = new DichvuDAO(ListDichVuActivity.this);
        dichVuList = dichvuDAO.getAllDichVu();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        dichVuAdapter  = new DichVuAdapter(this,dichVuList);

        rcDichVu.setLayoutManager(linearLayoutManager);

        rcDichVu.setAdapter(dichVuAdapter);


    }
}
