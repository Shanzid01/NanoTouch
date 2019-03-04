package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.internal.zzxc.zzd;
import com.google.android.gms.internal.zzxc.zzf;

public class zzmx {
    public static Value zza(zzd com_google_android_gms_internal_zzxc_zzd, zzf com_google_android_gms_internal_zzxc_zzf) {
        if (com_google_android_gms_internal_zzxc_zzf == null) {
            return null;
        }
        Value value = new Value(com_google_android_gms_internal_zzxc_zzd.zzaIh.intValue());
        if (com_google_android_gms_internal_zzxc_zzf.zzaIp != null) {
            zzx.zzb(com_google_android_gms_internal_zzxc_zzd.zzaIh.intValue() == 2, "Field format %d does not match stored value %s", com_google_android_gms_internal_zzxc_zzd.zzaIh, com_google_android_gms_internal_zzxc_zzf.zzaIp);
            value.setFloat(com_google_android_gms_internal_zzxc_zzf.zzaIp.floatValue());
        } else if (com_google_android_gms_internal_zzxc_zzf.zzaIo != null) {
            zzx.zzb(com_google_android_gms_internal_zzxc_zzd.zzaIh.intValue() == 1, "Field format %d does not match stored value %s", com_google_android_gms_internal_zzxc_zzd.zzaIh, com_google_android_gms_internal_zzxc_zzf.zzaIo);
            value.setInt(com_google_android_gms_internal_zzxc_zzf.zzaIo.intValue());
        }
        return value;
    }

    public static Value[] zza(zzd[] com_google_android_gms_internal_zzxc_zzdArr, zzf[] com_google_android_gms_internal_zzxc_zzfArr) {
        Value[] valueArr = new Value[com_google_android_gms_internal_zzxc_zzfArr.length];
        int min = Math.min(com_google_android_gms_internal_zzxc_zzdArr.length, com_google_android_gms_internal_zzxc_zzfArr.length);
        for (int i = 0; i < min; i++) {
            valueArr[i] = zza(com_google_android_gms_internal_zzxc_zzdArr[i], com_google_android_gms_internal_zzxc_zzfArr[i]);
        }
        return valueArr;
    }

    public static zzf[] zza(Value[] valueArr) {
        zzf[] com_google_android_gms_internal_zzxc_zzfArr = new zzf[valueArr.length];
        for (int i = 0; i < valueArr.length; i++) {
            com_google_android_gms_internal_zzxc_zzfArr[i] = zzb(valueArr[i]);
        }
        return com_google_android_gms_internal_zzxc_zzfArr;
    }

    public static zzf zzb(Value value) {
        zzf com_google_android_gms_internal_zzxc_zzf = new zzf();
        if (value != null && value.isSet()) {
            if (2 == value.getFormat()) {
                com_google_android_gms_internal_zzxc_zzf.zzaIp = Double.valueOf((double) value.asFloat());
            } else if (1 == value.getFormat()) {
                com_google_android_gms_internal_zzxc_zzf.zzaIo = Integer.valueOf(value.asInt());
            } else {
                throw new IllegalArgumentException("unknown type: " + value.getFormat() + " in: " + value);
            }
        }
        return com_google_android_gms_internal_zzxc_zzf;
    }
}
