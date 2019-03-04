package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
    public static final Creator<Session> CREATOR = new zzp();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int zzFG;
    private final long zzON;
    private final int zzYC;
    private final zza zzYP;
    private final long zzYq;
    private final String zzZN;
    private final String zzZO;

    public class Builder {
        private String mName = null;
        private long zzON = 0;
        private int zzYC = 4;
        private zza zzYP;
        private long zzYq = 0;
        private String zzZN;
        private String zzZO;

        public Session build() {
            boolean z = false;
            zzx.zza(this.zzON > 0, (Object) "Start time should be specified.");
            if (this.zzYq == 0 || this.zzYq > this.zzON) {
                z = true;
            }
            zzx.zza(z, (Object) "End time should be later than start time.");
            if (this.zzZN == null) {
                this.zzZN = (this.mName == null ? "" : this.mName) + this.zzON;
            }
            return new Session();
        }

        public Builder setActivity(String str) {
            return zzds(FitnessActivities.zzbG(str));
        }

        public Builder setDescription(String str) {
            zzx.zzb(str.length() <= 1000, "Session description cannot exceed %d characters", Integer.valueOf(1000));
            this.zzZO = str;
            return this;
        }

        public Builder setEndTime(long j, TimeUnit timeUnit) {
            zzx.zza(j >= 0, (Object) "End time should be positive.");
            this.zzYq = timeUnit.toMillis(j);
            return this;
        }

        public Builder setIdentifier(String str) {
            boolean z = str != null && TextUtils.getTrimmedLength(str) > 0;
            zzx.zzO(z);
            this.zzZN = str;
            return this;
        }

        public Builder setName(String str) {
            zzx.zzb(str.length() <= 100, "Session name cannot exceed %d characters", Integer.valueOf(100));
            this.mName = str;
            return this;
        }

        public Builder setStartTime(long j, TimeUnit timeUnit) {
            zzx.zza(j > 0, (Object) "Start time should be positive.");
            this.zzON = timeUnit.toMillis(j);
            return this;
        }

        public Builder zzbL(String str) {
            this.zzYP = zza.zzbI(str);
            return this;
        }

        public Builder zzds(int i) {
            this.zzYC = i;
            return this;
        }
    }

    Session(int i, long j, long j2, String str, String str2, String str3, int i2, zza com_google_android_gms_fitness_data_zza) {
        this.zzFG = i;
        this.zzON = j;
        this.zzYq = j2;
        this.mName = str;
        this.zzZN = str2;
        this.zzZO = str3;
        this.zzYC = i2;
        this.zzYP = com_google_android_gms_fitness_data_zza;
    }

    private Session(Builder builder) {
        this.zzFG = 2;
        this.zzON = builder.zzON;
        this.zzYq = builder.zzYq;
        this.mName = builder.mName;
        this.zzZN = builder.zzZN;
        this.zzZO = builder.zzZO;
        this.zzYC = builder.zzYC;
        this.zzYP = builder.zzYP;
    }

    public static Session extract(Intent intent) {
        return intent == null ? null : (Session) zzc.zza(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String str) {
        return MIME_TYPE_PREFIX + str;
    }

    private boolean zza(Session session) {
        return this.zzON == session.zzON && this.zzYq == session.zzYq && zzw.equal(this.mName, session.mName) && zzw.equal(this.zzZN, session.zzZN) && zzw.equal(this.zzZO, session.zzZO) && zzw.equal(this.zzYP, session.zzYP) && this.zzYC == session.zzYC;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Session) && zza((Session) obj));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzYC);
    }

    public String getAppPackageName() {
        return this.zzYP == null ? null : this.zzYP.getPackageName();
    }

    public String getDescription() {
        return this.zzZO;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzYq, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.zzZN;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzON, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzFG;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzON), Long.valueOf(this.zzYq), this.zzZN);
    }

    public boolean isOngoing() {
        return this.zzYq == 0;
    }

    public String toString() {
        return zzw.zzk(this).zza("startTime", Long.valueOf(this.zzON)).zza("endTime", Long.valueOf(this.zzYq)).zza("name", this.mName).zza("identifier", this.zzZN).zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzZO).zza("activity", Integer.valueOf(this.zzYC)).zza("application", this.zzYP).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }

    public int zzln() {
        return this.zzYC;
    }

    public long zzlp() {
        return this.zzON;
    }

    public long zzlq() {
        return this.zzYq;
    }

    public zza zzlz() {
        return this.zzYP;
    }
}
