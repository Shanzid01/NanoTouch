package com.slideme.sam.manager.model.p061a;

import android.content.Context;
import android.text.TextUtils;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.net.C1600v;

/* compiled from: InstalledAppsSyncHelper */
public class C1816d {
    private Context f3250a;

    public C1816d(Context context) {
        this.f3250a = context;
    }

    public void m5438a() {
        if (m5436b() && SAM.f2629v) {
            SAM.f2614g.m5627a(AuthData.m4810f(this.f3250a), C1827a.m5493a(this.f3250a), new C1600v());
        }
    }

    private boolean m5436b() {
        return System.currentTimeMillis() - m5437c() > 604800000;
    }

    private long m5437c() {
        if (TextUtils.isEmpty(AuthData.m4810f(this.f3250a))) {
            return this.f3250a.getSharedPreferences("intalledapps_preferences", 0).getLong("installedAppsSyncHelperLastUpdate_" + AuthData.m4810f(this.f3250a), 0);
        }
        return 0;
    }
}
