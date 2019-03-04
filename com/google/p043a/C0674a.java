package com.google.p043a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DefaultDateTypeAdapter */
final class C0674a implements ad<Date>, C0673v<Date> {
    private final DateFormat f1664a;
    private final DateFormat f1665b;
    private final DateFormat f1666c;

    public /* synthetic */ Object deserialize(C0675w c0675w, Type type, C0744u c0744u) {
        return m3262a(c0675w, type, c0744u);
    }

    C0674a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    C0674a(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    public C0674a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    C0674a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f1664a = dateFormat;
        this.f1665b = dateFormat2;
        this.f1666c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.f1666c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public C0675w m3261a(Date date, Type type, ac acVar) {
        C0675w abVar;
        synchronized (this.f1665b) {
            abVar = new ab(this.f1664a.format(date));
        }
        return abVar;
    }

    public Date m3262a(C0675w c0675w, Type type, C0744u c0744u) {
        if (c0675w instanceof ab) {
            Date a = m3259a(c0675w);
            if (type == Date.class) {
                return a;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
        }
        throw new aa("The date should be a string value");
    }

    private Date m3259a(C0675w c0675w) {
        Date parse;
        synchronized (this.f1665b) {
            try {
                parse = this.f1665b.parse(c0675w.mo1114b());
            } catch (ParseException e) {
                try {
                    parse = this.f1664a.parse(c0675w.mo1114b());
                } catch (ParseException e2) {
                    try {
                        parse = this.f1666c.parse(c0675w.mo1114b());
                    } catch (Throwable e3) {
                        throw new ae(c0675w.mo1114b(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0674a.class.getSimpleName());
        stringBuilder.append('(').append(this.f1665b.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }
}
