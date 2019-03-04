package com.slideme.sam.manager.controller.fragment;

import android.util.TypedValue;
import android.view.View;
import com.slideme.sam.manager.view.touchme.C1762l;
import com.slideme.sam.manager.view.touchme.ExpandableTitledContainer;

/* compiled from: ApplicationDetailsFragment */
class C1763m implements C1762l {
    final /* synthetic */ C1735a f3138a;
    private final /* synthetic */ ExpandableTitledContainer f3139b;
    private final /* synthetic */ View f3140c;

    C1763m(C1735a c1735a, ExpandableTitledContainer expandableTitledContainer, View view) {
        this.f3138a = c1735a;
        this.f3139b = expandableTitledContainer;
        this.f3140c = view;
    }

    public void mo4270a() {
        this.f3139b.post(new C1764n(this, (int) TypedValue.applyDimension(1, 55.0f, this.f3138a.getResources().getDisplayMetrics()), this.f3140c));
    }
}
