package com.slideme.sam.manager.controller.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0359q;

/* compiled from: ApplicationDetailsFragment */
class C1773w implements OnClickListener {
    final /* synthetic */ C1772v f3160a;
    private final /* synthetic */ String f3161b;

    C1773w(C1772v c1772v, String str) {
        this.f3160a = c1772v;
        this.f3161b = str;
    }

    public void onClick(View view) {
        C0345b.m2427c().m2437a((C0359q) new C0359q("Selected share notification").m2364a("app", this.f3160a.f3158a.f3156a.f2989a.app.getName()));
        this.f3160a.f3158a.f3156a.m5172a(this.f3161b);
    }
}
