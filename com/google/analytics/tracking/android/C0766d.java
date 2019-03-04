package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import java.util.List;
import java.util.Map;

/* compiled from: AnalyticsGmsCoreClient */
class C0766d implements C0765c {
    private ServiceConnection f2053a;
    private C0768f f2054b;
    private C0769g f2055c;
    private Context f2056d;
    private IAnalyticsService f2057e;

    public C0766d(Context context, C0768f c0768f, C0769g c0769g) {
        this.f2056d = context;
        if (c0768f == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.f2054b = c0768f;
        if (c0769g == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.f2055c = c0769g;
    }

    public void mo1205b() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.putExtra("app_package_name", this.f2056d.getPackageName());
        if (this.f2053a != null) {
            av.m3816c("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.f2053a = new C0767e(this);
        boolean bindService = this.f2056d.bindService(intent, this.f2053a, 129);
        av.m3818e("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.f2053a = null;
            this.f2055c.mo1221a(1, null);
        }
    }

    public void mo1206c() {
        this.f2057e = null;
        if (this.f2053a != null) {
            try {
                this.f2056d.unbindService(this.f2053a);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.f2053a = null;
            this.f2054b.mo1223b();
        }
    }

    public void mo1204a(Map<String, String> map, long j, String str, List<Command> list) {
        try {
            m3925f().sendHit(map, j, str, list);
        } catch (RemoteException e) {
            av.m3816c("sendHit failed: " + e);
        }
    }

    public void mo1203a() {
        try {
            m3925f().clearHits();
        } catch (RemoteException e) {
            av.m3816c("clear hits failed: " + e);
        }
    }

    private IAnalyticsService m3925f() {
        m3932d();
        return this.f2057e;
    }

    protected void m3932d() {
        if (!m3933e()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public boolean m3933e() {
        return this.f2057e != null;
    }

    private void m3926g() {
        m3927h();
    }

    private void m3927h() {
        this.f2054b.mo1220a();
    }
}
