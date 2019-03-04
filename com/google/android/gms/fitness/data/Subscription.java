package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class Subscription implements SafeParcelable {
    public static final Creator<Subscription> CREATOR = new zzs();
    private final int zzFG;
    private final DataType zzYo;
    private final DataSource zzYp;
    private final long zzZQ;
    private final int zzZR;

    public class zza {
        private DataType zzYo;
        private DataSource zzYp;
        private long zzZQ = -1;
        private int zzZR = 2;

        public zza zzb(DataSource dataSource) {
            this.zzYp = dataSource;
            return this;
        }

        public zza zzb(DataType dataType) {
            this.zzYo = dataType;
            return this;
        }

        public Subscription zzlK() {
            boolean z = false;
            boolean z2 = (this.zzYp == null && this.zzYo == null) ? false : true;
            zzx.zza(z2, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzYo == null || this.zzYp == null || this.zzYo.equals(this.zzYp.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new Subscription();
        }
    }

    Subscription(int i, DataSource dataSource, DataType dataType, long j, int i2) {
        this.zzFG = i;
        this.zzYp = dataSource;
        this.zzYo = dataType;
        this.zzZQ = j;
        this.zzZR = i2;
    }

    private Subscription(zza com_google_android_gms_fitness_data_Subscription_zza) {
        this.zzFG = 1;
        this.zzYo = com_google_android_gms_fitness_data_Subscription_zza.zzYo;
        this.zzYp = com_google_android_gms_fitness_data_Subscription_zza.zzYp;
        this.zzZQ = com_google_android_gms_fitness_data_Subscription_zza.zzZQ;
        this.zzZR = com_google_android_gms_fitness_data_Subscription_zza.zzZR;
    }

    private boolean zza(Subscription subscription) {
        return zzw.equal(this.zzYp, subscription.zzYp) && zzw.equal(this.zzYo, subscription.zzYo) && this.zzZQ == subscription.zzZQ && this.zzZR == subscription.zzZR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Subscription) && zza((Subscription) obj));
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

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzYp, this.zzYp, Long.valueOf(this.zzZQ), Integer.valueOf(this.zzZR));
    }

    public String toDebugString() {
        String str = "Subscription{%s}";
        Object[] objArr = new Object[1];
        objArr[0] = this.zzYp == null ? this.zzYo.getName() : this.zzYp.toDebugString();
        return String.format(str, objArr);
    }

    public String toString() {
        return zzw.zzk(this).zza("dataSource", this.zzYp).zza("dataType", this.zzYo).zza("samplingIntervalMicros", Long.valueOf(this.zzZQ)).zza("accuracyMode", Integer.valueOf(this.zzZR)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }

    public long zzlI() {
        return this.zzZQ;
    }

    public DataType zzlJ() {
        return this.zzYo == null ? this.zzYp.getDataType() : this.zzYo;
    }
}
