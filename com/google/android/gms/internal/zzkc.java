package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class zzkc {
    private static boolean zzKR = false;
    protected final String mTag;
    private boolean zzKS;
    private boolean zzKT;
    private String zzKU;

    public zzkc(String str) {
        this(str, zzhG());
    }

    public zzkc(String str, boolean z) {
        this.mTag = str;
        this.zzKS = z;
        this.zzKT = false;
    }

    public static boolean zzhG() {
        return zzKR;
    }

    public void zza(String str, Object... objArr) {
        if (zzhF()) {
            Log.v(this.mTag, zze(str, objArr));
        }
    }

    public void zza(Throwable th, String str, Object... objArr) {
        if (zzhE() || zzKR) {
            Log.d(this.mTag, zze(str, objArr), th);
        }
    }

    public void zzaP(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = String.format("[%s] ", new Object[]{str});
        }
        this.zzKU = str2;
    }

    public void zzb(String str, Object... objArr) {
        if (zzhE() || zzKR) {
            Log.d(this.mTag, zze(str, objArr));
        }
    }

    public void zzc(String str, Object... objArr) {
        Log.i(this.mTag, zze(str, objArr));
    }

    public void zzd(String str, Object... objArr) {
        Log.w(this.mTag, zze(str, objArr));
    }

    protected String zze(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        return !TextUtils.isEmpty(this.zzKU) ? this.zzKU + str : str;
    }

    public boolean zzhE() {
        return this.zzKS;
    }

    public boolean zzhF() {
        return this.zzKT;
    }
}
