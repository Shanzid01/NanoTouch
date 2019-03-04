package com.google.android.gms.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzvt.zza;
import com.google.android.gms.tagmanager.zzbf;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public class zzvu implements Runnable {
    private final Context mContext;
    private final zzvj zzaCG;
    private final zzvt zzaCN;
    private final zzvo zzaCO;
    private final zzvs zzazL;

    public zzvu(Context context, zzvj com_google_android_gms_internal_zzvj, zzvt com_google_android_gms_internal_zzvt) {
        this(context, com_google_android_gms_internal_zzvj, com_google_android_gms_internal_zzvt, new zzvs(), new zzvo());
    }

    zzvu(Context context, zzvj com_google_android_gms_internal_zzvj, zzvt com_google_android_gms_internal_zzvt, zzvs com_google_android_gms_internal_zzvs, zzvo com_google_android_gms_internal_zzvo) {
        zzx.zzl(context);
        zzx.zzl(com_google_android_gms_internal_zzvt);
        this.mContext = context;
        this.zzaCG = com_google_android_gms_internal_zzvj;
        this.zzaCN = com_google_android_gms_internal_zzvt;
        this.zzazL = com_google_android_gms_internal_zzvs;
        this.zzaCO = com_google_android_gms_internal_zzvo;
    }

    public zzvu(Context context, zzvj com_google_android_gms_internal_zzvj, zzvt com_google_android_gms_internal_zzvt, String str) {
        this(context, com_google_android_gms_internal_zzvj, com_google_android_gms_internal_zzvt, new zzvs(), new zzvo());
        this.zzaCO.zzdx(str);
    }

    public void run() {
        zzdo();
    }

    boolean zzdI(String str) {
        return this.mContext.getPackageManager().checkPermission(str, this.mContext.getPackageName()) == 0;
    }

    void zzdo() {
        String zzv;
        if (zzuQ()) {
            zzbf.zzab("NetworkLoader: Starting to load resource from Network.");
            zzvr zzuO = this.zzazL.zzuO();
            try {
                zzv = this.zzaCO.zzv(this.zzaCG.zzun());
                InputStream zzdG = zzuO.zzdG(zzv);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    zzlz.zza(zzdG, byteArrayOutputStream);
                    this.zzaCN.zzo(byteArrayOutputStream.toByteArray());
                    zzbf.zzab("NetworkLoader: Resource loaded.");
                } catch (Throwable e) {
                    zzbf.zzb("NetworkLoader: Error when parsing downloaded resources from url: " + zzv + " " + e.getMessage(), e);
                    this.zzaCN.zza(zza.SERVER_ERROR);
                    zzuO.close();
                }
            } catch (FileNotFoundException e2) {
                zzbf.zzZ("NetworkLoader: No data is retrieved from the given url: " + zzv);
                this.zzaCN.zza(zza.SERVER_ERROR);
            } catch (Throwable e3) {
                zzbf.zzb("NetworkLoader: Error when loading resource from url: " + zzv + " " + e3.getMessage(), e3);
                this.zzaCN.zza(zza.IO_ERROR);
            } finally {
                zzuO.close();
            }
        } else {
            this.zzaCN.zza(zza.NOT_AVAILABLE);
        }
    }

    boolean zzuQ() {
        if (!zzdI("android.permission.INTERNET")) {
            zzbf.zzZ("Missing android.permission.INTERNET. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.INTERNET\" />");
            return false;
        } else if (zzdI("android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            zzbf.zzac("NetworkLoader: No network connectivity - Offline");
            return false;
        } else {
            zzbf.zzZ("Missing android.permission.ACCESS_NETWORK_STATE. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
            return false;
        }
    }
}
