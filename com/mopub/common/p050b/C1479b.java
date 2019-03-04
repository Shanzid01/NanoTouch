package com.mopub.common.p050b;

import java.util.Date;
import java.util.TimeZone;

/* compiled from: DateAndTime */
public class C1479b {
    protected static C1479b f2147a = new C1479b();

    public static TimeZone m4051a() {
        return f2147a.m4053c();
    }

    public static Date m4052b() {
        return f2147a.m4054d();
    }

    public TimeZone m4053c() {
        return TimeZone.getDefault();
    }

    public Date m4054d() {
        return new Date();
    }
}
