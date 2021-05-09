package com.rutvik.a20mca121_internal_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewAll extends AppCompatActivity {

    Button back_VAA;
    ListView Employee_List;
    DataBaseHandler db = new DataBaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        getObjects();
        setObjects();
    }

    public void getObjects()
    {
        back_VAA = (Button)findViewById(R.id.back_VAA);
        Employee_List = (ListView)findViewById(R.id.Employee_List);
    }

    public void setObjects()
    {
        back_VAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAll.this, MainActivity.class);
                startActivity(intent);
            }
        });


        List<empmodel> EmployeeList = db.getAllEmployees();
        List<String> EmployeeListString = new ArrayList<String>();

        for (empmodel obj : EmployeeList) {
            String Temp;
            Temp = "ID : " + obj.Empid +
                    "\nName : " + obj.Ename +
                    "\nAge : " + obj.Eage +
                    "\nSalary : " + obj.Esalary +
                    "\nDept : " + obj.Edepartment;
            EmployeeListString.add(Temp);
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.lis, EmployeeListString);
        Employee_List.setAdapter(adapter);
    }
}