package com.github.amlcurran.showcaseview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ApiUtils */
public class C0649g {
    public boolean m3225a(int i) {
        return VERSION.SDK_INT >= i;
    }

    @TargetApi(14)
    public void m3224a(View view) {
        if (m3225a(14)) {
            view.setFitsSystemWindows(true);
        }
    }
}
