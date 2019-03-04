package com.slideme.sam.manager.model.data.dynamic.child;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.market.catalog.ActivityDynamicLayoutItemActivity;

public class ActivityChild extends LayoutChild {
    public static final Creator<ActivityChild> CREATOR = new C18471();
    @C0670c(a = "Data")
    public String data;
    @C0670c(a = "Icon")
    public String image;
    @C0670c(a = "Title")
    public String title;

    class C18471 implements Creator<ActivityChild> {
        C18471() {
        }

        public ActivityChild createFromParcel(Parcel parcel) {
            return new ActivityChild(parcel);
        }

        public ActivityChild[] newArray(int i) {
            return new ActivityChild[i];
        }
    }

    public void click(Context context) {
        if (this.data != null && !this.data.equals("")) {
            Intent intent = new Intent(context, ActivityDynamicLayoutItemActivity.class);
            intent.putExtra("com.slideme.sam.manager.EXTRA_TITLE", this.title);
            intent.putExtra("com.slideme.sam.manager.EXTRA_ACTIVITY_TYPE", this.data);
            context.startActivity(intent);
        }
    }

    public String getBannerLocation(Context context) {
        return LayoutChild.getScaledPromoUrl(this.image, context, R.integer.ordinal_promo_size);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.image);
        parcel.writeString(this.data);
        parcel.writeString(this.title);
    }

    private ActivityChild(Parcel parcel) {
        super(parcel);
        this.image = parcel.readString();
        this.data = parcel.readString();
        this.title = parcel.readString();
    }
}
