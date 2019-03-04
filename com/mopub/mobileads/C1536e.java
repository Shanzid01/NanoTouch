package com.mopub.mobileads;

import android.app.Activity;
import android.util.Log;
import org.apache.http.Header;

@Deprecated
/* compiled from: AdLoadTask */
class C1536e extends C1534c {
    private Header f2503b;

    public C1536e(AdViewController adViewController, Header header) {
        super(adViewController);
        this.f2503b = header;
    }

    void mo4142a() {
        AdViewController adViewController = (AdViewController) this.a.get();
        if (adViewController != null && !adViewController.m4265n()) {
            adViewController.m4250c();
            MoPubView a = adViewController.m4238a();
            if (this.f2503b == null) {
                Log.i("MoPub", "Couldn't call custom method because the server did not specify one.");
                a.m4347b(MoPubErrorCode.ADAPTER_NOT_FOUND);
                return;
            }
            String value = this.f2503b.getValue();
            Log.i("MoPub", "Trying to call method named " + value);
            Activity m = a.m4359m();
            try {
                m.getClass().getMethod(value, new Class[]{MoPubView.class}).invoke(m, new Object[]{a});
            } catch (NoSuchMethodException e) {
                Log.d("MoPub", "Couldn't perform custom method named " + value + "(MoPubView view) because your activity class has no such method");
                a.m4347b(MoPubErrorCode.ADAPTER_NOT_FOUND);
            } catch (Exception e2) {
                Log.d("MoPub", "Couldn't perform custom method named " + value);
                a.m4347b(MoPubErrorCode.ADAPTER_NOT_FOUND);
            }
        }
    }

    void mo4143b() {
        this.f2503b = null;
    }
}
