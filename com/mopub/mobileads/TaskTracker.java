package com.mopub.mobileads;

public class TaskTracker {
    private long f2364a = -1;
    private long f2365b;

    public long m4412a() {
        return this.f2364a;
    }

    public void m4414b() {
        this.f2364a++;
    }

    public void m4413a(long j) {
        if (j > this.f2365b) {
            this.f2365b = j;
        }
    }

    public boolean m4415b(long j) {
        return j >= this.f2365b;
    }
}
