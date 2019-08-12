package com.example.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlks.dao.DichvuDAO;
import com.example.qlks.dao.HoadonDAO;
import com.example.qlks.model.DichVu;
import com.example.qlks.model.HoaDon;

public class HoaDonActivity extends AppCompatActivity {
    private EditText edMaHD;
    private EditText edMaPTT;
    private EditText edSoTien;
    private EditText edTongTien;
    private Button btnLuu;
    private Button btnHuy;
    private Button btnShow;
    private Button btnUpdate;
    HoadonDAO hoadonDAO;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        edMaHD = (EditText) findViewById(R.id.edMaHD);
        edMaPTT = (EditText) findViewById(R.id.edMaPTT);
        edSoTien = (EditText) findViewById(R.id.edSoTien);
        edTongTien = (EditText) findViewById(R.id.edTongTien);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);


        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mahd = edMaHD.getText().toString();
                String maptt = edMaPTT.getText().toString();
                Double sotien = Double.parseDouble(edSoTien.getText().toString());
                Double tongtien = Double.parseDouble(edTongTien.getText().toString());



                if (mahd.equals("")){
                    edMaPTT.setError("Nhập Mã HĐ");
                }
                if (maptt.equals("")){
                    edMaPTT.setError("Nhập Mã PTT");
                }
                if (sotien.equals("")){
                    edSoTien.setError("Nhập Số Tiền");
                }
                if (tongtien.equals("")){
                    edTongTien.setError("Nhập Tổng Tiền");
                }

                HoaDon hoaDon = new HoaDon(mahd,maptt,sotien,tongtien);
                hoadonDAO = new HoadonDAO(HoaDonActivity.this);
                if (hoadonDAO.InsertHoaDon(hoaDon) > 0) {
                    Toast.makeText(HoaDonActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(HoaDonActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HoaDonActivity.this,ListHoaDonActivity.class));
            }
        });

        try{
            Intent intent = getIntent();
            if (intent!=null){
                Bundle bundle = intent.getBundleExtra("bun");
                edMaHD.setText(bundle.getString("1"));
                edMaPTT.setText(bundle.getString("2"));
                edSoTien.setText(bundle.getString("3"));
                edTongTien.setText(bundle.getString("4"));
            }}
        catch (NullPointerException e){
            Log.e("Loi",e.getMessage()+" ");
        }
    }

    public void UpdateHoaDon(View view){
        hoadonDAO = new HoadonDAO(HoaDonActivity.this);
        HoaDon hoaDon = new HoaDon(edMaHD.getText().toString().trim(),edMaPTT.getText().toString().trim(),Double.parseDouble(edSoTien.getText().toString()),Double.parseDouble(edTongTien.getText().toString()));
        if (hoadonDAO.UpdateHoaDon(hoaDon)==1){
            Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Cap nhat that bai", Toast.LENGTH_SHORT).show();
        }
    }
}
