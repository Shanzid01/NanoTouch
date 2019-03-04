package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int zzFG;
    final String zzVg;
    final boolean zzWz;

    FieldWithSortOrder(int i, String str, boolean z) {
        this.zzFG = i;
        this.zzVg = str;
        this.zzWz = z;
    }

    public FieldWithSortOrder(String str, boolean z) {
        this(1, str, z);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale locale = Locale.US;
        String str = "FieldWithSortOrder[%s %s]";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzVg;
        objArr[1] = this.zzWz ? "ASC" : "DESC";
        return String.format(locale, str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
