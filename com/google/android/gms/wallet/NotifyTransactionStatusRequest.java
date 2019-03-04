package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Creator<NotifyTransactionStatusRequest> CREATOR = new zzn();
    int status;
    final int zzFG;
    String zzaCY;
    String zzaEf;

    public final class Builder {
        final /* synthetic */ NotifyTransactionStatusRequest zzaEg;

        private Builder(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.zzaEg = notifyTransactionStatusRequest;
        }

        public NotifyTransactionStatusRequest build() {
            boolean z = true;
            zzx.zzb(!TextUtils.isEmpty(this.zzaEg.zzaCY), (Object) "googleTransactionId is required");
            if (this.zzaEg.status < 1 || this.zzaEg.status > 8) {
                z = false;
            }
            zzx.zzb(z, (Object) "status is an unrecognized value");
            return this.zzaEg;
        }

        public Builder setDetailedReason(String str) {
            this.zzaEg.zzaEf = str;
            return this;
        }

        public Builder setGoogleTransactionId(String str) {
            this.zzaEg.zzaCY = str;
            return this;
        }

        public Builder setStatus(int i) {
            this.zzaEg.status = i;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    NotifyTransactionStatusRequest() {
        this.zzFG = 1;
    }

    NotifyTransactionStatusRequest(int i, String str, int i2, String str2) {
        this.zzFG = i;
        this.zzaCY = str;
        this.status = i2;
        this.zzaEf = str2;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getDetailedReason() {
        return this.zzaEf;
    }

    public String getGoogleTransactionId() {
        return this.zzaCY;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
