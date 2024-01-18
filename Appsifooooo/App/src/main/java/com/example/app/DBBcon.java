package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBBcon extends SQLiteOpenHelper {
public static final String name="NewBDD.db";
public static final int version=1;



    public DBBcon(Context context) {

        super(context, name, null, version);

    }
        @Override
        public void onCreate (SQLiteDatabase db){
db.execSQL("create table IF NOT EXISTS ClientTable(nom TEXT,prenom TEXT,Place TEXT,Phone TEXT,id INTEGER primary key)");

    }

        @Override
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){
        db.execSQL("Drop table if EXISTS ClientTable");
        onCreate(db);

        }


    public void inserttodbb(String name, String prenom, String phone, String Place){


        SQLiteDatabase db=  this.getWritableDatabase();

        ContentValues content=new ContentValues();

        content.put("nom", name);
        content.put("prenom",prenom);
        content.put("Phone",phone);
        content.put("Place",Place);

        db.insert("ClientTable",null,content);

    }

    }