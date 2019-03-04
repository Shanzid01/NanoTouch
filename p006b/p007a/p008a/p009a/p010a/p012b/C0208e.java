package p006b.p007a.p008a.p009a.p010a.p012b;

import android.content.Context;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AdvertisingInfoReflectionStrategy */
class C0208e implements C0207j {
    private final Context f780a;

    public C0208e(Context context) {
        this.f780a = context.getApplicationContext();
    }

    boolean m1883a(Context context) {
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public C0203b mo468a() {
        if (m1883a(this.f780a)) {
            return new C0203b(m1879b(), m1880c());
        }
        return null;
    }

    private String m1879b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m1881d(), new Object[0]);
        } catch (Exception e) {
            C0326f.m2298h().mo516d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean m1880c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m1881d(), new Object[0])).booleanValue();
        } catch (Exception e) {
            C0326f.m2298h().mo516d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object m1881d() {
        Object obj = null;
        try {
            obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f780a});
        } catch (Exception e) {
            C0326f.m2298h().mo516d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
        }
        return obj;
    }
}
