package com.slideme.sam.manager.controller.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0359q;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;

/* compiled from: ApplicationDetailsFragment */
class C1770t implements OnClickListener {
    final /* synthetic */ C1767q f3153a;
    private final /* synthetic */ CheckBox f3154b;
    private final /* synthetic */ Dialog f3155c;

    C1770t(C1767q c1767q, CheckBox checkBox, Dialog dialog) {
        this.f3153a = c1767q;
        this.f3154b = checkBox;
        this.f3155c = dialog;
    }

    public void onClick(View view) {
        if (this.f3154b.isChecked()) {
            C0345b.m2427c().m2437a((C0359q) ((C0359q) ((C0359q) new C0359q("FBShare Cancel Pressed with Don't show").m2364a("app", this.f3153a.f3146a.f2989a.app.getName())).m2364a("country", this.f3153a.f3146a.f2984H)).m2364a("channel", this.f3153a.f3146a.getString(R.string.live_channel)));
            SAM.f2613f.m5441a(this.f3153a.f3146a.f2989a.app.packageName, false);
        } else {
            C0345b.m2427c().m2437a((C0359q) ((C0359q) ((C0359q) new C0359q("FBShare Cancel Pressed").m2364a("app", this.f3153a.f3146a.f2989a.app.getName())).m2364a("country", this.f3153a.f3146a.f2984H)).m2364a("channel", this.f3153a.f3146a.getString(R.string.live_channel)));
        }
        this.f3155c.hide();
    }
}
