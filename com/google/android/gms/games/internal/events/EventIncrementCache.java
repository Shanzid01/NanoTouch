package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzahN = new Object();
    private Handler zzahO;
    private boolean zzahP;
    private HashMap<String, AtomicInteger> zzahQ;
    private int zzahR;

    class C11291 implements Runnable {
        final /* synthetic */ EventIncrementCache zzahS;

        C11291(EventIncrementCache eventIncrementCache) {
            this.zzahS = eventIncrementCache;
        }

        public void run() {
            this.zzahS.zzog();
        }
    }

    public EventIncrementCache(Looper looper, int i) {
        this.zzahO = new Handler(looper);
        this.zzahQ = new HashMap();
        this.zzahR = i;
    }

    private void zzog() {
        synchronized (this.zzahN) {
            this.zzahP = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzahN) {
            for (Entry entry : this.zzahQ.entrySet()) {
                zzs((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzahQ.clear();
        }
    }

    protected abstract void zzs(String str, int i);

    public void zzz(String str, int i) {
        synchronized (this.zzahN) {
            if (!this.zzahP) {
                this.zzahP = true;
                this.zzahO.postDelayed(new C11291(this), (long) this.zzahR);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzahQ.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzahQ.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
