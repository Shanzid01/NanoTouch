package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.internal.zzx;

@zzgi
public final class zzdw implements MediationBannerListener, MediationInterstitialListener {
    private final zzdt zzsS;

    public zzdw(zzdt com_google_android_gms_internal_zzdt) {
        this.zzsS = com_google_android_gms_internal_zzdt;
    }

    public void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzbd("onAdClicked must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdClicked.");
        try {
            this.zzsS.onAdClicked();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzbd("onAdClicked must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdClicked.");
        try {
            this.zzsS.onAdClicked();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzbd("onAdClosed must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdClosed.");
        try {
            this.zzsS.onAdClosed();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzbd("onAdClosed must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdClosed.");
        try {
            this.zzsS.onAdClosed();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        zzx.zzbd("onAdFailedToLoad must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.zzsS.onAdFailedToLoad(i);
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        zzx.zzbd("onAdFailedToLoad must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zzsS.onAdFailedToLoad(i);
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzbd("onAdLeftApplication must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdLeftApplication.");
        try {
            this.zzsS.onAdLeftApplication();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzbd("onAdLeftApplication must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdLeftApplication.");
        try {
            this.zzsS.onAdLeftApplication();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzbd("onAdLoaded must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdLoaded.");
        try {
            this.zzsS.onAdLoaded();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzbd("onAdLoaded must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdLoaded.");
        try {
            this.zzsS.onAdLoaded();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzbd("onAdOpened must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdOpened.");
        try {
            this.zzsS.onAdOpened();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzbd("onAdOpened must be called on the main UI thread.");
        zzhx.zzY("Adapter called onAdOpened.");
        try {
            this.zzsS.onAdOpened();
        } catch (Throwable e) {
            zzhx.zzd("Could not call onAdOpened.", e);
        }
    }
}
