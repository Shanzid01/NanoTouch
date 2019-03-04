package com.google.android.gms.tagmanager;

import android.util.Log;

public class zzx implements zzbg {
    private int zzBJ = 5;

    public void setLogLevel(int i) {
        this.zzBJ = i;
    }

    public void zzY(String str) {
        if (this.zzBJ <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void zzZ(String str) {
        if (this.zzBJ <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void zzaa(String str) {
        if (this.zzBJ <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void zzab(String str) {
        if (this.zzBJ <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void zzac(String str) {
        if (this.zzBJ <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void zzb(String str, Throwable th) {
        if (this.zzBJ <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void zzd(String str, Throwable th) {
        if (this.zzBJ <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
