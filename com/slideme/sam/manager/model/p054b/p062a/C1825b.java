package com.slideme.sam.manager.model.p054b.p062a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.CurrencyResponse;
import com.slideme.sam.manager.util.C1922m;
import java.util.HashMap;

/* compiled from: CurrencyDatabase */
class C1825b extends C1600v {
    final /* synthetic */ C1824a f3264a;

    C1825b(C1824a c1824a) {
        this.f3264a = c1824a;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        HashMap hashMap = ((CurrencyResponse) baseNetworkResponse).rates;
        if (hashMap != null) {
            SQLiteDatabase writableDatabase = this.f3264a.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (String str : hashMap.keySet()) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("currency_code", str);
                    contentValues.put("exchange_rate", (Double) hashMap.get(str));
                    contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                    writableDatabase.delete("currencies", "currency_code = '" + str + "'", null);
                    writableDatabase.insert("currencies", null, contentValues);
                } catch (Throwable e) {
                    C1922m.m5791a(e);
                    return;
                } finally {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                    this.f3264a.f3263a = false;
                }
            }
            writableDatabase.setTransactionSuccessful();
        }
    }

    public void mo4231a() {
        this.f3264a.f3263a = false;
    }
}
