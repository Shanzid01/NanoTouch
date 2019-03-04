package com.slideme.sam.manager.model.data.dynamic.child;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.google.p043a.p044a.C0670c;
import com.p026b.p027a.p034b.C0509f;
import com.p026b.p027a.p034b.C0510g;
import com.p026b.p027a.p034b.p035a.C0477e;
import com.p026b.p027a.p034b.p035a.C0483k;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Application.ImageSize;
import com.slideme.sam.manager.util.C1922m;

public abstract class LayoutChild implements Parcelable {
    @C0670c(a = "Weight")
    public int weightIndex;

    public abstract void click(Context context);

    public abstract String getBannerLocation(Context context);

    public LayoutChild(Parcel parcel) {
    }

    public void setBanner(Activity activity, ImageView imageView, C0483k c0483k) {
        try {
            C0510g.m3081a().m3084a(getBannerLocation(activity), imageView, new C0509f().m3079b().m3074a().m3077a(C0477e.EXACTLY).m3075a((int) R.drawable.ic_loading_banner).m3080c(), c0483k);
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
    }

    static String getScaledPromoUrl(String str, Context context, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("files", "files/imagecache/promo-" + ImageSize.values()[context.getResources().getInteger(i)]);
    }
}
