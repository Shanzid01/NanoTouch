package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevel implements SafeParcelable {
    public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
    private final int zzFG;
    private final int zzacP;
    private final long zzacQ;
    private final long zzacR;

    PlayerLevel(int i, int i2, long j, long j2) {
        boolean z = true;
        zzx.zza(j >= 0, (Object) "Min XP must be positive!");
        if (j2 <= j) {
            z = false;
        }
        zzx.zza(z, (Object) "Max XP must be more than min XP!");
        this.zzFG = i;
        this.zzacP = i2;
        this.zzacQ = j;
        this.zzacR = j2;
    }

    public PlayerLevel(int i, long j, long j2) {
        this(1, i, j, j2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return zzw.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && zzw.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && zzw.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.zzacP;
    }

    public long getMaxXp() {
        return this.zzacR;
    }

    public long getMinXp() {
        return this.zzacQ;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzacP), Long.valueOf(this.zzacQ), Long.valueOf(this.zzacR));
    }

    public String toString() {
        return zzw.zzk(this).zza("LevelNumber", Integer.valueOf(getLevelNumber())).zza("MinXp", Long.valueOf(getMinXp())).zza("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelCreator.zza(this, parcel, i);
    }
}
