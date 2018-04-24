package com.example.macstudent.parkingsystem.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macstudent on 2018-04-12.
 */

public class DBhelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "dbcollege";
    private static final int DB_VERSION = 1;

    public DBhelper(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String userTable = "CREATE TABLE " + DBUser.TABLE_USER
                + "(" +DBUser.KEY_USER_EMAIL + " TEXT PRIMARY KEY, "
                + DBUser.KEY_USER_PASSWORD + " TEXT )";

        db.execSQL(userTable);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + DBUser.TABLE_USER);

        onCreate(db);
    }

    public List<String> getAllLabels() {
        List<String> labels = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DBAddTcket.TABLE_ADD_TICKET;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;

    }
}