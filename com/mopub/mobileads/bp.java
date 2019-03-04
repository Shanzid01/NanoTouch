package com.mopub.mobileads;

/* compiled from: MraidProperty */
class bp extends bm {
    private boolean f2459a;
    private boolean f2460b;
    private boolean f2461c;
    private boolean f2462d;
    private boolean f2463e;

    bp() {
    }

    public String mo4141a() {
        return "supports: {sms: " + String.valueOf(this.f2459a) + ", " + "tel: " + String.valueOf(this.f2460b) + ", " + "calendar: " + String.valueOf(this.f2461c) + ", " + "storePicture: " + String.valueOf(this.f2462d) + ", " + "inlineVideo: " + String.valueOf(this.f2463e) + "}";
    }

    public bp m4592a(boolean z) {
        this.f2459a = z;
        return this;
    }

    public bp m4594b(boolean z) {
        this.f2460b = z;
        return this;
    }

    public bp m4595c(boolean z) {
        this.f2461c = z;
        return this;
    }

    public bp m4596d(boolean z) {
        this.f2462d = z;
        return this;
    }

    public bp m4597e(boolean z) {
        this.f2463e = z;
        return this;
    }
}
