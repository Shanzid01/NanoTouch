package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.zzhx;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    CustomEventBanner f1958a;
    CustomEventInterstitial f1959b;
    private View f1960c;

    final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter f1953a;
        private final MediationBannerListener f1954b;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f1953a = customEventAdapter;
            this.f1954b = mediationBannerListener;
        }
    }

    class zzb implements CustomEventInterstitialListener {
        final /* synthetic */ CustomEventAdapter f1955a;
        private final CustomEventAdapter f1956b;
        private final MediationInterstitialListener f1957c;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f1955a = customEventAdapter;
            this.f1956b = customEventAdapter2;
            this.f1957c = mediationInterstitialListener;
        }
    }

    private static <T> T m3728a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            zzhx.zzac("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    zzb m3729a(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }

    public void mo1174a() {
        if (this.f1958a != null) {
            this.f1958a.m3727a();
        }
        if (this.f1959b != null) {
            this.f1959b.m3727a();
        }
    }

    public void m3732a(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f1958a = (CustomEventBanner) m3728a(customEventServerParameters.f1962b);
        if (this.f1958a == null) {
            mediationBannerListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f1958a.m3739a(new zza(this, mediationBannerListener), activity, customEventServerParameters.f1961a, customEventServerParameters.f1963c, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.f1961a));
        }
    }

    public void m3734a(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f1959b = (CustomEventInterstitial) m3728a(customEventServerParameters.f1962b);
        if (this.f1959b == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f1959b.m3740a(m3729a(mediationInterstitialListener), activity, customEventServerParameters.f1961a, customEventServerParameters.f1963c, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.f1961a));
        }
    }

    public Class<CustomEventExtras> mo1177b() {
        return CustomEventExtras.class;
    }

    public Class<CustomEventServerParameters> mo1178c() {
        return CustomEventServerParameters.class;
    }

    public View mo1179d() {
        return this.f1960c;
    }

    public void mo1180e() {
        this.f1959b.m3741b();
    }
}
