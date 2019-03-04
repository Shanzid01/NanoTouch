package com.google.p043a.p045b.p046a;

import com.google.p043a.al;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: TypeAdapters */
final class aq extends al<Calendar> {
    aq() {
    }

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3363a(c0683a);
    }

    public Calendar m3363a(C0683a c0683a) {
        int i = 0;
        if (c0683a.mo1130f() == C0734c.NULL) {
            c0683a.mo1134j();
            return null;
        }
        c0683a.mo1126c();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (c0683a.mo1130f() != C0734c.END_OBJECT) {
            String g = c0683a.mo1131g();
            int m = c0683a.mo1137m();
            if ("year".equals(g)) {
                i6 = m;
            } else if ("month".equals(g)) {
                i5 = m;
            } else if ("dayOfMonth".equals(g)) {
                i4 = m;
            } else if ("hourOfDay".equals(g)) {
                i3 = m;
            } else if ("minute".equals(g)) {
                i2 = m;
            } else if ("second".equals(g)) {
                i = m;
            }
        }
        c0683a.mo1128d();
        return new GregorianCalendar(i6, i5, i4, i3, i2, i);
    }

    public void m3365a(C0686d c0686d, Calendar calendar) {
        if (calendar == null) {
            c0686d.mo1152f();
            return;
        }
        c0686d.mo1150d();
        c0686d.mo1143a("year");
        c0686d.mo1141a((long) calendar.get(1));
        c0686d.mo1143a("month");
        c0686d.mo1141a((long) calendar.get(2));
        c0686d.mo1143a("dayOfMonth");
        c0686d.mo1141a((long) calendar.get(5));
        c0686d.mo1143a("hourOfDay");
        c0686d.mo1141a((long) calendar.get(11));
        c0686d.mo1143a("minute");
        c0686d.mo1141a((long) calendar.get(12));
        c0686d.mo1143a("second");
        c0686d.mo1141a((long) calendar.get(13));
        c0686d.mo1151e();
    }
}
