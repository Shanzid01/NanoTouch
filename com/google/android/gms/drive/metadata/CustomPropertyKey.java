package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class CustomPropertyKey implements SafeParcelable {
    public static final Creator<CustomPropertyKey> CREATOR = new zzc();
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;
    private static final Pattern zzVk = Pattern.compile("[\\w.!@$%^&*()/-]+");
    final int mVisibility;
    final int zzFG;
    final String zzqd;

    CustomPropertyKey(int i, String str, int i2) {
        boolean z = true;
        zzx.zzb((Object) str, (Object) "key");
        zzx.zzb(zzVk.matcher(str).matches(), (Object) "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        if (!(i2 == 0 || i2 == 1)) {
            z = false;
        }
        zzx.zzb(z, (Object) "visibility must be either PUBLIC or PRIVATE");
        this.zzFG = i;
        this.zzqd = str;
        this.mVisibility = i2;
    }

    public CustomPropertyKey(String str, int i) {
        this(1, str, i);
    }

    public static CustomPropertyKey fromJson(JSONObject jSONObject) {
        return new CustomPropertyKey(jSONObject.getString("key"), jSONObject.getInt("visibility"));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPropertyKey)) {
            return false;
        }
        CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
        if (!(customPropertyKey.getKey().equals(this.zzqd) && customPropertyKey.getVisibility() == this.mVisibility)) {
            z = false;
        }
        return z;
    }

    public String getKey() {
        return this.zzqd;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int hashCode() {
        return (this.zzqd + this.mVisibility).hashCode();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", getKey());
        jSONObject.put("visibility", getVisibility());
        return jSONObject;
    }

    public String toString() {
        return "CustomPropertyKey(" + this.zzqd + "," + this.mVisibility + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
