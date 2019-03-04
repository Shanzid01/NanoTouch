package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR = new zza();
    public static final AppVisibleCustomProperties zzVl = new zza().zzkW();
    final int zzFG;
    final List<CustomProperty> zzVm;

    public class zza {
        private final Map<CustomPropertyKey, CustomProperty> zzVn = new HashMap();

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzx.zzb((Object) customPropertyKey, (Object) "key");
            this.zzVn.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public AppVisibleCustomProperties zzkW() {
            return new AppVisibleCustomProperties(this.zzVn.values());
        }
    }

    AppVisibleCustomProperties(int i, Collection<CustomProperty> collection) {
        this.zzFG = i;
        zzx.zzl(collection);
        this.zzVm = new ArrayList(collection);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> collection) {
        this(1, (Collection) collection);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.zzVm.iterator();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Map<CustomPropertyKey, String> zzkV() {
        Map hashMap = new HashMap(this.zzVm.size());
        for (CustomProperty customProperty : this.zzVm) {
            hashMap.put(customProperty.zzkX(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
