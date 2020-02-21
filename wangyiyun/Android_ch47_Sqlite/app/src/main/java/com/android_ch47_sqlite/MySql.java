package com.android_ch47_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "user";
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String SEX = "sex";

    public MySql(Context context) {
        /**
         * 参数1：承接上下文， 参数2：数据库名， 参数3：， 参数4：版本
         */
        super(context, "wen.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NAME + " TEXT NOT NULL," +
                SEX + " TEXT NOT NULL)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
