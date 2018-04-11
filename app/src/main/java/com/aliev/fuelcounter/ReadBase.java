package com.aliev.fuelcounter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by modus on 3/20/18.
 */

public class ReadBase {

    public Cursor readBase(Context context){
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(context);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COLUMN_LiTRES,
                FeedReaderContract.FeedEntry.COLUMN_DATE_DAY,
                FeedReaderContract.FeedEntry.COLUMN_NAME_MONTH,
                FeedReaderContract.FeedEntry.COLUMN_NAME_YEAR
        };

        Cursor c = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );
        Log.d("Cursor", "Cursor is " + c.getCount());
        return c;
    }
}
