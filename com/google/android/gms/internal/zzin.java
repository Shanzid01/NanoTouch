package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class zzin implements SafeParcelable {
    public static final zzio CREATOR = new zzio();
    public final Account account;
    final int zzFG;
    final zzir[] zzFH;
    public final String zzFI;
    public final boolean zzFJ;

    public class zza {
        private List<zzir> zzFK;
        private String zzFL;
        private boolean zzFM;
        private Account zzFN;

        public zza zzH(boolean z) {
            this.zzFM = z;
            return this;
        }

        public zza zza(Account account) {
            this.zzFN = account;
            return this;
        }

        public zza zza(zzir com_google_android_gms_internal_zzir) {
            if (this.zzFK == null) {
                this.zzFK = new ArrayList();
            }
            this.zzFK.add(com_google_android_gms_internal_zzir);
            return this;
        }

        public zza zzax(String str) {
            this.zzFL = str;
            return this;
        }

        public zzin zzgU() {
            return new zzin(this.zzFL, this.zzFM, this.zzFN, this.zzFK != null ? (zzir[]) this.zzFK.toArray(new zzir[this.zzFK.size()]) : null);
        }
    }

    zzin(int i, zzir[] com_google_android_gms_internal_zzirArr, String str, boolean z, Account account) {
        this.zzFG = i;
        this.zzFH = com_google_android_gms_internal_zzirArr;
        this.zzFI = str;
        this.zzFJ = z;
        this.account = account;
    }

    zzin(String str, boolean z, Account account, zzir... com_google_android_gms_internal_zzirArr) {
        this(1, com_google_android_gms_internal_zzirArr, str, z, account);
        BitSet bitSet = new BitSet(zziy.zzgW());
        for (zzir com_google_android_gms_internal_zzir : com_google_android_gms_internal_zzirArr) {
            int i = com_google_android_gms_internal_zzir.zzFV;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + zziy.zzV(i));
                }
                bitSet.set(i);
            }
        }
    }

    public int describeContents() {
        zzio com_google_android_gms_internal_zzio = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzio com_google_android_gms_internal_zzio = CREATOR;
        zzio.zza(this, parcel, i);
    }
}
