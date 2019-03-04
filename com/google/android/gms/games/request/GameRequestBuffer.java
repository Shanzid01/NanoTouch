package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;

public final class GameRequestBuffer extends zzg<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String zziB() {
        return "external_request_id";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzt(i, i2);
    }

    protected GameRequest zzt(int i, int i2) {
        return new GameRequestRef(this.zzMd, i, i2);
    }
}
