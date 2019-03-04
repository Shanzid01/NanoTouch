package com.mopub.mobileads;

import com.facebook.internal.ServerProtocol;

/* compiled from: MraidProperty */
class bw extends bm {
    private final boolean f2471a;

    bw(boolean z) {
        this.f2471a = z;
    }

    public static bw m4602a(boolean z) {
        return new bw(z);
    }

    public String mo4141a() {
        return "viewable: " + (this.f2471a ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
    }
}
