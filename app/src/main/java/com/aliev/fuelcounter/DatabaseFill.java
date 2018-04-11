package com.aliev.fuelcounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by modus on 3/20/18.
 */

public class DatabaseFill {

    Context context ;

            ContentValues values = new ContentValues();

    public void fillBase(Context context, int litres, int day, int month, int year){
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        values.put(FeedReaderContract.FeedEntry.COLUMN_LiTRES, litres);
        values.put(FeedReaderContract.FeedEntry.COLUMN_DATE_DAY, day);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_MONTH, month + 1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_YEAR, year);
        db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
        Log.d("Added", "Data is added!!!" + values);

    }
}
