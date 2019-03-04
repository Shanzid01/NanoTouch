package com.slideme.sam.manager.util.p063a;

import android.animation.LayoutTransition;
import android.app.ActivityManager.MemoryInfo;

/* compiled from: JellyBeanCompatHelper */
public abstract class C1909c {
    public static final long m5751a(MemoryInfo memoryInfo) {
        return memoryInfo.totalMem;
    }

    public static void m5752a(LayoutTransition layoutTransition, int i) {
        layoutTransition.enableTransitionType(i);
    }
}
