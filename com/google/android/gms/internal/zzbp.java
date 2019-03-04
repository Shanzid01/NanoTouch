package com.google.android.gms.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzbp {
    private zzat zzoJ;
    private AdListener zzoK;
    private final zzdq zzpD;
    private final zzaz zzpE;
    private final AtomicBoolean zzpF;
    private zzbi zzpG;
    private String zzpH;
    private ViewGroup zzpI;
    private InAppPurchaseListener zzpJ;
    private PlayStorePurchaseListener zzpK;
    private OnCustomRenderedAdLoadedListener zzpL;
    private AppEventListener zzpd;
    private AdSize[] zzpe;
    private String zzpf;

    public zzbp(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzaz.zzbA());
    }

    public zzbp(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzaz.zzbA());
    }

    zzbp(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzaz com_google_android_gms_internal_zzaz) {
        this(viewGroup, attributeSet, z, com_google_android_gms_internal_zzaz, null);
    }

    zzbp(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzaz com_google_android_gms_internal_zzaz, zzbi com_google_android_gms_internal_zzbi) {
        this.zzpD = new zzdq();
        this.zzpI = viewGroup;
        this.zzpE = com_google_android_gms_internal_zzaz;
        this.zzpG = com_google_android_gms_internal_zzbi;
        this.zzpF = new AtomicBoolean(false);
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzbd com_google_android_gms_internal_zzbd = new zzbd(context, attributeSet);
                this.zzpe = com_google_android_gms_internal_zzbd.zzi(z);
                this.zzpf = com_google_android_gms_internal_zzbd.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzbe.zzbD().zza(viewGroup, new zzba(context, this.zzpe[0]), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzbe.zzbD().zza(viewGroup, new zzba(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private void zzbN() {
        try {
            zzd zzac = this.zzpG.zzac();
            if (zzac != null) {
                this.zzpI.addView((View) zze.zzf(zzac));
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to get an ad frame.", e);
        }
    }

    private void zzbO() {
        if ((this.zzpe == null || this.zzpf == null) && this.zzpG == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.zzpI.getContext();
        this.zzpG = zzbe.zzbE().zza(context, new zzba(context, this.zzpe), this.zzpf, this.zzpD);
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
        this.zzpG.zza(zzbe.zzbF());
        zzbN();
    }

    public void destroy() {
        try {
            if (this.zzpG != null) {
                this.zzpG.destroy();
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zzoK;
    }

    public AdSize getAdSize() {
        try {
            if (this.zzpG != null) {
                zzba zzad = this.zzpG.zzad();
                if (zzad != null) {
                    return zzad.zzbB();
                }
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to get the current AdSize.", e);
        }
        return this.zzpe != null ? this.zzpe[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.zzpe;
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

    public void pause() {
        try {
            if (this.zzpG != null) {
                this.zzpG.pause();
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (!this.zzpF.getAndSet(true)) {
            try {
                if (this.zzpG != null) {
                    this.zzpG.zzan();
                }
            } catch (Throwable e) {
                zzhx.zzd("Failed to record impression.", e);
            }
        }
    }

    public void resume() {
        try {
            if (this.zzpG != null) {
                this.zzpG.resume();
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to call resume.", e);
        }
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

    public void setAdSizes(AdSize... adSizeArr) {
        if (this.zzpe != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        if (this.zzpf != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
        this.zzpL = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzpG != null) {
                this.zzpG.zza(onCustomRenderedAdLoadedListener != null ? new zzck(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.zzpJ != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
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
                zzbO();
            }
            if (this.zzpG.zza(this.zzpE.zza(this.zzpI.getContext(), com_google_android_gms_internal_zzbo))) {
                this.zzpD.zze(com_google_android_gms_internal_zzbo.zzbJ());
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.zzpe = adSizeArr;
        try {
            if (this.zzpG != null) {
                this.zzpG.zza(new zzba(this.zzpI.getContext(), this.zzpe));
            }
        } catch (Throwable e) {
            zzhx.zzd("Failed to set the ad size.", e);
        }
        this.zzpI.requestLayout();
    }
}
