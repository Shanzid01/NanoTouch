package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza.zza;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zznv;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new zzaq();
    private final int zzFG;
    private final String zzFO;
    private final List<DataType> zzYA;
    private final zznv zzaaN;
    private final zzt zzabH;
    private final int zzabI;

    public class Builder {
        private zzt zzabH;
        private int zzabI = 10;
        private DataType[] zzabg = new DataType[0];

        public StartBleScanRequest build() {
            zzx.zza(this.zzabH != null, (Object) "Must set BleScanCallback");
            return new StartBleScanRequest();
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza(zza.zzlO().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzabg = dataTypeArr;
            return this;
        }

        public Builder setTimeoutSecs(int i) {
            boolean z = true;
            zzx.zzb(i > 0, (Object) "Stop time must be greater than zero");
            if (i > 60) {
                z = false;
            }
            zzx.zzb(z, (Object) "Stop time must be less than 1 minute");
            this.zzabI = i;
            return this;
        }

        public Builder zza(zzt com_google_android_gms_fitness_request_zzt) {
            this.zzabH = com_google_android_gms_fitness_request_zzt;
            return this;
        }
    }

    StartBleScanRequest(int i, List<DataType> list, IBinder iBinder, int i2, IBinder iBinder2, String str) {
        this.zzFG = i;
        this.zzYA = list;
        this.zzabH = zzt.zza.zzaV(iBinder);
        this.zzabI = i2;
        this.zzaaN = iBinder2 == null ? null : zznv.zza.zzaS(iBinder2);
        this.zzFO = str;
    }

    private StartBleScanRequest(Builder builder) {
        this(zzls.zzb(builder.zzabg), builder.zzabH, builder.zzabI, null, null);
    }

    public StartBleScanRequest(StartBleScanRequest startBleScanRequest, zznv com_google_android_gms_internal_zznv, String str) {
        this(startBleScanRequest.zzYA, startBleScanRequest.zzabH, startBleScanRequest.zzabI, com_google_android_gms_internal_zznv, str);
    }

    public StartBleScanRequest(List<DataType> list, zzt com_google_android_gms_fitness_request_zzt, int i, zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 3;
        this.zzYA = list;
        this.zzabH = com_google_android_gms_fitness_request_zzt;
        this.zzabI = i;
        this.zzaaN = com_google_android_gms_internal_zznv;
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

    public int getTimeoutSecs() {
        return this.zzabI;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public String toString() {
        return zzw.zzk(this).zza("dataTypes", this.zzYA).zza("timeoutSecs", Integer.valueOf(this.zzabI)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaq.zza(this, parcel, i);
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public IBinder zzmk() {
        return this.zzabH.asBinder();
    }
}
