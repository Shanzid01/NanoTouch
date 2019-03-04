package com.google.analytics.tracking.android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

@VisibleForTesting
/* compiled from: PersistentAnalyticsStore */
class bh extends SQLiteOpenHelper {
    final /* synthetic */ be f2035a;
    private boolean f2036b;
    private long f2037c = 0;

    bh(be beVar, Context context, String str) {
        this.f2035a = beVar;
        super(context, str, null, 1);
    }

    private boolean m3869a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query == null) {
                    return moveToFirst;
                }
                query.close();
                return moveToFirst;
            } catch (SQLiteException e) {
                cursor = query;
                try {
                    av.m3821h("error querying for table " + str);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    cursor2 = cursor;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            cursor = null;
            av.m3821h("error querying for table " + str);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        if (!this.f2036b || this.f2037c + 3600000 <= this.f2035a.f2032h.mo1198a()) {
            SQLiteDatabase sQLiteDatabase = null;
            this.f2036b = true;
            this.f2037c = this.f2035a.f2032h.mo1198a();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.f2035a.f2029e.getDatabasePath(this.f2035a.f2030f).delete();
            }
            if (sQLiteDatabase == null) {
                sQLiteDatabase = super.getWritableDatabase();
            }
            this.f2036b = false;
            return sQLiteDatabase;
        }
        throw new SQLiteException("Database creation failed");
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (m3869a("hits2", sQLiteDatabase)) {
            m3868a(sQLiteDatabase);
        } else {
            sQLiteDatabase.execSQL(be.f2025a);
        }
    }

    private void m3868a(SQLiteDatabase sQLiteDatabase) {
        Object obj = null;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
        Set hashSet = new HashSet();
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (Object add : columnNames) {
                hashSet.add(add);
            }
            if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                if (!hashSet.remove("hit_app_id")) {
                    obj = 1;
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                } else if (obj != null) {
                    sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                    return;
                } else {
                    return;
                }
            }
            throw new SQLiteException("Database column missing");
        } finally {
            rawQuery.close();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0776t.m3960a(sQLiteDatabase.getPath());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
