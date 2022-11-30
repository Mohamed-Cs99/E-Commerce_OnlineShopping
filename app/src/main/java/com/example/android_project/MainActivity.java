package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myList=(ListView)findViewById(R.id.lv);
        ArrayAdapter<String>myAdapter =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        myList.setAdapter(myAdapter);

        ShoppingDb mydb =new ShoppingDb(getApplicationContext());

        Cursor cr = mydb.getCustomersData();

        while(!cr.isAfterLast())
        {
            myAdapter.add(cr.getString(0));
            myAdapter.add(cr.getString(1));
            myAdapter.add(cr.getString(2));
            myAdapter.add(cr.getString(3));
            myAdapter.add(cr.getString(4));
            myAdapter.add(cr.getString(5));
            myAdapter.add(cr.getString(6));
            cr.moveToNext();
        }



    }
}