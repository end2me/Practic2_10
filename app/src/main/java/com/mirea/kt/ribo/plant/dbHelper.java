package com.mirea.kt.ribo.plant;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class dbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "plants.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PLANTS = "plants";

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_PLANTS + " (" +
                "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name" + " TEXT, " +
                "type" + " TEXT, " +
                "isGreenhouse" + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANTS);
        onCreate(db);
    }

    public void addPlant(Plant plant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", plant.getName());
        values.put("type", plant.getType());
        values.put("isGreenhouse", plant.isGreenhouse() ? 1 : 0);
        db.insert(TABLE_PLANTS, null, values);
        db.close();
    }

    public List<Plant> getAllPlants() {
        List<Plant> plants = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PLANTS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String type = cursor.getString(cursor.getColumnIndex("type"));
                @SuppressLint("Range") boolean isGreenhouse = cursor.getInt(cursor.getColumnIndex("isGreenhouse")) == 1;
                plants.add(new Plant(name, type, isGreenhouse));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return plants;
    }
}

