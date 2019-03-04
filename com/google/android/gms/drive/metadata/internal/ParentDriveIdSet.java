package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParentDriveIdSet implements SafeParcelable {
    public static final Creator<ParentDriveIdSet> CREATOR = new zzk();
    final int zzFG;
    final List<PartialDriveId> zzVr;

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    ParentDriveIdSet(int i, List<PartialDriveId> list) {
        this.zzFG = i;
        this.zzVr = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public Set<DriveId> zzs(long j) {
        Set<DriveId> hashSet = new HashSet();
        for (PartialDriveId zzt : this.zzVr) {
            hashSet.add(zzt.zzt(j));
        }
        return hashSet;
    }
}
