package com.slideme.sam.manager.auth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SlidemeAuthenticatorService extends Service {
    public IBinder onBind(Intent intent) {
        return new C1607i(this).getIBinder();
    }
}
