package com.slideme.sam.manager.model.data.cache.helper.cursor;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.slideme.sam.manager.util.C1922m;

public class LeaklessCursor extends SQLiteCursor {
    static final String TAG = "LeaklessCursor";

    public LeaklessCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        super(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    public void close() {
        SQLiteDatabase database = getDatabase();
        super.close();
        if (database != null) {
            C1922m.m5797b(TAG, "Closing LeaklessCursor: " + database.getPath());
            database.close();
        }
    }
}
