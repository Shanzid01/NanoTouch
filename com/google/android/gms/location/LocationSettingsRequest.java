package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LocationSettingsRequest implements SafeParcelable {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzj();
    private final int zzFG;
    private final List<LocationRequest> zzabu;
    private final boolean zzamm;
    private final boolean zzamn;

    public final class Builder {
        private boolean zzamm = false;
        private boolean zzamn = false;
        private final ArrayList<LocationRequest> zzamo = new ArrayList();

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.zzamo.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.zzamo.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zzamo, this.zzamm, this.zzamn);
        }

        public Builder setAlwaysShow(boolean z) {
            this.zzamm = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.zzamn = z;
            return this;
        }
    }

    LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2) {
        this.zzFG = i;
        this.zzabu = list;
        this.zzamm = z;
        this.zzamn = z2;
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2) {
        this(1, (List) list, z, z2);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public List<LocationRequest> zzme() {
        return Collections.unmodifiableList(this.zzabu);
    }

    public boolean zzps() {
        return this.zzamm;
    }

    public boolean zzpt() {
        return this.zzamn;
    }
}
