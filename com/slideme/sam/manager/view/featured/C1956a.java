package com.slideme.sam.manager.view.featured;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.slideme.sam.manager.model.data.dynamic.child.LayoutChild;

/* compiled from: DynamicLayoutGridView */
class C1956a implements OnItemClickListener {
    final /* synthetic */ DynamicLayoutGridView f3609a;

    C1956a(DynamicLayoutGridView dynamicLayoutGridView) {
        this.f3609a = dynamicLayoutGridView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((LayoutChild) this.f3609a.f3605b.get(i)).click(this.f3609a.getContext());
    }
}
