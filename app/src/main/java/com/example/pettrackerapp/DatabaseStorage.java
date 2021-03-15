package com.example.pettrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import timber.log.Timber;

public class DatabaseStorage extends SQLiteOpenHelper {
     static final int DATABASE_VERSION = 1;
     static final String DATABASE_NAME = "PetsDatabase";
     //public  SQLiteDatabase db;

     public DatabaseStorage(Context context) {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
     }
     //create table
     @Override
     public void onCreate(SQLiteDatabase db){
         db.execSQL("Create Table " + "PETS" + "(" + "ID " + "Integer Primary Key," + "NAME "
                 + "Text," + "TYPE " + "Text" + ")");
     }
     //upgrade table by dropping old table and creating new one
     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
         db.execSQL("DROP TABLE IF EXISTS " + "PETS");
         onCreate(db);
     }
     // CRUD Operations
    //creation
    public void createPet(String name, String type){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues newVals = new ContentValues();
         newVals.put("NAME", name);
         newVals.put("TYPE", type);
         db.insert("PETS", null, newVals);
         db.close();
    }
    //retrieval
    public String retrieveEntry(int id){
        SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.query("PETS", null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
         if (cursor == null){
             cursor.close();
             return "Pet does not exist";
         }
         cursor.moveToFirst();
         String name = cursor.getString(cursor.getColumnIndex("NAME"));
         cursor.close();
         db.close();
         return name;
    }
    //update
    public void updateEntry(String name, String type, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues newVals = new ContentValues();
        newVals.put("NAME", name);
        newVals.put("TYPE", type);
        db.update("PETS", newVals, "ID = ?", new String[] {String.valueOf(id)});
        db.close();
    }
    //deletion
    public void deleteEntry(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("PETS", "ID = ?", new String[] {String.valueOf(id)});
        db.close();
    }
}
