package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR = new zzm();
    public static final Operator zzWM = new Operator("=");
    public static final Operator zzWN = new Operator("<");
    public static final Operator zzWO = new Operator("<=");
    public static final Operator zzWP = new Operator(">");
    public static final Operator zzWQ = new Operator(">=");
    public static final Operator zzWR = new Operator("and");
    public static final Operator zzWS = new Operator("or");
    public static final Operator zzWT = new Operator("not");
    public static final Operator zzWU = new Operator("contains");
    final String mTag;
    final int zzFG;

    Operator(int i, String str) {
        this.zzFG = i;
        this.mTag = str;
    }

    private Operator(String str) {
        this(1, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
