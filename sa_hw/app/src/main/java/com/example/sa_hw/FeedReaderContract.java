package com.example.sa_hw;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract() {}

    public static class FeedEntry implements BaseColumns {
//        public static final String TABLE_NAME = "entry";
//        public static final String COLUMN_NAME_TITLE = "title";
//        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

        public static final String TABLE_NAME = "courseSystem";
        public static final String COLUMN_COURSE_NAME = "name";
        public static final String COLUMN_COURSE_INTRO = "introduction";
        public static final String COLUMN_COURSE_SUITABLE = "suitable";
        public static final String COLUMN_COURSE_PRICE = "price";
        public static final String COLUMN_COURSE_NOTICE = "notice";
        public static final String COLUMN_COURSE_REMARK = "remark";
    }
}
