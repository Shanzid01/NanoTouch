package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR = new zzj();
    private final int zzFG;
    private final String zzFO;
    private final List<DataType> zzYA;
    private final List<Integer> zzabd;
    private final boolean zzabe;
    private final zznh zzabf;

    public class Builder {
        private boolean zzabe = false;
        private DataType[] zzabg = new DataType[0];
        private int[] zzabh = new int[]{0, 1};

        public DataSourcesRequest build() {
            boolean z = true;
            zzx.zza(this.zzabg.length > 0, (Object) "Must add at least one data type");
            if (this.zzabh.length <= 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must add at least one data source type");
            return new DataSourcesRequest();
        }

        public Builder setDataSourceTypes(int... iArr) {
            this.zzabh = iArr;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzabg = dataTypeArr;
            return this;
        }
    }

    DataSourcesRequest(int i, List<DataType> list, List<Integer> list2, boolean z, IBinder iBinder, String str) {
        this.zzFG = i;
        this.zzYA = list;
        this.zzabd = list2;
        this.zzabe = z;
        this.zzabf = iBinder == null ? null : zza.zzaE(iBinder);
        this.zzFO = str;
    }

    private DataSourcesRequest(Builder builder) {
        this(zzls.zzb(builder.zzabg), Arrays.asList(zzls.zza(builder.zzabh)), builder.zzabe, null, null);
    }

    public DataSourcesRequest(DataSourcesRequest dataSourcesRequest, zznh com_google_android_gms_internal_zznh, String str) {
        this(dataSourcesRequest.zzYA, dataSourcesRequest.zzabd, dataSourcesRequest.zzabe, com_google_android_gms_internal_zznh, str);
    }

    public DataSourcesRequest(List<DataType> list, List<Integer> list2, boolean z, zznh com_google_android_gms_internal_zznh, String str) {
        this.zzFG = 3;
        this.zzYA = list;
        this.zzabd = list2;
        this.zzabe = z;
        this.zzabf = com_google_android_gms_internal_zznh;
        this.zzFO = str;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzYA);
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        zzw.zza zza = zzw.zzk(this).zza("dataTypes", this.zzYA).zza("sourceTypes", this.zzabd);
        if (this.zzabe) {
            zza.zza("includeDbOnlySources", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        return zza.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabf == null ? null : this.zzabf.asBinder();
    }

    public List<Integer> zzlY() {
        return this.zzabd;
    }

    public boolean zzlZ() {
        return this.zzabe;
    }
}
