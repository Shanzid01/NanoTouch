package com.slideme.sam.manager.model.data.dynamic.child;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;

public class AppChild extends LayoutChild {
    public static final Creator<AppChild> CREATOR = new C18491();
    @C0670c(a = "BundleID")
    public String bundleId;
    @C0670c(a = "Category")
    public String category;
    @C0670c(a = "Developer")
    public String developer;
    @C0670c(a = "Icon")
    public String icon;
    @C0670c(a = "Package")
    public String packageName;
    @C0670c(a = "Price")
    public float price;
    @C0670c(a = "PromoIcon")
    public String promoUrl;
    @C0670c(a = "Rating")
    public int rating;
    @C0670c(a = "Title")
    public String title;
    @C0670c(a = "TopApp")
    public boolean topApp;

    class C18491 implements Creator<AppChild> {
        C18491() {
        }

        public AppChild createFromParcel(Parcel parcel) {
            return new AppChild(parcel);
        }

        public AppChild[] newArray(int i) {
            return new AppChild[i];
        }
    }

    public void click(Context context) {
        Intent intent = new Intent(context, ApplicationDetailsActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_BUNDLE_ID", this.bundleId);
        context.startActivity(intent);
    }

    public String getBannerLocation(Context context) {
        return LayoutChild.getScaledPromoUrl(this.promoUrl, context, R.integer.ordinal_promo_size);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bundleId);
        parcel.writeString(this.category);
        parcel.writeString(this.developer);
        parcel.writeString(this.icon);
        parcel.writeString(this.packageName);
        parcel.writeString(this.promoUrl);
        parcel.writeString(this.title);
        parcel.writeInt(this.rating);
        parcel.writeInt(this.topApp ? 1 : 0);
        parcel.writeFloat(this.price);
    }

    private AppChild(Parcel parcel) {
        boolean z = true;
        super(parcel);
        this.bundleId = parcel.readString();
        this.category = parcel.readString();
        this.developer = parcel.readString();
        this.icon = parcel.readString();
        this.packageName = parcel.readString();
        this.promoUrl = parcel.readString();
        this.title = parcel.readString();
        this.rating = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.topApp = z;
        this.price = parcel.readFloat();
    }
}
