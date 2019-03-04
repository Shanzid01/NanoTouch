package com.slideme.sam.manager.controller.fragment.p056a;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.p053a.ah;
import com.slideme.sam.manager.net.C1881n;

/* compiled from: DeveloperDetailsFragment */
class C1727r implements OnClickListener {
    final /* synthetic */ C1726q f2973a;

    C1727r(C1726q c1726q) {
        this.f2973a = c1726q;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.slideme.sam.manager.extra.SUPPORT_RECEPIENT", C1881n.DEVELOPER.ordinal());
        bundle.putString("com.slideme.sam.manager.EXTRA_BUNDLE_ID", this.f2973a.getArguments().getString("com.slideme.sam.manager.EXTRA_BUNDLE_ID"));
        ah ahVar = new ah();
        ahVar.setArguments(bundle);
        ahVar.show(this.f2973a.getActivity().getSupportFragmentManager(), "support_app");
    }
}
