package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

@zzgi
public final class zzhk {
    private static final Object zzmz = new Object();
    private static zzcc zzzg;
    private static String zzzh;

    public static String zza(Context context, String str, String str2) {
        String str3;
        synchronized (zzmz) {
            if (zzzh == null && !TextUtils.isEmpty(str)) {
                zzb(context, str, str2);
            }
            str3 = zzzh;
        }
        return str3;
    }

    private static void zzb(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (zzab.zzaM().zza(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            zzzh = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            zzzh = "err";
        }
    }

    public static void zzd(Context context, String str) {
        synchronized (zzmz) {
            if (zzzg == null) {
                zzcb com_google_android_gms_internal_zzcb = new zzcb();
                com_google_android_gms_internal_zzcb.zzb(context, str);
                try {
                    zzzg = zzab.zzaR().zzb(com_google_android_gms_internal_zzcb);
                } catch (IllegalArgumentException e) {
                    zzhx.zzac("Cannot initialize CSI reporter." + e.getMessage());
                }
            }
        }
    }

    public static zzcc zzeg() {
        zzcc com_google_android_gms_internal_zzcc;
        synchronized (zzmz) {
            com_google_android_gms_internal_zzcc = zzzg;
        }
        return com_google_android_gms_internal_zzcc;
    }

    public static String zzep() {
        String str;
        synchronized (zzmz) {
            str = zzzh;
        }
        return str;
    }
}
