package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;

public class zzre {
    private static final zza[] zzash = new zza[0];
    private static zzre zzasi;
    private final Application zzasj;
    private zzrh zzask;
    private final List<zza> zzasl = new ArrayList();
    private zzri zzasm;

    public interface zza {
        void zza(zzrh com_google_android_gms_internal_zzrh);

        void zza(zzrh com_google_android_gms_internal_zzrh, Activity activity);
    }

    private zzre(Application application) {
        zzx.zzl(application);
        this.zzasj = application;
    }

    public static zzre zzag(Context context) {
        zzre com_google_android_gms_internal_zzre;
        zzx.zzl(context);
        Application application = (Application) context.getApplicationContext();
        zzx.zzl(application);
        synchronized (zzre.class) {
            if (zzasi == null) {
                zzasi = new zzre(application);
            }
            com_google_android_gms_internal_zzre = zzasi;
        }
        return com_google_android_gms_internal_zzre;
    }

    private zza[] zzqZ() {
        zza[] com_google_android_gms_internal_zzre_zzaArr;
        synchronized (this.zzasl) {
            if (this.zzasl.isEmpty()) {
                com_google_android_gms_internal_zzre_zzaArr = zzash;
            } else {
                com_google_android_gms_internal_zzre_zzaArr = (zza[]) this.zzasl.toArray(new zza[this.zzasl.size()]);
            }
        }
        return com_google_android_gms_internal_zzre_zzaArr;
    }

    public void zzZ(boolean z) {
        if (VERSION.SDK_INT < 14) {
            Log.i("com.google.android.gms.measurement.ScreenViewService", "AutoScreeViewTracking is not supported on API 14 or earlier devices");
        } else if (zzqY() == z) {
        } else {
            if (z) {
                this.zzasm = new zzri(this);
                this.zzasj.registerActivityLifecycleCallbacks(this.zzasm);
                return;
            }
            this.zzasj.unregisterActivityLifecycleCallbacks(this.zzasm);
            this.zzasm = null;
        }
    }

    public void zza(zza com_google_android_gms_internal_zzre_zza) {
        zzx.zzl(com_google_android_gms_internal_zzre_zza);
        synchronized (this.zzasl) {
            this.zzasl.remove(com_google_android_gms_internal_zzre_zza);
            this.zzasl.add(com_google_android_gms_internal_zzre_zza);
        }
    }

    public void zzb(zzrh com_google_android_gms_internal_zzrh, Activity activity) {
        int i = 0;
        zzx.zzl(com_google_android_gms_internal_zzrh);
        zza[] com_google_android_gms_internal_zzre_zzaArr = null;
        if (com_google_android_gms_internal_zzrh.isMutable()) {
            if (activity instanceof zzrd) {
                ((zzrd) activity).zzb(com_google_android_gms_internal_zzrh);
            }
            if (this.zzask != null) {
                com_google_android_gms_internal_zzrh.zzgr(this.zzask.zzaF());
                com_google_android_gms_internal_zzrh.zzcv(this.zzask.zzre());
            }
            zza[] zzqZ = zzqZ();
            for (zza zza : zzqZ) {
                zza.zza(com_google_android_gms_internal_zzrh, activity);
            }
            com_google_android_gms_internal_zzrh.zzrh();
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzrh.zzre())) {
                com_google_android_gms_internal_zzre_zzaArr = zzqZ;
            } else {
                return;
            }
        }
        if (this.zzask == null || this.zzask.zzaF() != com_google_android_gms_internal_zzrh.zzaF()) {
            zzqX();
            this.zzask = com_google_android_gms_internal_zzrh;
            if (com_google_android_gms_internal_zzre_zzaArr == null) {
                com_google_android_gms_internal_zzre_zzaArr = zzqZ();
            }
            while (i < com_google_android_gms_internal_zzre_zzaArr.length) {
                com_google_android_gms_internal_zzre_zzaArr[i].zza(com_google_android_gms_internal_zzrh);
                i++;
            }
            return;
        }
        this.zzask = com_google_android_gms_internal_zzrh;
    }

    public zzrh zzqW() {
        return this.zzask;
    }

    public void zzqX() {
        this.zzask = null;
    }

    public boolean zzqY() {
        return this.zzasm != null;
    }
}
