package com.rutvik.a20mca121_internal_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText name;
    EditText age;
    EditText sal;
    EditText dept;
    Button btnAdd;
    Button btnBack_IA;
    DataBaseHandler db = new DataBaseHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getObjects();
        setObjects();
    }

    public void getObjects() {
        name = (EditText) findViewById(R.id.edname);
        age = (EditText) findViewById(R.id.edage);
        sal = (EditText) findViewById(R.id.edsal);
        dept = (EditText) findViewById(R.id.eddept);
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnBack_IA = (Button) findViewById(R.id.btnBack);
    }

    public void setObjects() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empmodel obj = new empmodel();
                obj.Ename = name.getText().toString();
                obj.Eage = age.getText().toString();
                obj.Esalary = sal.getText().toString();
                obj.Edepartment = dept.getText().toString();
                db.addEmployee(obj);

                Toast myToast = Toast.makeText(AddActivity.this, "Employee Inserted", Toast.LENGTH_LONG);
                myToast.show();

                name.setText("");
                age.setText("");
                sal.setText("");
                dept.setText("");
            }
        });

        btnBack_IA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}