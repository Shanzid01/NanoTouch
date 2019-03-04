package com.p026b.p027a.p034b.p039d;

import com.p026b.p027a.p034b.p035a.C0475c;
import java.io.InputStream;

/* compiled from: SlowNetworkImageDownloader */
public class C0504g implements C0498c {
    private final C0498c f1468a;

    public C0504g(C0498c c0498c) {
        this.f1468a = c0498c;
    }

    public InputStream mo936a(String str, Object obj) {
        InputStream a = this.f1468a.mo936a(str, obj);
        switch (C0505h.f1469a[C0501d.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return new C0475c(a);
            default:
                return a;
        }
    }
}
