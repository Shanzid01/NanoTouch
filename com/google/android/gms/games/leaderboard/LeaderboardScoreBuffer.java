package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader zzaiV;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzaiV = new LeaderboardScoreBufferHeader(dataHolder.zziu());
    }

    public LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.zzMd, i);
    }

    public LeaderboardScoreBufferHeader zzoQ() {
        return this.zzaiV;
    }
}
