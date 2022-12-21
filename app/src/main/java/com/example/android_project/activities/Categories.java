package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_project.DataBase.ShoppingDb;
import com.example.android_project.R;

public class Categories extends AppCompatActivity {

    EditText ed1 ;
    Button btn ,activ;
    ShoppingDb mydb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


        ed1 =(EditText)findViewById(R.id.catName);
        btn =(Button)findViewById(R.id.btn);
        activ=(Button)findViewById(R.id.ProductActivity);
        mydb = new ShoppingDb(this);
        activ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Categories.this,UploadProduct.class);
                startActivity(it);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String catName =ed1.getText().toString();
                long res = mydb.addCategory(catName);
                if(res!=-1)
                {
                    Toast.makeText(getApplicationContext(),"New Category Added",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error!! Not Added... ",Toast.LENGTH_LONG).show();
                }
                ed1.setText("");
            }
        });
    }
}