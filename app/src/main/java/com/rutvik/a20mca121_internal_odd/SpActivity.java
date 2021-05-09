package com.rutvik.a20mca121_internal_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SpActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedpreferences = getSharedPreferences("mypef", Context.MODE_PRIVATE);
                str = sharedpreferences.getString("user", "Wrong");
                if (str.equals("Wrong")) {
                    startActivity(new Intent(SpActivity.this, LoginActivity.class));
                    finish();
                }
                else{
                    startActivity(new Intent(SpActivity.this,HomeActivity.class)); finish();
            }
        }
    },3000);
}
}
