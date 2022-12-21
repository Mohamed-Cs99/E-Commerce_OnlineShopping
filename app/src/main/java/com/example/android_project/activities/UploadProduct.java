package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_project.DataBase.ShoppingDb;
import com.example.android_project.R;

public class UploadProduct extends AppCompatActivity {
   EditText edt1 ,edt2 ,edt3 ,edt4 ;
   Button btn ;
   ShoppingDb mydb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_product);
        edt1 = (EditText)findViewById(R.id.ProuductName);
        edt2 =(EditText)findViewById(R.id.ProductPrice);
        edt3 =(EditText)findViewById(R.id.ProductQuantity);
        edt4=(EditText)findViewById(R.id.ProuductCategory);
        btn =(Button)findViewById(R.id.nwProductBtn);

        mydb =new ShoppingDb(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edt1.getText().toString();
                int price = Integer.parseInt(edt2.getText().toString());
                int quantity =Integer.parseInt(edt3.getText().toString());
                int categoryId =Integer.parseInt(edt4.getText().toString());
                long result= mydb.addNewProduct(name, price ,quantity,categoryId);
                if(result!=-1)
                {
                    Toast.makeText(getApplicationContext(),"New Product Added",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error!! Not Added... ",Toast.LENGTH_LONG).show();
                }
                edt1.setText("");
                edt2.setText("");
                edt3.setText("");
                edt4.setText("");
            }
        });







    }
}