package com.rutvik.a20mca121_internal_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DbMainActivity extends AppCompatActivity {

    Button btnInsertData_MA;
    Button btnUpdateData_MA;
    Button btnDeleteData_MA;
    Button btnVIewAll_MA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_main);
        getObjects();
        setObjects();
    }
    public void getObjects()
    {
        btnInsertData_MA = (Button)findViewById(R.id.btnInsertData_MA);
        btnUpdateData_MA = (Button)findViewById(R.id.btnUpdateData_MA);
        btnDeleteData_MA = (Button)findViewById(R.id.btnDeleteData_MA);
        btnVIewAll_MA = (Button)findViewById(R.id.btnVIewAll_MA);
    }

    public void setObjects()
    {
        btnUpdateData_MA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DbMainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        btnInsertData_MA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DbMainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        btnVIewAll_MA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DbMainActivity.this, ViewAll.class);
                startActivity(intent);
            }
        });

        btnDeleteData_MA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DbMainActivity.this, DeleteActivity.class);
                startActivity(intent);
            }
        });
    }
}