package com.google.p043a.p045b;

import com.google.p043a.C0675w;
import com.google.p043a.C0754x;
import com.google.p043a.C0755y;
import com.google.p043a.ae;
import com.google.p043a.p045b.p046a.C0703z;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import java.io.Writer;

/* compiled from: Streams */
public final class ag {
    public static C0675w m3582a(C0683a c0683a) {
        Object obj = 1;
        try {
            c0683a.mo1130f();
            obj = null;
            return (C0675w) C0703z.f1788P.mo1122b(c0683a);
        } catch (Throwable e) {
            if (obj != null) {
                return C0755y.f1932a;
            }
            throw new ae(e);
        } catch (Throwable e2) {
            throw new ae(e2);
        } catch (Throwable e22) {
            throw new C0754x(e22);
        } catch (Throwable e222) {
            throw new ae(e222);
        }
    }

    public static void m3584a(C0675w c0675w, C0686d c0686d) {
        C0703z.f1788P.mo1121a(c0686d, c0675w);
    }

    public static Writer m3583a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new ai(appendable);
    }
}
