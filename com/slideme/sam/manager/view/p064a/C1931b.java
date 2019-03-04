package com.slideme.sam.manager.view.p064a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0359q;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.web.AdProxyWebViewActivity;
import com.slideme.sam.manager.net.response.AdProxyItem;

/* compiled from: AdsListAdapter */
class C1931b implements OnClickListener {
    final /* synthetic */ C1930a f3537a;
    private final /* synthetic */ AdProxyItem f3538b;

    C1931b(C1930a c1930a, AdProxyItem adProxyItem) {
        this.f3537a = c1930a;
        this.f3538b = adProxyItem;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f3537a.f3535g, AdProxyWebViewActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_DESTINATION_URL", this.f3538b.clickUrl);
        intent.putExtra("com.slideme.sam.manager.EXTRA_SAM_AVAILABLE_AD", !SAM.f2615h.m5512c());
        intent.putExtra("com.slideme.sam.manager.EXTRA_ADSLOT_ID", this.f3537a.f3536h);
        intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_ID", this.f3538b.offerId);
        intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_SHARE", this.f3538b.platform.contains("ios"));
        intent.putExtra("com.slideme.sam.manager.EXTRA_OFFER_PAYOUT", this.f3538b.payout);
        intent.putExtra("com.slideme.sam.manager.EXTRA_NETWORK_ID", this.f3538b.network);
        C0345b.m2427c().m2437a((C0359q) ((C0359q) new C0359q(new StringBuilder(String.valueOf(SAM.f2615h.m5512c() ? "Play" : "SME")).append(" Ofer Click").toString()).m2364a("mAdSlotId", this.f3537a.f3536h)).m2364a("packageName", this.f3538b.packageName));
        this.f3537a.f3535g.startActivity(intent);
    }
}
