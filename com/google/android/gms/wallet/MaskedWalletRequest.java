package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new zzm();
    private final int zzFG;
    String zzaCS;
    String zzaCZ;
    boolean zzaDT;
    boolean zzaDU;
    boolean zzaDV;
    String zzaDW;
    String zzaDX;
    boolean zzaDY;
    boolean zzaDZ;
    Cart zzaDi;
    CountrySpecification[] zzaEa;
    boolean zzaEb;
    boolean zzaEc;
    ArrayList<CountrySpecification> zzaEd;

    public final class Builder {
        final /* synthetic */ MaskedWalletRequest zzaEe;

        private Builder(MaskedWalletRequest maskedWalletRequest) {
            this.zzaEe = maskedWalletRequest;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (this.zzaEe.zzaEd == null) {
                this.zzaEe.zzaEd = new ArrayList();
            }
            this.zzaEe.zzaEd.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> collection) {
            if (collection != null) {
                if (this.zzaEe.zzaEd == null) {
                    this.zzaEe.zzaEd = new ArrayList();
                }
                this.zzaEe.zzaEd.addAll(collection);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return this.zzaEe;
        }

        public Builder setAllowDebitCard(boolean z) {
            this.zzaEe.zzaEc = z;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean z) {
            this.zzaEe.zzaEb = z;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.zzaEe.zzaDi = cart;
            return this;
        }

        public Builder setCurrencyCode(String str) {
            this.zzaEe.zzaCS = str;
            return this;
        }

        public Builder setEstimatedTotalPrice(String str) {
            this.zzaEe.zzaDW = str;
            return this;
        }

        public Builder setIsBillingAgreement(boolean z) {
            this.zzaEe.zzaDZ = z;
            return this;
        }

        public Builder setMerchantName(String str) {
            this.zzaEe.zzaDX = str;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            this.zzaEe.zzaCZ = str;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean z) {
            this.zzaEe.zzaDT = z;
            return this;
        }

        public Builder setShippingAddressRequired(boolean z) {
            this.zzaEe.zzaDU = z;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean z) {
            this.zzaEe.zzaDY = z;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean z) {
            this.zzaEe.zzaDV = z;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.zzFG = 3;
        this.zzaEb = true;
        this.zzaEc = true;
    }

    MaskedWalletRequest(int i, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, Cart cart, boolean z4, boolean z5, CountrySpecification[] countrySpecificationArr, boolean z6, boolean z7, ArrayList<CountrySpecification> arrayList) {
        this.zzFG = i;
        this.zzaCZ = str;
        this.zzaDT = z;
        this.zzaDU = z2;
        this.zzaDV = z3;
        this.zzaDW = str2;
        this.zzaCS = str3;
        this.zzaDX = str4;
        this.zzaDi = cart;
        this.zzaDY = z4;
        this.zzaDZ = z5;
        this.zzaEa = countrySpecificationArr;
        this.zzaEb = z6;
        this.zzaEc = z7;
        this.zzaEd = arrayList;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzaEc;
    }

    public boolean allowPrepaidCard() {
        return this.zzaEb;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzaEd;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzaEa;
    }

    public Cart getCart() {
        return this.zzaDi;
    }

    public String getCurrencyCode() {
        return this.zzaCS;
    }

    public String getEstimatedTotalPrice() {
        return this.zzaDW;
    }

    public String getMerchantName() {
        return this.zzaDX;
    }

    public String getMerchantTransactionId() {
        return this.zzaCZ;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public boolean isBillingAgreement() {
        return this.zzaDZ;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzaDT;
    }

    public boolean isShippingAddressRequired() {
        return this.zzaDU;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.zzaDY;
    }

    public boolean useMinimalBillingAddress() {
        return this.zzaDV;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
