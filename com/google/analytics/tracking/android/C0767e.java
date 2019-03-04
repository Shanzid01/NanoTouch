package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.IAnalyticsService.Stub;

/* compiled from: AnalyticsGmsCoreClient */
final class C0767e implements ServiceConnection {
    final /* synthetic */ C0766d f2058a;

    C0767e(C0766d c0766d) {
        this.f2058a = c0766d;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        av.m3815b("service connected, binder: " + iBinder);
        try {
            if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(iBinder.getInterfaceDescriptor())) {
                av.m3815b("bound to service");
                this.f2058a.f2057e = Stub.asInterface(iBinder);
                this.f2058a.m3926g();
                return;
            }
        } catch (RemoteException e) {
        }
        this.f2058a.f2056d.unbindService(this);
        this.f2058a.f2053a = null;
        this.f2058a.f2055c.mo1221a(2, null);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        av.m3815b("service disconnected: " + componentName);
        this.f2058a.f2053a = null;
        this.f2058a.f2054b.mo1223b();
    }
}
