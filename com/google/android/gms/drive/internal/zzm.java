package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzm extends Metadata {
    private final MetadataBundle zzTv;

    public zzm(MetadataBundle metadataBundle) {
        this.zzTv = metadataBundle;
    }

    public /* synthetic */ Object freeze() {
        return zzkw();
    }

    public boolean isDataValid() {
        return this.zzTv != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.zzTv + "]";
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return this.zzTv.zza((MetadataField) metadataField);
    }

    public Metadata zzkw() {
        return new zzm(MetadataBundle.zza(this.zzTv));
    }
}
