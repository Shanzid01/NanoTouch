package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
    private final int zzFG;
    private final long zzacS;
    private final long zzacT;
    private final PlayerLevel zzacU;
    private final PlayerLevel zzacV;

    PlayerLevelInfo(int i, long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        zzx.zzN(j != -1);
        zzx.zzl(playerLevel);
        zzx.zzl(playerLevel2);
        this.zzFG = i;
        this.zzacS = j;
        this.zzacT = j2;
        this.zzacU = playerLevel;
        this.zzacV = playerLevel2;
    }

    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        this(1, j, j2, playerLevel, playerLevel2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzw.equal(Long.valueOf(this.zzacS), Long.valueOf(playerLevelInfo.zzacS)) && zzw.equal(Long.valueOf(this.zzacT), Long.valueOf(playerLevelInfo.zzacT)) && zzw.equal(this.zzacU, playerLevelInfo.zzacU) && zzw.equal(this.zzacV, playerLevelInfo.zzacV);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzacU;
    }

    public long getCurrentXpTotal() {
        return this.zzacS;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzacT;
    }

    public PlayerLevel getNextLevel() {
        return this.zzacV;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzacS), Long.valueOf(this.zzacT), this.zzacU, this.zzacV);
    }

    public boolean isMaxLevel() {
        return this.zzacU.equals(this.zzacV);
    }

    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelInfoCreator.zza(this, parcel, i);
    }
}
