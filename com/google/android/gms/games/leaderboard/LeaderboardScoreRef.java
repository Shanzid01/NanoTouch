package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends zzd implements LeaderboardScore {
    private final PlayerRef zzaji;

    LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzaji = new PlayerRef(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzoS();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        zza("display_rank", charArrayBuffer);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        zza("display_score", charArrayBuffer);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return zzbc("external_player_id") ? null : this.zzaji;
    }

    public String getScoreHolderDisplayName() {
        return zzbc("external_player_id") ? getString("default_display_name") : this.zzaji.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (zzbc("external_player_id")) {
            zza("default_display_name", charArrayBuffer);
        } else {
            this.zzaji.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return zzbc("external_player_id") ? null : this.zzaji.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return zzbc("external_player_id") ? null : this.zzaji.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return zzbc("external_player_id") ? zzbb("default_display_image_uri") : this.zzaji.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return zzbc("external_player_id") ? getString("default_display_image_url") : this.zzaji.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public LeaderboardScore zzoS() {
        return new LeaderboardScoreEntity(this);
    }
}
