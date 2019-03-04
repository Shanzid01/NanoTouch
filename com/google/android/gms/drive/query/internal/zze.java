package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

class zze {
    static MetadataField<?> zzb(MetadataBundle metadataBundle) {
        Set zzla = metadataBundle.zzla();
        if (zzla.size() == 1) {
            return (MetadataField) zzla.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
