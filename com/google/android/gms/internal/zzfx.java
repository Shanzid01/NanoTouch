package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzfs.zza;

@zzgi
public final class zzfx extends zza {
    private final PlayStorePurchaseListener zzpK;

    public zzfx(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzpK = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String str) {
        return this.zzpK.isValidPurchase(str);
    }

    public void zza(zzfr com_google_android_gms_internal_zzfr) {
        this.zzpK.onInAppPurchaseFinished(new zzfv(com_google_android_gms_internal_zzfr));
    }
}
