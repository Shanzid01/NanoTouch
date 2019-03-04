package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzcf extends zzaj {
    private static final String ID = zza.RESOLUTION.toString();
    private final Context mContext;

    public zzcf(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return zzde.zzx(i + "x" + displayMetrics.heightPixels);
    }

    public boolean zzsD() {
        return true;
    }
}
