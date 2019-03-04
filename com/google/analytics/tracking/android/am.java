package com.google.analytics.tracking.android;

import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: GAUsage */
class am {
    private static final am f1993d = new am();
    private SortedSet<an> f1994a = new TreeSet();
    private StringBuilder f1995b = new StringBuilder();
    private boolean f1996c = false;

    public static am m3786a() {
        return f1993d;
    }

    private am() {
    }

    public synchronized void m3788a(boolean z) {
        this.f1996c = z;
    }

    public synchronized void m3787a(an anVar) {
        if (!this.f1996c) {
            this.f1994a.add(anVar);
            this.f1995b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(anVar.ordinal()));
        }
    }

    public synchronized String m3789b() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        int i = 6;
        int i2 = 0;
        while (this.f1994a.size() > 0) {
            an anVar = (an) this.f1994a.first();
            this.f1994a.remove(anVar);
            int ordinal = anVar.ordinal();
            while (ordinal >= i) {
                stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                i += 6;
                i2 = 0;
            }
            i2 += 1 << (anVar.ordinal() % 6);
        }
        if (i2 > 0 || stringBuilder.length() == 0) {
            stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
        }
        this.f1994a.clear();
        return stringBuilder.toString();
    }

    public synchronized String m3790c() {
        String stringBuilder;
        if (this.f1995b.length() > 0) {
            this.f1995b.insert(0, ".");
        }
        stringBuilder = this.f1995b.toString();
        this.f1995b = new StringBuilder();
        return stringBuilder;
    }
}
