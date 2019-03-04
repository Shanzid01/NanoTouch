package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlw;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
    private final int zzFG;
    private final String zzSy;
    private final String zzZO;
    private final String zzaef;
    private final GameEntity zzahV;
    private final Uri zzakH;
    private final PlayerEntity zzakK;
    private final String zzakL;
    private final long zzakM;
    private final long zzakN;
    private final float zzakO;
    private final String zzakP;
    private final boolean zzakQ;
    private final long zzakR;

    SnapshotMetadataEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, String str, Uri uri, String str2, String str3, String str4, long j, long j2, float f, String str5, boolean z, long j3) {
        this.zzFG = i;
        this.zzahV = gameEntity;
        this.zzakK = playerEntity;
        this.zzaef = str;
        this.zzakH = uri;
        this.zzakL = str2;
        this.zzakO = f;
        this.zzSy = str3;
        this.zzZO = str4;
        this.zzakM = j;
        this.zzakN = j2;
        this.zzakP = str5;
        this.zzakQ = z;
        this.zzakR = j3;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.zzFG = 5;
        this.zzahV = new GameEntity(snapshotMetadata.getGame());
        this.zzakK = new PlayerEntity(snapshotMetadata.getOwner());
        this.zzaef = snapshotMetadata.getSnapshotId();
        this.zzakH = snapshotMetadata.getCoverImageUri();
        this.zzakL = snapshotMetadata.getCoverImageUrl();
        this.zzakO = snapshotMetadata.getCoverImageAspectRatio();
        this.zzSy = snapshotMetadata.getTitle();
        this.zzZO = snapshotMetadata.getDescription();
        this.zzakM = snapshotMetadata.getLastModifiedTimestamp();
        this.zzakN = snapshotMetadata.getPlayedTime();
        this.zzakP = snapshotMetadata.getUniqueName();
        this.zzakQ = snapshotMetadata.hasChangePending();
        this.zzakR = snapshotMetadata.getProgressValue();
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return zzw.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()));
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzw.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && zzw.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && zzw.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && zzw.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && zzw.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && zzw.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && zzw.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && zzw.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && zzw.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && zzw.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && zzw.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && zzw.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue()));
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return zzw.zzk(snapshotMetadata).zza("Game", snapshotMetadata.getGame()).zza("Owner", snapshotMetadata.getOwner()).zza("SnapshotId", snapshotMetadata.getSnapshotId()).zza("CoverImageUri", snapshotMetadata.getCoverImageUri()).zza("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).zza("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).zza("Description", snapshotMetadata.getDescription()).zza("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).zza("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).zza("UniqueName", snapshotMetadata.getUniqueName()).zza("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).zza("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.zzakO;
    }

    public Uri getCoverImageUri() {
        return this.zzakH;
    }

    public String getCoverImageUrl() {
        return this.zzakL;
    }

    public String getDescription() {
        return this.zzZO;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzlw.zzb(this.zzZO, charArrayBuffer);
    }

    public Game getGame() {
        return this.zzahV;
    }

    public long getLastModifiedTimestamp() {
        return this.zzakM;
    }

    public Player getOwner() {
        return this.zzakK;
    }

    public long getPlayedTime() {
        return this.zzakN;
    }

    public long getProgressValue() {
        return this.zzakR;
    }

    public String getSnapshotId() {
        return this.zzaef;
    }

    public String getTitle() {
        return this.zzSy;
    }

    public String getUniqueName() {
        return this.zzakP;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean hasChangePending() {
        return this.zzakQ;
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
        SnapshotMetadataEntityCreator.zza(this, parcel, i);
    }
}
