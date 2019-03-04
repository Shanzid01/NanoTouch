package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;

public final class RoomBuffer extends zzg<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String zziB() {
        return "external_match_id";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzq(i, i2);
    }

    protected Room zzq(int i, int i2) {
        return new RoomRef(this.zzMd, i, i2);
    }
}
