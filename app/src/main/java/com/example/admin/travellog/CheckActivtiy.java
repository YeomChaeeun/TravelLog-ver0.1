package com.example.admin.travellog;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.admin.travellog.db.TrackingHistoryHelper;

public class CheckActivtiy extends AppCompatActivity {

    private TrackingHistoryHelper dbHelper;
    private SQLiteDatabase db;
    private String DATABASE_NAME = "TrackingHistory.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

    }

    @Override
    protected void onResume() {
        super.onResume();

        boolean isOpen = openDatabase();
        if(isOpen) {
            executeRawQuery();
            executeRawQueryParam();
        }
    }

    private boolean openDatabase() {
        Log.d("@@@@@@@", "opening database [" + DATABASE_NAME + " ]");

        this.dbHelper = TrackingHistoryHelper.getInstance(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        return true;
    }

    private void executeRawQuery() {
        Log.d("@@@@@@@", "\nexecuteRawQuery called.\n");

        Cursor c1 = db.rawQuery("select count(*) as Total from " + "Memo" , null);
        Log.d("@@@@@@@", "cursor count : " + c1.getCount());

        c1.moveToNext();
        Log.d("@@@@@@@", "record count : " + c1.getInt(0));

        c1.close();
    }

    private void executeRawQueryParam() {
        Log.d("@@@@@@@", "\nexecuteRawQueryParam called.\n");

        String SQL = "select latitude, longitude, memo, date " +
                        " from memo";
        String[] args = {};

        Cursor c1 = db.rawQuery(SQL, args);
        int recordCount = c1.getCount();
        Log.d("@@@@@@@", "cursor count : " + recordCount + "\n");

        for(int i=0; i<recordCount; i++) {
            c1. moveToNext();
            String latitude = c1.getString(0);
            String longitude = c1.getString(1);
            String memo = c1.getString(2);

            Log.d("@@@@@@@", "Recode #" + i + " : " + latitude + ", " + longitude + ", " + memo);
        }

        c1.close();
    }
}
