package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzgi
public final class zzdy<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzdt zzsS;

    class C11841 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C11841(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClicked();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    class C11852 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C11852(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdOpened();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    class C11863 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C11863(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLoaded();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    class C11874 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C11874(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClosed();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    class C11896 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C11896(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLeftApplication();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C11907 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C11907(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdOpened();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    class C11918 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C11918(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdLoaded();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    class C11929 implements Runnable {
        final /* synthetic */ zzdy zzsV;

        C11929(zzdy com_google_android_gms_internal_zzdy) {
            this.zzsV = com_google_android_gms_internal_zzdy;
        }

        public void run() {
            try {
                this.zzsV.zzsS.onAdClosed();
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzdy(zzdt com_google_android_gms_internal_zzdt) {
        this.zzsS = com_google_android_gms_internal_zzdt;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onClick.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClicked();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzhx.zzac("onClick must be called on the main UI thread.");
        zzhw.zzzG.post(new C11841(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onDismissScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClosed();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzhx.zzac("onDismissScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C11874(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onDismissScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdClosed();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzhx.zzac("onDismissScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C11929(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        zzhx.zzY("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzhx.zzac("onFailedToReceiveAd must be called on the main UI thread.");
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzdy zzsV;

            public void run() {
                try {
                    this.zzsV.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                } catch (Throwable e) {
                    zzhx.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        zzhx.zzY("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzhx.zzac("onFailedToReceiveAd must be called on the main UI thread.");
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzdy zzsV;

            public void run() {
                try {
                    this.zzsV.zzsS.onAdFailedToLoad(zzdz.zza(errorCode));
                } catch (Throwable e) {
                    zzhx.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onLeaveApplication.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzhx.zzac("onLeaveApplication must be called on the main UI thread.");
        zzhw.zzzG.post(new C11896(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onLeaveApplication.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzhx.zzac("onLeaveApplication must be called on the main UI thread.");
        zzhw.zzzG.post(new Runnable(this) {
            final /* synthetic */ zzdy zzsV;

            {
                this.zzsV = r1;
            }

            public void run() {
                try {
                    this.zzsV.zzsS.onAdLeftApplication();
                } catch (Throwable e) {
                    zzhx.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onPresentScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdOpened();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzhx.zzac("onPresentScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C11907(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onPresentScreen.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdOpened();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzhx.zzac("onPresentScreen must be called on the main UI thread.");
        zzhw.zzzG.post(new C11852(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzhx.zzY("Adapter called onReceivedAd.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzhx.zzac("onReceivedAd must be called on the main UI thread.");
        zzhw.zzzG.post(new C11918(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzhx.zzY("Adapter called onReceivedAd.");
        if (zzbe.zzbD().zzeC()) {
            try {
                this.zzsS.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzhx.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzhx.zzac("onReceivedAd must be called on the main UI thread.");
        zzhw.zzzG.post(new C11863(this));
    }
}
