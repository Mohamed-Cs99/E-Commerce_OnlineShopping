package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_project.DataBase.ShoppingDb;
import com.example.android_project.R;

public class PasswordRecovery extends AppCompatActivity {

    EditText edtxt1 ;
    Button btn ;
    TextView  tv ;
    ShoppingDb obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery);

        edtxt1 = (EditText)findViewById(R.id.editTextTextPersonName) ;
        btn =(Button)findViewById(R.id.button2) ;
        tv =(TextView)findViewById(R.id.textView) ;
        obj=new ShoppingDb(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String email = edtxt1.getText().toString() ;
             String Pass =obj.getPassword(email) ;
             if(Pass==null)
             {
                 Toast.makeText(getApplicationContext(),"Check Email ",Toast.LENGTH_LONG).show();
             }
             else
             {
                 tv.setText(Pass);
             }

            }
        });

    }
}