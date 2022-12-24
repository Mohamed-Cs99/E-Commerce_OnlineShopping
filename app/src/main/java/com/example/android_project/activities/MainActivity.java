package com.example.android_project.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.android_project.R;
import com.example.android_project.DataBase.ShoppingDb;

public class MainActivity extends AppCompatActivity {

     ShoppingDb mydb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListView myList =(ListView)findViewById(R.id.Lv) ;
//        ArrayAdapter<String>adapt =new ArrayAdapter<String>(getApplicationContext() , android.R.layout.simple_list_item_1);
//        myList.setAdapter(adapt);
//        mydb =new ShoppingDb(this);
//        Cursor cr = mydb.getAllProducts();
//        if(cr.getCount()==0)
//        {
//            Toast.makeText(getApplicationContext(),"No Products Yet!!",Toast.LENGTH_SHORT).show();
//        }
//
//            adapt.add("Product Name :: "+cr.getString(1));
//            adapt.add("Product Price :: "+cr.getString(2));
//            adapt.add("Product Quantity :: "+cr.getString(3));
//            adapt.add("Product ID :: "+cr.getString(0));
//            cr.moveToNext();
//



    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.settings,menu);
//        return true;
//    }

//   // Un completed
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        return super.onOptionsItemSelected(item);
//    }
}