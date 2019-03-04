package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzmi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new zzh();
    final int zzFG;
    final Bundle zzVq;

    MetadataBundle(int i, Bundle bundle) {
        this.zzFG = i;
        this.zzVq = (Bundle) zzx.zzl(bundle);
        this.zzVq.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.zzVq.keySet()) {
            if (zze.zzby(str) == null) {
                arrayList.add(str);
                zzw.zzr("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.zzVq.remove(str2);
        }
    }

    private MetadataBundle(Bundle bundle) {
        this(1, bundle);
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzkZ = zzkZ();
        zzkZ.zzb(metadataField, t);
        return zzkZ;
    }

    public static MetadataBundle zza(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.zzVq));
    }

    public static MetadataBundle zzkZ() {
        return new MetadataBundle(new Bundle());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzVq.keySet();
        if (!keySet.equals(metadataBundle.zzVq.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!com.google.android.gms.common.internal.zzw.equal(this.zzVq.get(str), metadataBundle.zzVq.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.zzVq.keySet()) {
            i *= 31;
            i = this.zzVq.get(str).hashCode() + i;
        }
        return i;
    }

    public void setContext(Context context) {
        zza com_google_android_gms_common_data_zza = (zza) zza(zzmi.zzVU);
        if (com_google_android_gms_common_data_zza != null) {
            com_google_android_gms_common_data_zza.zza(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.zzVq + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zza(this.zzVq);
    }

    public <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zze.zzby(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(t, this.zzVq);
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzVq.containsKey(metadataField.getName());
    }

    public Set<MetadataField<?>> zzla() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String zzby : this.zzVq.keySet()) {
            hashSet.add(zze.zzby(zzby));
        }
        return hashSet;
    }
}
