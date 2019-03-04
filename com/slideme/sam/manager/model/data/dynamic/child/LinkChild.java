package com.slideme.sam.manager.model.data.dynamic.child;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.R;

public class LinkChild extends LayoutChild {
    public static final Creator<LinkChild> CREATOR = new C18501();
    @C0670c(a = "URL")
    public String destination;
    @C0670c(a = "Icon")
    public String image;

    class C18501 implements Creator<LinkChild> {
        C18501() {
        }

        public LinkChild createFromParcel(Parcel parcel) {
            return new LinkChild(parcel);
        }

        public LinkChild[] newArray(int i) {
            return new LinkChild[i];
        }
    }

    public void click(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.destination));
        context.startActivity(intent);
    }

    public String getBannerLocation(Context context) {
        return LayoutChild.getScaledPromoUrl(this.image, context, R.integer.ordinal_promo_size);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.image);
        parcel.writeString(this.destination);
    }

    private LinkChild(Parcel parcel) {
        super(parcel);
        this.image = parcel.readString();
        this.destination = parcel.readString();
    }
}
