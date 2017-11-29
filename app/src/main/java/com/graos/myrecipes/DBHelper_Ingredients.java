package com.graos.myrecipes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SA on 27/11/2017.
 */

public class DBHelper_Ingredients extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ingredients_db";
    public static final String TABLE_NAME = "ingredients_table";
    public static final String COL_0 = "recipe_id";
    public static final String COL_1 = "product_name";
    public static final String COL_2 = "amount";
    public static final String COL_3 = "type_measure";

    public DBHelper_Ingredients(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( recipe_id TEXT, product_name TEXT, amount TEXT, type_measure TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    // --- Add ingredient ---
    public long add_ingredient(String recipe_id, String product, String amount, String type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0, recipe_id);
        contentValues.put(COL_1, product);
        contentValues.put(COL_2, amount);
        contentValues.put(COL_3, type);
        long result_add = db.insert(TABLE_NAME, null, contentValues); // add the db
        return result_add;
    }
}
