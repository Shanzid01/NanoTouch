package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter */
public final class C0698u extends al<Date> {
    public static final am f1766a = new C0699v();
    private final DateFormat f1767b = new SimpleDateFormat("MMM d, yyyy");

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3555a(c0683a);
    }

    public synchronized Date m3555a(C0683a c0683a) {
        Date date;
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            date = null;
        } else {
            try {
                date = new Date(this.f1767b.parse(c0683a.mo1132h()).getTime());
            } catch (Throwable e) {
                throw new ae(e);
            }
        }
        return date;
    }

    public synchronized void m3557a(C0686d c0686d, Date date) {
        c0686d.mo1147b(date == null ? null : this.f1767b.format(date));
    }
}
