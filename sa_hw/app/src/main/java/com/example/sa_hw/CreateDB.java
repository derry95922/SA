package com.example.sa_hw;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class CreateDB {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TITLE + " TEXT," +
                    COLUMN_NAME_SUBTITLE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
