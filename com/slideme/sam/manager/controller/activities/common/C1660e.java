package com.slideme.sam.manager.controller.activities.common;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FlipperFragmentActivity */
class C1660e implements OnClickListener {
    final /* synthetic */ FlipperFragmentActivity f2791a;

    C1660e(FlipperFragmentActivity flipperFragmentActivity) {
        this.f2791a = flipperFragmentActivity;
    }

    public void onClick(View view) {
        this.f2791a.finish();
        this.f2791a.startActivity(this.f2791a.getIntent());
    }
}
