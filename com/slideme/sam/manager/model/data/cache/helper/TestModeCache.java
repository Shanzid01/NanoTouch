package com.slideme.sam.manager.model.data.cache.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.slideme.sam.manager.util.C1922m;

public class TestModeCache extends SimpleCacheHelper<String> {
    private static final int DAYS_TO_KEEP = 5;
    private static final String KEY_BUNDLE_ID = "id";
    private static final String KEY_TIMESTAMP = "tested_on_millis";
    private static final String TABLE_NAME = "test_mode_cache";

    public TestModeCache(Context context) {
        super(context, "CREATE TABLE IF NOT EXISTS test_mode_cache (id TEXT PRIMARY KEY, tested_on_millis INTEGER NOT NULL);");
        deleteOld();
    }

    public synchronized String[] getAll() {
        String[] strArr;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, null, null, null, null, null);
        strArr = new String[query.getCount()];
        int i = 0;
        while (query.moveToNext()) {
            strArr[i] = query.getString(0);
            i++;
        }
        query.close();
        return strArr;
    }

    public synchronized boolean toggle(String str) {
        boolean z;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, "id=\"" + str + "\"", null, null, null, null);
        if (query.getCount() == 0) {
            add(str);
            query.close();
            z = true;
        } else {
            remove(str);
            query.close();
            z = false;
        }
        return z;
    }

    public synchronized void clear() {
        checkAndOpenDb();
        try {
            this.mDatabase.delete(TABLE_NAME, null, null);
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
    }

    public synchronized void addAll(String[] strArr) {
        checkAndOpenDb();
        for (String add : strArr) {
            add(add);
        }
    }

    public synchronized void add(String str) {
        checkAndOpenDb();
        ContentValues contentValues = new ContentValues(2);
        contentValues.put(KEY_BUNDLE_ID, str);
        contentValues.put(KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.mDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public synchronized void remove(String str) {
        checkAndOpenDb();
        this.mDatabase.delete(TABLE_NAME, "id=\"" + str + "\"", null);
    }

    public synchronized boolean has(String str) {
        boolean moveToFirst;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query(TABLE_NAME, null, "id=\"" + str + "\"", null, null, null, null);
        moveToFirst = query.moveToFirst();
        query.close();
        return moveToFirst;
    }

    private void deleteOld() {
        checkAndOpenDb();
        try {
            this.mDatabase.delete(TABLE_NAME, "test_mode_cache.tested_on_millis < " + (System.currentTimeMillis() - 432000000), null);
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
    }
}
