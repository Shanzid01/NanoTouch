package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int zzFG;
    final Operator zzWw;
    final MetadataBundle zzWx;
    final MetadataField<T> zzWy;

    ComparisonFilter(int i, Operator operator, MetadataBundle metadataBundle) {
        this.zzFG = i;
        this.zzWw = operator;
        this.zzWx = metadataBundle;
        this.zzWy = zze.zzb(metadataBundle);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, operator, MetadataBundle.zza(searchableMetadataField, t));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.zzWx.zza(this.zzWy);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> com_google_android_gms_drive_query_internal_zzf_F) {
        return com_google_android_gms_drive_query_internal_zzf_F.zzb(this.zzWw, this.zzWy, getValue());
    }
}
