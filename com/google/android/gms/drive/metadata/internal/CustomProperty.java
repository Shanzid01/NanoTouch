package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class CustomProperty implements SafeParcelable {
    public static final Creator<CustomProperty> CREATOR = new zzc();
    final String mValue;
    final int zzFG;
    final CustomPropertyKey zzVo;

    CustomProperty(int i, CustomPropertyKey customPropertyKey, String str) {
        this.zzFG = i;
        zzx.zzb((Object) customPropertyKey, (Object) "key");
        this.zzVo = customPropertyKey;
        this.mValue = str;
    }

    public CustomProperty(CustomPropertyKey customPropertyKey, String str) {
        this(1, customPropertyKey, str);
    }

    public int describeContents() {
        return 0;
    }

    public String getValue() {
        return this.mValue;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public CustomPropertyKey zzkX() {
        return this.zzVo;
    }
}
