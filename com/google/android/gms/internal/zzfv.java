package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzgi
public class zzfv implements InAppPurchaseResult {
    private final zzfr zzvx;

    public zzfv(zzfr com_google_android_gms_internal_zzfr) {
        this.zzvx = com_google_android_gms_internal_zzfr;
    }

    public void finishPurchase() {
        try {
            this.zzvx.finishPurchase();
        } catch (Throwable e) {
            zzhx.zzd("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.zzvx.getProductId();
        } catch (Throwable e) {
            zzhx.zzd("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.zzvx.getPurchaseData();
        } catch (Throwable e) {
            zzhx.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.zzvx.getResultCode();
        } catch (Throwable e) {
            zzhx.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.zzvx.isVerified();
        } catch (Throwable e) {
            zzhx.zzd("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
