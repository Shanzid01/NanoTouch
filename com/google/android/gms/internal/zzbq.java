package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public class zzbq {
    private final Context mContext;
    private zzat zzoJ;
    private AdListener zzoK;
    private final zzdq zzpD;
    private final zzaz zzpE;
    private zzbi zzpG;
    private String zzpH;
    private InAppPurchaseListener zzpJ;
    private PlayStorePurchaseListener zzpK;
    private OnCustomRenderedAdLoadedListener zzpL;
    private PublisherInterstitialAd zzpM;
    private AppEventListener zzpd;
    private String zzpf;

    public zzbq(Context context) {
        this(context, zzaz.zzbA(), null);
    }

    public zzbq(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzaz.zzbA(), publisherInterstitialAd);
    }

    public zzbq(Context context, zzaz com_google_android_gms_internal_zzaz, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzpD = new zzdq();
        this.mContext = context;
        this.zzpE = com_google_android_gms_internal_zzaz;
        this.zzpM = publisherInterstitialAd;
    }

    private void zzy(String str) {
        if (this.zzpf == null) {
            zzz(str);
        }
        this.zzpG = zzbe.zzbE().zza(this.mContext, new zzba(), this.zzpf, this.zzpD);
        if (this.zzoK != null) {
            this.zzpG.zza(new zzav(this.zzoK));
        }
        if (this.zzoJ != null) {
            this.zzpG.zza(new zzau(this.zzoJ));
        }
        if (this.zzpd != null) {
            this.zzpG.zza(new zzbc(this.zzpd));
        }
        if (this.zzpJ != null) {
            this.zzpG.zza(new zzft(this.zzpJ));
        }
        if (this.zzpK != null) {
            this.zzpG.zza(new zzfx(this.zzpK), this.zzpH);
        }
        if (this.zzpL != null) {
            this.zzpG.zza(new zzck(this.zzpL));
        }
    }

    private void zzz(String str) {
        if (this.zzpG == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public AdListener getAdListener() {
        return this.zzoK;
    }

    public String getAdUnitId() {
        return this.zzpf;
    }

    public AppEventListener getAppEventListener() {
        return this.zzpd;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzpJ;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzpG != null) {
                return this.zzpG.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzpL;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.zzpG != null) {
                z = this.zzpG.isReady();
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.zzoK = adListener;
            if (this.zzpG != null) {
                this.zzpG.zza(adListener != null ? new zzav(adListener) : null);
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String str) {
        if (this.zzpf != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzpf = str;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzpd = appEventListener;
            if (this.zzpG != null) {
                this.zzpG.zza(appEventListener != null ? new zzbc(appEventListener) : null);
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zzpK != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zzpJ = inAppPurchaseListener;
            if (this.zzpG != null) {
                this.zzpG.zza(inAppPurchaseListener != null ? new zzft(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzpL = onCustomRenderedAdLoadedListener;
            if (this.zzpG != null) {
                this.zzpG.zza(onCustomRenderedAdLoadedListener != null ? new zzck(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzpJ != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.zzpK = playStorePurchaseListener;
            this.zzpH = str;
            if (this.zzpG != null) {
                this.zzpG.zza(playStorePurchaseListener != null ? new zzfx(playStorePurchaseListener) : null, str);
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            zzz("show");
            this.zzpG.showInterstitial();
        } catch (Throwable e) {
            zzhx.zzd("Failed to show interstitial.", e);
        }
    }

    public void zza(zzat com_google_android_gms_internal_zzat) {
        try {
            this.zzoJ = com_google_android_gms_internal_zzat;
            if (this.zzpG != null) {
                this.zzpG.zza(com_google_android_gms_internal_zzat != null ? new zzau(com_google_android_gms_internal_zzat) : null);
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzbo com_google_android_gms_internal_zzbo) {
        try {
            if (this.zzpG == null) {
                zzy("loadAd");
            }
            if (this.zzpG.zza(this.zzpE.zza(this.mContext, com_google_android_gms_internal_zzbo))) {
                this.zzpD.zze(com_google_android_gms_internal_zzbo.zzbJ());
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to load ad.", e);
        }
    }
}
