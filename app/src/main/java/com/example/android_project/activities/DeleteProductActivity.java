package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_project.DataBase.ShoppingDb;
import com.example.android_project.R;

public class DeleteProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);
        EditText edtxt =(EditText)findViewById(R.id.DELETEDNAME);
        Button btn =(Button)findViewById(R.id.deletebtn);
        ShoppingDb mydb=new ShoppingDb(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pname=edtxt.getText().toString();
                mydb.deleteProduct(Pname);
                Toast.makeText(getApplicationContext(),"Product Deleted",Toast.LENGTH_LONG).show();
            }
        });

    }
}