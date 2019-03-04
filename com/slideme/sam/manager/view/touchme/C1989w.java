package com.slideme.sam.manager.view.touchme;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.controller.p053a.C1632w;
import com.slideme.sam.manager.util.C1920k;

/* compiled from: MyReview */
class C1989w implements OnClickListener {
    final /* synthetic */ MyReview f3852a;

    C1989w(MyReview myReview) {
        this.f3852a = myReview;
    }

    public void onClick(View view) {
        if (this.f3852a.f3716c == null) {
            return;
        }
        if (this.f3852a.f3718e != null) {
            Bundle bundle = new Bundle();
            bundle.putString("com.slideme.sam.manager.EXTRA_BUNDLE_ID", this.f3852a.f3717d.app.bundleId);
            bundle.putParcelable("com.slideme.sam.manager.extra.REVIEW", this.f3852a.f3718e);
            bundle.putFloat("com.slideme.sam.manager.extra.RATING_AVERAGE", this.f3852a.f3717d.getStarRating());
            C1632w c1632w = new C1632w();
            c1632w.setArguments(bundle);
            c1632w.show(this.f3852a.f3716c.getSupportFragmentManager(), "review_dialog");
            return;
        }
        C1920k.m5781a(this.f3852a.f3716c, (int) R.string.please_wait, 0).show();
    }
}
