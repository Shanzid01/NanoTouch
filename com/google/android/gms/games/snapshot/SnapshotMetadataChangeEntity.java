package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int zzFG;
    private final String zzZO;
    private final Long zzakF;
    private final Uri zzakH;
    private final Long zzakI;
    private zza zzakJ;

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int i, String str, Long l, zza com_google_android_gms_common_data_zza, Uri uri, Long l2) {
        boolean z = true;
        this.zzFG = i;
        this.zzZO = str;
        this.zzakI = l;
        this.zzakJ = com_google_android_gms_common_data_zza;
        this.zzakH = uri;
        this.zzakF = l2;
        if (this.zzakJ != null) {
            if (this.zzakH != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        } else if (this.zzakH != null) {
            if (this.zzakJ != null) {
                z = false;
            }
            zzx.zza(z, (Object) "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String str, Long l, zza com_google_android_gms_common_data_zza, Uri uri, Long l2) {
        this(5, str, l, com_google_android_gms_common_data_zza, uri, l2);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.zzakJ == null ? null : this.zzakJ.zziv();
    }

    public Uri getCoverImageUri() {
        return this.zzakH;
    }

    public String getDescription() {
        return this.zzZO;
    }

    public Long getPlayedTimeMillis() {
        return this.zzakI;
    }

    public Long getProgressValue() {
        return this.zzakF;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        SnapshotMetadataChangeCreator.zza(this, parcel, i);
    }

    public zza zzpc() {
        return this.zzakJ;
    }
}
