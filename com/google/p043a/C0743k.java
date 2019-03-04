package com.google.p043a;

import com.google.p043a.p045b.C0709f;
import com.google.p043a.p045b.C0722s;
import com.google.p043a.p045b.af;
import com.google.p043a.p045b.ag;
import com.google.p043a.p045b.p046a.C0676a;
import com.google.p043a.p045b.p046a.C0678c;
import com.google.p043a.p045b.p046a.C0680e;
import com.google.p043a.p045b.p046a.C0682g;
import com.google.p043a.p045b.p046a.C0689l;
import com.google.p043a.p045b.p046a.C0691n;
import com.google.p043a.p045b.p046a.C0694q;
import com.google.p043a.p045b.p046a.C0698u;
import com.google.p043a.p045b.p046a.C0700w;
import com.google.p043a.p045b.p046a.C0703z;
import com.google.p043a.p047d.C0683a;
import com.google.p043a.p047d.C0686d;
import com.google.p043a.p047d.C0734c;
import com.google.p043a.p048c.C0731a;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Gson */
public final class C0743k {
    final C0744u f1900a;
    final ac f1901b;
    private final ThreadLocal<Map<C0731a<?>, C0750q<?>>> f1902c;
    private final Map<C0731a<?>, al<?>> f1903d;
    private final List<am> f1904e;
    private final C0709f f1905f;
    private final boolean f1906g;
    private final boolean f1907h;
    private final boolean f1908i;
    private final boolean f1909j;

    public C0743k() {
        this(C0722s.f1870a, C0737d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, af.DEFAULT, Collections.emptyList());
    }

    C0743k(C0722s c0722s, C0736j c0736j, Map<Type, C0752s<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, af afVar, List<am> list) {
        this.f1902c = new ThreadLocal();
        this.f1903d = Collections.synchronizedMap(new HashMap());
        this.f1900a = new C0745l(this);
        this.f1901b = new C0746m(this);
        this.f1905f = new C0709f(map);
        this.f1906g = z;
        this.f1908i = z3;
        this.f1907h = z4;
        this.f1909j = z5;
        List arrayList = new ArrayList();
        arrayList.add(C0703z.f1789Q);
        arrayList.add(C0691n.f1749a);
        arrayList.add(c0722s);
        arrayList.addAll(list);
        arrayList.add(C0703z.f1814x);
        arrayList.add(C0703z.f1803m);
        arrayList.add(C0703z.f1797g);
        arrayList.add(C0703z.f1799i);
        arrayList.add(C0703z.f1801k);
        arrayList.add(C0703z.m3570a(Long.TYPE, Long.class, m3663a(afVar)));
        arrayList.add(C0703z.m3570a(Double.TYPE, Double.class, m3664a(z6)));
        arrayList.add(C0703z.m3570a(Float.TYPE, Float.class, m3669b(z6)));
        arrayList.add(C0703z.f1808r);
        arrayList.add(C0703z.f1810t);
        arrayList.add(C0703z.f1816z);
        arrayList.add(C0703z.f1774B);
        arrayList.add(C0703z.m3569a(BigDecimal.class, C0703z.f1812v));
        arrayList.add(C0703z.m3569a(BigInteger.class, C0703z.f1813w));
        arrayList.add(C0703z.f1776D);
        arrayList.add(C0703z.f1778F);
        arrayList.add(C0703z.f1782J);
        arrayList.add(C0703z.f1787O);
        arrayList.add(C0703z.f1780H);
        arrayList.add(C0703z.f1794d);
        arrayList.add(C0680e.f1703a);
        arrayList.add(C0703z.f1785M);
        arrayList.add(C0700w.f1768a);
        arrayList.add(C0698u.f1766a);
        arrayList.add(C0703z.f1783K);
        arrayList.add(C0676a.f1680a);
        arrayList.add(C0703z.f1792b);
        arrayList.add(new C0678c(this.f1905f));
        arrayList.add(new C0689l(this.f1905f, z2));
        arrayList.add(new C0682g(this.f1905f));
        arrayList.add(C0703z.f1790R);
        arrayList.add(new C0694q(this.f1905f, c0736j, c0722s));
        this.f1904e = Collections.unmodifiableList(arrayList);
    }

    private al<Number> m3664a(boolean z) {
        if (z) {
            return C0703z.f1806p;
        }
        return new C0747n(this);
    }

    private al<Number> m3669b(boolean z) {
        if (z) {
            return C0703z.f1805o;
        }
        return new C0748o(this);
    }

    private void m3666a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private al<Number> m3663a(af afVar) {
        if (afVar == af.DEFAULT) {
            return C0703z.f1804n;
        }
        return new C0749p(this);
    }

    public <T> al<T> m3671a(C0731a<T> c0731a) {
        al<T> alVar = (al) this.f1903d.get(c0731a);
        if (alVar == null) {
            Map map;
            Map map2 = (Map) this.f1902c.get();
            Object obj = null;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.f1902c.set(hashMap);
                map = hashMap;
                obj = 1;
            } else {
                map = map2;
            }
            C0750q c0750q = (C0750q) map.get(c0731a);
            if (c0750q == null) {
                try {
                    C0750q c0750q2 = new C0750q();
                    map.put(c0731a, c0750q2);
                    for (am a : this.f1904e) {
                        alVar = a.mo1123a(this, c0731a);
                        if (alVar != null) {
                            c0750q2.m3696a(alVar);
                            this.f1903d.put(c0731a, alVar);
                            map.remove(c0731a);
                            if (obj != null) {
                                this.f1902c.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + c0731a);
                } catch (Throwable th) {
                    map.remove(c0731a);
                    if (obj != null) {
                        this.f1902c.remove();
                    }
                }
            }
        }
        return alVar;
    }

    public <T> al<T> m3670a(am amVar, C0731a<T> c0731a) {
        Object obj = null;
        if (!this.f1904e.contains(amVar)) {
            obj = 1;
        }
        Object obj2 = obj;
        for (am amVar2 : this.f1904e) {
            if (obj2 != null) {
                al<T> a = amVar2.mo1123a(this, c0731a);
                if (a != null) {
                    return a;
                }
            } else if (amVar2 == amVar) {
                obj2 = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + c0731a);
    }

    public <T> al<T> m3672a(Class<T> cls) {
        return m3671a(C0731a.m3659b(cls));
    }

    public String m3678a(Object obj) {
        if (obj == null) {
            return m3677a(C0755y.f1932a);
        }
        return m3679a(obj, obj.getClass());
    }

    public String m3679a(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        m3683a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void m3683a(Object obj, Type type, Appendable appendable) {
        try {
            m3682a(obj, type, m3665a(ag.m3583a(appendable)));
        } catch (Throwable e) {
            throw new C0754x(e);
        }
    }

    public void m3682a(Object obj, Type type, C0686d c0686d) {
        al a = m3671a(C0731a.m3657a(type));
        boolean g = c0686d.m3511g();
        c0686d.m3503b(true);
        boolean h = c0686d.m3512h();
        c0686d.m3506c(this.f1907h);
        boolean i = c0686d.m3513i();
        c0686d.m3508d(this.f1906g);
        try {
            a.mo1121a(c0686d, obj);
            c0686d.m3503b(g);
            c0686d.m3506c(h);
            c0686d.m3508d(i);
        } catch (Throwable e) {
            throw new C0754x(e);
        } catch (Throwable th) {
            c0686d.m3503b(g);
            c0686d.m3506c(h);
            c0686d.m3508d(i);
        }
    }

    public String m3677a(C0675w c0675w) {
        Appendable stringWriter = new StringWriter();
        m3681a(c0675w, stringWriter);
        return stringWriter.toString();
    }

    public void m3681a(C0675w c0675w, Appendable appendable) {
        try {
            m3680a(c0675w, m3665a(ag.m3583a(appendable)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private C0686d m3665a(Writer writer) {
        if (this.f1908i) {
            writer.write(")]}'\n");
        }
        C0686d c0686d = new C0686d(writer);
        if (this.f1909j) {
            c0686d.m3505c("  ");
        }
        c0686d.m3508d(this.f1906g);
        return c0686d;
    }

    public void m3680a(C0675w c0675w, C0686d c0686d) {
        boolean g = c0686d.m3511g();
        c0686d.m3503b(true);
        boolean h = c0686d.m3512h();
        c0686d.m3506c(this.f1907h);
        boolean i = c0686d.m3513i();
        c0686d.m3508d(this.f1906g);
        try {
            ag.m3584a(c0675w, c0686d);
            c0686d.m3503b(g);
            c0686d.m3506c(h);
            c0686d.m3508d(i);
        } catch (Throwable e) {
            throw new C0754x(e);
        } catch (Throwable th) {
            c0686d.m3503b(g);
            c0686d.m3506c(h);
            c0686d.m3508d(i);
        }
    }

    public <T> T m3675a(String str, Class<T> cls) {
        return af.m3579a((Class) cls).cast(m3676a(str, (Type) cls));
    }

    public <T> T m3676a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return m3674a(new StringReader(str), type);
    }

    public <T> T m3674a(Reader reader, Type type) {
        C0683a c0683a = new C0683a(reader);
        Object a = m3673a(c0683a, type);
        C0743k.m3668a(a, c0683a);
        return a;
    }

    private static void m3668a(Object obj, C0683a c0683a) {
        if (obj != null) {
            try {
                if (c0683a.mo1130f() != C0734c.END_DOCUMENT) {
                    throw new C0754x("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new ae(e);
            } catch (Throwable e2) {
                throw new C0754x(e2);
            }
        }
    }

    public <T> T m3673a(C0683a c0683a, Type type) {
        boolean z = true;
        boolean p = c0683a.m3467p();
        c0683a.m3453a(true);
        try {
            c0683a.mo1130f();
            z = false;
            T b = m3671a(C0731a.m3657a(type)).mo1122b(c0683a);
            c0683a.m3453a(p);
            return b;
        } catch (Throwable e) {
            if (z) {
                c0683a.m3453a(p);
                return null;
            }
            throw new ae(e);
        } catch (Throwable e2) {
            throw new ae(e2);
        } catch (Throwable e22) {
            throw new ae(e22);
        } catch (Throwable th) {
            c0683a.m3453a(p);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f1906g + "factories:" + this.f1904e + ",instanceCreators:" + this.f1905f + "}";
    }
}
