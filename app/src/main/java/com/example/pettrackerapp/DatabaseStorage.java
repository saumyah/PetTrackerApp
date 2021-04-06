package com.example.pettrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class DatabaseStorage extends SQLiteOpenHelper {
     static final int DATABASE_VERSION = 1;
     static final String DATABASE_NAME = "PetsDatabase";
    private static DatabaseStorage sInstance;
    private static final String TAG = "DatabaseStorage";

     public DatabaseStorage(Context context) {
         super(context, DATABASE_NAME, null, DATABASE_VERSION);
     }
     //create table
     @Override
     public void onCreate(SQLiteDatabase db){
         db.execSQL("CREATE TABLE " + "PETS" + "(" + "ID " + " INTEGER PRIMARY KEY," + "NAME "
                 + " TEXT, " + "TYPE " + " TEXT," + "AGE " + " INTEGER," + "SEX " + " TEXT," + "WEIGHT " + " INTEGER" + ")");
     }
     //upgrade table by dropping old table and creating new one
     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
         db.execSQL("DROP TABLE IF EXISTS " + "PETS");
         onCreate(db);
     }
     // CRUD Operations
    //creation
    public void createPet(String name, String type, int age, String sex, int weight){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues newVals = new ContentValues();
         newVals.put("NAME", name);
         newVals.put("TYPE", type);
         newVals.put("AGE", age);
         newVals.put("SEX", sex);
         newVals.put("WEIGHT", weight);

         db.insert("PETS", null, newVals);
         db.close();
    }
    //retrieval
    public List<Pet> retrieveEntry(){
        List<Pet> pets = new ArrayList<>();
        String PETS_SELECT_QUERY =
                String.format("SELECT * FROM %s", "PETS");

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(PETS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Pet newPet = new Pet();
                    newPet.name = cursor.getString(cursor.getColumnIndex("NAME"));
                    newPet.type = cursor.getString(cursor.getColumnIndex("TYPE"));
                    newPet.age = cursor.getInt(cursor.getColumnIndex("AGE"));
                    newPet.sex = cursor.getString(cursor.getColumnIndex("SEX"));
                    newPet.weight = cursor.getInt(cursor.getColumnIndex("WEIGHT"));
                    pets.add(newPet);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return pets;

    }

    //update
    public void updateEntry(String name, String type, int id, int age, String sex, int weight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues newVals = new ContentValues();

        newVals.put("NAME", name);
        newVals.put("TYPE", type);
        newVals.put("AGE", age);
        newVals.put("SEX", sex);
        newVals.put("WEIGHT", weight);

        db.update("PETS", newVals, "ID = ?", new String[] {String.valueOf(id)});
        db.close();
    }
    //deletion
    public void deleteEntry(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("PETS", "ID = ?", new String[] {String.valueOf(id)});
        db.close();
    }

    public static synchronized DatabaseStorage getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseStorage(context.getApplicationContext());
        }
        return sInstance;
    }
}
