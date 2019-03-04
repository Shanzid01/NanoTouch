package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends zzd implements Player {
    private final PlayerLevelInfo zzacM;
    private final PlayerColumnNames zzacW;
    private final MostRecentGameInfoRef zzacX;

    public PlayerRef(DataHolder dataHolder, int i) {
        this(dataHolder, i, null);
    }

    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        this.zzacW = new PlayerColumnNames(str);
        this.zzacX = new MostRecentGameInfoRef(dataHolder, i, this.zzacW);
        if (zzmG()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.zzacW.zzaiy);
            int integer2 = getInteger(this.zzacW.zzaiB);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.zzacW.zzaiz), getLong(this.zzacW.zzaiA));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.zzacW.zzaiA), getLong(this.zzacW.zzaiC));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzacM = new PlayerLevelInfo(getLong(this.zzacW.zzaix), getLong(this.zzacW.zzaiD), playerLevel2, playerLevel);
            return;
        }
        this.zzacM = null;
    }

    private boolean zzmG() {
        return (zzbc(this.zzacW.zzaix) || getLong(this.zzacW.zzaix) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString(this.zzacW.zzaip);
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zza(this.zzacW.zzaip, charArrayBuffer);
    }

    public Uri getHiResImageUri() {
        return zzbb(this.zzacW.zzais);
    }

    public String getHiResImageUrl() {
        return getString(this.zzacW.zzait);
    }

    public Uri getIconImageUri() {
        return zzbb(this.zzacW.zzaiq);
    }

    public String getIconImageUrl() {
        return getString(this.zzacW.zzair);
    }

    public long getLastPlayedWithTimestamp() {
        return (!zzba(this.zzacW.zzaiw) || zzbc(this.zzacW.zzaiw)) ? -1 : getLong(this.zzacW.zzaiw);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzacM;
    }

    public String getPlayerId() {
        return getString(this.zzacW.zzaio);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.zzacW.zzaiu);
    }

    public String getTitle() {
        return getString(this.zzacW.zzaiE);
    }

    public void getTitle(CharArrayBuffer charArrayBuffer) {
        zza(this.zzacW.zzaiE, charArrayBuffer);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.zzb(this);
    }

    public boolean isProfileVisible() {
        return getBoolean(this.zzacW.zzaiG);
    }

    public String toString() {
        return PlayerEntity.zzc((Player) this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) freeze()).writeToParcel(parcel, i);
    }

    public boolean zzmD() {
        return getBoolean(this.zzacW.zzaiN);
    }

    public int zzmE() {
        return getInteger(this.zzacW.zzaiv);
    }

    public MostRecentGameInfo zzmF() {
        return zzbc(this.zzacW.zzaiH) ? null : this.zzacX;
    }
}
