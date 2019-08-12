package com.example.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlks.dao.NhanvienDAO;

public class LoGinActivity extends AppCompatActivity {
    private Button btnLogin;

    private EditText edtUser;
    private EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lo_gin);
        btnLogin=findViewById(R.id.btnLogin);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanvienDAO nhanvienDAO = new NhanvienDAO(LoGinActivity.this);
                if (nhanvienDAO.checkLogin(edtUser.getText().toString(),edtPass.getText().toString())<=0){
                    Toast.makeText(LoGinActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoGinActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoGinActivity.this,MainActivity.class));
                }
            }
        });
    }
}
