package com.slideme.sam.manager.net.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.p043a.p044a.C0670c;
import java.util.List;

public class InAppPurchasesListResponse extends BaseNetworkResponse implements Parcelable {
    private static final Creator<InAppPurchasesListResponse> CREATOR = new C18871();
    @C0670c(a = "item_data")
    public List<String> itemData;
    @C0670c(a = "product_ids")
    public List<String> productIds;
    public List<String> signatures;
    public int status;

    class C18871 implements Creator<InAppPurchasesListResponse> {
        C18871() {
        }

        public InAppPurchasesListResponse[] newArray(int i) {
            return new InAppPurchasesListResponse[i];
        }

        public InAppPurchasesListResponse createFromParcel(Parcel parcel) {
            return new InAppPurchasesListResponse(parcel);
        }
    }

    private InAppPurchasesListResponse(Parcel parcel) {
        parcel.readStringList(this.itemData);
        parcel.readStringList(this.signatures);
        parcel.readStringList(this.productIds);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.itemData);
        parcel.writeList(this.signatures);
        parcel.writeList(this.productIds);
    }

    public int describeContents() {
        return 0;
    }
}
