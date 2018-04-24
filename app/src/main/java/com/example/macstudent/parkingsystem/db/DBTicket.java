package com.example.macstudent.parkingsystem.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by macstudent on 2018-04-19.
 */

public class DBTicket extends SQLiteOpenHelper {

    private static final String DB_NAME = "dbTicket";
    private static final int DB_VERSION = 1;


    public DBTicket(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String AddTicketTable = "CREATE TABLE " + DBAddTcket.TABLE_ADD_TICKET
                + "(" +DBAddTcket.KEY_VEHICLE_NO + " TEXT PRIMARY KEY, " + DBAddTcket.KEY_VEHICLE_BRAND + " TEXT ," +DBAddTcket.KEY_AMOUNT + " TEXT ," +DBAddTcket.KEY_SPIN_LANE + " TEXT ,"
                +DBAddTcket.KEY_SPIN_PARKING + "TEXT ," +DBAddTcket.KEY_SPIN_COLOR + " TEXT ," +DBAddTcket.KEY_SPIN_PAYMENT +" TEXT )";

        db.execSQL(AddTicketTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
