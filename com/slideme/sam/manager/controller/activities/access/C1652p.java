package com.slideme.sam.manager.controller.activities.access;

import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1882o;
import com.slideme.sam.manager.view.C1954b;
import com.slideme.sam.manager.view.touchme.bb;

/* compiled from: SimpleRegisterActivity */
class C1652p implements bb {
    public int f2780a;
    final /* synthetic */ SimpleRegisterActivity f2781b;

    private C1652p(SimpleRegisterActivity simpleRegisterActivity) {
        this.f2781b = simpleRegisterActivity;
        this.f2780a = -1;
    }

    public boolean mo4244a(CharSequence charSequence) {
        if (C1954b.m5862a(this.f2781b.f2757f.m6053a().toString())) {
            this.f2780a = -1;
            return SAM.f2614g.m5628a(C1882o.EMAIL, this.f2781b.f2757f.m6053a().toString());
        }
        this.f2780a = 0;
        return false;
    }
}
