package com.google.android.gms.internal;

@zzgi
public class zzbe {
    private static final Object zzmz = new Object();
    private static zzbe zzpg;
    private final zzhw zzph = new zzhw();
    private final zzaw zzpi = new zzaw();
    private final zzbf zzpj = new zzbf();
    private final zzbr zzpk = new zzbr();

    static {
        zza(new zzbe());
    }

    protected zzbe() {
    }

    protected static void zza(zzbe com_google_android_gms_internal_zzbe) {
        synchronized (zzmz) {
            zzpg = com_google_android_gms_internal_zzbe;
        }
    }

    private static zzbe zzbC() {
        zzbe com_google_android_gms_internal_zzbe;
        synchronized (zzmz) {
            com_google_android_gms_internal_zzbe = zzpg;
        }
        return com_google_android_gms_internal_zzbe;
    }

    public static zzhw zzbD() {
        return zzbC().zzph;
    }

    public static zzaw zzbE() {
        return zzbC().zzpi;
    }

    public static zzbf zzbF() {
        return zzbC().zzpj;
    }
}
