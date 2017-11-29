package com.graos.myrecipes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_Menu extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "menu.db";
    public static final String TABLE_NAME = "menu_table";
    public static final String COL_0 = "category_name";

    public DBHelper_Menu(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (category_name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    // --- Add new list of recipes ---
    public long add_list(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0, name);
        long result_add = db.insert(TABLE_NAME, null, contentValues); // add the db
        return result_add;
    }
}
