package com.mopub.common.p050b;

import android.os.Build.VERSION;

/* compiled from: VersionCode */
public enum C1493p {
    BASE(1),
    BASE_1_1(2),
    CUPCAKE(3),
    DONUT(4),
    ECLAIR(5),
    ECLAIR_0_1(6),
    ECLAIR_MR1(7),
    FROYO(8),
    GINGERBREAD(9),
    GINGERBREAD_MR1(10),
    HONEYCOMB(11),
    HONEYCOMB_MR1(12),
    HONEYCOMB_MR2(13),
    ICE_CREAM_SANDWICH(14),
    ICE_CREAM_SANDWICH_MR1(15),
    JELLY_BEAN(16),
    JELLY_BEAN_MR1(17),
    JELLY_BEAN_MR2(18),
    CUR_DEVELOPMENT(10000);
    
    private int mApiLevel;

    public static C1493p currentApiLevel() {
        return C1493p.forApiLevel(VERSION.SDK_INT);
    }

    private static C1493p forApiLevel(int i) {
        for (C1493p c1493p : C1493p.values()) {
            if (c1493p.getApiLevel() == i) {
                return c1493p;
            }
        }
        return CUR_DEVELOPMENT;
    }

    private C1493p(int i) {
        this.mApiLevel = i;
    }

    public int getApiLevel() {
        return this.mApiLevel;
    }

    public boolean isAtMost(C1493p c1493p) {
        return getApiLevel() <= c1493p.getApiLevel();
    }

    public boolean isAtLeast(C1493p c1493p) {
        return getApiLevel() >= c1493p.getApiLevel();
    }

    public boolean isBelow(C1493p c1493p) {
        return getApiLevel() < c1493p.getApiLevel();
    }
}
