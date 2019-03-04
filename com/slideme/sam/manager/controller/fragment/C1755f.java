package com.slideme.sam.manager.controller.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.activities.market.vendor.DeveloperDetailsActivity;

/* compiled from: ApplicationDetailsFragment */
class C1755f implements OnClickListener {
    final /* synthetic */ C1735a f3125a;

    C1755f(C1735a c1735a) {
        this.f3125a = c1735a;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f3125a.getActivity(), DeveloperDetailsActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_DEVELOPER_NAME", this.f3125a.f2989a.app.vendor);
        intent.putExtra("com.slideme.sam.manager.EXTRA_ORGANIZATION_NAME", this.f3125a.f2989a.app.getOrganization());
        intent.putExtra("com.slideme.sam.manager.EXTRA_BUNDLE_ID", this.f3125a.f2989a.app.bundleId);
        this.f3125a.startActivity(intent);
    }
}
