package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Tracker */
class bo {
    private Map<String, String> f2050a;
    private Map<String, String> f2051b;

    private bo() {
        this.f2050a = new HashMap();
        this.f2051b = new HashMap();
    }

    public synchronized void m3903a(String str, String str2) {
        this.f2050a.put(str, str2);
    }

    public synchronized void m3906b(String str, String str2) {
        this.f2051b.put(str, str2);
    }

    public synchronized void m3902a() {
        this.f2050a.clear();
    }

    public synchronized void m3904a(Map<String, String> map, Boolean bool) {
        if (bool.booleanValue()) {
            this.f2050a.putAll(map);
        } else {
            this.f2051b.putAll(map);
        }
    }

    public synchronized Map<String, String> m3905b() {
        Map<String, String> hashMap;
        hashMap = new HashMap(this.f2051b);
        hashMap.putAll(this.f2050a);
        return hashMap;
    }
}
