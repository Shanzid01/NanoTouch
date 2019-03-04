package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzg;

public final class LeaderboardBuffer extends zzg<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected String zziB() {
        return "external_leaderboard_id";
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzo(i, i2);
    }

    protected Leaderboard zzo(int i, int i2) {
        return new LeaderboardRef(this.zzMd, i, i2);
    }
}
