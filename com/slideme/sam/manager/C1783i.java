package com.slideme.sam.manager;

import android.text.TextUtils;
import com.slideme.sam.manager.net.C1782r;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: SAM */
class C1783i implements C1782r {
    final /* synthetic */ SAM f3177a;

    C1783i(SAM sam) {
        this.f3177a = sam;
    }

    public void onFinish(String str) {
        if (TextUtils.isEmpty(str)) {
            SAM.f2630y = new ArrayList();
        } else {
            SAM.f2630y = new ArrayList(Arrays.asList(str.split("\n")));
        }
    }
}
