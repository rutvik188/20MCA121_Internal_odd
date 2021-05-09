package com.rutvik.a20mca121_internal_odd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rutvik.Model;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.q4RecyclerView);

        ArrayList<Model> list = new ArrayList<Model>();
        list.add(new Model("oninon", R.drawable.p));
        list.add(new Model("potato", R.drawable.po));
        list.add(new Model("cucumber", R.drawable.images));

        ImgAdapter adapter = new ImgAdapter(list, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }
}