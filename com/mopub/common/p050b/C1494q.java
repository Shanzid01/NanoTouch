package com.mopub.common.p050b;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Views */
public class C1494q {
    public static void m4092a(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
