package com.mopub.common;

import java.io.Closeable;
import java.io.InputStream;

/* compiled from: DiskLruCache */
public final class C1503k implements Closeable {
    final /* synthetic */ C1498f f2183a;
    private final String f2184b;
    private final long f2185c;
    private final InputStream[] f2186d;
    private final long[] f2187e;

    private C1503k(C1498f c1498f, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
        this.f2183a = c1498f;
        this.f2184b = str;
        this.f2185c = j;
        this.f2186d = inputStreamArr;
        this.f2187e = jArr;
    }

    public void close() {
        for (Closeable a : this.f2186d) {
            C1504l.m4130a(a);
        }
    }
}
