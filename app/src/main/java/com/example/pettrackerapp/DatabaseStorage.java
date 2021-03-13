package com.example.pettrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import timber.log.Timber;

public class DatabaseStorage extends SQLiteOpenHelper {
     static final int DATABASE_VERSION = 1;
     static final String DATABASE_NAME = "Pets";
     //public  SQLiteDatabase db;

     public DatabaseStorage(Context context) {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
     }
     //create table
     @override
     public void onCreate(SQLiteDatabase db){
         db.execSQL("Create Table " + "Pets" + "(" + "ID " + "Integer Primary Key," + "Name "
                 + "Text," + "Type " + "Text" + ")");
     }
     //upgrade table by dropping old table and creating new one
     @override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
         db.execSQL("DROP TABLE IF EXISTS " + "Pets");
         onCreate(db);
     }
     // CRUD Operations
    //creation
    public void insertPet(){

    }
    //retrieval
    public String retrieveEntry(int id){

    }
    //update
    public void updateEntry(){

    }
    //deletion
    public void deleteEntry(){

    }
}
