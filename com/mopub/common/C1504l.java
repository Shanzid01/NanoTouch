package com.mopub.common;

import java.io.Closeable;
import java.nio.charset.Charset;

/* compiled from: DiskLruCacheUtil */
public final class C1504l {
    static final Charset f2188a = Charset.forName("US-ASCII");
    static final Charset f2189b = Charset.forName("UTF-8");

    static void m4130a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }
}
