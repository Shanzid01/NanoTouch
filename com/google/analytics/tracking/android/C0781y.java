package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: GAServiceProxy */
class C0781y implements bj, C0768f, C0769g {
    private volatile long f2109a;
    private volatile ac f2110b;
    private volatile C0765c f2111c;
    private C0761h f2112d;
    private C0761h f2113e;
    private final C0758j f2114f;
    private final Context f2115g;
    private final Queue<af> f2116h;
    private volatile int f2117i;
    private volatile Timer f2118j;
    private volatile Timer f2119k;
    private volatile Timer f2120l;
    private boolean f2121m;
    private boolean f2122n;
    private C0762l f2123o;
    private long f2124p;

    C0781y(Context context, C0758j c0758j, C0761h c0761h) {
        this.f2116h = new ConcurrentLinkedQueue();
        this.f2124p = 300000;
        this.f2113e = c0761h;
        this.f2115g = context;
        this.f2114f = c0758j;
        this.f2123o = new C0782z(this);
        this.f2117i = 0;
        this.f2110b = ac.DISCONNECTED;
    }

    C0781y(Context context, C0758j c0758j) {
        this(context, c0758j, null);
    }

    public void mo1222a(Map<String, String> map, long j, String str, List<Command> list) {
        av.m3818e("putHit called");
        this.f2116h.add(new af(map, j, str, list));
        m3985g();
    }

    public void mo1224c() {
        switch (this.f2110b) {
            case CONNECTED_LOCAL:
                m3987h();
                return;
            case CONNECTED_SERVICE:
                return;
            default:
                this.f2121m = true;
                return;
        }
    }

    public void m3999d() {
        av.m3818e("clearHits called");
        this.f2116h.clear();
        switch (this.f2110b) {
            case CONNECTED_LOCAL:
                this.f2112d.mo1196a(0);
                this.f2122n = false;
                return;
            case CONNECTED_SERVICE:
                this.f2111c.mo1203a();
                this.f2122n = false;
                return;
            default:
                this.f2122n = true;
                return;
        }
    }

    private Timer m3976a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private void m3983f() {
        this.f2118j = m3976a(this.f2118j);
        this.f2119k = m3976a(this.f2119k);
        this.f2120l = m3976a(this.f2120l);
    }

    public void mo1225e() {
        if (this.f2111c == null) {
            this.f2111c = new C0766d(this.f2115g, this, this);
            m3991j();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m3985g() {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0063 }
        r3 = r8.f2114f;	 Catch:{ all -> 0x0063 }
        r3 = r3.mo1186c();	 Catch:{ all -> 0x0063 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0063 }
        if (r2 != 0) goto L_0x0021;
    L_0x0011:
        r2 = r8.f2114f;	 Catch:{ all -> 0x0063 }
        r2 = r2.mo1185b();	 Catch:{ all -> 0x0063 }
        r3 = new com.google.analytics.tracking.android.aa;	 Catch:{ all -> 0x0063 }
        r3.<init>(r8);	 Catch:{ all -> 0x0063 }
        r2.add(r3);	 Catch:{ all -> 0x0063 }
    L_0x001f:
        monitor-exit(r8);
        return;
    L_0x0021:
        r2 = r8.f2122n;	 Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x0028;
    L_0x0025:
        r8.m3999d();	 Catch:{ all -> 0x0063 }
    L_0x0028:
        r2 = com.google.analytics.tracking.android.ab.f1966a;	 Catch:{ all -> 0x0063 }
        r3 = r8.f2110b;	 Catch:{ all -> 0x0063 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0063 }
        r2 = r2[r3];	 Catch:{ all -> 0x0063 }
        switch(r2) {
            case 1: goto L_0x0036;
            case 2: goto L_0x006e;
            case 3: goto L_0x00aa;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0063 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r2 = r8.f2116h;	 Catch:{ all -> 0x0063 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0063 }
        if (r2 != 0) goto L_0x0066;
    L_0x003e:
        r2 = r8.f2116h;	 Catch:{ all -> 0x0063 }
        r2 = r2.poll();	 Catch:{ all -> 0x0063 }
        r0 = r2;
        r0 = (com.google.analytics.tracking.android.af) r0;	 Catch:{ all -> 0x0063 }
        r7 = r0;
        r2 = "Sending hit to store";
        com.google.analytics.tracking.android.av.m3818e(r2);	 Catch:{ all -> 0x0063 }
        r2 = r8.f2112d;	 Catch:{ all -> 0x0063 }
        r3 = r7.m3743a();	 Catch:{ all -> 0x0063 }
        r4 = r7.m3744b();	 Catch:{ all -> 0x0063 }
        r6 = r7.m3745c();	 Catch:{ all -> 0x0063 }
        r7 = r7.m3746d();	 Catch:{ all -> 0x0063 }
        r2.mo1197a(r3, r4, r6, r7);	 Catch:{ all -> 0x0063 }
        goto L_0x0036;
    L_0x0063:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x0066:
        r2 = r8.f2121m;	 Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x001f;
    L_0x006a:
        r8.m3987h();	 Catch:{ all -> 0x0063 }
        goto L_0x001f;
    L_0x006e:
        r2 = r8.f2116h;	 Catch:{ all -> 0x0063 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0063 }
        if (r2 != 0) goto L_0x00a0;
    L_0x0076:
        r2 = r8.f2116h;	 Catch:{ all -> 0x0063 }
        r2 = r2.peek();	 Catch:{ all -> 0x0063 }
        r0 = r2;
        r0 = (com.google.analytics.tracking.android.af) r0;	 Catch:{ all -> 0x0063 }
        r7 = r0;
        r2 = "Sending hit to service";
        com.google.analytics.tracking.android.av.m3818e(r2);	 Catch:{ all -> 0x0063 }
        r2 = r8.f2111c;	 Catch:{ all -> 0x0063 }
        r3 = r7.m3743a();	 Catch:{ all -> 0x0063 }
        r4 = r7.m3744b();	 Catch:{ all -> 0x0063 }
        r6 = r7.m3745c();	 Catch:{ all -> 0x0063 }
        r7 = r7.m3746d();	 Catch:{ all -> 0x0063 }
        r2.mo1204a(r3, r4, r6, r7);	 Catch:{ all -> 0x0063 }
        r2 = r8.f2116h;	 Catch:{ all -> 0x0063 }
        r2.poll();	 Catch:{ all -> 0x0063 }
        goto L_0x006e;
    L_0x00a0:
        r2 = r8.f2123o;	 Catch:{ all -> 0x0063 }
        r2 = r2.mo1198a();	 Catch:{ all -> 0x0063 }
        r8.f2109a = r2;	 Catch:{ all -> 0x0063 }
        goto L_0x001f;
    L_0x00aa:
        r2 = "Need to reconnect";
        com.google.analytics.tracking.android.av.m3818e(r2);	 Catch:{ all -> 0x0063 }
        r2 = r8.f2116h;	 Catch:{ all -> 0x0063 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0063 }
        if (r2 != 0) goto L_0x001f;
    L_0x00b7:
        r8.m3991j();	 Catch:{ all -> 0x0063 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.y.g():void");
    }

    private void m3987h() {
        this.f2112d.mo1195a();
        this.f2121m = false;
    }

    private synchronized void m3988i() {
        if (this.f2110b != ac.CONNECTED_LOCAL) {
            m3983f();
            av.m3818e("falling back to local store");
            if (this.f2113e != null) {
                this.f2112d = this.f2113e;
            } else {
                C0778v a = C0778v.m3961a();
                a.m3970a(this.f2115g, this.f2114f);
                this.f2112d = a.m3973b();
            }
            this.f2110b = ac.CONNECTED_LOCAL;
            m3985g();
        }
    }

    private synchronized void m3991j() {
        if (this.f2111c == null || this.f2110b == ac.CONNECTED_LOCAL) {
            av.m3821h("client not initialized.");
            m3988i();
        } else {
            try {
                this.f2117i++;
                m3976a(this.f2119k);
                this.f2110b = ac.CONNECTING;
                this.f2119k = new Timer("Failed Connect");
                this.f2119k.schedule(new ae(), 3000);
                av.m3818e("connecting to Analytics service");
                this.f2111c.mo1205b();
            } catch (SecurityException e) {
                av.m3821h("security exception on connectToService");
                m3988i();
            }
        }
    }

    private synchronized void m3992k() {
        if (this.f2111c != null && this.f2110b == ac.CONNECTED_SERVICE) {
            this.f2110b = ac.PENDING_DISCONNECT;
            this.f2111c.mo1206c();
        }
    }

    public synchronized void mo1220a() {
        this.f2119k = m3976a(this.f2119k);
        this.f2117i = 0;
        av.m3818e("Connected to service");
        this.f2110b = ac.CONNECTED_SERVICE;
        m3985g();
        this.f2120l = m3976a(this.f2120l);
        this.f2120l = new Timer("disconnect check");
        this.f2120l.schedule(new ad(), this.f2124p);
    }

    public synchronized void mo1223b() {
        if (this.f2110b == ac.PENDING_DISCONNECT) {
            av.m3818e("Disconnected from service");
            m3983f();
            this.f2110b = ac.DISCONNECTED;
        } else {
            av.m3818e("Unexpected disconnect.");
            this.f2110b = ac.PENDING_CONNECTION;
            if (this.f2117i < 2) {
                m3993l();
            } else {
                m3988i();
            }
        }
    }

    public synchronized void mo1221a(int i, Intent intent) {
        this.f2110b = ac.PENDING_CONNECTION;
        if (this.f2117i < 2) {
            av.m3821h("Service unavailable (code=" + i + "), will retry.");
            m3993l();
        } else {
            av.m3821h("Service unavailable (code=" + i + "), using local store.");
            m3988i();
        }
    }

    private void m3993l() {
        this.f2118j = m3976a(this.f2118j);
        this.f2118j = new Timer("Service Reconnect");
        this.f2118j.schedule(new ag(), 5000);
    }
}
