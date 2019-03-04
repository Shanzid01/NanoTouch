package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
    public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
    private final int zzFG;
    private final SnapshotMetadataEntity zzakC;
    private final SnapshotContentsEntity zzakD;

    SnapshotEntity(int i, SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this.zzFG = i;
        this.zzakC = new SnapshotMetadataEntity(snapshotMetadata);
        this.zzakD = snapshotContentsEntity;
    }

    public SnapshotEntity(SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this(2, snapshotMetadata, snapshotContentsEntity);
    }

    private boolean isClosed() {
        return this.zzakD.isClosed();
    }

    static boolean zza(Snapshot snapshot, Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (snapshot == obj) {
            return true;
        }
        Snapshot snapshot2 = (Snapshot) obj;
        return zzw.equal(snapshot2.getMetadata(), snapshot.getMetadata()) && zzw.equal(snapshot2.getSnapshotContents(), snapshot.getSnapshotContents());
    }

    static int zzb(Snapshot snapshot) {
        return zzw.hashCode(snapshot.getMetadata(), snapshot.getSnapshotContents());
    }

    static String zzc(Snapshot snapshot) {
        return zzw.zzk(snapshot).zza("Metadata", snapshot.getMetadata()).zza("HasContents", Boolean.valueOf(snapshot.getSnapshotContents() != null)).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Snapshot freeze() {
        return this;
    }

    public SnapshotMetadata getMetadata() {
        return this.zzakC;
    }

    public SnapshotContents getSnapshotContents() {
        return isClosed() ? null : this.zzakD;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        SnapshotEntityCreator.zza(this, parcel, i);
    }
}
