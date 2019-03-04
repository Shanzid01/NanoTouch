package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR = new zzg();
    private final int zzFG;
    String zzaCY;
    String zzaCZ;
    Cart zzaDi;

    public final class Builder {
        final /* synthetic */ FullWalletRequest zzaDj;

        private Builder(FullWalletRequest fullWalletRequest) {
            this.zzaDj = fullWalletRequest;
        }

        public FullWalletRequest build() {
            return this.zzaDj;
        }

        public Builder setCart(Cart cart) {
            this.zzaDj.zzaDi = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String str) {
            this.zzaDj.zzaCY = str;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            this.zzaDj.zzaCZ = str;
            return this;
        }
    }

    FullWalletRequest() {
        this.zzFG = 1;
    }

    FullWalletRequest(int i, String str, String str2, Cart cart) {
        this.zzFG = i;
        this.zzaCY = str;
        this.zzaCZ = str2;
        this.zzaDi = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.zzaDi;
    }

    public String getGoogleTransactionId() {
        return this.zzaCY;
    }

    public String getMerchantTransactionId() {
        return this.zzaCZ;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
