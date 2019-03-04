package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DriveSpace implements SafeParcelable {
    public static final Creator<DriveSpace> CREATOR = new zzg();
    public static final DriveSpace zzSl = new DriveSpace("DRIVE");
    public static final DriveSpace zzSm = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzSn = new DriveSpace("GOOGLE_PHOTOS");
    public static final Set<DriveSpace> zzSo = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[]{zzSl, zzSm, zzSn})));
    public static final String zzSp = TextUtils.join(",", zzSo.toArray());
    private final String mName;
    final int zzFG;

    DriveSpace(int i, String str) {
        this.zzFG = i;
        this.mName = (String) zzx.zzl(str);
    }

    private DriveSpace(String str) {
        this(1, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj == null || obj.getClass() != DriveSpace.class) ? false : this.mName.equals(((DriveSpace) obj).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return 1247068382 ^ this.mName.hashCode();
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
