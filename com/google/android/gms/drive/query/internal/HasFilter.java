package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T> extends AbstractFilter {
    public static final zzh CREATOR = new zzh();
    final int zzFG;
    final MetadataBundle zzWx;
    final MetadataField<T> zzWy;

    HasFilter(int i, MetadataBundle metadataBundle) {
        this.zzFG = i;
        this.zzWx = metadataBundle;
        this.zzWy = zze.zzb(metadataBundle);
    }

    public HasFilter(SearchableMetadataField<T> searchableMetadataField, T t) {
        this(1, MetadataBundle.zza(searchableMetadataField, t));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.zzWx.zza(this.zzWy);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> com_google_android_gms_drive_query_internal_zzf_F) {
        return com_google_android_gms_drive_query_internal_zzf_F.zzd(this.zzWy, getValue());
    }
}
