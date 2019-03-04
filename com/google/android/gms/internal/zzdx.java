package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzds.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzgi
public final class zzdx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzsT;
    private final NETWORK_EXTRAS zzsU;

    public zzdx(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzsT = mediationAdapter;
        this.zzsU = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                zzhx.zzd("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class c = this.zzsT.mo1178c();
        if (c == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) c.newInstance();
        mediationServerParameters.m3725a(hashMap);
        return mediationServerParameters;
    }

    public void destroy() {
        try {
            this.zzsT.mo1174a();
        } catch (Throwable th) {
            zzhx.zzd("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzd getView() {
        if (this.zzsT instanceof MediationBannerAdapter) {
            try {
                return zze.zzn(((MediationBannerAdapter) this.zzsT).mo1179d());
            } catch (Throwable th) {
                zzhx.zzd("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationBannerAdapter: " + this.zzsT.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() {
        throw new RemoteException();
    }

    public void resume() {
        throw new RemoteException();
    }

    public void showInterstitial() {
        if (this.zzsT instanceof MediationInterstitialAdapter) {
            zzhx.zzY("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzsT).mo1180e();
            } catch (Throwable th) {
                zzhx.zzd("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzsT.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, zzax com_google_android_gms_internal_zzax, String str, zzdt com_google_android_gms_internal_zzdt) {
        zza(com_google_android_gms_dynamic_zzd, com_google_android_gms_internal_zzax, str, null, com_google_android_gms_internal_zzdt);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, zzax com_google_android_gms_internal_zzax, String str, String str2, zzdt com_google_android_gms_internal_zzdt) {
        if (this.zzsT instanceof MediationInterstitialAdapter) {
            zzhx.zzY("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzsT).mo1176a(new zzdy(com_google_android_gms_internal_zzdt), (Activity) zze.zzf(com_google_android_gms_dynamic_zzd), zzb(str, com_google_android_gms_internal_zzax.zzoP, str2), zzdz.zzd(com_google_android_gms_internal_zzax), this.zzsU);
            } catch (Throwable th) {
                zzhx.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzsT.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, zzba com_google_android_gms_internal_zzba, zzax com_google_android_gms_internal_zzax, String str, zzdt com_google_android_gms_internal_zzdt) {
        zza(com_google_android_gms_dynamic_zzd, com_google_android_gms_internal_zzba, com_google_android_gms_internal_zzax, str, null, com_google_android_gms_internal_zzdt);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, zzba com_google_android_gms_internal_zzba, zzax com_google_android_gms_internal_zzax, String str, String str2, zzdt com_google_android_gms_internal_zzdt) {
        if (this.zzsT instanceof MediationBannerAdapter) {
            zzhx.zzY("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.zzsT).mo1175a(new zzdy(com_google_android_gms_internal_zzdt), (Activity) zze.zzf(com_google_android_gms_dynamic_zzd), zzb(str, com_google_android_gms_internal_zzax.zzoP, str2), zzdz.zzb(com_google_android_gms_internal_zzba), zzdz.zzd(com_google_android_gms_internal_zzax), this.zzsU);
            } catch (Throwable th) {
                zzhx.zzd("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzhx.zzac("MediationAdapter is not a MediationBannerAdapter: " + this.zzsT.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
