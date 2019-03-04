package com.google.p043a.p045b.p046a;

import com.google.p043a.C0675w;
import com.google.p043a.al;
import com.google.p043a.am;
import com.google.p043a.p048c.C0731a;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

/* compiled from: TypeAdapters */
public final class C0703z {
    public static final al<StringBuffer> f1773A = new ai();
    public static final am f1774B = C0703z.m3569a(StringBuffer.class, f1773A);
    public static final al<URL> f1775C = new aj();
    public static final am f1776D = C0703z.m3569a(URL.class, f1775C);
    public static final al<URI> f1777E = new ak();
    public static final am f1778F = C0703z.m3569a(URI.class, f1777E);
    public static final al<InetAddress> f1779G = new am();
    public static final am f1780H = C0703z.m3571b(InetAddress.class, f1779G);
    public static final al<UUID> f1781I = new an();
    public static final am f1782J = C0703z.m3569a(UUID.class, f1781I);
    public static final am f1783K = new ao();
    public static final al<Calendar> f1784L = new aq();
    public static final am f1785M = C0703z.m3572b(Calendar.class, GregorianCalendar.class, f1784L);
    public static final al<Locale> f1786N = new ar();
    public static final am f1787O = C0703z.m3569a(Locale.class, f1786N);
    public static final al<C0675w> f1788P = new as();
    public static final am f1789Q = C0703z.m3571b(C0675w.class, f1788P);
    public static final am f1790R = new at();
    public static final al<Class> f1791a = new aa();
    public static final am f1792b = C0703z.m3569a(Class.class, f1791a);
    public static final al<BitSet> f1793c = new al();
    public static final am f1794d = C0703z.m3569a(BitSet.class, f1793c);
    public static final al<Boolean> f1795e = new ax();
    public static final al<Boolean> f1796f = new bb();
    public static final am f1797g = C0703z.m3570a(Boolean.TYPE, Boolean.class, f1795e);
    public static final al<Number> f1798h = new bc();
    public static final am f1799i = C0703z.m3570a(Byte.TYPE, Byte.class, f1798h);
    public static final al<Number> f1800j = new bd();
    public static final am f1801k = C0703z.m3570a(Short.TYPE, Short.class, f1800j);
    public static final al<Number> f1802l = new be();
    public static final am f1803m = C0703z.m3570a(Integer.TYPE, Integer.class, f1802l);
    public static final al<Number> f1804n = new bf();
    public static final al<Number> f1805o = new bg();
    public static final al<Number> f1806p = new ab();
    public static final al<Number> f1807q = new ac();
    public static final am f1808r = C0703z.m3569a(Number.class, f1807q);
    public static final al<Character> f1809s = new ad();
    public static final am f1810t = C0703z.m3570a(Character.TYPE, Character.class, f1809s);
    public static final al<String> f1811u = new ae();
    public static final al<BigDecimal> f1812v = new af();
    public static final al<BigInteger> f1813w = new ag();
    public static final am f1814x = C0703z.m3569a(String.class, f1811u);
    public static final al<StringBuilder> f1815y = new ah();
    public static final am f1816z = C0703z.m3569a(StringBuilder.class, f1815y);

    public static <TT> am m3568a(C0731a<TT> c0731a, al<TT> alVar) {
        return new au(c0731a, alVar);
    }

    public static <TT> am m3569a(Class<TT> cls, al<TT> alVar) {
        return new av(cls, alVar);
    }

    public static <TT> am m3570a(Class<TT> cls, Class<TT> cls2, al<? super TT> alVar) {
        return new aw(cls, cls2, alVar);
    }

    public static <TT> am m3572b(Class<TT> cls, Class<? extends TT> cls2, al<? super TT> alVar) {
        return new ay(cls, cls2, alVar);
    }

    public static <TT> am m3571b(Class<TT> cls, al<TT> alVar) {
        return new az(cls, alVar);
    }
}
