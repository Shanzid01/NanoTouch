package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings.Secure;
import com.facebook.AppEventsConstants;
import com.mopub.common.p050b.C1491n;
import com.mopub.common.p050b.C1492o;

/* compiled from: BaseUrlGenerator */
public abstract class C1476d {
    private StringBuilder f2133a;
    private boolean f2134b;

    public abstract String mo4136k(String str);

    protected void m4014a(String str, String str2) {
        this.f2133a = new StringBuilder("http://" + str + str2);
        this.f2134b = true;
    }

    protected String m4020f() {
        return this.f2133a.toString();
    }

    protected void m4017b(String str, String str2) {
        if (str2 != null && !C1491n.m4088a(str2)) {
            this.f2133a.append(mo4075a());
            this.f2133a.append(str);
            this.f2133a.append("=");
            this.f2133a.append(Uri.encode(str2));
        }
    }

    private String mo4075a() {
        if (!this.f2134b) {
            return "&";
        }
        this.f2134b = false;
        return "?";
    }

    protected void m4022l(String str) {
        m4017b("v", str);
    }

    protected void m4023m(String str) {
        m4017b("av", str);
    }

    protected void m4018c(boolean z) {
        m4017b("android_perms_ext_storage", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    protected void m4015a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strArr != null && strArr.length >= 1) {
            for (int i = 0; i < strArr.length - 1; i++) {
                stringBuilder.append(strArr[i]).append(",");
            }
            stringBuilder.append(strArr[strArr.length - 1]);
            m4017b("dn", stringBuilder.toString());
        }
    }

    protected void m4019d(boolean z) {
        if (z) {
            m4017b("dnt", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    protected void m4024n(String str) {
        m4017b("udid", str);
    }

    protected String m4013a(Context context) {
        String b = C1508p.m4143b(context);
        if (b != null) {
            return "ifa:" + b;
        }
        b = Secure.getString(context.getContentResolver(), "android_id");
        return "sha:" + (b == null ? "" : C1492o.m4090a(b));
    }

    protected String m4016b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }
}
