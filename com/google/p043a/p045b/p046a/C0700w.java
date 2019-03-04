package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* compiled from: TimeTypeAdapter */
public final class C0700w extends al<Time> {
    public static final am f1768a = new C0701x();
    private final DateFormat f1769b = new SimpleDateFormat("hh:mm:ss a");

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3560a(c0683a);
    }

    public synchronized Time m3560a(C0683a c0683a) {
        Time time;
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            time = null;
        } else {
            try {
                time = new Time(this.f1769b.parse(c0683a.mo1132h()).getTime());
            } catch (Throwable e) {
                throw new ae(e);
            }
        }
        return time;
    }

    public synchronized void m3562a(C0686d c0686d, Time time) {
        c0686d.mo1147b(time == null ? null : this.f1769b.format(time));
    }
}
