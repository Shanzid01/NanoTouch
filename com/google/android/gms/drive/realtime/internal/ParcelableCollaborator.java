package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR = new zzp();
    final int zzFG;
    final String zzSJ;
    final boolean zzWX;
    final boolean zzWY;
    final String zzWZ;
    final String zzXa;
    final String zzXb;
    final String zzyL;

    ParcelableCollaborator(int i, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5) {
        this.zzFG = i;
        this.zzWX = z;
        this.zzWY = z2;
        this.zzyL = str;
        this.zzWZ = str2;
        this.zzSJ = str3;
        this.zzXa = str4;
        this.zzXb = str5;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.zzyL.equals(((ParcelableCollaborator) obj).zzyL);
    }

    public int hashCode() {
        return this.zzyL.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzWX + ", isAnonymous=" + this.zzWY + ", sessionId=" + this.zzyL + ", userId=" + this.zzWZ + ", displayName=" + this.zzSJ + ", color=" + this.zzXa + ", photoUrl=" + this.zzXb + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
