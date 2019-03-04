package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzds.zza;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzgi
public final class zzdv extends zza {
    private final MediationAdapter zzsR;

    public zzdv(MediationAdapter mediationAdapter) {
        this.zzsR = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) {
        zzhx.zzac("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.zzsR instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            zzhx.zzd("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void destroy() {
        try {
            this.zzsR.onDestroy();
        } catch (Throwable th) {
            zzhx.zzd("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzd getView() {
        if (this.zzsR instanceof MediationBannerAdapter) {
            try {
                return zze.zzn(((MediationBannerAdapter) this.zzsR).getBannerView());
            } catch (Throwable th) {
                zzhx.zzd("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationBannerAdapter: " + this.zzsR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() {
        try {
            this.zzsR.onPause();
        } catch (Throwable th) {
            zzhx.zzd("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() {
        try {
            this.zzsR.onResume();
        } catch (Throwable th) {
            zzhx.zzd("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() {
        if (this.zzsR instanceof MediationInterstitialAdapter) {
            zzhx.zzY("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzsR).showInterstitial();
            } catch (Throwable th) {
                zzhx.zzd("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzsR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, zzax com_google_android_gms_internal_zzax, String str, zzdt com_google_android_gms_internal_zzdt) {
        zza(com_google_android_gms_dynamic_zzd, com_google_android_gms_internal_zzax, str, null, com_google_android_gms_internal_zzdt);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, zzax com_google_android_gms_internal_zzax, String str, String str2, zzdt com_google_android_gms_internal_zzdt) {
        if (this.zzsR instanceof MediationInterstitialAdapter) {
            zzhx.zzY("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzsR;
                mediationInterstitialAdapter.requestInterstitialAd((Context) zze.zzf(com_google_android_gms_dynamic_zzd), new zzdw(com_google_android_gms_internal_zzdt), zza(str, com_google_android_gms_internal_zzax.zzoP, str2), new zzdu(new Date(com_google_android_gms_internal_zzax.zzoL), com_google_android_gms_internal_zzax.zzoM, com_google_android_gms_internal_zzax.zzoN != null ? new HashSet(com_google_android_gms_internal_zzax.zzoN) : null, com_google_android_gms_internal_zzax.zzoT, com_google_android_gms_internal_zzax.zzoO, com_google_android_gms_internal_zzax.zzoP), com_google_android_gms_internal_zzax.zzoV != null ? com_google_android_gms_internal_zzax.zzoV.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzhx.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzsR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, zzba com_google_android_gms_internal_zzba, zzax com_google_android_gms_internal_zzax, String str, zzdt com_google_android_gms_internal_zzdt) {
        zza(com_google_android_gms_dynamic_zzd, com_google_android_gms_internal_zzba, com_google_android_gms_internal_zzax, str, null, com_google_android_gms_internal_zzdt);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, zzba com_google_android_gms_internal_zzba, zzax com_google_android_gms_internal_zzax, String str, String str2, zzdt com_google_android_gms_internal_zzdt) {
        Bundle bundle = null;
        if (this.zzsR instanceof MediationBannerAdapter) {
            zzhx.zzY("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzsR;
                zzdu com_google_android_gms_internal_zzdu = new zzdu(new Date(com_google_android_gms_internal_zzax.zzoL), com_google_android_gms_internal_zzax.zzoM, com_google_android_gms_internal_zzax.zzoN != null ? new HashSet(com_google_android_gms_internal_zzax.zzoN) : null, com_google_android_gms_internal_zzax.zzoT, com_google_android_gms_internal_zzax.zzoO, com_google_android_gms_internal_zzax.zzoP);
                if (com_google_android_gms_internal_zzax.zzoV != null) {
                    bundle = com_google_android_gms_internal_zzax.zzoV.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) zze.zzf(com_google_android_gms_dynamic_zzd), new zzdw(com_google_android_gms_internal_zzdt), zza(str, com_google_android_gms_internal_zzax.zzoP, str2), com.google.android.gms.ads.zza.zza(com_google_android_gms_internal_zzba.width, com_google_android_gms_internal_zzba.height, com_google_android_gms_internal_zzba.zzpa), com_google_android_gms_internal_zzdu, bundle);
            } catch (Throwable th) {
                zzhx.zzd("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationBannerAdapter: " + this.zzsR.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
