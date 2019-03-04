package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzk extends zzd implements DataEvent {
    private final int zzadF;

    public zzk(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzadF = i2;
    }

    public /* synthetic */ Object freeze() {
        return zzvh();
    }

    public DataItem getDataItem() {
        return new zzr(this.zzMd, this.zzNQ, this.zzadF);
    }

    public int getType() {
        return getInteger("event_type");
    }

    public DataEvent zzvh() {
        return new zzj(this);
    }
}
