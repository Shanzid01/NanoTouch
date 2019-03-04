package com.p019a.p020a.p022b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p011a.C0199b;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p012b.C0220t;
import p006b.p007a.p008a.p009a.p010a.p012b.C0221u;
import p006b.p007a.p008a.p009a.p010a.p012b.C0226z;
import p006b.p007a.p008a.p009a.p010a.p012b.aa;
import p006b.p007a.p008a.p009a.p010a.p012b.aj;
import p006b.p007a.p008a.p009a.p010a.p016e.C0275b;
import p006b.p007a.p008a.p009a.p010a.p017f.C0293d;
import p006b.p007a.p008a.p009a.p010a.p018g.C0299f;
import p006b.p007a.p008a.p009a.p010a.p018g.C0312q;
import p006b.p007a.p008a.p009a.p010a.p018g.C0317w;

/* compiled from: Beta */
public class C0373e extends C0337q<Boolean> implements C0221u {
    private final C0199b<String> f1166a = new C0199b();
    private final C0378j f1167b = new C0378j();
    private C0368l f1168c;

    protected /* synthetic */ Object mo532f() {
        return m2533c();
    }

    @TargetApi(14)
    protected boolean a_() {
        this.f1168c = m2528a(VERSION.SDK_INT, (Application) m2334B().getApplicationContext());
        return true;
    }

    protected Boolean m2533c() {
        C0326f.m2298h().mo511a("Beta", "Beta kit initializing...");
        Context B = m2334B();
        C0226z A = m2333A();
        if (TextUtils.isEmpty(m2526a(B, A.m1965h()))) {
            C0326f.m2298h().mo511a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        C0326f.m2298h().mo511a("Beta", "Beta device token is present, checking for app updates.");
        C0299f h = m2527h();
        C0374f a = m2525a(B);
        if (m2530a(h, a)) {
            this.f1168c.mo548a(B, this, A, h, a, new C0293d(this), new aj(), new C0275b(C0326f.m2298h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    C0368l m2528a(int i, Application application) {
        if (i >= 14) {
            return new C0370b(m2335C().m2309e(), m2335C().m2310f());
        }
        return new C0379k();
    }

    public Map<aa, String> mo549e() {
        CharSequence a = m2526a(m2334B(), m2333A().m1965h());
        Map<aa, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(aa.FONT_TOKEN, a);
        }
        return hashMap;
    }

    public String mo531b() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String mo529a() {
        return "1.1.3.61";
    }

    @TargetApi(11)
    boolean m2531a(String str, int i) {
        if (i < 11) {
            return str == null;
        } else {
            return C0220t.BETA_APP_PACKAGE_NAME.equals(str);
        }
    }

    boolean m2530a(C0299f c0299f, C0374f c0374f) {
        return (c0299f == null || TextUtils.isEmpty(c0299f.f945a) || c0374f == null) ? false : true;
    }

    private String m2526a(Context context, String str) {
        if (m2531a(str, VERSION.SDK_INT)) {
            C0326f.m2298h().mo511a("Beta", "App was possibly installed by Beta. Getting device token");
            try {
                String str2 = (String) this.f1166a.mo461a(context, this.f1167b);
                if ("".equals(str2)) {
                    str2 = null;
                }
                return str2;
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Beta", "Failed to load the Beta device token", e);
                return null;
            }
        }
        C0326f.m2298h().mo511a("Beta", "App was not installed by Beta. Skipping device token");
        return null;
    }

    private C0299f m2527h() {
        C0317w b = C0312q.m2242a().m2246b();
        if (b != null) {
            return b.f986f;
        }
        return null;
    }

    private C0374f m2525a(Context context) {
        InputStream open;
        Throwable th;
        Throwable e;
        Throwable th2;
        C0374f c0374f;
        InputStream inputStream = null;
        try {
            open = context.getAssets().open("crashlytics-build.properties");
            Object obj;
            if (open != null) {
                C0374f a;
                try {
                    a = C0374f.m2537a(open);
                } catch (Throwable e2) {
                    th = e2;
                    obj = inputStream;
                    th2 = th;
                    try {
                        C0326f.m2298h().mo519e("Beta", "Error reading Beta build properties", th2);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th22) {
                                C0326f.m2298h().mo519e("Beta", "Error closing Beta build properties asset", th22);
                            }
                        }
                        return c0374f;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th222) {
                                C0326f.m2298h().mo519e("Beta", "Error closing Beta build properties asset", th222);
                            }
                        }
                        throw e2;
                    }
                }
                try {
                    C0326f.m2298h().mo511a("Beta", a.f1172d + " build properties: " + a.f1170b + " (" + a.f1169a + ")" + " - " + a.f1171c);
                    c0374f = a;
                } catch (Throwable e22) {
                    th = e22;
                    c0374f = a;
                    th222 = th;
                    C0326f.m2298h().mo519e("Beta", "Error reading Beta build properties", th222);
                    if (open != null) {
                        open.close();
                    }
                    return c0374f;
                }
            }
            obj = inputStream;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2222) {
                    C0326f.m2298h().mo519e("Beta", "Error closing Beta build properties asset", th2222);
                }
            }
        } catch (Throwable e222) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            th2222 = e222;
            c0374f = inputStream2;
            C0326f.m2298h().mo519e("Beta", "Error reading Beta build properties", th2222);
            if (open != null) {
                open.close();
            }
            return c0374f;
        } catch (Throwable th4) {
            e222 = th4;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        return c0374f;
    }

    String m2536g() {
        return C0214m.m1921b(m2334B(), "com.crashlytics.ApiEndpoint");
    }
}
