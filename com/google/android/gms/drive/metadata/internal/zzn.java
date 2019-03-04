package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzn extends zza<String> {
    public zzn(String str, int i) {
        super(str, i);
    }

    protected void zza(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzi(dataHolder, i, i2);
    }

    protected String zzi(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzc(getName(), i, i2);
    }

    protected /* synthetic */ Object zzl(Bundle bundle) {
        return zzs(bundle);
    }

    protected String zzs(Bundle bundle) {
        return bundle.getString(getName());
    }
}
