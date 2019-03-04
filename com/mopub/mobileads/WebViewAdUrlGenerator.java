package com.mopub.mobileads;

import android.content.Context;
import android.os.Build;
import com.mopub.common.C1477a;
import com.mopub.common.C1508p;
import com.mopub.mobileads.util.C1559e;

public class WebViewAdUrlGenerator extends C1477a {
    public WebViewAdUrlGenerator(Context context) {
        super(context);
    }

    public String mo4136k(String str) {
        m4014a(str, "/m/ad");
        m4022l("6");
        m4039c(this.d);
        m4041d("2.2");
        m4015a(Build.MANUFACTURER, Build.MODEL, Build.PRODUCT);
        m4024n(m4013a(this.a));
        m4019d(C1508p.m4145c(this.a));
        m4043e(m4470c(this.e, m4469a(this.a, this.g)));
        m4036b(this.f);
        m4044f(C1477a.m4026b());
        m4033a(this.a.getResources().getConfiguration().orientation);
        m4032a(this.a.getResources().getDisplayMetrics().density);
        m4037b(m4471g());
        String a = mo4075a();
        m4045g(a);
        m4046h(a);
        m4047i(this.b.getNetworkCountryIso());
        m4048j(this.b.getNetworkOperatorName());
        m4035b(m4038c());
        m4023m(m4016b(this.a));
        m4018c(C1559e.m4667c(this.a));
        m4040d();
        return m4020f();
    }

    private boolean m4471g() {
        try {
            Class.forName("com.mopub.mobileads.MraidView");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static String m4469a(Context context, boolean z) {
        if (!z) {
            return null;
        }
        try {
            Class cls = Class.forName("com.mopub.mobileads.FacebookKeywordProvider");
            return (String) cls.getMethod("getKeyword", new Class[]{Context.class}).invoke(cls, new Object[]{context});
        } catch (Exception e) {
            return null;
        }
    }

    private static String m4470c(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return (str == null || str.length() == 0) ? str2 : new StringBuilder(String.valueOf(str)).append(",").append(str2).toString();
    }
}
