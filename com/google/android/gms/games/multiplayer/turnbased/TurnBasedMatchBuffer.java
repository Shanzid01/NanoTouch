package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;

public final class TurnBasedMatchBuffer extends zzg<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String zziB() {
        return "external_match_id";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzr(i, i2);
    }

    protected TurnBasedMatch zzr(int i, int i2) {
        return new TurnBasedMatchRef(this.zzMd, i, i2);
    }
}
