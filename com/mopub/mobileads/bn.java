package com.mopub.mobileads;

/* compiled from: MraidProperty */
class bn extends bm {
    private final int f2456a;
    private final int f2457b;

    bn(int i, int i2) {
        this.f2456a = i;
        this.f2457b = i2;
    }

    public static bn m4588a(int i, int i2) {
        return new bn(i, i2);
    }

    public String mo4141a() {
        return "screenSize: { width: " + this.f2456a + ", height: " + this.f2457b + " }";
    }
}
