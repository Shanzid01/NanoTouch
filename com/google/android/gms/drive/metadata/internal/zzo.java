package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzo extends zzj<UserMetadata> {
    public zzo(String str, int i) {
        super(str, zzbB(str), Collections.emptyList(), i);
    }

    private String zzbA(String str) {
        return zzt(getName(), str);
    }

    private static Collection<String> zzbB(String str) {
        return Arrays.asList(new String[]{zzt(str, "permissionId"), zzt(str, "displayName"), zzt(str, "picture"), zzt(str, "isAuthenticatedUser"), zzt(str, "emailAddress")});
    }

    private static String zzt(String str, String str2) {
        return str + "." + str2;
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzba(zzbA("permissionId")) && !dataHolder.zzh(zzbA("permissionId"), i, i2);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzj(dataHolder, i, i2);
    }

    protected UserMetadata zzj(DataHolder dataHolder, int i, int i2) {
        String zzc = dataHolder.zzc(zzbA("permissionId"), i, i2);
        if (zzc == null) {
            return null;
        }
        String zzc2 = dataHolder.zzc(zzbA("displayName"), i, i2);
        String zzc3 = dataHolder.zzc(zzbA("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.zzd(zzbA("isAuthenticatedUser"), i, i2));
        return new UserMetadata(zzc, zzc2, zzc3, valueOf.booleanValue(), dataHolder.zzc(zzbA("emailAddress"), i, i2));
    }
}
