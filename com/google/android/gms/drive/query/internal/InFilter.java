package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final zzi CREATOR = new zzi();
    final int zzFG;
    private final zzb<T> zzWJ;
    final MetadataBundle zzWx;

    InFilter(int i, MetadataBundle metadataBundle) {
        this.zzFG = i;
        this.zzWx = metadataBundle;
        this.zzWJ = (zzb) zze.zzb(metadataBundle);
    }

    public InFilter(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        this(1, MetadataBundle.zza(searchableCollectionMetadataField, Collections.singleton(t)));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.zzWx.zza(this.zzWJ)).iterator().next();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public <F> F zza(zzf<F> com_google_android_gms_drive_query_internal_zzf_F) {
        return com_google_android_gms_drive_query_internal_zzf_F.zzb(this.zzWJ, getValue());
    }
}
