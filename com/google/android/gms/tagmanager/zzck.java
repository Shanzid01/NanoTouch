package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzc.zzj;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvr;
import com.google.android.gms.internal.zzvs;
import com.google.android.gms.tagmanager.zzbe.zza;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class zzck implements Runnable {
    private final Context mContext;
    private volatile String zzaxT;
    private final String zzaxw;
    private final zzvs zzazL;
    private final String zzazM;
    private zzbe<zzj> zzazN;
    private volatile zzr zzazO;
    private volatile String zzazP;

    zzck(Context context, String str, zzvs com_google_android_gms_internal_zzvs, zzr com_google_android_gms_tagmanager_zzr) {
        this.mContext = context;
        this.zzazL = com_google_android_gms_internal_zzvs;
        this.zzaxw = str;
        this.zzazO = com_google_android_gms_tagmanager_zzr;
        this.zzazM = "/r?id=" + str;
        this.zzaxT = this.zzazM;
        this.zzazP = null;
    }

    public zzck(Context context, String str, zzr com_google_android_gms_tagmanager_zzr) {
        this(context, str, new zzvs(), com_google_android_gms_tagmanager_zzr);
    }

    private boolean zztA() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbf.zzab("...no network connectivity");
        return false;
    }

    private void zztB() {
        if (zztA()) {
            zzbf.zzab("Start loading resource from network ...");
            String zztC = zztC();
            zzvr zzuO = this.zzazL.zzuO();
            try {
                InputStream zzdG = zzuO.zzdG(zztC);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    zzvl.zzc(zzdG, byteArrayOutputStream);
                    zzj zzb = zzj.zzb(byteArrayOutputStream.toByteArray());
                    zzbf.zzab("Successfully loaded supplemented resource: " + zzb);
                    if (zzb.zzgs == null && zzb.zzgr.length == 0) {
                        zzbf.zzab("No change for container: " + this.zzaxw);
                    }
                    this.zzazN.zzo(zzb);
                    zzbf.zzab("Load resource from network finished.");
                } catch (Throwable e) {
                    zzbf.zzd("Error when parsing downloaded resources from url: " + zztC + " " + e.getMessage(), e);
                    this.zzazN.zza(zza.SERVER_ERROR);
                    zzuO.close();
                }
            } catch (FileNotFoundException e2) {
                zzbf.zzac("No data is retrieved from the given url: " + zztC + ". Make sure container_id: " + this.zzaxw + " is correct.");
                this.zzazN.zza(zza.SERVER_ERROR);
            } catch (Throwable e3) {
                zzbf.zzd("Error when loading resources from url: " + zztC + " " + e3.getMessage(), e3);
                this.zzazN.zza(zza.IO_ERROR);
            } finally {
                zzuO.close();
            }
        } else {
            this.zzazN.zza(zza.NOT_AVAILABLE);
        }
    }

    public void run() {
        if (this.zzazN == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.zzazN.zzsR();
        zztB();
    }

    void zza(zzbe<zzj> com_google_android_gms_tagmanager_zzbe_com_google_android_gms_internal_zzc_zzj) {
        this.zzazN = com_google_android_gms_tagmanager_zzbe_com_google_android_gms_internal_zzc_zzj;
    }

    void zzcT(String str) {
        if (str == null) {
            this.zzaxT = this.zzazM;
            return;
        }
        zzbf.zzY("Setting CTFE URL path: " + str);
        this.zzaxT = str;
    }

    void zzdg(String str) {
        zzbf.zzY("Setting previous container version: " + str);
        this.zzazP = str;
    }

    String zztC() {
        String str = this.zzazO.zzsT() + this.zzaxT + "&v=a65833898";
        if (!(this.zzazP == null || this.zzazP.trim().equals(""))) {
            str = str + "&pv=" + this.zzazP;
        }
        return zzca.zztx().zzty().equals(zza.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }
}
