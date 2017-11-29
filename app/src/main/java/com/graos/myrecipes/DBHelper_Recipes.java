package com.graos.myrecipes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SA on 27/11/2017.
 */

public class DBHelper_Recipes extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "recipes_db";
    public static final String TABLE_NAME = "recipes_table";
    public static final String COL_0 = "recipe_id";
    public static final String COL_1 = "category_id";
    public static final String COL_2 = "recipe_name";

    public DBHelper_Recipes(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( recipe_id INTEGER PRIMARY KEY AUTOINCREMENT, category_id TEXT, recipe_id TEXT, recipe_name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    // --- Add new recipe ---
    public long add_recipe(String parent_ctg, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, parent_ctg);
        contentValues.put(COL_2, name);
        long result_add = db.insert(TABLE_NAME, null, contentValues); // add the db
        return result_add;
    }
}
