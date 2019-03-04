package com.slideme.sam.manager.inapp;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: InAppHelperActivity */
class C1788e implements ServiceConnection {
    final /* synthetic */ InAppHelperActivity f3214a;

    C1788e(InAppHelperActivity inAppHelperActivity) {
        this.f3214a = inAppHelperActivity;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f3214a.f3181a = false;
        this.f3214a.f3184d = null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3214a.f3184d = C1786c.m5352a(iBinder);
        this.f3214a.f3181a = true;
        this.f3214a.m5325a();
    }
}
