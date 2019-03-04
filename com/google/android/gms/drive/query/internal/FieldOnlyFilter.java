package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Creator<FieldOnlyFilter> CREATOR = new zzb();
    final int zzFG;
    final MetadataBundle zzWx;
    private final MetadataField<?> zzWy;

    FieldOnlyFilter(int i, MetadataBundle metadataBundle) {
        this.zzFG = i;
        this.zzWx = metadataBundle;
        this.zzWy = zze.zzb(metadataBundle);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> searchableMetadataField) {
        this(1, MetadataBundle.zza(searchableMetadataField, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public <T> T zza(zzf<T> com_google_android_gms_drive_query_internal_zzf_T) {
        return com_google_android_gms_drive_query_internal_zzf_T.zze(this.zzWy);
    }
}
