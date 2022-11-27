package com.example.android_project;

import android.content.Context;
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
        db.execSQL("create table Customers(CustId integer primary key autoIncrement not null  ,UserName text not null ,Password text not null , gender text not null ,BirthDate text not null ,Job text not null)");

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
}
