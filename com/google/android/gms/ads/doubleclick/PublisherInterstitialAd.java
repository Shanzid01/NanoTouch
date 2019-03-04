package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzbq;

public final class PublisherInterstitialAd {
    private final zzbq zzlm;

    public PublisherInterstitialAd(Context context) {
        this.zzlm = new zzbq(context, this);
    }

    public AdListener getAdListener() {
        return this.zzlm.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzlm.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzlm.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzlm.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzlm.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoaded() {
        return this.zzlm.isLoaded();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzlm.zza(publisherAdRequest.zzY());
    }

    public void setAdListener(AdListener adListener) {
        this.zzlm.setAdListener(adListener);
    }

    public void setAdUnitId(String str) {
        this.zzlm.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zzlm.setAppEventListener(appEventListener);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzlm.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public void show() {
        this.zzlm.show();
    }
}
