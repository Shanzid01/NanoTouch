package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameBadgeBuffer extends AbstractDataBuffer<GameBadge> {
    public /* synthetic */ Object get(int i) {
        return zzeM(i);
    }

    public GameBadge zzeM(int i) {
        return new GameBadgeRef(this.zzMd, i);
    }
}
