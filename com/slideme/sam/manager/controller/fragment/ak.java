package com.slideme.sam.manager.controller.fragment;

import android.view.View;
import com.github.amlcurran.showcaseview.C0666y;
import com.github.amlcurran.showcaseview.p042a.C0641c;
import com.slideme.sam.manager.R;

/* compiled from: DynamicLayoutFragment */
class ak implements Runnable {
    final /* synthetic */ aj f3045a;

    ak(aj ajVar) {
        this.f3045a = ajVar;
    }

    public void run() {
        if (this.f3045a.f3044a.f3032f.contains("/template/home") && this.f3045a.f3044a.getActivity() != null) {
            View findViewById = this.f3045a.f3044a.getActivity().findViewById(R.id.showcase_item);
            if (findViewById != null) {
                this.f3045a.f3044a.f3027a = new C0666y(this.f3045a.f3044a.getActivity(), true).m3249a(new C0641c(findViewById)).m3247a((int) R.string.changelog).m3251b(this.f3045a.f3044a.getResources().getString(R.string.sharearn_prompt)).m3248a(42).m3246a();
            }
        }
    }
}
