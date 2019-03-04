package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR = new zzf();
    private final int zzFG;
    String zzaCY;
    String zzaCZ;
    ProxyCard zzaDa;
    String zzaDb;
    Address zzaDc;
    Address zzaDd;
    String[] zzaDe;
    UserAddress zzaDf;
    UserAddress zzaDg;
    InstrumentInfo[] zzaDh;

    private FullWallet() {
        this.zzFG = 1;
    }

    FullWallet(int i, String str, String str2, ProxyCard proxyCard, String str3, Address address, Address address2, String[] strArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.zzFG = i;
        this.zzaCY = str;
        this.zzaCZ = str2;
        this.zzaDa = proxyCard;
        this.zzaDb = str3;
        this.zzaDc = address;
        this.zzaDd = address2;
        this.zzaDe = strArr;
        this.zzaDf = userAddress;
        this.zzaDg = userAddress2;
        this.zzaDh = instrumentInfoArr;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzaDc;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzaDf;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzaDg;
    }

    public String getEmail() {
        return this.zzaDb;
    }

    public String getGoogleTransactionId() {
        return this.zzaCY;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzaDh;
    }

    public String getMerchantTransactionId() {
        return this.zzaCZ;
    }

    public String[] getPaymentDescriptions() {
        return this.zzaDe;
    }

    public ProxyCard getProxyCard() {
        return this.zzaDa;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzaDd;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
