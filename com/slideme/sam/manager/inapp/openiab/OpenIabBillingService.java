package com.slideme.sam.manager.inapp.openiab;

import android.content.Intent;
import android.os.IBinder;
import com.slideme.sam.manager.inapp.AccountAwareService;

public class OpenIabBillingService extends AccountAwareService {
    private C1802a f3230b;

    public void onCreate() {
        super.onCreate();
        this.f3230b = new C1802a();
    }

    public IBinder onBind(Intent intent) {
        return this.f3230b;
    }
}
