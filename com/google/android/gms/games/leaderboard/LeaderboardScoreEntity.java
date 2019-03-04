package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlw;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long zzaiW;
    private final String zzaiX;
    private final String zzaiY;
    private final long zzaiZ;
    private final long zzaja;
    private final String zzajb;
    private final Uri zzajc;
    private final Uri zzajd;
    private final PlayerEntity zzaje;
    private final String zzajf;
    private final String zzajg;
    private final String zzajh;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        this.zzaiW = leaderboardScore.getRank();
        this.zzaiX = (String) zzx.zzl(leaderboardScore.getDisplayRank());
        this.zzaiY = (String) zzx.zzl(leaderboardScore.getDisplayScore());
        this.zzaiZ = leaderboardScore.getRawScore();
        this.zzaja = leaderboardScore.getTimestampMillis();
        this.zzajb = leaderboardScore.getScoreHolderDisplayName();
        this.zzajc = leaderboardScore.getScoreHolderIconImageUri();
        this.zzajd = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.zzaje = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.zzajf = leaderboardScore.getScoreTag();
        this.zzajg = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzajh = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return zzw.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return zzw.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && zzw.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && zzw.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && zzw.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && zzw.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && zzw.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && zzw.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && zzw.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && zzw.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && zzw.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return zzw.zzk(leaderboardScore).zza("Rank", Long.valueOf(leaderboardScore.getRank())).zza("DisplayRank", leaderboardScore.getDisplayRank()).zza("Score", Long.valueOf(leaderboardScore.getRawScore())).zza("DisplayScore", leaderboardScore.getDisplayScore()).zza("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).zza("DisplayName", leaderboardScore.getScoreHolderDisplayName()).zza("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).zza("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).zza("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).zza("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).zza("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).zza("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzoS();
    }

    public String getDisplayRank() {
        return this.zzaiX;
    }

    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzaiX, charArrayBuffer);
    }

    public String getDisplayScore() {
        return this.zzaiY;
    }

    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzaiY, charArrayBuffer);
    }

    public long getRank() {
        return this.zzaiW;
    }

    public long getRawScore() {
        return this.zzaiZ;
    }

    public Player getScoreHolder() {
        return this.zzaje;
    }

    public String getScoreHolderDisplayName() {
        return this.zzaje == null ? this.zzajb : this.zzaje.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.zzaje == null) {
            zzlw.zzb(this.zzajb, charArrayBuffer);
        } else {
            this.zzaje.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.zzaje == null ? this.zzajd : this.zzaje.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.zzaje == null ? this.zzajh : this.zzaje.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.zzaje == null ? this.zzajc : this.zzaje.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.zzaje == null ? this.zzajg : this.zzaje.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.zzajf;
    }

    public long getTimestampMillis() {
        return this.zzaja;
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

    public LeaderboardScore zzoS() {
        return this;
    }
}
