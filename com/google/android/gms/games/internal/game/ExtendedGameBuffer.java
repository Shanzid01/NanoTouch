package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;

public final class ExtendedGameBuffer extends zzg<ExtendedGame> {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String zziB() {
        return "external_game_id";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzn(i, i2);
    }

    protected ExtendedGame zzn(int i, int i2) {
        return new ExtendedGameRef(this.zzMd, i, i2);
    }
}
