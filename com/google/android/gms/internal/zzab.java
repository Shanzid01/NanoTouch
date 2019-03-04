package com.google.android.gms.internal;

import android.os.Build.VERSION;

@zzgi
public class zzab {
    private static zzab zzmN;
    private static final Object zzmz = new Object();
    private final zzgj zzmO = new zzgj();
    private final zzei zzmP = new zzei();
    private final zzem zzmQ = new zzem();
    private final zzgc zzmR = new zzgc();
    private final zzho zzmS = new zzho();
    private final zzie zzmT = new zzie();
    private final zzhp zzmU = zzhp.zzz(VERSION.SDK_INT);
    private final zzhg zzmV = new zzhg(this.zzmS);
    private final zzlv zzmW = new zzlx();
    private final zzcd zzmX = new zzcd();
    private final zzby zzmY = new zzby();
    private final zzbz zzmZ = new zzbz();
    private final zzfj zzna = new zzfj();
    private final zzdp zznb = new zzdp();

    static {
        zza(new zzab());
    }

    protected zzab() {
    }

    protected static void zza(zzab com_google_android_gms_internal_zzab) {
        synchronized (zzmz) {
            zzmN = com_google_android_gms_internal_zzab;
        }
    }

    private static zzab zzaH() {
        zzab com_google_android_gms_internal_zzab;
        synchronized (zzmz) {
            com_google_android_gms_internal_zzab = zzmN;
        }
        return com_google_android_gms_internal_zzab;
    }

    public static zzgj zzaI() {
        return zzaH().zzmO;
    }

    public static zzei zzaJ() {
        return zzaH().zzmP;
    }

    public static zzem zzaK() {
        return zzaH().zzmQ;
    }

    public static zzgc zzaL() {
        return zzaH().zzmR;
    }

    public static zzho zzaM() {
        return zzaH().zzmS;
    }

    public static zzie zzaN() {
        return zzaH().zzmT;
    }

    public static zzhp zzaO() {
        return zzaH().zzmU;
    }

    public static zzhg zzaP() {
        return zzaH().zzmV;
    }

    public static zzlv zzaQ() {
        return zzaH().zzmW;
    }

    public static zzcd zzaR() {
        return zzaH().zzmX;
    }

    public static zzby zzaS() {
        return zzaH().zzmY;
    }

    public static zzbz zzaT() {
        return zzaH().zzmZ;
    }

    public static zzfj zzaU() {
        return zzaH().zzna;
    }

    public static zzdp zzaV() {
        return zzaH().zznb;
    }
}
