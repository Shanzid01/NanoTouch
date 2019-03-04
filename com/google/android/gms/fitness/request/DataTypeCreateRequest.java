package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zzni.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Creator<DataTypeCreateRequest> CREATOR = new zzk();
    private final String mName;
    private final int zzFG;
    private final String zzFO;
    private final List<Field> zzZd;
    private final zzni zzabi;

    public class Builder {
        private String mName;
        private List<Field> zzZd = new ArrayList();

        public Builder addField(Field field) {
            if (!this.zzZd.contains(field)) {
                this.zzZd.add(field);
            }
            return this;
        }

        public Builder addField(String str, int i) {
            boolean z = (str == null || str.isEmpty()) ? false : true;
            zzx.zzb(z, (Object) "Invalid name specified");
            return addField(Field.zzn(str, i));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            zzx.zza(this.mName != null, (Object) "Must set the name");
            if (this.zzZd.isEmpty()) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify the data fields");
            return new DataTypeCreateRequest();
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }
    }

    DataTypeCreateRequest(int i, String str, List<Field> list, IBinder iBinder, String str2) {
        this.zzFG = i;
        this.mName = str;
        this.zzZd = Collections.unmodifiableList(list);
        this.zzabi = iBinder == null ? null : zza.zzaF(iBinder);
        this.zzFO = str2;
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzZd, null, null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zzni com_google_android_gms_internal_zzni, String str) {
        this(dataTypeCreateRequest.mName, dataTypeCreateRequest.zzZd, com_google_android_gms_internal_zzni, str);
    }

    public DataTypeCreateRequest(String str, List<Field> list, zzni com_google_android_gms_internal_zzni, String str2) {
        this.zzFG = 2;
        this.mName = str;
        this.zzZd = Collections.unmodifiableList(list);
        this.zzabi = com_google_android_gms_internal_zzni;
        this.zzFO = str2;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return zzw.equal(this.mName, dataTypeCreateRequest.mName) && zzw.equal(this.zzZd, dataTypeCreateRequest.zzZd);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) obj));
    }

    public List<Field> getFields() {
        return this.zzZd;
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzZd);
    }

    public String toString() {
        return zzw.zzk(this).zza("name", this.mName).zza("fields", this.zzZd).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzabi == null ? null : this.zzabi.asBinder();
    }
}
