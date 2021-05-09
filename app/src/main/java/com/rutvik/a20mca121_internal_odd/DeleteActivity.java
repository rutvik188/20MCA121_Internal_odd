package com.rutvik.a20mca121_internal_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DeleteActivity extends AppCompatActivity {

    Button btndel;
    Button btnback;
    Spinner spinner;

    DataBaseHandler db = new DataBaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        getObjects();
        setObjects();
    }

    public void getObjects()
    {
        btndel = (Button) findViewById(R.id.btnDelete_DA);
        btnback = (Button) findViewById(R.id.btnBack_DA);
        spinner = (Spinner)findViewById(R.id.spinnerID_DA);
    }

    public void setObjects()
    {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        List<empmodel> EmployeeList = db.getAllEmployees();
        List<String> EmployeeIDs = new ArrayList<String>();

        for (empmodel obj : EmployeeList) {
            EmployeeIDs.add(obj.Empid);
        }

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,EmployeeIDs);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteEmployee(spinner.getSelectedItem().toString());
                Toast myToast = Toast.makeText(DeleteActivity.this, "Employee Deleted", Toast.LENGTH_LONG);
                myToast.show();
                setObjects();
            }
        });
    }
}