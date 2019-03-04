package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;

public final class Value implements SafeParcelable {
    public static final Creator<Value> CREATOR = new zzu();
    private final int zzFG;
    private final int zzZE;
    private boolean zzZS;
    private float zzZT;

    public Value(int i) {
        this(1, i, false, 0.0f);
    }

    Value(int i, int i2, boolean z, float f) {
        this.zzFG = i;
        this.zzZE = i2;
        this.zzZS = z;
        this.zzZT = f;
    }

    private boolean zza(Value value) {
        if (this.zzZE != value.zzZE || this.zzZS != value.zzZS) {
            return false;
        }
        switch (this.zzZE) {
            case 1:
                return asInt() == value.asInt();
            case 2:
                return asFloat() == value.asFloat();
            default:
                return this.zzZT == value.zzZT;
        }
    }

    public String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat() {
        zzx.zza(this.zzZE == 2, (Object) "Value is not in float format");
        return this.zzZT;
    }

    public int asInt() {
        boolean z = true;
        if (this.zzZE != 1) {
            z = false;
        }
        zzx.zza(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.zzZT);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Value) && zza((Value) obj));
    }

    public int getFormat() {
        return this.zzZE;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzZT), Integer.valueOf(this.zzZE), Boolean.valueOf(this.zzZS));
    }

    public boolean isSet() {
        return this.zzZS;
    }

    public void setActivity(String str) {
        setInt(FitnessActivities.zzbG(str));
    }

    public void setFloat(float f) {
        zzx.zza(this.zzZE == 2, (Object) "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzZS = true;
        this.zzZT = f;
    }

    public void setInt(int i) {
        zzx.zza(this.zzZE == 1, (Object) "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzZS = true;
        this.zzZT = Float.intBitsToFloat(i);
    }

    public String toString() {
        if (!this.zzZS) {
            return "unset";
        }
        switch (this.zzZE) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(asFloat());
            default:
                return FitnessActivities.UNKNOWN;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }

    float zzlL() {
        return this.zzZT;
    }
}
