package com.rutvik.a20mca121_internal_odd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user, pass;
    Button login;
    String message = "";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.txtEdusername);
        pass = findViewById(R.id.txtEdpass);
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
                    sharedpreferences = getSharedPreferences("mypef", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("user", user.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Login Successfully",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Enter Data!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}