package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzh extends zzaj {
    private static final String ID = zza.APP_VERSION.toString();
    private final Context mContext;

    public zzh(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        try {
            return zzde.zzx(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            zzbf.zzZ("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return zzde.zzuf();
        }
    }

    public boolean zzsD() {
        return true;
    }
}
