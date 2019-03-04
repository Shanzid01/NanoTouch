package com.google.analytics.tracking.android;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: GAServiceManager */
class C0780x implements Callback {
    final /* synthetic */ C0778v f2108a;

    C0780x(C0778v c0778v) {
        this.f2108a = c0778v;
    }

    public boolean handleMessage(Message message) {
        if (1 == message.what && C0778v.f2094a.equals(message.obj)) {
            am.m3786a().m3788a(true);
            this.f2108a.mo1218c();
            am.m3786a().m3788a(false);
            if (this.f2108a.f2099e > 0 && !this.f2108a.f2106l) {
                this.f2108a.f2104j.sendMessageDelayed(this.f2108a.f2104j.obtainMessage(1, C0778v.f2094a), (long) (this.f2108a.f2099e * 1000));
            }
        }
        return true;
    }
}
