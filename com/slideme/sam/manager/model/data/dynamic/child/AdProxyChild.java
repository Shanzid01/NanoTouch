package com.slideme.sam.manager.model.data.dynamic.child;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.controller.activities.web.AdProxyWebViewActivity;
import com.slideme.sam.manager.model.p054b.C1827a;
import com.slideme.sam.manager.model.p054b.C1828b;

public class AdProxyChild extends LayoutChild {
    public static final Creator<AdProxyChild> CREATOR = new C18481();
    public String adslotId;
    public String clickUrl;
    public String id;
    public String limit;
    public String network;
    public String offerId;
    public String packageName;
    public double payout;
    public String platform;
    public String promoUrl;
    public boolean samAvailable;
    public String source;
    @C0670c(a = "Title")
    public String title;
    public String uid;
    public int versionCode;

    class C18481 implements Creator<AdProxyChild> {
        C18481() {
        }

        public AdProxyChild createFromParcel(Parcel parcel) {
            return new AdProxyChild(parcel);
        }

        public AdProxyChild[] newArray(int i) {
            return new AdProxyChild[i];
        }
    }

    public void click(Context context) {
        boolean z = true;
        if (C1827a.m5491a(context, this.packageName, this.versionCode) != C1828b.UP_TO_DATE || TextUtils.isEmpty(this.uid)) {
            if (SAM.f2615h.m5512c() && isReward()) {
                z = false;
            }
            this.samAvailable = z;
            Intent intent = new Intent(context, AdProxyWebViewActivity.class);
            intent.putExtra("com.slideme.sam.manager.EXTRA_DESTINATION_URL", this.clickUrl);
            intent.putExtra("com.slideme.sam.manager.EXTRA_SAM_AVAILABLE_AD", this.samAvailable);
            intent.putExtra("com.slideme.sam.manager.EXTRA_ADSLOT_ID", this.adslotId);
            intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_ID", this.offerId);
            intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_SHARE", this.platform.contains("ios"));
            intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT", this.payout);
            intent.putExtra("com.slideme.sam.manager.EXTRA_NETWORK_ID", this.network);
            intent.putExtra("com.slideme.sam.manager.EXTRA_PACKAGE_NAME", this.packageName);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, ApplicationDetailsActivity.class);
        intent2.putExtra("com.slideme.sam.manager.EXTRA_BUNDLE_ID", this.uid);
        intent2.putExtra("com.slideme.sam.manager.EXTRA_APP_PRIVATE", true);
        intent2.putExtra("com.slideme.sam.manager.EXTRA_OFFER_ID", this.offerId);
        intent2.putExtra("com.slideme.sam.manager.EXTRA_OFFER_SHARE", this.platform.contains("ios"));
        intent2.putExtra("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT", this.payout);
        context.startActivity(intent2);
    }

    public String getBannerLocation(Context context) {
        return LayoutChild.getScaledPromoUrl(this.promoUrl, context, R.integer.ordinal_promo_size);
    }

    public AdProxyChild(Parcel parcel) {
        super(parcel);
        this.promoUrl = parcel.readString();
        this.clickUrl = parcel.readString();
        this.samAvailable = parcel.readByte() != (byte) 0;
        this.adslotId = parcel.readString();
        this.payout = parcel.readDouble();
        this.offerId = parcel.readString();
        this.platform = parcel.readString();
        this.network = parcel.readString();
        this.title = parcel.readString();
    }

    public boolean isReward() {
        return (!TextUtils.isEmpty(this.adslotId) && this.adslotId.contains("reward")) || (!TextUtils.isEmpty(this.id) && this.id.contains("reward"));
    }

    public boolean isShare() {
        return (!TextUtils.isEmpty(this.adslotId) && this.adslotId.contains("shareandearn")) || ((!TextUtils.isEmpty(this.id) && this.id.contains("shareandearn")) || (!TextUtils.isEmpty(this.title) && this.title.contains("shareandearn")));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.promoUrl);
        parcel.writeString(this.clickUrl);
        parcel.writeByte((byte) (this.samAvailable ? 1 : 0));
        parcel.writeString(this.adslotId);
        parcel.writeDouble(this.payout);
        parcel.writeString(this.offerId);
        parcel.writeString(this.platform);
        parcel.writeString(this.network);
        parcel.writeString(this.title);
    }
}
