package com.slideme.sam.manager.model.data.dynamic.child;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.content.C0090q;
import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.activities.market.catalog.DynamicLayoutAccountAwareActivity;
import com.slideme.sam.manager.controller.activities.market.catalog.DynamicLayoutActivity;

public class SetChild extends LayoutChild {
    public static final Creator<SetChild> CREATOR = new C18511();
    @C0670c(a = "Data")
    public String data;
    @C0670c(a = "Icon")
    public String image;

    class C18511 implements Creator<SetChild> {
        C18511() {
        }

        public SetChild createFromParcel(Parcel parcel) {
            return new SetChild(parcel);
        }

        public SetChild[] newArray(int i) {
            return new SetChild[i];
        }
    }

    public void click(Context context) {
        if (this.data != null && !this.data.equals("")) {
            Class cls;
            if (this.data.contains("reward") || this.data.contains("shareandearn")) {
                cls = DynamicLayoutAccountAwareActivity.class;
            } else {
                cls = DynamicLayoutActivity.class;
            }
            if (this.data.contains("shareandearn")) {
                C0090q.m145a(context).m150a(new Intent("com.slideme.sam.manager.ACTION_HIDE_SHOWCASE"));
            }
            Intent intent = new Intent(context, cls);
            intent.putExtra("com.slideme.sam.manager.EXTRA_DYNAMIC_LAYOUT_SOURCE", this.data);
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
    }

    private SetChild(Parcel parcel) {
        super(parcel);
        this.image = parcel.readString();
        this.data = parcel.readString();
    }
}
