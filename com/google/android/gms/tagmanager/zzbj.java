package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzbj extends zzaj {
    private static final String ID = zza.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context mContext;

    public zzbj(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        String zzal = zzal(this.mContext);
        return zzal == null ? zzde.zzuf() : zzde.zzx(zzal);
    }

    protected String zzal(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean zzsD() {
        return true;
    }
}
