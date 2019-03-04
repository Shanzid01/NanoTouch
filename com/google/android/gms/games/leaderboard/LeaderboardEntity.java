package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzlw;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final String zzSJ;
    private final Uri zzacc;
    private final String zzacn;
    private final String zzaiR;
    private final int zzaiS;
    private final ArrayList<LeaderboardVariantEntity> zzaiT;
    private final Game zzaiU;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zzaiR = leaderboard.getLeaderboardId();
        this.zzSJ = leaderboard.getDisplayName();
        this.zzacc = leaderboard.getIconImageUri();
        this.zzacn = leaderboard.getIconImageUrl();
        this.zzaiS = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.zzaiU = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.zzaiT = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaiT.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int zza(Leaderboard leaderboard) {
        return zzw.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean zza(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzw.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && zzw.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && zzw.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && zzw.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && zzw.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String zzb(Leaderboard leaderboard) {
        return zzw.zzk(leaderboard).zza("LeaderboardId", leaderboard.getLeaderboardId()).zza("DisplayName", leaderboard.getDisplayName()).zza("IconImageUri", leaderboard.getIconImageUri()).zza("IconImageUrl", leaderboard.getIconImageUrl()).zza("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zza("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzoP();
    }

    public String getDisplayName() {
        return this.zzSJ;
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzSJ, charArrayBuffer);
    }

    public Game getGame() {
        return this.zzaiU;
    }

    public Uri getIconImageUri() {
        return this.zzacc;
    }

    public String getIconImageUrl() {
        return this.zzacn;
    }

    public String getLeaderboardId() {
        return this.zzaiR;
    }

    public int getScoreOrder() {
        return this.zzaiS;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.zzaiT);
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

    public Leaderboard zzoP() {
        return this;
    }
}
