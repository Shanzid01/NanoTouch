package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.data.Application;

/* compiled from: ApplicationListView */
class C1969b implements OnClickListener {
    final /* synthetic */ ApplicationListView f3821a;
    private final /* synthetic */ int f3822b;

    C1969b(ApplicationListView applicationListView, int i) {
        this.f3821a = applicationListView;
        this.f3822b = i;
    }

    public void onClick(View view) {
        C1698a.m5055a(this.f3821a.f3651f, (Application) this.f3821a.f3647b.getItem(this.f3822b));
    }
}
