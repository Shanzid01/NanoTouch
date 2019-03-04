package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzlw;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
    private final int zzFG;
    private final String zzIm;
    private final String zzSJ;
    private final String zzZO;
    private final String zzabZ;
    private final String zzaca;
    private final String zzacb;
    private final Uri zzacc;
    private final Uri zzacd;
    private final Uri zzace;
    private final boolean zzacf;
    private final boolean zzacg;
    private final String zzach;
    private final int zzaci;
    private final int zzacj;
    private final int zzack;
    private final boolean zzacl;
    private final boolean zzacm;
    private final String zzacn;
    private final String zzaco;
    private final String zzacp;
    private final boolean zzacq;
    private final boolean zzacr;
    private final boolean zzacs;
    private final String zzact;
    private final boolean zzacu;

    final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzcP(parcel);
        }

        public GameEntity zzcP(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(zzh.zziX()) || zzh.zzbf(GameEntity.class.getCanonicalName())) {
                return super.zzcP(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(6, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    GameEntity(int i, String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Uri uri2, Uri uri3, boolean z, boolean z2, String str7, int i2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, String str10, boolean z5, boolean z6, boolean z7, String str11, boolean z8) {
        this.zzFG = i;
        this.zzIm = str;
        this.zzSJ = str2;
        this.zzabZ = str3;
        this.zzaca = str4;
        this.zzZO = str5;
        this.zzacb = str6;
        this.zzacc = uri;
        this.zzacn = str8;
        this.zzacd = uri2;
        this.zzaco = str9;
        this.zzace = uri3;
        this.zzacp = str10;
        this.zzacf = z;
        this.zzacg = z2;
        this.zzach = str7;
        this.zzaci = i2;
        this.zzacj = i3;
        this.zzack = i4;
        this.zzacl = z3;
        this.zzacm = z4;
        this.zzacq = z5;
        this.zzacr = z6;
        this.zzacs = z7;
        this.zzact = str11;
        this.zzacu = z8;
    }

    public GameEntity(Game game) {
        this.zzFG = 6;
        this.zzIm = game.getApplicationId();
        this.zzabZ = game.getPrimaryCategory();
        this.zzaca = game.getSecondaryCategory();
        this.zzZO = game.getDescription();
        this.zzacb = game.getDeveloperName();
        this.zzSJ = game.getDisplayName();
        this.zzacc = game.getIconImageUri();
        this.zzacn = game.getIconImageUrl();
        this.zzacd = game.getHiResImageUri();
        this.zzaco = game.getHiResImageUrl();
        this.zzace = game.getFeaturedImageUri();
        this.zzacp = game.getFeaturedImageUrl();
        this.zzacf = game.zzmx();
        this.zzacg = game.zzmz();
        this.zzach = game.zzmA();
        this.zzaci = game.zzmB();
        this.zzacj = game.getAchievementTotalCount();
        this.zzack = game.getLeaderboardCount();
        this.zzacl = game.isRealTimeMultiplayerEnabled();
        this.zzacm = game.isTurnBasedMultiplayerEnabled();
        this.zzacq = game.isMuted();
        this.zzacr = game.zzmy();
        this.zzacs = game.areSnapshotsEnabled();
        this.zzact = game.getThemeColor();
        this.zzacu = game.hasGamepadSupport();
    }

    static int zza(Game game) {
        return zzw.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzmx()), Boolean.valueOf(game.zzmz()), game.zzmA(), Integer.valueOf(game.zzmB()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzmy()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (zzw.equal(game2.getApplicationId(), game.getApplicationId()) && zzw.equal(game2.getDisplayName(), game.getDisplayName()) && zzw.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && zzw.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && zzw.equal(game2.getDescription(), game.getDescription()) && zzw.equal(game2.getDeveloperName(), game.getDeveloperName()) && zzw.equal(game2.getIconImageUri(), game.getIconImageUri()) && zzw.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && zzw.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && zzw.equal(Boolean.valueOf(game2.zzmx()), Boolean.valueOf(game.zzmx())) && zzw.equal(Boolean.valueOf(game2.zzmz()), Boolean.valueOf(game.zzmz())) && zzw.equal(game2.zzmA(), game.zzmA()) && zzw.equal(Integer.valueOf(game2.zzmB()), Integer.valueOf(game.zzmB())) && zzw.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && zzw.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && zzw.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && zzw.equal(Boolean.valueOf(game2.zzmy()), Boolean.valueOf(game.zzmy()));
            if (zzw.equal(valueOf, Boolean.valueOf(z)) && zzw.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && zzw.equal(game2.getThemeColor(), game.getThemeColor()) && zzw.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()))) {
                return true;
            }
        }
        return false;
    }

    static String zzb(Game game) {
        return zzw.zzk(game).zza("ApplicationId", game.getApplicationId()).zza("DisplayName", game.getDisplayName()).zza("PrimaryCategory", game.getPrimaryCategory()).zza("SecondaryCategory", game.getSecondaryCategory()).zza("Description", game.getDescription()).zza("DeveloperName", game.getDeveloperName()).zza("IconImageUri", game.getIconImageUri()).zza("IconImageUrl", game.getIconImageUrl()).zza("HiResImageUri", game.getHiResImageUri()).zza("HiResImageUrl", game.getHiResImageUrl()).zza("FeaturedImageUri", game.getFeaturedImageUri()).zza("FeaturedImageUrl", game.getFeaturedImageUrl()).zza("PlayEnabledGame", Boolean.valueOf(game.zzmx())).zza("InstanceInstalled", Boolean.valueOf(game.zzmz())).zza("InstancePackageName", game.zzmA()).zza("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zza("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zza("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zza("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zza("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zza("ThemeColor", game.getThemeColor()).zza("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.zzacs;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.zzacj;
    }

    public String getApplicationId() {
        return this.zzIm;
    }

    public String getDescription() {
        return this.zzZO;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzZO, charArrayBuffer);
    }

    public String getDeveloperName() {
        return this.zzacb;
    }

    public void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzacb, charArrayBuffer);
    }

    public String getDisplayName() {
        return this.zzSJ;
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzSJ, charArrayBuffer);
    }

    public Uri getFeaturedImageUri() {
        return this.zzace;
    }

    public String getFeaturedImageUrl() {
        return this.zzacp;
    }

    public Uri getHiResImageUri() {
        return this.zzacd;
    }

    public String getHiResImageUrl() {
        return this.zzaco;
    }

    public Uri getIconImageUri() {
        return this.zzacc;
    }

    public String getIconImageUrl() {
        return this.zzacn;
    }

    public int getLeaderboardCount() {
        return this.zzack;
    }

    public String getPrimaryCategory() {
        return this.zzabZ;
    }

    public String getSecondaryCategory() {
        return this.zzaca;
    }

    public String getThemeColor() {
        return this.zzact;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean hasGamepadSupport() {
        return this.zzacu;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.zzacq;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.zzacl;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.zzacm;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        String str = null;
        if (zziY()) {
            parcel.writeString(this.zzIm);
            parcel.writeString(this.zzSJ);
            parcel.writeString(this.zzabZ);
            parcel.writeString(this.zzaca);
            parcel.writeString(this.zzZO);
            parcel.writeString(this.zzacb);
            parcel.writeString(this.zzacc == null ? null : this.zzacc.toString());
            parcel.writeString(this.zzacd == null ? null : this.zzacd.toString());
            if (this.zzace != null) {
                str = this.zzace.toString();
            }
            parcel.writeString(str);
            parcel.writeInt(this.zzacf ? 1 : 0);
            if (!this.zzacg) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.zzach);
            parcel.writeInt(this.zzaci);
            parcel.writeInt(this.zzacj);
            parcel.writeInt(this.zzack);
            return;
        }
        GameEntityCreator.zza(this, parcel, i);
    }

    public String zzmA() {
        return this.zzach;
    }

    public int zzmB() {
        return this.zzaci;
    }

    public boolean zzmx() {
        return this.zzacf;
    }

    public boolean zzmy() {
        return this.zzacr;
    }

    public boolean zzmz() {
        return this.zzacg;
    }
}
