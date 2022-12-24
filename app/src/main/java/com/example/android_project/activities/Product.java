package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_project.R;

public class Product extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Button btn2 =(Button)findViewById(R.id.add);
        Button btn3 =(Button)findViewById(R.id.UPD);
        Button btn4 =(Button)findViewById(R.id.dlt);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(Product.this,UploadProduct.class);
                startActivity(it);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(Product.this,DeleteProductActivity.class);
                startActivity(it);
            }
        });
    }
}