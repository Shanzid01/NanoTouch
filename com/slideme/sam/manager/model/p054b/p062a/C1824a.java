package com.slideme.sam.manager.model.p054b.p062a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.AppEventsConstants;
import com.slideme.sam.manager.SAM;
import java.util.HashMap;

/* compiled from: CurrencyDatabase */
public class C1824a extends SQLiteOpenHelper {
    private static HashMap<String, Double> f3262b = new HashMap();
    private boolean f3263a = false;

    public C1824a(Context context) {
        super(context, "currency_db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS currencies (currency_code TEXT PRIMARY KEY, exchange_rate REAL NOT NULL, timestamp INTEGER NOT NULL)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void m5480a(String str, boolean z) {
        if (!this.f3263a) {
            if (m5481b() || z) {
                this.f3263a = true;
                SAM.f2614g.m5615a(new C1825b(this));
            }
        }
    }

    public long m5479a() {
        long j;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor query = readableDatabase.query("currencies", new String[]{"timestamp"}, null, null, null, null, "timestamp ASC", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (query.moveToFirst()) {
            j = query.getLong(0);
        } else {
            j = 0;
        }
        query.close();
        readableDatabase.close();
        return j;
    }

    public boolean m5481b() {
        return System.currentTimeMillis() - m5479a() > 86400000;
    }

    public double m5478a(String str) {
        Double d = (Double) f3262b.get(str);
        if (d != null) {
            return d.doubleValue();
        }
        double d2;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor query = readableDatabase.query("currencies", new String[]{"exchange_rate"}, "currency_code = '" + str + "'", null, null, null, null);
        if (query.moveToFirst()) {
            d2 = (double) query.getFloat(0);
        } else {
            d2 = -1.0d;
        }
        query.close();
        readableDatabase.close();
        f3262b.put(str, Double.valueOf(d2));
        return d2;
    }
}
