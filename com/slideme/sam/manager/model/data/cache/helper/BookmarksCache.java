package com.slideme.sam.manager.model.data.cache.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.slideme.sam.manager.util.C1922m;

public class BookmarksCache extends SimpleCacheHelper<String> {
    public BookmarksCache(Context context) {
        super(context, "CREATE TABLE IF NOT EXISTS bookmarks (id TEXT PRIMARY KEY);");
    }

    public synchronized String[] getAll() {
        String[] strArr;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query("bookmarks", null, null, null, null, null, null);
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
        Cursor query = this.mDatabase.query("bookmarks", null, "id=\"" + str + "\"", null, null, null, null);
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
            this.mDatabase.delete("bookmarks", null, null);
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
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("id", str);
        this.mDatabase.insert("bookmarks", null, contentValues);
    }

    public synchronized void remove(String str) {
        checkAndOpenDb();
        this.mDatabase.delete("bookmarks", "id=\"" + str + "\"", null);
    }

    public synchronized boolean has(String str) {
        boolean moveToFirst;
        checkAndOpenDb();
        Cursor query = this.mDatabase.query("bookmarks", null, "id=\"" + str + "\"", null, null, null, null);
        moveToFirst = query.moveToFirst();
        query.close();
        return moveToFirst;
    }
}
