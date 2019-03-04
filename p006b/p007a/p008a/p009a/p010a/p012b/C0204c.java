package p006b.p007a.p008a.p009a.p010a.p012b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p017f.C0292c;
import p006b.p007a.p008a.p009a.p010a.p017f.C0293d;

/* compiled from: AdvertisingInfoProvider */
class C0204c {
    private final Context f776a;
    private final C0292c f777b;

    public C0204c(Context context) {
        this.f776a = context.getApplicationContext();
        this.f777b = new C0293d(context, "TwitterAdvertisingInfoPreferences");
    }

    public C0203b m1872a() {
        C0203b b = m1873b();
        if (m1870c(b)) {
            C0326f.m2298h().mo511a("Fabric", "Using AdvertisingInfo from Preference Store");
            m1867a(b);
            return b;
        }
        b = m1871e();
        m1869b(b);
        return b;
    }

    private void m1867a(C0203b c0203b) {
        new Thread(new C0206d(this, c0203b)).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m1869b(C0203b c0203b) {
        if (m1870c(c0203b)) {
            this.f777b.mo501a(this.f777b.mo502b().putString("advertising_id", c0203b.f774a).putBoolean("limit_ad_tracking_enabled", c0203b.f775b));
        } else {
            this.f777b.mo501a(this.f777b.mo502b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected C0203b m1873b() {
        return new C0203b(this.f777b.mo500a().getString("advertising_id", ""), this.f777b.mo500a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public C0207j m1874c() {
        return new C0208e(this.f776a);
    }

    public C0207j m1875d() {
        return new C0209f(this.f776a);
    }

    private boolean m1870c(C0203b c0203b) {
        return (c0203b == null || TextUtils.isEmpty(c0203b.f774a)) ? false : true;
    }

    private C0203b m1871e() {
        C0203b a = m1874c().mo468a();
        if (m1870c(a)) {
            C0326f.m2298h().mo511a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = m1875d().mo468a();
            if (m1870c(a)) {
                C0326f.m2298h().mo511a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                C0326f.m2298h().mo511a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
