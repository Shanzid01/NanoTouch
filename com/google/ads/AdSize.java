package com.google.ads;

@Deprecated
public final class AdSize {
    public static final AdSize f1935a = new AdSize(-1, -2, "mb");
    public static final AdSize f1936b = new AdSize(320, 50, "mb");
    public static final AdSize f1937c = new AdSize(300, 250, "as");
    public static final AdSize f1938d = new AdSize(468, 60, "as");
    public static final AdSize f1939e = new AdSize(728, 90, "as");
    public static final AdSize f1940f = new AdSize(160, 600, "as");
    private final com.google.android.gms.ads.AdSize f1941g;

    private AdSize(int i, int i2, String str) {
        this(new com.google.android.gms.ads.AdSize(i, i2));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.f1941g = adSize;
    }

    public int m3713a() {
        return this.f1941g.getWidth();
    }

    public int m3714b() {
        return this.f1941g.getHeight();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.f1941g.equals(((AdSize) obj).f1941g);
    }

    public int hashCode() {
        return this.f1941g.hashCode();
    }

    public String toString() {
        return this.f1941g.toString();
    }
}
