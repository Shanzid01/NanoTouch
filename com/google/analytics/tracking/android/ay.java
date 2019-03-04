package com.google.analytics.tracking.android;

/* compiled from: MetaModel */
public class ay {
    private final String f2015a;
    private final String f2016b;
    private final ax f2017c;

    public ay(String str, String str2, ax axVar) {
        this.f2015a = str;
        this.f2016b = str2;
        this.f2017c = axVar;
    }

    public String m3828a(String str) {
        String str2 = null;
        if (!str.contains("*")) {
            return this.f2015a;
        }
        String str3 = this.f2015a;
        String[] split = str.split("\\*");
        if (split.length <= 1) {
            return str2;
        }
        try {
            return str3 + Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            av.m3821h("Unable to parse slot for url parameter " + str3);
            return str2;
        }
    }

    public String m3827a() {
        return this.f2016b;
    }

    public ax m3829b() {
        return this.f2017c;
    }
}
