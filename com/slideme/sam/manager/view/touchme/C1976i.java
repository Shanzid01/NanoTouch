package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.R;

/* compiled from: ExpandableTextContainer */
class C1976i implements OnClickListener {
    final /* synthetic */ ExpandableTextContainer f3830a;

    C1976i(ExpandableTextContainer expandableTextContainer) {
        this.f3830a = expandableTextContainer;
    }

    public void onClick(View view) {
        this.f3830a.f3670a.m5948c();
        this.f3830a.f3671b.setText(this.f3830a.f3670a.m5949d() ? R.string.expandable_less : R.string.expandable_more);
    }
}
