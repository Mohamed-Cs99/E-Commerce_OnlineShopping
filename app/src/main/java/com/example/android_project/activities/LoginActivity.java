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
    TextView sUp, forget;
    CheckBox remember;
    Button lgIn;
    boolean logIn;
    SharedPreferences SharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.inputCustomerName);
        Password = (EditText) findViewById(R.id.pass);
        sUp = (TextView) findViewById(R.id.textviewSignUp);
        forget = (TextView) findViewById(R.id.forget);
        remember = (CheckBox) findViewById(R.id.checkBox2);
        SharedPreferences = getSharedPreferences("Remembering", MODE_PRIVATE);
        lgIn = (Button) findViewById(R.id.logInBtn);
        obj = new ShoppingDb(this);

        // Function check if User Login Befor
        LogInCheck();

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(LoginActivity.this, PasswordRecovery.class);
                startActivity(it);
            }
        });
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
        Cursor lgin_cr = obj.LogIn(usern, pass);
        if (usern.equals("admin") && pass.equals("admin")) {


            Intent it = new Intent(LoginActivity.this, Product.class);
            startActivity(it);
            finish();
        } else {

            if (lgin_cr.getCount() <= 0) {
                Toast.makeText(getApplicationContext(), "Invalid UserName Or Password", Toast.LENGTH_LONG).show();

            } else {
                if (remember.isChecked()) {
                    keepLogIn(usern, pass);
                }
                Toast.makeText(getApplicationContext(), "Successfully Log in ", Toast.LENGTH_LONG).show();
                Intent it = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        }


    }

    protected void LogInCheck() {
        logIn = SharedPreferences.getBoolean("login", false);
        if (logIn) {
            Intent it = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(it);
            finish();
        }
    }

    protected void keepLogIn(String userName, String Pass) {
        editor = SharedPreferences.edit();
        editor.putString("UserName", userName);
        editor.putString("Password", Pass);
        editor.putBoolean("login", true);
        editor.apply();
    }
}