package com.aliev.fuelcounter;

import android.database.Cursor;
import android.util.Log;

/**
 * Created by modus on 3/20/18.
 */

public class DeadLineLitres {

    public String DeadLineLitres(Cursor cursor, int month){
        String balance;
        Integer fuelbalance = 0;
        cursor.moveToFirst();
        for (int x = 0; x < cursor.getCount(); x++ ) {
            if (cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_MONTH)) == month) {
                fuelbalance = fuelbalance + (cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_LiTRES)));
                cursor.moveToNext();
            } else {
                cursor.moveToNext();
            }


        }
        balance = fuelbalance.toString();
        Log.d("Balance", "Balance is " + balance + " fuelbalance is " + fuelbalance);
        return balance;
    }
}
