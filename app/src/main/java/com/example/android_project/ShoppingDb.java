package com.example.android_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ShoppingDb extends SQLiteOpenHelper {
    private static String databaseName = "ProjectDb";
    SQLiteDatabase Project_db;


    public ShoppingDb(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Customers(CustId integer primary key autoIncrement not null  ,CustName text not null,UserName text not null ,Password text not null , gender text not null ,BirthDate text not null ,Job text not null)");

        db.execSQL("create table Orders(OrderId integer primary key autoIncrement not null,OrderDate text not null ,Address text not null ,CustId integer not null,foreign key(CustId) references Customers(CustId))");

        db.execSQL("create table OrderDetails(OrderId integer not null , ProdId integer not null , Quantity integer not null ,primary key(OrderId,ProdId) ,Foreign key(OrderId) references Orders(OrderId),Foreign key(ProdId)references Products(ProductId))");

        db.execSQL("create table Products(ProductId integer primary key autoIncrement not null ,ProductName text not null ,Price integer not null ,Quantity intger not null ,CategoryId text not null,Foreign key(CategoryId)references Categories(CatId))");

        db.execSQL("create table Categories(CatId integer primary key autoIncrement not null , CatName text not null)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Customers");
        db.execSQL("drop table if exists Orders");
        db.execSQL("drop table if exists OrderDetails");
        db.execSQL("drop table if exists Products");
        db.execSQL("drop table if exists Categories");

        onCreate(db);
    }

    public long addNewCustomer(String CustomerName,String name, String pass, String gender, String birthdate, String job) {
        ContentValues row = new ContentValues();
        row.put("CustName", CustomerName);
        row.put("UserName", name);
        row.put("Password", pass);
        row.put("gender", gender);
        row.put("BirthDate", birthdate);
        row.put("Job", job);

        Project_db = getWritableDatabase();
        long insertResult =Project_db.insert("Customers", null, row);
        Project_db.close();
        return  insertResult;

    }
    public Cursor getCustomersData()
    {
        Project_db=getReadableDatabase();
        String[]customers ={"CustId","CustName","UserName","Password","gender","BirthDate","Job"};
        Cursor cr =Project_db.query("Customers",customers,null,null,null,null,null);
        if(cr!=null)
        {
            cr.moveToFirst();
        }
        Project_db.close();
        return  cr;
    }
    public void addNewOrder(String ordDate ,String address ,Integer customerId)
    {
        ContentValues row = new ContentValues();
        row.put("OrderDate",ordDate);
        row.put("Address",address);
        row.put("CustId",customerId);

        Project_db =getWritableDatabase();
        Project_db.insert("Orders",null,row);
        Project_db.close();
    }

    public void addOrderDetails(Integer ordId ,Integer prodId ,Integer Qtity)
    {
        ContentValues row = new ContentValues();
        row.put("OrderId",ordId);
        row.put("ProdId",prodId);
        row.put("Quantity",Qtity);

        Project_db =getWritableDatabase();
        Project_db.insert("OrderDetails",null,row);
        Project_db.close();
    }

    public void addNewProduct(String name , Integer price , Integer quantity,Integer categId)
    {
        ContentValues row = new ContentValues();
        row.put("ProductName",name);
        row.put("Price",price);
        row.put("Quantity",quantity);
        row.put("CategoryId",categId);

        Project_db=getWritableDatabase();
        Project_db.insert("Products",null ,row);
        Project_db.close();
    }
    public void addCategory(String name)
    {
        ContentValues row = new ContentValues();
        row.put("CatName",name);

        Project_db=getWritableDatabase();
        Project_db.insert("Categories",null,row);
        Project_db.close();
    }






}
