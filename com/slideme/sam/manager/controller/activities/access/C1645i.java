package com.slideme.sam.manager.controller.activities.access;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.p053a.aj;

/* compiled from: RegisterActivity */
class C1645i implements OnClickListener {
    final /* synthetic */ RegisterActivity f2770a;

    C1645i(RegisterActivity registerActivity) {
        this.f2770a = registerActivity;
    }

    public void onClick(View view) {
        new aj().show(this.f2770a.getSupportFragmentManager(), "terms_and_conditions_dialog");
    }
}
