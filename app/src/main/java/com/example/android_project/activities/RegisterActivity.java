package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_project.R;
import com.example.android_project.DataBase.ShoppingDb;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView log = (TextView) findViewById(R.id.regtxtview);
        EditText name = (EditText) findViewById(R.id.inputCustomerName);
        EditText UserName = (EditText) findViewById(R.id.inputUserName);
        EditText password = (EditText) findViewById(R.id.pass);
        EditText gender = (EditText) findViewById(R.id.gender);
        EditText bdate = (EditText) findViewById(R.id.birthdate);
        EditText job = (EditText) findViewById(R.id.job);
        Button reg = (Button) findViewById(R.id.regbtn);
        ShoppingDb Mydb = new ShoppingDb(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long res =Mydb.addNewCustomer(name.getText().toString(), UserName.getText().toString(), password.getText().toString(), gender.getText().toString(), bdate.getText().toString(), job.getText().toString());
                if(res!=-1)
                {
                    Toast.makeText(getApplicationContext(),"New Customer Added",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error Not Added ",Toast.LENGTH_LONG).show();
                }
             }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}