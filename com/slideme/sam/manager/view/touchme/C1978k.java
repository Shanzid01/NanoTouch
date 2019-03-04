package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.R;

/* compiled from: ExpandableTitledContainer */
class C1978k implements OnClickListener {
    final /* synthetic */ ExpandableTitledContainer f3833a;

    C1978k(ExpandableTitledContainer expandableTitledContainer) {
        this.f3833a = expandableTitledContainer;
    }

    public void onClick(View view) {
        if (this.f3833a.f3683g) {
            this.f3833a.m5954b();
        } else {
            this.f3833a.m5951a();
        }
        this.f3833a.f3681e.setImageResource(this.f3833a.f3683g ? R.drawable.ic_expander_indicator_close : R.drawable.ic_expander_indicator_open);
    }
}
