package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public void insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO users(name) VALUES(?)", new Object[]{name});
        db.close();
    }

    public String getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM users", null);

        String result = "No Data";
        if (cursor != null && cursor.moveToLast()) {
            result = cursor.getString(0);
            cursor.close();
        }
        db.close();
        return result;
    }
}