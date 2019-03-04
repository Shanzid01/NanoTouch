package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzat;
import com.google.android.gms.internal.zzbq;

public final class InterstitialAd {
    private final zzbq zzlm;

    public InterstitialAd(Context context) {
        this.zzlm = new zzbq(context);
    }

    public AdListener getAdListener() {
        return this.zzlm.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzlm.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzlm.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzlm.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.zzlm.isLoaded();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzlm.zza(adRequest.zzY());
    }

    public void setAdListener(AdListener adListener) {
        this.zzlm.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzat)) {
            this.zzlm.zza((zzat) adListener);
        } else if (adListener == null) {
            this.zzlm.zza(null);
        }
    }

    public void setAdUnitId(String str) {
        this.zzlm.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zzlm.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.zzlm.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }

    public void show() {
        this.zzlm.show();
    }
}
