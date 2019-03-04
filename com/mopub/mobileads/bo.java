package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.ViewState;

/* compiled from: MraidProperty */
class bo extends bm {
    private final ViewState f2458a;

    bo(ViewState viewState) {
        this.f2458a = viewState;
    }

    public static bo m4590a(ViewState viewState) {
        return new bo(viewState);
    }

    public String mo4141a() {
        return "state: '" + this.f2458a.toString().toLowerCase() + "'";
    }
}
