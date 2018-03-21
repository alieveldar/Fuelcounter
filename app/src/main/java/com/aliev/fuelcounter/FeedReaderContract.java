package com.aliev.fuelcounter;

import android.provider.BaseColumns;

/**
 * Created by modus on 3/19/18.
 */

public final class FeedReaderContract {
    public FeedReaderContract() {}

    public static abstract class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "fueling";
        public static final String COLUMN_DATE_DAY = "day";
        public static final String COLUMN_NAME_MONTH = "month";
        public static final String COLUMN_NAME_YEAR = "year";
        public static final String COLUMN_LiTRES = "litres";
    }
}
