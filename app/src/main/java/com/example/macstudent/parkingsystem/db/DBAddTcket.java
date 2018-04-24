package com.example.macstudent.parkingsystem.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.macstudent.parkingsystem.model.*;
import com.example.macstudent.parkingsystem.model.User;

import java.util.ArrayList;

/**
 * Created by macstudent on 2018-04-19.
 */

public class DBAddTcket {

    public static final String TABLE_ADD_TICKET = "tbladdTicket";
    public static final String KEY_VEHICLE_NO = "vehicleno";
    public static final String KEY_VEHICLE_BRAND = "vehiclebrand";
    public static final String  KEY_AMOUNT = "amount";
    public static final String KEY_SPIN_LANE = "Spinlane";
    public static final String  KEY_SPIN_PARKING = "Spinparking";
    public static final String KEY_SPIN_COLOR = "Spincolor";
    public static final String  KEY_SPIN_PAYMENT = "Spinpayment";



    private Context context;

    private DBhelper dbHelper;

    public DBAddTcket(Context context) {
        this.context = context;
    }

    public void insertticket(com.example.macstudent.parkingsystem.model.AddTicket AddTicket) {
        dbHelper = new DBhelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_VEHICLE_NO, AddTicket.getVehicleno());
        contentValues.put(KEY_VEHICLE_BRAND, AddTicket.getVehiclebrand());
        contentValues.put(KEY_AMOUNT, AddTicket.getAmount());
        contentValues.put(KEY_SPIN_LANE, AddTicket.getSpinlane());
        contentValues.put(KEY_SPIN_PARKING, AddTicket.getSpinparking());
        contentValues.put(KEY_SPIN_COLOR, AddTicket.getSpincolor());
        contentValues.put(KEY_SPIN_PAYMENT, AddTicket.getSpinpayment());






        database.insert(TABLE_ADD_TICKET, null, contentValues);

        database.close();

    }

    public void updateticket(AddTicket AddTicket) {
        dbHelper = new DBhelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_VEHICLE_BRAND, AddTicket.getVehiclebrand());
        contentValues.put(KEY_AMOUNT, AddTicket.getAmount());
        contentValues.put(KEY_SPIN_LANE, AddTicket.getSpinlane());
        contentValues.put(KEY_SPIN_PARKING, AddTicket.getSpinparking());
        contentValues.put(KEY_SPIN_COLOR, AddTicket.getSpincolor());
        contentValues.put(KEY_SPIN_PAYMENT, AddTicket.getSpinpayment());


        database.update(TABLE_ADD_TICKET, contentValues, KEY_VEHICLE_NO + "=?", new String[]{AddTicket.getVehicleno()});

        database.close();

    }

    public void deleteticket(AddTicket AddTicket) {
        dbHelper = new DBhelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        database.delete(TABLE_ADD_TICKET, KEY_VEHICLE_NO + "=?", new String[]{AddTicket.getVehicleno()});

        database.close();
    }
    public ArrayList<AddTicket> getAlltickets()
    {
        dbHelper = new DBhelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(TABLE_ADD_TICKET,
                null,
                null,
                null,
                null,
                null,
                null);

        ArrayList<AddTicket> AddTicketArrayList = new ArrayList<>();
        if(cursor !=null)
        {
            if(cursor.getCount() > 0)
            {
                while (cursor.moveToNext())
                {
                    AddTicket AddTicket = new AddTicket();
                    AddTicket.setVehicleno(cursor.getString(0));
                    AddTicket.setVehiclebrand(cursor.getString(1));
                    AddTicketArrayList.add(AddTicket);
                    Log.d("DB",AddTicket.getVehicleno() + " : " + AddTicket.getVehiclebrand());
                }
            }
        }
        database.close();

        return AddTicketArrayList;

    }
}