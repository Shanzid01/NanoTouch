package com.slideme.sam.manager.inapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: AccountAwareService */
class C1784a extends BroadcastReceiver {
    C1784a() {
    }

    public void onReceive(Context context, Intent intent) {
        AccountAwareService.f3178a = intent.getBooleanExtra("com.slideme.sam.manager.extra.ACCOUNT_HANDLED", false);
        synchronized (AccountAwareService.f3179b) {
            AccountAwareService.f3179b.notifyAll();
        }
    }
}
