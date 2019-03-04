package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzd;
import java.util.Map;

class zzaa extends zzaj {
    private static final String ID = zza.DEVICE_NAME.toString();

    public zzaa() {
        super(ID, new String[0]);
    }

    public zzd.zza zzH(Map<String, zzd.zza> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals(FitnessActivities.UNKNOWN))) {
            obj = str + " " + obj;
        }
        return zzde.zzx(obj);
    }

    public boolean zzsD() {
        return true;
    }
}
