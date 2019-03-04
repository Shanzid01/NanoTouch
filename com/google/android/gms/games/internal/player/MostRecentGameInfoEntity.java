package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int zzFG;
    private final String zzaii;
    private final String zzaij;
    private final long zzaik;
    private final Uri zzail;
    private final Uri zzaim;
    private final Uri zzain;

    MostRecentGameInfoEntity(int i, String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.zzFG = i;
        this.zzaii = str;
        this.zzaij = str2;
        this.zzaik = j;
        this.zzail = uri;
        this.zzaim = uri2;
        this.zzain = uri3;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostRecentGameInfo) {
        this.zzFG = 2;
        this.zzaii = mostRecentGameInfo.zzoF();
        this.zzaij = mostRecentGameInfo.zzoG();
        this.zzaik = mostRecentGameInfo.zzoH();
        this.zzail = mostRecentGameInfo.zzoI();
        this.zzaim = mostRecentGameInfo.zzoJ();
        this.zzain = mostRecentGameInfo.zzoK();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.hashCode(mostRecentGameInfo.zzoF(), mostRecentGameInfo.zzoG(), Long.valueOf(mostRecentGameInfo.zzoH()), mostRecentGameInfo.zzoI(), mostRecentGameInfo.zzoJ(), mostRecentGameInfo.zzoK());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzw.equal(mostRecentGameInfo2.zzoF(), mostRecentGameInfo.zzoF()) && zzw.equal(mostRecentGameInfo2.zzoG(), mostRecentGameInfo.zzoG()) && zzw.equal(Long.valueOf(mostRecentGameInfo2.zzoH()), Long.valueOf(mostRecentGameInfo.zzoH())) && zzw.equal(mostRecentGameInfo2.zzoI(), mostRecentGameInfo.zzoI()) && zzw.equal(mostRecentGameInfo2.zzoJ(), mostRecentGameInfo.zzoJ()) && zzw.equal(mostRecentGameInfo2.zzoK(), mostRecentGameInfo.zzoK());
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.zzk(mostRecentGameInfo).zza("GameId", mostRecentGameInfo.zzoF()).zza("GameName", mostRecentGameInfo.zzoG()).zza("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zzoH())).zza("GameIconUri", mostRecentGameInfo.zzoI()).zza("GameHiResUri", mostRecentGameInfo.zzoJ()).zza("GameFeaturedUri", mostRecentGameInfo.zzoK()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzoL();
    }

    public int getVersionCode() {
        return this.zzFG;
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

    public void writeToParcel(Parcel parcel, int i) {
        MostRecentGameInfoEntityCreator.zza(this, parcel, i);
    }

    public String zzoF() {
        return this.zzaii;
    }

    public String zzoG() {
        return this.zzaij;
    }

    public long zzoH() {
        return this.zzaik;
    }

    public Uri zzoI() {
        return this.zzail;
    }

    public Uri zzoJ() {
        return this.zzaim;
    }

    public Uri zzoK() {
        return this.zzain;
    }

    public MostRecentGameInfo zzoL() {
        return this;
    }
}
