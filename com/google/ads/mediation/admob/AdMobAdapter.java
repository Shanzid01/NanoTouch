package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.zzat;
import com.google.android.gms.internal.zzbe;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView f1951a;
    private InterstitialAd f1952b;

    final class zza extends AdListener implements zzat {
        final AdMobAdapter f1947a;
        final MediationBannerListener f1948b;

        public zza(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f1947a = adMobAdapter;
            this.f1948b = mediationBannerListener;
        }

        public void onAdClicked() {
            this.f1948b.onAdClicked(this.f1947a);
        }

        public void onAdClosed() {
            this.f1948b.onAdClosed(this.f1947a);
        }

        public void onAdFailedToLoad(int i) {
            this.f1948b.onAdFailedToLoad(this.f1947a, i);
        }

        public void onAdLeftApplication() {
            this.f1948b.onAdLeftApplication(this.f1947a);
        }

        public void onAdLoaded() {
            this.f1948b.onAdLoaded(this.f1947a);
        }

        public void onAdOpened() {
            this.f1948b.onAdOpened(this.f1947a);
        }
    }

    final class zzb extends AdListener implements zzat {
        final AdMobAdapter f1949a;
        final MediationInterstitialListener f1950b;

        public zzb(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f1949a = adMobAdapter;
            this.f1950b = mediationInterstitialListener;
        }

        public void onAdClicked() {
            this.f1950b.onAdClicked(this.f1949a);
        }

        public void onAdClosed() {
            this.f1950b.onAdClosed(this.f1949a);
        }

        public void onAdFailedToLoad(int i) {
            this.f1950b.onAdFailedToLoad(this.f1949a, i);
        }

        public void onAdLeftApplication() {
            this.f1950b.onAdLeftApplication(this.f1949a);
        }

        public void onAdLoaded() {
            this.f1950b.onAdLoaded(this.f1949a);
        }

        public void onAdOpened() {
            this.f1950b.onAdOpened(this.f1949a);
        }
    }

    static AdRequest m3726a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(zzbe.zzbD().zzz(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.f1951a;
    }

    public void onDestroy() {
        if (this.f1951a != null) {
            this.f1951a.destroy();
            this.f1951a = null;
        }
        if (this.f1952b != null) {
            this.f1952b = null;
        }
    }

    public void onPause() {
        if (this.f1951a != null) {
            this.f1951a.pause();
        }
    }

    public void onResume() {
        if (this.f1951a != null) {
            this.f1951a.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f1951a = new AdView(context);
        this.f1951a.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f1951a.setAdUnitId(bundle.getString("pubid"));
        this.f1951a.setAdListener(new zza(this, mediationBannerListener));
        this.f1951a.loadAd(m3726a(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f1952b = new InterstitialAd(context);
        this.f1952b.setAdUnitId(bundle.getString("pubid"));
        this.f1952b.setAdListener(new zzb(this, mediationInterstitialListener));
        this.f1952b.loadAd(m3726a(context, mediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.f1952b.show();
    }
}
