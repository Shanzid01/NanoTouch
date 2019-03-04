package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zzajj;
    private final int zzajk;
    private final boolean zzajl;
    private final long zzajm;
    private final String zzajn;
    private final long zzajo;
    private final String zzajp;
    private final String zzajq;
    private final long zzajr;
    private final String zzajs;
    private final String zzajt;
    private final String zzaju;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.zzajj = leaderboardVariant.getTimeSpan();
        this.zzajk = leaderboardVariant.getCollection();
        this.zzajl = leaderboardVariant.hasPlayerInfo();
        this.zzajm = leaderboardVariant.getRawPlayerScore();
        this.zzajn = leaderboardVariant.getDisplayPlayerScore();
        this.zzajo = leaderboardVariant.getPlayerRank();
        this.zzajp = leaderboardVariant.getDisplayPlayerRank();
        this.zzajq = leaderboardVariant.getPlayerScoreTag();
        this.zzajr = leaderboardVariant.getNumScores();
        this.zzajs = leaderboardVariant.zzoT();
        this.zzajt = leaderboardVariant.zzoU();
        this.zzaju = leaderboardVariant.zzoV();
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return zzw.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzoT(), leaderboardVariant.zzoV(), leaderboardVariant.zzoU());
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzw.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzw.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzw.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzw.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzw.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzw.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzw.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzw.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzw.equal(leaderboardVariant2.zzoT(), leaderboardVariant.zzoT()) && zzw.equal(leaderboardVariant2.zzoV(), leaderboardVariant.zzoV()) && zzw.equal(leaderboardVariant2.zzoU(), leaderboardVariant.zzoU());
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        return zzw.zzk(leaderboardVariant).zza("TimeSpan", TimeSpan.zzeJ(leaderboardVariant.getTimeSpan())).zza("Collection", LeaderboardCollection.zzeJ(leaderboardVariant.getCollection())).zza("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").zza("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").zza("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").zza("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").zza("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).zza("TopPageNextToken", leaderboardVariant.zzoT()).zza("WindowPageNextToken", leaderboardVariant.zzoV()).zza("WindowPagePrevToken", leaderboardVariant.zzoU()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzoW();
    }

    public int getCollection() {
        return this.zzajk;
    }

    public String getDisplayPlayerRank() {
        return this.zzajp;
    }

    public String getDisplayPlayerScore() {
        return this.zzajn;
    }

    public long getNumScores() {
        return this.zzajr;
    }

    public long getPlayerRank() {
        return this.zzajo;
    }

    public String getPlayerScoreTag() {
        return this.zzajq;
    }

    public long getRawPlayerScore() {
        return this.zzajm;
    }

    public int getTimeSpan() {
        return this.zzajj;
    }

    public boolean hasPlayerInfo() {
        return this.zzajl;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public String zzoT() {
        return this.zzajs;
    }

    public String zzoU() {
        return this.zzajt;
    }

    public String zzoV() {
        return this.zzaju;
    }

    public LeaderboardVariant zzoW() {
        return this;
    }
}
