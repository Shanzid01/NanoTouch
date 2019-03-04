package com.p026b.p027a.p034b;

import android.widget.ImageView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ImageLoaderEngine */
class C0514k {
    final C0511h f1553a;
    private Executor f1554b;
    private Executor f1555c;
    private ExecutorService f1556d;
    private final Map<Integer, String> f1557e = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReentrantLock> f1558f = new WeakHashMap();
    private final AtomicBoolean f1559g = new AtomicBoolean(false);
    private final AtomicBoolean f1560h = new AtomicBoolean(false);
    private final AtomicBoolean f1561i = new AtomicBoolean(false);

    C0514k(C0511h c0511h) {
        this.f1553a = c0511h;
        this.f1554b = c0511h.f1511h;
        this.f1555c = c0511h.f1512i;
        this.f1556d = Executors.newCachedThreadPool();
    }

    void m3121a(C0517n c0517n) {
        this.f1556d.execute(new C0515l(this, c0517n));
    }

    void m3122a(C0520q c0520q) {
        m3115g();
        this.f1555c.execute(c0520q);
    }

    private void m3115g() {
        if (this.f1554b == null) {
            this.f1554b = m3116h();
        }
        if (this.f1555c == null) {
            this.f1555c = m3116h();
        }
    }

    private Executor m3116h() {
        return C0486a.m2983a(this.f1553a.f1515l, this.f1553a.f1516m, this.f1553a.f1517n);
    }

    String m3117a(ImageView imageView) {
        return (String) this.f1557e.get(Integer.valueOf(imageView.hashCode()));
    }

    void m3120a(ImageView imageView, String str) {
        this.f1557e.put(Integer.valueOf(imageView.hashCode()), str);
    }

    void m3124b(ImageView imageView) {
        this.f1557e.remove(Integer.valueOf(imageView.hashCode()));
    }

    void m3119a() {
        this.f1559g.set(true);
    }

    void m3123b() {
        synchronized (this.f1559g) {
            this.f1559g.set(false);
            this.f1559g.notifyAll();
        }
    }

    void m3125c() {
        if (!this.f1553a.f1513j) {
            this.f1554b = null;
        }
        if (!this.f1553a.f1514k) {
            this.f1555c = null;
        }
        this.f1557e.clear();
        this.f1558f.clear();
    }

    ReentrantLock m3118a(String str) {
        ReentrantLock reentrantLock = (ReentrantLock) this.f1558f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        reentrantLock = new ReentrantLock();
        this.f1558f.put(str, reentrantLock);
        return reentrantLock;
    }

    AtomicBoolean m3126d() {
        return this.f1559g;
    }

    boolean m3127e() {
        return this.f1560h.get();
    }

    boolean m3128f() {
        return this.f1561i.get();
    }
}
