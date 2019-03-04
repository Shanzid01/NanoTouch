package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.slideme.sam.manager.model.data.dynamic.LayoutTagTable;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private final int zzFG;
    private int zzJp;
    private String zzSy;
    private String zzZO;
    private Uri zzacc;

    final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzda(parcel);
        }

        public GameBadgeEntity zzda(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(zzh.zziX()) || zzh.zzbf(GameBadgeEntity.class.getCanonicalName())) {
                return super.zzda(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    GameBadgeEntity(int i, int i2, String str, String str2, Uri uri) {
        this.zzFG = i;
        this.zzJp = i2;
        this.zzSy = str;
        this.zzZO = str2;
        this.zzacc = uri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.zzFG = 1;
        this.zzJp = gameBadge.getType();
        this.zzSy = gameBadge.getTitle();
        this.zzZO = gameBadge.getDescription();
        this.zzacc = gameBadge.getIconImageUri();
    }

    static int zza(GameBadge gameBadge) {
        return zzw.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean zza(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return zzw.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && zzw.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String zzb(GameBadge gameBadge) {
        return zzw.zzk(gameBadge).zza("Type", Integer.valueOf(gameBadge.getType())).zza(LayoutTagTable.TITLE, gameBadge.getTitle()).zza("Description", gameBadge.getDescription()).zza("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzot();
    }

    public String getDescription() {
        return this.zzZO;
    }

    public Uri getIconImageUri() {
        return this.zzacc;
    }

    public String getTitle() {
        return this.zzSy;
    }

    public int getType() {
        return this.zzJp;
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
        if (zziY()) {
            parcel.writeInt(this.zzJp);
            parcel.writeString(this.zzSy);
            parcel.writeString(this.zzZO);
            parcel.writeString(this.zzacc == null ? null : this.zzacc.toString());
            return;
        }
        GameBadgeEntityCreator.zza(this, parcel, i);
    }

    public GameBadge zzot() {
        return this;
    }
}
