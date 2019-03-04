package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.zzp;

public final class GamesLog {
    private static final zzp zzUh = new zzp("Games");

    private GamesLog() {
    }

    public static void zza(String str, String str2, Throwable th) {
        zzUh.zza(str, str2, th);
    }

    public static void zzb(String str, String str2, Throwable th) {
        zzUh.zzb(str, str2, th);
    }

    public static void zzr(String str, String str2) {
        zzUh.zzr(str, str2);
    }

    public static void zzs(String str, String str2) {
        zzUh.zzs(str, str2);
    }
}
