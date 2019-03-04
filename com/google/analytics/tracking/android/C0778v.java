package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: GAServiceManager */
public class C0778v implements bi {
    private static final Object f2094a = new Object();
    private static C0778v f2095m;
    private Context f2096b;
    private C0761h f2097c;
    private volatile C0758j f2098d;
    private int f2099e = 1800;
    private boolean f2100f = true;
    private boolean f2101g = true;
    private boolean f2102h = true;
    private C0770i f2103i = new C0779w(this);
    private Handler f2104j;
    private C0777u f2105k;
    private boolean f2106l = false;

    public static C0778v m3961a() {
        if (f2095m == null) {
            f2095m = new C0778v();
        }
        return f2095m;
    }

    private C0778v() {
    }

    private void m3967e() {
        this.f2105k = new C0777u(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f2096b.registerReceiver(this.f2105k, intentFilter);
    }

    private void m3968f() {
        this.f2104j = new Handler(this.f2096b.getMainLooper(), new C0780x(this));
        if (this.f2099e > 0) {
            this.f2104j.sendMessageDelayed(this.f2104j.obtainMessage(1, f2094a), (long) (this.f2099e * 1000));
        }
    }

    synchronized void m3970a(Context context, C0758j c0758j) {
        if (this.f2096b == null) {
            this.f2096b = context.getApplicationContext();
            if (this.f2098d == null) {
                this.f2098d = c0758j;
                if (this.f2100f) {
                    c0758j.mo1181a();
                }
            }
        }
    }

    synchronized C0761h m3973b() {
        if (this.f2097c == null) {
            if (this.f2096b == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.f2097c = new be(this.f2103i, this.f2096b);
        }
        if (this.f2104j == null) {
            m3968f();
        }
        if (this.f2105k == null && this.f2102h) {
            m3967e();
        }
        return this.f2097c;
    }

    public synchronized void mo1218c() {
        if (this.f2098d == null) {
            av.m3821h("dispatch call queued.  Need to call GAServiceManager.getInstance().initialize().");
            this.f2100f = true;
        } else {
            am.m3786a().m3787a(an.DISPATCH);
            this.f2098d.mo1181a();
        }
    }

    public synchronized void mo1216a(int i) {
        if (this.f2104j == null) {
            av.m3821h("Need to call initialize() and be in fallback mode to start dispatch.");
            this.f2099e = i;
        } else {
            am.m3786a().m3787a(an.SET_DISPATCH_PERIOD);
            if (!this.f2106l && this.f2101g && this.f2099e > 0) {
                this.f2104j.removeMessages(1, f2094a);
            }
            this.f2099e = i;
            if (i > 0 && !this.f2106l && this.f2101g) {
                this.f2104j.sendMessageDelayed(this.f2104j.obtainMessage(1, f2094a), (long) (i * 1000));
            }
        }
    }

    @VisibleForTesting
    synchronized void m3972a(boolean z, boolean z2) {
        if (!(this.f2106l == z && this.f2101g == z2)) {
            if (z || !z2) {
                if (this.f2099e > 0) {
                    this.f2104j.removeMessages(1, f2094a);
                }
            }
            if (!z && z2 && this.f2099e > 0) {
                this.f2104j.sendMessageDelayed(this.f2104j.obtainMessage(1, f2094a), (long) (this.f2099e * 1000));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            av.m3818e(append.append(str).toString());
            this.f2106l = z;
            this.f2101g = z2;
        }
    }

    public synchronized void mo1217a(boolean z) {
        m3972a(this.f2106l, z);
    }
}
