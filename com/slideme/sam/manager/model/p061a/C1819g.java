package com.slideme.sam.manager.model.p061a;

import android.content.Intent;
import android.support.v4.content.C0090q;
import android.text.TextUtils;
import com.slideme.sam.manager.net.C1782r;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: SAMUpdateManager */
class C1819g implements C1782r {
    final /* synthetic */ C1818f f3256a;
    private final /* synthetic */ String f3257b;

    C1819g(C1818f c1818f, String str) {
        this.f3256a = c1818f;
        this.f3257b = str;
    }

    public void onFinish(String str) {
        if (TextUtils.isEmpty(str)) {
            C0090q.m145a(this.f3256a.f3253a).m150a(new Intent("com.slideme.sam.manager.ACTION_NOTIFICATION_BANNER_REFRESH"));
            return;
        }
        try {
            float parseFloat = Float.parseFloat(str);
            if (parseFloat > Float.parseFloat(this.f3257b)) {
                this.f3256a.f3255c = C1822j.CHECK;
                this.f3256a.m5460b(parseFloat);
                return;
            }
            this.f3256a.f3255c = C1822j.NOUPDATE;
            C0090q.m145a(this.f3256a.f3253a).m150a(new Intent("com.slideme.sam.manager.ACTION_NOTIFICATION_BANNER_REFRESH"));
        } catch (Exception e) {
            C1922m.m5790a(e);
        }
    }
}
