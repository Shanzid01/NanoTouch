package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new zzj();
    String description;
    private final int zzFG;
    String zzaCR;
    String zzaCS;
    String zzaDt;
    String zzaDu;
    int zzaDv;

    public final class Builder {
        final /* synthetic */ LineItem zzaDw;

        private Builder(LineItem lineItem) {
            this.zzaDw = lineItem;
        }

        public LineItem build() {
            return this.zzaDw;
        }

        public Builder setCurrencyCode(String str) {
            this.zzaDw.zzaCS = str;
            return this;
        }

        public Builder setDescription(String str) {
            this.zzaDw.description = str;
            return this;
        }

        public Builder setQuantity(String str) {
            this.zzaDw.zzaDt = str;
            return this;
        }

        public Builder setRole(int i) {
            this.zzaDw.zzaDv = i;
            return this;
        }

        public Builder setTotalPrice(String str) {
            this.zzaDw.zzaCR = str;
            return this;
        }

        public Builder setUnitPrice(String str) {
            this.zzaDw.zzaDu = str;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.zzFG = 1;
        this.zzaDv = 0;
    }

    LineItem(int i, String str, String str2, String str3, String str4, int i2, String str5) {
        this.zzFG = i;
        this.description = str;
        this.zzaDt = str2;
        this.zzaDu = str3;
        this.zzaCR = str4;
        this.zzaDv = i2;
        this.zzaCS = str5;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaCS;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzaDt;
    }

    public int getRole() {
        return this.zzaDv;
    }

    public String getTotalPrice() {
        return this.zzaCR;
    }

    public String getUnitPrice() {
        return this.zzaDu;
    }

    public int getVersionCode() {
        return this.zzFG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
