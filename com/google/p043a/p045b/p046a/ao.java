package com.google.p043a.p045b.p046a;

import com.google.p043a.C0743k;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p048c.C0731a;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters */
final class ao implements am {
    ao() {
    }

    public <T> al<T> mo1123a(C0743k c0743k, C0731a<T> c0731a) {
        if (c0731a.m3660a() != Timestamp.class) {
            return null;
        }
        return new ap(this, c0743k.m3672a(Date.class));
    }
}
