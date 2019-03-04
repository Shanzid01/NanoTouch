package com.slideme.sam.manager.inapp.openiab;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OpenIabStoreService extends Service {
    private C1805b f3231a;

    public void onCreate() {
        super.onCreate();
        this.f3231a = new C1805b();
    }

    public IBinder onBind(Intent intent) {
        return this.f3231a;
    }
}
