package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzk.zza;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class zzac implements SafeParcelable {
    public static final Creator<zzac> CREATOR = new zzad();
    private final PendingIntent mPendingIntent;
    private final int zzFG;
    private final String zzFO;
    private final DataType zzYo;
    private final DataSource zzYp;
    private final long zzZQ;
    private final int zzZR;
    private final zznv zzaaN;
    private zzk zzabp;
    int zzabq;
    int zzabr;
    private final long zzabs;
    private final long zzabt;
    private final List<LocationRequest> zzabu;
    private final long zzabv;
    private final List<Object> zzabw;

    zzac(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4, IBinder iBinder2, String str) {
        this.zzFG = i;
        this.zzYp = dataSource;
        this.zzYo = dataType;
        this.zzabp = iBinder == null ? null : zza.zzav(iBinder);
        if (j == 0) {
            j = (long) i2;
        }
        this.zzZQ = j;
        this.zzabt = j3;
        if (j2 == 0) {
            j2 = (long) i3;
        }
        this.zzabs = j2;
        this.zzabu = list;
        this.mPendingIntent = pendingIntent;
        this.zzZR = i4;
        this.zzabw = Collections.emptyList();
        this.zzabv = j4;
        this.zzaaN = iBinder2 == null ? null : zznv.zza.zzaS(iBinder2);
        this.zzFO = str;
    }

    public zzac(DataSource dataSource, DataType dataType, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent, long j, long j2, long j3, int i, List<LocationRequest> list, List<Object> list2, long j4, zznv com_google_android_gms_internal_zznv, String str) {
        this.zzFG = 5;
        this.zzYp = dataSource;
        this.zzYo = dataType;
        this.zzabp = com_google_android_gms_fitness_data_zzk;
        this.mPendingIntent = pendingIntent;
        this.zzZQ = j;
        this.zzabt = j2;
        this.zzabs = j3;
        this.zzZR = i;
        this.zzabu = list;
        this.zzabw = list2;
        this.zzabv = j4;
        this.zzaaN = com_google_android_gms_internal_zznv;
        this.zzFO = str;
    }

    public zzac(SensorRequest sensorRequest, zzk com_google_android_gms_fitness_data_zzk, PendingIntent pendingIntent, zznv com_google_android_gms_internal_zznv, String str) {
        zzk com_google_android_gms_fitness_data_zzk2 = com_google_android_gms_fitness_data_zzk;
        PendingIntent pendingIntent2 = pendingIntent;
        this(sensorRequest.getDataSource(), sensorRequest.getDataType(), com_google_android_gms_fitness_data_zzk2, pendingIntent2, sensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorRequest.getFastestRate(TimeUnit.MICROSECONDS), sensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorRequest.getAccuracyMode(), null, Collections.emptyList(), sensorRequest.zzmh(), com_google_android_gms_internal_zznv, str);
    }

    private boolean zzb(zzac com_google_android_gms_fitness_request_zzac) {
        return zzw.equal(this.zzYp, com_google_android_gms_fitness_request_zzac.zzYp) && zzw.equal(this.zzYo, com_google_android_gms_fitness_request_zzac.zzYo) && this.zzZQ == com_google_android_gms_fitness_request_zzac.zzZQ && this.zzabt == com_google_android_gms_fitness_request_zzac.zzabt && this.zzabs == com_google_android_gms_fitness_request_zzac.zzabs && this.zzZR == com_google_android_gms_fitness_request_zzac.zzZR && zzw.equal(this.zzabu, com_google_android_gms_fitness_request_zzac.zzabu);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof zzac) && zzb((zzac) obj));
    }

    public int getAccuracyMode() {
        return this.zzZR;
    }

    public DataSource getDataSource() {
        return this.zzYp;
    }

    public DataType getDataType() {
        return this.zzYo;
    }

    public String getPackageName() {
        return this.zzFO;
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYp, this.zzYo, this.zzabp, Long.valueOf(this.zzZQ), Long.valueOf(this.zzabt), Long.valueOf(this.zzabs), Integer.valueOf(this.zzZR), this.zzabu);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.zzYo, this.zzYp, Long.valueOf(this.zzZQ), Long.valueOf(this.zzabt), Long.valueOf(this.zzabs)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }

    public long zzlI() {
        return this.zzZQ;
    }

    public IBinder zzlQ() {
        return this.zzaaN == null ? null : this.zzaaN.asBinder();
    }

    public PendingIntent zzmb() {
        return this.mPendingIntent;
    }

    public long zzmc() {
        return this.zzabt;
    }

    public long zzmd() {
        return this.zzabs;
    }

    public List<LocationRequest> zzme() {
        return this.zzabu;
    }

    public long zzmf() {
        return this.zzabv;
    }

    IBinder zzmg() {
        return this.zzabp == null ? null : this.zzabp.asBinder();
    }
}
