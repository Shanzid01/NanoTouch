package com.p026b.p027a.p034b.p039d;

import java.io.InputStream;

/* compiled from: NetworkDeniedImageDownloader */
public class C0502e implements C0498c {
    private final C0498c f1466a;

    public C0502e(C0498c c0498c) {
        this.f1466a = c0498c;
    }

    public InputStream mo936a(String str, Object obj) {
        switch (C0503f.f1467a[C0501d.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                throw new IllegalStateException();
            default:
                return this.f1466a.mo936a(str, obj);
        }
    }
}
