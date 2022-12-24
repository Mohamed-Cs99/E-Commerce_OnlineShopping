package com.example.android_project.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android_project.Models.category;
import com.example.android_project.Models.Customer;
import com.example.android_project.Models.Order;
import com.example.android_project.Models.OrderDetails;
import com.example.android_project.Models.Product;

public class ShoppingDb extends SQLiteOpenHelper {
    private static String databaseName = "ProjectDb";
    SQLiteDatabase Project_db;


    public ShoppingDb(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Customers(CustId integer primary key autoIncrement   ,CustName text not null,UserName text not null ,Password text not null , gender text not null ,BirthDate text ,Job text )");

        db.execSQL("create table Orders(OrderId integer primary key autoIncrement ,OrderDate text not null ,Address text not null ,CustId integer not null,foreign key(CustId) references Customers(CustId))");

        db.execSQL("create table OrderDetails(OrderId integer not null , ProdId integer not null , Quantity integer not null ,primary key(OrderId,ProdId) ,Foreign key(OrderId) references Orders(OrderId),Foreign key(ProdId)references Products(ProductId))");

        db.execSQL("create table Products(ProductId integer primary key autoIncrement not null ,ProductName text not null ,Price integer not null ,Quantity intger not null ,CategoryId text not null,Foreign key(CategoryId)references Categories(CatId))");

        db.execSQL("create table Categories(CatId integer primary key autoIncrement  , CatName text not null)");


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

    public long addNewCustomer(Customer customer) {
        ContentValues row = new ContentValues();
        row.put("CustName", customer.getCustName());
        row.put("UserName", customer.getMail());
        row.put("Password", customer.getPassword());
        row.put("gender", customer.getGender());
        row.put("BirthDate", customer.getBirthDate());
        row.put("Job", customer.getJob());

        Project_db = getWritableDatabase();
        long insertResult =Project_db.insert("Customers", null, row);
        Project_db.close();
        return  insertResult;

    }

    public Cursor LogIn(String userName ,String password)
    {
        Project_db = getReadableDatabase() ;
        String[]args ={userName ,password};
        Cursor cr=Project_db.rawQuery("select CustId  from Customers where UserName=? and Password=?",args);
        if(cr!=null)
        {
            cr.moveToFirst();
        }
        Project_db.close();
        return  cr ;
    }


    public String getPassword(String Email)
    {
     Project_db=getReadableDatabase() ;
     String[]args={Email};
     Cursor cr = Project_db.rawQuery("select Password from Customers where UserName=?",args) ;
        if(cr.getCount()>0)
        {
            cr.moveToFirst();
            Project_db.close();
            return  cr.getString(0);
        }
        Project_db.close();
        return  null;
    }

    public long addNewProduct(Product product)
    {
        ContentValues row = new ContentValues();
        row.put("ProductName",product.getProName());
        row.put("Price",product.getPrice());
        row.put("Quantity",product.getQuantity());
        row.put("CategoryId",product.getCatId());

        Project_db=getWritableDatabase();
        long insertRes = Project_db.insert("Products",null ,row);
        Project_db.close();
        return  insertRes ;
    }


    public Cursor getAllProducts()
    {
        Project_db=getReadableDatabase();
        String[]args ={"ProductId","ProductName","Price","Quantity","CategoryId"};
        Cursor cr = Project_db.query("Products",args,null,null,null,null,null);
        if(cr!=null)
        {
            cr.moveToFirst();
        }
        return cr ;
    }

    public long addCategory(category cat)
    {
        Project_db=getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("CatName",cat.getCategoryName());
        long InsertRes =Project_db.insert("Categories",null,row);
        Project_db.close();
        return  InsertRes ;
    }

    public Cursor getCategory()
    {
        Project_db=getReadableDatabase();
        String []args={"CatId","CatName"};
        Cursor cr =Project_db.query("Categories",args,null ,null ,null , null ,null);
        if(cr.getCount()>0)
        {
            cr.moveToFirst();
        }
        Project_db.close();
        return  cr;
    }
    public Cursor getProductByCategory(String category)
    {
     Project_db=getReadableDatabase();
     String[]args ={category};
     Cursor cr =Project_db.rawQuery("select * from Products where CategoryId=?",args);
     if(cr!=null)
     {
         cr.moveToFirst();
     }
     Project_db.close();
     return  cr ;
    }

    public Cursor getProductById(String id)
    {
     Project_db=getReadableDatabase();
     String[]args ={id};
     Cursor cr=Project_db.rawQuery("select * from Products where ProductId=?",args);
     if (cr!=null)
     {
         cr.moveToFirst();
     }
     return  cr ;
    }
    public String getCategoryId(String name)
    {
        Project_db=getReadableDatabase();
        String[]args={name};
        Cursor cr = Project_db.rawQuery("select CatId from Categories where CatName=?",args);
        if(cr.getCount()>0)
        {
            cr.moveToFirst();
            Project_db.close();
            return  cr.getString(0);
        }
        Project_db.close();
        return  null ;
    }

    public void addNewOrder(Order ordr)
    {
        ContentValues row = new ContentValues();
        row.put("OrderDate",ordr.getOrderDate());
        row.put("Address",ordr.getAddress());
        row.put("CustId",ordr.getCustomerId());

        Project_db =getWritableDatabase();
        Project_db.insert("Orders",null,row);
        Project_db.close();
    }

    public void addOrderDetails(OrderDetails orderDetails)
    {
        ContentValues row = new ContentValues();
        row.put("OrderId",orderDetails.getOrderId());
        row.put("ProdId",orderDetails.getProductId());
        row.put("Quantity",orderDetails.getQuantity());

        Project_db =getWritableDatabase();
        Project_db.insert("OrderDetails",null,row);
        Project_db.close();
    }




    public void deleteProduct(String name )
    {
        Project_db=getWritableDatabase();
        Project_db.delete("Products","ProductName='"+name+"'",null);
        Project_db.close();
    }
    public void UpdateProduct()
    {

    }





}
