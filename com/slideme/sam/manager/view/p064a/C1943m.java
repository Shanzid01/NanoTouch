package com.slideme.sam.manager.view.p064a;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.p053a.C1635z;
import com.slideme.sam.manager.model.data.Review;

/* compiled from: ReviewListAdapter */
class C1943m implements OnClickListener {
    final /* synthetic */ C1942l f3573a;
    private final /* synthetic */ int f3574b;

    C1943m(C1942l c1942l, int i) {
        this.f3573a = c1942l;
        this.f3574b = i;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.slideme.sam.manager.extra.REVIEW", (Review) this.f3573a.getItem(this.f3574b));
        C1635z c1635z = new C1635z();
        c1635z.setArguments(bundle);
        c1635z.show(this.f3573a.f3567a.getSupportFragmentManager(), "review_rate_dialog");
    }
}
