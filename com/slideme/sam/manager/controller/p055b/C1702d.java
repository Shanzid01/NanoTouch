package com.slideme.sam.manager.controller.p055b;

import android.app.Activity;
import com.slideme.sam.manager.controller.activities.common.FlipperFragmentActivity;

/* compiled from: ActivityHelper */
class C1702d implements Runnable {
    final /* synthetic */ C1701c f2901a;
    private final /* synthetic */ Activity f2902b;
    private final /* synthetic */ boolean f2903c;

    C1702d(C1701c c1701c, Activity activity, boolean z) {
        this.f2901a = c1701c;
        this.f2902b = activity;
        this.f2903c = z;
    }

    public void run() {
        if ((this.f2902b instanceof FlipperFragmentActivity) && !this.f2903c) {
            try {
                ((FlipperFragmentActivity) this.f2902b).m4796e();
            } catch (Exception e) {
            }
        }
    }
}
