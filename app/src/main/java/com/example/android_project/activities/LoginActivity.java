package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_project.DataBase.ShoppingDb;
import com.example.android_project.R;

public class LoginActivity extends AppCompatActivity {
    EditText userName, Password;
    ShoppingDb obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.inputCustomerName);
        Password = (EditText) findViewById(R.id.pass);
        TextView sUp = (TextView) findViewById(R.id.textviewSignUp);
        CheckBox remember = (CheckBox) findViewById(R.id.checkBox2);
        SharedPreferences SharedPreferences = getSharedPreferences("Remembering", MODE_PRIVATE);
        SharedPreferences.Editor editor;
        Button lgIn =(Button)findViewById(R.id.logInBtn);
        obj = new ShoppingDb(this);

        sUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(it);
            }
        });


        lgIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    protected void login() {
        String usern = userName.getText().toString();
        String pass = Password.getText().toString();
        Cursor lgin_cr = obj.LogIN(usern,pass);
        if (usern.equals("admin") &&pass.equals("admin")) {


            Intent it = new Intent(LoginActivity.this,UploadProduct.class);
            startActivity(it);
            finish();
        } else {

            if (lgin_cr.getCount() <= 0) {
                Toast.makeText(getApplicationContext(), "Invalid UserName Or Password", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getApplicationContext(), "Successfully Log in ", Toast.LENGTH_LONG).show();
                Intent it = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        }


    }
}