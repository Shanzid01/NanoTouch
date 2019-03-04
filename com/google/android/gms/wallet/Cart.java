package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new zzb();
    private final int zzFG;
    String zzaCR;
    String zzaCS;
    ArrayList<LineItem> zzaCT;

    public final class Builder {
        final /* synthetic */ Cart zzaCU;

        private Builder(Cart cart) {
            this.zzaCU = cart;
        }

        public Builder addLineItem(LineItem lineItem) {
            this.zzaCU.zzaCT.add(lineItem);
            return this;
        }

        public Cart build() {
            return this.zzaCU;
        }

        public Builder setCurrencyCode(String str) {
            this.zzaCU.zzaCS = str;
            return this;
        }

        public Builder setLineItems(List<LineItem> list) {
            this.zzaCU.zzaCT.clear();
            this.zzaCU.zzaCT.addAll(list);
            return this;
        }

        public Builder setTotalPrice(String str) {
            this.zzaCU.zzaCR = str;
            return this;
        }
    }

    Cart() {
        this.zzFG = 1;
        this.zzaCT = new ArrayList();
    }

    Cart(int i, String str, String str2, ArrayList<LineItem> arrayList) {
        this.zzFG = i;
        this.zzaCR = str;
        this.zzaCS = str2;
        this.zzaCT = arrayList;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaCS;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzaCT;
    }

    public String getTotalPrice() {
        return this.zzaCR;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
