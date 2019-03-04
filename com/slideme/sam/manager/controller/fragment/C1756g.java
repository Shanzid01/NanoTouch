package com.slideme.sam.manager.controller.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.activities.market.product.ReviewListActivity;

/* compiled from: ApplicationDetailsFragment */
class C1756g implements OnClickListener {
    final /* synthetic */ C1735a f3126a;

    C1756g(C1735a c1735a) {
        this.f3126a = c1735a;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f3126a.getActivity(), ReviewListActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_APPHOLDER", this.f3126a.f2989a);
        this.f3126a.startActivity(intent);
    }
}
