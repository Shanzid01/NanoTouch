package com.slideme.sam.manager.util.cache;

public class CacheItem {
    public int duration;
    public String key;
    public String payload;
    public String payloadClassName;
    public long timestamp;

    public CacheItem(String str, String str2) {
        this(str, str2, String.class.getName(), 60);
    }

    public CacheItem(String str, String str2, String str3) {
        this(str, str2, str3, 60);
    }

    public CacheItem(String str, String str2, String str3, int i) {
        this.key = str;
        this.payload = str2;
        this.duration = i;
        this.payloadClassName = str3;
        this.timestamp = System.currentTimeMillis();
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.timestamp + (60000 * ((long) this.duration));
    }
}
