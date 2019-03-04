package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class zza<T> implements MetadataField<T> {
    private final String zzVg;
    private final Set<String> zzVh;
    private final Set<String> zzVi;
    private final int zzVj;

    protected zza(String str, int i) {
        this.zzVg = (String) zzx.zzb((Object) str, (Object) "fieldName");
        this.zzVh = Collections.singleton(str);
        this.zzVi = Collections.emptySet();
        this.zzVj = i;
    }

    protected zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.zzVg = (String) zzx.zzb((Object) str, (Object) "fieldName");
        this.zzVh = Collections.unmodifiableSet(new HashSet(collection));
        this.zzVi = Collections.unmodifiableSet(new HashSet(collection2));
        this.zzVj = i;
    }

    public final String getName() {
        return this.zzVg;
    }

    public String toString() {
        return this.zzVg;
    }

    public final T zza(Bundle bundle) {
        zzx.zzb((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? zzl(bundle) : null;
    }

    public final T zza(DataHolder dataHolder, int i, int i2) {
        return zzb(dataHolder, i, i2) ? zzc(dataHolder, i, i2) : null;
    }

    protected abstract void zza(Bundle bundle, T t);

    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        zzx.zzb((Object) dataHolder, (Object) "dataHolder");
        zzx.zzb((Object) metadataBundle, (Object) "bundle");
        if (zzb(dataHolder, i, i2)) {
            metadataBundle.zzb(this, zzc(dataHolder, i, i2));
        }
    }

    public final void zza(T t, Bundle bundle) {
        zzx.zzb((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            zza(bundle, (Object) t);
        }
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String str : this.zzVh) {
            if (dataHolder.zzba(str)) {
                if (dataHolder.zzh(str, i, i2)) {
                }
            }
            return false;
        }
        return true;
    }

    protected abstract T zzc(DataHolder dataHolder, int i, int i2);

    protected abstract T zzl(Bundle bundle);
}
