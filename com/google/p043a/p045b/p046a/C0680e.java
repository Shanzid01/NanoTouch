package com.google.p043a.p045b.p046a;

import com.google.p043a.ae;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DateTypeAdapter */
public final class C0680e extends al<Date> {
    public static final am f1703a = new C0681f();
    private final DateFormat f1704b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat f1705c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat f1706d = C0680e.m3419a();

    public /* synthetic */ Object mo1122b(C0683a c0683a) {
        return m3421a(c0683a);
    }

    private static DateFormat m3419a() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    public Date m3421a(C0683a c0683a) {
        if (c0683a.mo1130f() != C0734c.NULL) {
            return m3420a(c0683a.mo1132h());
        }
        c0683a.mo1134j();
        return null;
    }

    private synchronized Date m3420a(String str) {
        Date parse;
        try {
            parse = this.f1705c.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f1704b.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.f1706d.parse(str);
                } catch (Throwable e3) {
                    throw new ae(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void m3423a(C0686d c0686d, Date date) {
        if (date == null) {
            c0686d.mo1152f();
        } else {
            c0686d.mo1147b(this.f1704b.format(date));
        }
    }
}
