package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters */
class ap extends al<Timestamp> {
    final /* synthetic */ al f1683a;
    final /* synthetic */ ao f1684b;

    ap(ao aoVar, al alVar) {
        this.f1684b = aoVar;
        this.f1683a = alVar;
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3359a(c0683a);
    }

    public Timestamp m3359a(C0683a c0683a) {
        Date date = (Date) this.f1683a.mo1122b(c0683a);
        return date != null ? new Timestamp(date.getTime()) : null;
    }

    public void m3361a(C0686d c0686d, Timestamp timestamp) {
        this.f1683a.mo1121a(c0686d, timestamp);
    }
}
