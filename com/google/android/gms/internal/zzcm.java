package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.facebook.AppEventsConstants;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcp.zza;

@zzgi
public class zzcm extends zza implements zzcn.zza {
    private final Object zznh = new Object();
    private final String zzrk;
    private final Drawable zzrl;
    private final String zzrm;
    private final String zzro;
    private zzcn zzrs;
    private final Drawable zzrt;
    private final String zzru;

    public zzcm(String str, Drawable drawable, String str2, Drawable drawable2, String str3, String str4) {
        this.zzrk = str;
        this.zzrl = drawable;
        this.zzrm = str2;
        this.zzrt = drawable2;
        this.zzro = str3;
        this.zzru = str4;
    }

    public String getBody() {
        return this.zzrm;
    }

    public void recordImpression() {
        synchronized (this.zznh) {
            if (this.zzrs == null) {
                zzhx.zzZ("Attempt to record impression before content ad initialized.");
                return;
            }
            this.zzrs.recordImpression();
        }
    }

    public void zza(zzcn com_google_android_gms_internal_zzcn) {
        synchronized (this.zznh) {
            this.zzrs = com_google_android_gms_internal_zzcn;
        }
    }

    public zzd zzcD() {
        return zze.zzn(this.zzrt);
    }

    public String zzcE() {
        return this.zzru;
    }

    public String zzcw() {
        return this.zzrk;
    }

    public zzd zzcx() {
        return zze.zzn(this.zzrl);
    }

    public String zzcz() {
        return this.zzro;
    }

    public void zzl(int i) {
        synchronized (this.zznh) {
            if (this.zzrs == null) {
                zzhx.zzZ("Attempt to perform click before content ad initialized.");
                return;
            }
            this.zzrs.zzb(AppEventsConstants.EVENT_PARAM_VALUE_YES, i);
        }
    }
}
