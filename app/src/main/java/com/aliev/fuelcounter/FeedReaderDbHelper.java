package com.aliev.fuelcounter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by modus on 3/19/18.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RefullingData.db";
    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER ";
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" + FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY, " + FeedReaderContract.FeedEntry.COLUMN_DATE_DAY + INT_TYPE + ", " + FeedReaderContract.FeedEntry.COLUMN_NAME_MONTH + INT_TYPE + ", " + FeedReaderContract.FeedEntry.COLUMN_NAME_YEAR + INT_TYPE + ", " + FeedReaderContract.FeedEntry.COLUMN_LiTRES + INT_TYPE +" )";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;
    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
