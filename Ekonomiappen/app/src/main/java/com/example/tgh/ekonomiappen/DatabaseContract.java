package com.example.tgh.ekonomiappen;

import android.provider.BaseColumns;

/**
 * Created by TGH on 10/1/2014.
 */
public final class DatabaseContract {

    //an empty constructor.
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class DatabaseEntry implements BaseColumns {
        public static final String TABLE_NAME_1 = "Utgifter";
        public static final String TABLE_NAME_2 = "Inkomster";
        public static final String COLUMN_NAME_UTGIFT_ID = "utgiftid";
        public static final String COLUMN_NAME_INKOMST_ID = "inkomstid";
        public static final String COLUMN_NAME_TITLE = "Title";
        public static final String COLUMN_NAME_KATEGOGI = "Kategori";
        public static final String COLUMN_NAME_PRICE = "Price";
        public static final String COLUMN_NAME_DATUM = "Datum";
        public static final String COLUMN_NAME_BELLOP = "Belopp";
    }
}
