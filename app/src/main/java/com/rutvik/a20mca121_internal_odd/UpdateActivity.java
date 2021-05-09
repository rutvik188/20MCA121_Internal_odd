package com.rutvik.a20mca121_internal_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {

    Button btnup;
    Button btnbk;
    EditText name;
    EditText age;
    EditText sal;
    EditText depr;
    Spinner spinner;

    DataBaseHandler db = new DataBaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        getObjects();
        setObjects();
    }

    public void getObjects()
    {
        name = (EditText)findViewById(R.id.etEname_UA);
        age = (EditText)findViewById(R.id.etEage_UA);
        sal = (EditText)findViewById(R.id.etEsalary_UA);
        depr = (EditText)findViewById(R.id.etEdepartment_UA);
        spinner = (Spinner)findViewById(R.id.spinnerID_UA);
        btnup = (Button)findViewById(R.id.btnUpdate_UA);
        btnbk = (Button)findViewById(R.id.btnBack_UA);
    }

    public void setObjects() {
        btnbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        List<empmodel> EmployeeList = db.getAllEmployees();
        List<String> EmployeeIDs = new ArrayList<String>();

        for (empmodel obj : EmployeeList) {
            EmployeeIDs.add(obj.Empid);
        }

        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,EmployeeIDs);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa2);

        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empmodel obj = new empmodel();

                obj.Empid = spinner.getSelectedItem().toString();
                obj.Ename = name.getText().toString();
                obj.Eage = age.getText().toString();
                obj.Esalary = sal.getText().toString();
                obj.Edepartment = depr.getText().toString();

                db.updateEmployee(obj);
                name.setText("");
                age.setText("");
                sal.setText("");
                depr.setText("");

                Toast myToast = Toast.makeText(UpdateActivity.this, "Employee Updated", Toast.LENGTH_LONG);
                myToast.show();

                setObjects();
            }
        });

    }
}