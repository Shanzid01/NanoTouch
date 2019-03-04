package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new C11321();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzajI;
    private final byte[] zzajJ;
    private final int zzajK;

    final class C11321 implements Creator<RealTimeMessage> {
        C11321() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzdg(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzeX(i);
        }

        public RealTimeMessage zzdg(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] zzeX(int i) {
            return new RealTimeMessage[i];
        }
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String str, byte[] bArr, int i) {
        this.zzajI = (String) zzx.zzl(str);
        this.zzajJ = (byte[]) ((byte[]) zzx.zzl(bArr)).clone();
        this.zzajK = i;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzajJ;
    }

    public String getSenderParticipantId() {
        return this.zzajI;
    }

    public boolean isReliable() {
        return this.zzajK == 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzajI);
        parcel.writeByteArray(this.zzajJ);
        parcel.writeInt(this.zzajK);
    }
}
