package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

class zzy implements zzaq {
    private static final Object zzaxj = new Object();
    private static zzy zzayy;
    private zzcc zzaxM;
    private String zzayA;
    private zzar zzayB;
    private String zzayz;

    private zzy(Context context) {
        this(zzas.zzam(context), new zzcr());
    }

    zzy(zzar com_google_android_gms_tagmanager_zzar, zzcc com_google_android_gms_tagmanager_zzcc) {
        this.zzayB = com_google_android_gms_tagmanager_zzar;
        this.zzaxM = com_google_android_gms_tagmanager_zzcc;
    }

    public static zzaq zzak(Context context) {
        zzaq com_google_android_gms_tagmanager_zzaq;
        synchronized (zzaxj) {
            if (zzayy == null) {
                zzayy = new zzy(context);
            }
            com_google_android_gms_tagmanager_zzaq = zzayy;
        }
        return com_google_android_gms_tagmanager_zzaq;
    }

    public boolean zzcY(String str) {
        if (this.zzaxM.zzgv()) {
            if (!(this.zzayz == null || this.zzayA == null)) {
                try {
                    str = this.zzayz + "?" + this.zzayA + "=" + URLEncoder.encode(str, "UTF-8");
                    zzbf.zzab("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    zzbf.zzd("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.zzayB.zzdb(str);
            return true;
        }
        zzbf.zzac("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
