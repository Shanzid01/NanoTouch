package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;
import com.google.android.gms.wearable.internal.zzk;

public class DataEventBuffer extends zzg<DataEvent> implements Result {
    private final Status zzHb;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzHb = new Status(dataHolder.getStatusCode());
    }

    public Status getStatus() {
        return this.zzHb;
    }

    protected String zziB() {
        return "path";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzv(i, i2);
    }

    protected DataEvent zzv(int i, int i2) {
        return new zzk(this.zzMd, i, i2);
    }
}
