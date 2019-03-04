package com.slideme.sam.manager.model.data.cache.helper.cursor;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

public class LeaklessCursorFactory implements CursorFactory {
    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return new LeaklessCursor(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
