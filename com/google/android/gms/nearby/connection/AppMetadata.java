package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public final class AppMetadata implements SafeParcelable {
    public static final AppMetadataCreator CREATOR = new AppMetadataCreator();
    private final int zzFG;
    private final List<AppIdentifier> zzasE;

    AppMetadata(int i, List<AppIdentifier> list) {
        this.zzFG = i;
        this.zzasE = (List) zzx.zzb((Object) list, (Object) "Must specify application identifiers");
        zzx.zza(list.size(), (Object) "Application identifiers cannot be empty");
    }

    public AppMetadata(List<AppIdentifier> list) {
        this(1, list);
    }

    public int describeContents() {
        AppMetadataCreator appMetadataCreator = CREATOR;
        return 0;
    }

    public List<AppIdentifier> getAppIdentifiers() {
        return this.zzasE;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMetadataCreator appMetadataCreator = CREATOR;
        AppMetadataCreator.zza(this, parcel, i);
    }
}
