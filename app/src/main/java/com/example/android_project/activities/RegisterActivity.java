package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_project.Models.Customer;
import com.example.android_project.R;
import com.example.android_project.DataBase.ShoppingDb;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, password, day, month, year, job;
    Button reg;
    Spinner gender;
    ShoppingDb Mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.inputCustomerName);
        email = (EditText) findViewById(R.id.inputUserName);
        password = (EditText) findViewById(R.id.pass);
        day = (EditText) findViewById(R.id.day);
        month = (EditText) findViewById(R.id.month);
        year = (EditText) findViewById(R.id.year);
        job = (EditText) findViewById(R.id.job);
        reg = (Button) findViewById(R.id.regbtn);
        gender = (Spinner) findViewById(R.id.spinner);
        Mydb = new ShoppingDb(this);

//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                long res =Mydb.addNewCustomer(name.getText().toString(), UserName.getText().toString(), password.getText().toString(), gender.getText().toString(), bdate.getText().toString(), job.getText().toString());
//                if(res!=-1)
//                {
//                    Toast.makeText(getApplicationContext(),"New Customer Added",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"Error Not Added ",Toast.LENGTH_LONG).show();
//                }
//             }
//        });


    }

    protected  void SignUp()
    {
      String n =name.getText().toString();
      String pass = password.getText().toString();
      String mail =email.getText().toString();
      String gend=gender.getSelectedItem().toString();
      String birthDate=day.getText().toString()+"/"+month.getText().toString()+"/"+year.getText().toString();
      String jobTitle =job.getText().toString();
      if(n==""||pass==""||mail=="")
      {
            Toast.makeText(this,"Please Complete required fields",Toast.LENGTH_SHORT).show();
      }
      else{
          Customer cust =new Customer(n ,mail,pass,gend,jobTitle,birthDate);
          Mydb.addNewCustomer(cust);
          Toast.makeText(this,"Successfully Register ",Toast.LENGTH_SHORT).show();
          Intent it = new Intent(RegisterActivity.this,LoginActivity.class);
          startActivity(it);
          finish();
      }
    }

}