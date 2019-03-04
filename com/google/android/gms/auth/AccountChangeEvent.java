package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent implements SafeParcelable {
    public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();
    final int zzHe;
    final long zzHf;
    final String zzHg;
    final int zzHh;
    final int zzHi;
    final String zzHj;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.zzHe = i;
        this.zzHf = j;
        this.zzHg = (String) zzx.zzl(str);
        this.zzHh = i2;
        this.zzHi = i3;
        this.zzHj = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.zzHe = 1;
        this.zzHf = j;
        this.zzHg = (String) zzx.zzl(str);
        this.zzHh = i;
        this.zzHi = i2;
        this.zzHj = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.zzHe == accountChangeEvent.zzHe && this.zzHf == accountChangeEvent.zzHf && zzw.equal(this.zzHg, accountChangeEvent.zzHg) && this.zzHh == accountChangeEvent.zzHh && this.zzHi == accountChangeEvent.zzHi && zzw.equal(this.zzHj, accountChangeEvent.zzHj);
    }

    public String getAccountName() {
        return this.zzHg;
    }

    public String getChangeData() {
        return this.zzHj;
    }

    public int getChangeType() {
        return this.zzHh;
    }

    public int getEventIndex() {
        return this.zzHi;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzHe), Long.valueOf(this.zzHf), this.zzHg, Integer.valueOf(this.zzHh), Integer.valueOf(this.zzHi), this.zzHj);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzHh) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.zzHg + ", changeType = " + str + ", changeData = " + this.zzHj + ", eventIndex = " + this.zzHi + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        AccountChangeEventCreator.zza(this, parcel, i);
    }
}
