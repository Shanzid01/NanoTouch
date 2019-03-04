package com.mopub.common;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class C1498f implements Closeable {
    static final Pattern f2159a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream f2160l = new C1499g();
    final ThreadPoolExecutor f2161b;
    private final File f2162c;
    private long f2163d;
    private final int f2164e;
    private long f2165f;
    private Writer f2166g;
    private final LinkedHashMap<String, C1502j> f2167h;
    private int f2168i;
    private long f2169j;
    private final Callable<Void> f2170k;

    private static void m4101a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized C1503k m4108a(String str) {
        int i;
        C1503k c1503k = null;
        synchronized (this) {
            m4106e();
            m4104d(str);
            C1502j c1502j = (C1502j) this.f2167h.get(str);
            if (c1502j != null) {
                if (c1502j.f2180d) {
                    r6 = new InputStream[this.f2164e];
                    int i2 = 0;
                    while (i2 < this.f2164e) {
                        try {
                            r6[i2] = new FileInputStream(c1502j.m4127a(i2));
                            i2++;
                        } catch (FileNotFoundException e) {
                            i = 0;
                            while (i < this.f2164e && r6[i] != null) {
                                InputStream[] inputStreamArr;
                                C1504l.m4130a(inputStreamArr[i]);
                                i++;
                            }
                        }
                    }
                    this.f2168i++;
                    this.f2166g.append("READ " + str + '\n');
                    if (m4105d()) {
                        this.f2161b.submit(this.f2170k);
                    }
                    c1503k = new C1503k(this, str, c1502j.f2182f, inputStreamArr, c1502j.f2179c);
                }
            }
        }
        return c1503k;
    }

    public C1500h m4110b(String str) {
        return m4098a(str, -1);
    }

    private synchronized C1500h m4098a(String str, long j) {
        C1500h c1500h;
        m4106e();
        m4104d(str);
        C1502j c1502j = (C1502j) this.f2167h.get(str);
        if (j == -1 || (c1502j != null && c1502j.f2182f == j)) {
            C1502j c1502j2;
            if (c1502j == null) {
                c1502j = new C1502j(this, str);
                this.f2167h.put(str, c1502j);
                c1502j2 = c1502j;
            } else if (c1502j.f2181e != null) {
                c1500h = null;
            } else {
                c1502j2 = c1502j;
            }
            c1500h = new C1500h(this, c1502j2);
            c1502j2.f2181e = c1500h;
            this.f2166g.write("DIRTY " + str + '\n');
            this.f2166g.flush();
        } else {
            c1500h = null;
        }
        return c1500h;
    }

    public File m4109a() {
        return this.f2162c;
    }

    private synchronized void m4100a(C1500h c1500h, boolean z) {
        int i = 0;
        synchronized (this) {
            C1502j a = c1500h.f2172b;
            if (a.f2181e != c1500h) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f2180d) {
                    int i2 = 0;
                    while (i2 < this.f2164e) {
                        if (!c1500h.f2173c[i2]) {
                            c1500h.m4118b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.m4129b(i2).exists()) {
                            c1500h.m4118b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f2164e) {
                File b = a.m4129b(i);
                if (!z) {
                    C1498f.m4101a(b);
                } else if (b.exists()) {
                    File a2 = a.m4127a(i);
                    b.renameTo(a2);
                    long j = a.f2179c[i];
                    long length = a2.length();
                    a.f2179c[i] = length;
                    this.f2165f = (this.f2165f - j) + length;
                }
                i++;
            }
            this.f2168i++;
            a.f2181e = null;
            if ((a.f2180d | z) != 0) {
                a.f2180d = true;
                this.f2166g.write("CLEAN " + a.f2178b + a.m4128a() + '\n');
                if (z) {
                    long j2 = this.f2169j;
                    this.f2169j = 1 + j2;
                    a.f2182f = j2;
                }
            } else {
                this.f2167h.remove(a.f2178b);
                this.f2166g.write("REMOVE " + a.f2178b + '\n');
            }
            this.f2166g.flush();
            if (this.f2165f > this.f2163d || m4105d()) {
                this.f2161b.submit(this.f2170k);
            }
        }
    }

    private boolean m4105d() {
        return this.f2168i >= 2000 && this.f2168i >= this.f2167h.size();
    }

    public synchronized boolean m4112c(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            m4106e();
            m4104d(str);
            C1502j c1502j = (C1502j) this.f2167h.get(str);
            if (c1502j == null || c1502j.f2181e != null) {
                z = false;
            } else {
                while (i < this.f2164e) {
                    File a = c1502j.m4127a(i);
                    if (!a.exists() || a.delete()) {
                        this.f2165f -= c1502j.f2179c[i];
                        c1502j.f2179c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f2168i++;
                this.f2166g.append("REMOVE " + str + '\n');
                this.f2167h.remove(str);
                if (m4105d()) {
                    this.f2161b.submit(this.f2170k);
                }
                z = true;
            }
        }
        return z;
    }

    private void m4106e() {
        if (this.f2166g == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void m4111b() {
        m4106e();
        m4107f();
        this.f2166g.flush();
    }

    public synchronized void close() {
        if (this.f2166g != null) {
            Iterator it = new ArrayList(this.f2167h.values()).iterator();
            while (it.hasNext()) {
                C1502j c1502j = (C1502j) it.next();
                if (c1502j.f2181e != null) {
                    c1502j.f2181e.m4118b();
                }
            }
            m4107f();
            this.f2166g.close();
            this.f2166g = null;
        }
    }

    private void m4107f() {
        while (this.f2165f > this.f2163d) {
            m4112c((String) ((Entry) this.f2167h.entrySet().iterator().next()).getKey());
        }
    }

    private void m4104d(String str) {
        if (!f2159a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }
}
