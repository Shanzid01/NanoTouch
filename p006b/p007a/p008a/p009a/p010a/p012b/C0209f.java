package p006b.p007a.p008a.p009a.p010a.p012b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesUtil;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AdvertisingInfoServiceStrategy */
class C0209f implements C0207j {
    private final Context f781a;

    public C0209f(Context context) {
        this.f781a = context.getApplicationContext();
    }

    public C0203b mo468a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C0326f.m2298h().mo511a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f781a.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            ServiceConnection c0211h = new C0211h();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
            try {
                if (this.f781a.bindService(intent, c0211h, 1)) {
                    C0212i c0212i = new C0212i(c0211h.m1885a());
                    C0203b c0203b = new C0203b(c0212i.m1886a(), c0212i.m1887b());
                    this.f781a.unbindService(c0211h);
                    return c0203b;
                }
                C0326f.m2298h().mo511a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Throwable e) {
                C0326f.m2298h().mo517d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.f781a.unbindService(c0211h);
                return null;
            } catch (Throwable e2) {
                C0326f.m2298h().mo512a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", e2);
                return null;
            }
        } catch (NameNotFoundException e3) {
            C0326f.m2298h().mo511a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Throwable e22) {
            C0326f.m2298h().mo512a("Fabric", "Unable to determine if Google Play Services is available", e22);
            return null;
        }
    }
}
