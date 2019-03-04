package com.slideme.sam.manager.model.data.cache.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.slideme.sam.manager.util.C1914e;

public abstract class SimpleCacheHelper<T> {
    private static String CREATE_TABLE = null;
    private static final String DB_NAME = "cache_db";
    protected SQLiteDatabase mDatabase = this.mHelper.getWritableDatabase();
    protected CacheDbHelper mHelper;

    class CacheDbHelper extends SQLiteOpenHelper {
        public CacheDbHelper(Context context) {
            super(context, SimpleCacheHelper.DB_NAME, null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(SimpleCacheHelper.CREATE_TABLE);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!sQLiteDatabase.isReadOnly()) {
                sQLiteDatabase.execSQL(SimpleCacheHelper.CREATE_TABLE);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public synchronized SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                if (C1914e.f3493a) {
                    e.printStackTrace();
                }
            }
            return sQLiteDatabase;
        }
    }

    public abstract void add(T t);

    public abstract void addAll(T[] tArr);

    public abstract void clear();

    public abstract T[] getAll();

    public abstract boolean has(T t);

    public abstract void remove(T t);

    public abstract boolean toggle(T t);

    public SimpleCacheHelper(Context context, String str) {
        CREATE_TABLE = str;
        this.mHelper = new CacheDbHelper(context);
    }

    public synchronized void close() {
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
        }
    }

    public void checkAndOpenDb() {
        if (this.mDatabase != null && !this.mDatabase.isOpen()) {
            this.mDatabase = this.mHelper.getWritableDatabase();
        }
    }
}
