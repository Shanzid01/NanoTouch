package com.slideme.sam.manager.controller.activities.access;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1882o;
import com.slideme.sam.manager.view.C1954b;
import com.slideme.sam.manager.view.touchme.bb;

/* compiled from: RegisterActivity */
class C1639c implements bb {
    final /* synthetic */ RegisterActivity f2764a;

    C1639c(RegisterActivity registerActivity) {
        this.f2764a = registerActivity;
    }

    public boolean mo4244a(CharSequence charSequence) {
        if (C1954b.m5862a(this.f2764a.f2747e.m6053a().toString())) {
            this.f2764a.f2747e.setUnverifiedText(R.string.usernameIndicatorNotOk);
            return SAM.f2614g.m5628a(C1882o.EMAIL, this.f2764a.f2747e.m6053a().toString());
        }
        this.f2764a.f2747e.setUnverifiedText(R.string.usernameIndicatorNotOk);
        return false;
    }
}
