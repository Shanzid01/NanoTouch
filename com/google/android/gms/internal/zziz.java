package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class zziz implements SafeParcelable {
    public static final zzja CREATOR = new zzja();
    public final String name;
    public final int weight;
    final int zzFG;
    public final String zzGh;
    public final boolean zzGi;
    public final boolean zzGj;
    public final String zzGk;
    public final zzit[] zzGl;
    final int[] zzGm;
    public final String zzGn;

    public final class zza {
        private final String mName;
        private String zzGo;
        private boolean zzGp;
        private int zzGq = 1;
        private boolean zzGr;
        private String zzGs;
        private final List<zzit> zzGt = new ArrayList();
        private BitSet zzGu;
        private String zzGv;

        public zza(String str) {
            this.mName = str;
        }

        public zza zzI(boolean z) {
            this.zzGp = z;
            return this;
        }

        public zza zzJ(boolean z) {
            this.zzGr = z;
            return this;
        }

        public zza zzW(int i) {
            if (this.zzGu == null) {
                this.zzGu = new BitSet();
            }
            this.zzGu.set(i);
            return this;
        }

        public zza zzaA(String str) {
            this.zzGv = str;
            return this;
        }

        public zza zzaz(String str) {
            this.zzGo = str;
            return this;
        }

        public zziz zzgX() {
            int i = 0;
            int[] iArr = null;
            if (this.zzGu != null) {
                iArr = new int[this.zzGu.cardinality()];
                int nextSetBit = this.zzGu.nextSetBit(0);
                while (nextSetBit >= 0) {
                    int i2 = i + 1;
                    iArr[i] = nextSetBit;
                    nextSetBit = this.zzGu.nextSetBit(nextSetBit + 1);
                    i = i2;
                }
            }
            return new zziz(this.mName, this.zzGo, this.zzGp, this.zzGq, this.zzGr, this.zzGs, (zzit[]) this.zzGt.toArray(new zzit[this.zzGt.size()]), iArr, this.zzGv);
        }
    }

    zziz(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, zzit[] com_google_android_gms_internal_zzitArr, int[] iArr, String str4) {
        this.zzFG = i;
        this.name = str;
        this.zzGh = str2;
        this.zzGi = z;
        this.weight = i2;
        this.zzGj = z2;
        this.zzGk = str3;
        this.zzGl = com_google_android_gms_internal_zzitArr;
        this.zzGm = iArr;
        this.zzGn = str4;
    }

    zziz(String str, String str2, boolean z, int i, boolean z2, String str3, zzit[] com_google_android_gms_internal_zzitArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, com_google_android_gms_internal_zzitArr, iArr, str4);
    }

    public int describeContents() {
        zzja com_google_android_gms_internal_zzja = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zziz)) {
            return false;
        }
        zziz com_google_android_gms_internal_zziz = (zziz) obj;
        return this.name.equals(com_google_android_gms_internal_zziz.name) && this.zzGh.equals(com_google_android_gms_internal_zziz.zzGh) && this.zzGi == com_google_android_gms_internal_zziz.zzGi;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzja com_google_android_gms_internal_zzja = CREATOR;
        zzja.zza(this, parcel, i);
    }
}
