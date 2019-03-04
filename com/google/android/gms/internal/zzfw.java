package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchase;

@zzgi
public class zzfw implements InAppPurchase {
    private final zzfn zzvi;

    public zzfw(zzfn com_google_android_gms_internal_zzfn) {
        this.zzvi = com_google_android_gms_internal_zzfn;
    }

    public String getProductId() {
        try {
            return this.zzvi.getProductId();
        } catch (Throwable e) {
            zzhx.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.zzvi.recordPlayBillingResolution(i);
        } catch (Throwable e) {
            zzhx.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.zzvi.recordResolution(i);
        } catch (Throwable e) {
            zzhx.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
