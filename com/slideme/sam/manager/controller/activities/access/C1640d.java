package com.slideme.sam.manager.controller.activities.access;

import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1882o;
import com.slideme.sam.manager.view.C1954b;
import com.slideme.sam.manager.view.touchme.bb;

/* compiled from: RegisterActivity */
class C1640d implements bb {
    final /* synthetic */ RegisterActivity f2765a;

    C1640d(RegisterActivity registerActivity) {
        this.f2765a = registerActivity;
    }

    public boolean mo4244a(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            this.f2765a.f2748f.setUnverifiedText(R.string.generic_empty);
            return false;
        } else if (C1954b.m5862a(this.f2765a.f2748f.m6053a().toString())) {
            this.f2765a.f2748f.setUnverifiedText(R.string.username_is_email);
            return false;
        } else {
            this.f2765a.f2748f.setUnverifiedText(R.string.username_exists);
            return SAM.f2614g.m5628a(C1882o.USERNAME, this.f2765a.f2748f.m6053a().toString());
        }
    }
}
