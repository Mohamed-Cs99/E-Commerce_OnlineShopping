package com.example.android_project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android_project.DataBase.ShoppingDb;
import com.example.android_project.Models.Product;
import com.example.android_project.Models.category;
import com.example.android_project.R;

import java.util.ArrayList;
import java.util.List;

public class UploadProduct extends AppCompatActivity {
    EditText edt1, edt2, edt3;
    ArrayAdapter adapter;
    Spinner catSpinner;
    Button addProductBtn;
    ShoppingDb mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_product);

        // intialze globale variables
        edt1 = (EditText) findViewById(R.id.ProuductName);
        edt2 = (EditText) findViewById(R.id.ProductPrice);
        edt3 = (EditText) findViewById(R.id.ProductQuantity);
        catSpinner = (Spinner) findViewById(R.id.categorySpinner);
        addProductBtn = (Button) findViewById(R.id.nwProductBtn);
        mydb = new ShoppingDb(this);

        addCategory();
        getAllCategories();

        // add new Product when click on Add New Product Button
        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              addNewProduct();
            }
        });
    }
    protected  void addCategory()
    {
        mydb.addCategory(new category("Cars"));
        mydb.addCategory(new category("Electronics"));
        mydb.addCategory(new category("Accessories"));
        mydb.addCategory(new category("Clothes"));
    }
    protected void getAllCategories() {
        List<String> MyCategories = new ArrayList<>();
        Cursor cr = mydb.getCategory();
        if (cr != null) {
            while (!cr.isAfterLast()) {
                MyCategories.add(cr.getString(1));
                cr.moveToNext();
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MyCategories);
            catSpinner.setAdapter(adapter);
        }
    }

    protected void addNewProduct() {
        String name = edt1.getText().toString();
        int price = Integer.parseInt(edt2.getText().toString());
        int quantity = Integer.parseInt(edt3.getText().toString());
        int categoryId = Integer.parseInt(mydb.getCategoryId(catSpinner.getSelectedItem().toString()));

        if (!edt2.getText().toString().equals("") || !edt3.getText().toString().equals("") || !edt1.getText().toString().equals("")) {
            Product product =new Product(categoryId,quantity,name,price);
            mydb.addNewProduct(product);

            edt1.setText("");
            edt2.setText("");
            edt3.setText("");

            Toast.makeText(this,"New Product Added",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Check Fields Please !  ",Toast.LENGTH_LONG).show();
        }

    }


}