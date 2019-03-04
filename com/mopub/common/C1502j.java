package com.mopub.common;

import java.io.File;

/* compiled from: DiskLruCache */
final class C1502j {
    final /* synthetic */ C1498f f2177a;
    private final String f2178b;
    private final long[] f2179c;
    private boolean f2180d;
    private C1500h f2181e;
    private long f2182f;

    private C1502j(C1498f c1498f, String str) {
        this.f2177a = c1498f;
        this.f2178b = str;
        this.f2179c = new long[c1498f.f2164e];
    }

    public String m4128a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : this.f2179c) {
            stringBuilder.append(' ').append(append);
        }
        return stringBuilder.toString();
    }

    public File m4127a(int i) {
        return new File(this.f2177a.f2162c, this.f2178b + "." + i);
    }

    public File m4129b(int i) {
        return new File(this.f2177a.f2162c, this.f2178b + "." + i + ".tmp");
    }
}
