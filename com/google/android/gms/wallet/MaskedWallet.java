package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR = new zzl();
    private final int zzFG;
    String zzaCY;
    String zzaCZ;
    LoyaltyWalletObject[] zzaDQ;
    OfferWalletObject[] zzaDR;
    String zzaDb;
    Address zzaDc;
    Address zzaDd;
    String[] zzaDe;
    UserAddress zzaDf;
    UserAddress zzaDg;
    InstrumentInfo[] zzaDh;

    public final class Builder {
        final /* synthetic */ MaskedWallet zzaDS;

        private Builder(MaskedWallet maskedWallet) {
            this.zzaDS = maskedWallet;
        }

        public MaskedWallet build() {
            return this.zzaDS;
        }

        public Builder setBillingAddress(Address address) {
            this.zzaDS.zzaDc = address;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress userAddress) {
            this.zzaDS.zzaDf = userAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress userAddress) {
            this.zzaDS.zzaDg = userAddress;
            return this;
        }

        public Builder setEmail(String str) {
            this.zzaDS.zzaDb = str;
            return this;
        }

        public Builder setGoogleTransactionId(String str) {
            this.zzaDS.zzaCY = str;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfoArr) {
            this.zzaDS.zzaDh = instrumentInfoArr;
            return this;
        }

        public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] loyaltyWalletObjectArr) {
            this.zzaDS.zzaDQ = loyaltyWalletObjectArr;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            this.zzaDS.zzaCZ = str;
            return this;
        }

        public Builder setOfferWalletObjects(OfferWalletObject[] offerWalletObjectArr) {
            this.zzaDS.zzaDR = offerWalletObjectArr;
            return this;
        }

        public Builder setPaymentDescriptions(String[] strArr) {
            this.zzaDS.zzaDe = strArr;
            return this;
        }

        public Builder setShippingAddress(Address address) {
            this.zzaDS.zzaDd = address;
            return this;
        }
    }

    private MaskedWallet() {
        this.zzFG = 2;
    }

    MaskedWallet(int i, String str, String str2, String[] strArr, String str3, Address address, Address address2, LoyaltyWalletObject[] loyaltyWalletObjectArr, OfferWalletObject[] offerWalletObjectArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.zzFG = i;
        this.zzaCY = str;
        this.zzaCZ = str2;
        this.zzaDe = strArr;
        this.zzaDb = str3;
        this.zzaDc = address;
        this.zzaDd = address2;
        this.zzaDQ = loyaltyWalletObjectArr;
        this.zzaDR = offerWalletObjectArr;
        this.zzaDf = userAddress;
        this.zzaDg = userAddress2;
        this.zzaDh = instrumentInfoArr;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzx.zzl(maskedWallet);
        return zzuR().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).setLoyaltyWalletObjects(maskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(maskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzuR() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
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

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.zzaDQ;
    }

    public String getMerchantTransactionId() {
        return this.zzaCZ;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.zzaDR;
    }

    public String[] getPaymentDescriptions() {
        return this.zzaDe;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzaDd;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
