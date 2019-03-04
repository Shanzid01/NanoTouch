package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Creator<ParcelableEvent> CREATOR = new zzc();
    final int zzFG;
    final String zzWZ;
    final String zzXc;
    final List<String> zzXh;
    final boolean zzXi;
    final boolean zzXj;
    final boolean zzXk;
    final String zzXl;
    final TextInsertedDetails zzXm;
    final TextDeletedDetails zzXn;
    final ValuesAddedDetails zzXo;
    final ValuesRemovedDetails zzXp;
    final ValuesSetDetails zzXq;
    final ValueChangedDetails zzXr;
    final ReferenceShiftedDetails zzXs;
    final ObjectChangedDetails zzXt;
    final FieldChangedDetails zzXu;
    final String zzyL;

    ParcelableEvent(int i, String str, String str2, List<String> list, boolean z, boolean z2, boolean z3, String str3, String str4, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails, FieldChangedDetails fieldChangedDetails) {
        this.zzFG = i;
        this.zzyL = str;
        this.zzWZ = str2;
        this.zzXh = list;
        this.zzXi = z;
        this.zzXj = z2;
        this.zzXk = z3;
        this.zzXc = str3;
        this.zzXl = str4;
        this.zzXm = textInsertedDetails;
        this.zzXn = textDeletedDetails;
        this.zzXo = valuesAddedDetails;
        this.zzXp = valuesRemovedDetails;
        this.zzXq = valuesSetDetails;
        this.zzXr = valueChangedDetails;
        this.zzXs = referenceShiftedDetails;
        this.zzXt = objectChangedDetails;
        this.zzXu = fieldChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
