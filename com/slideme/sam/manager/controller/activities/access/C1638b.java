package com.slideme.sam.manager.controller.activities.access;

import com.slideme.sam.manager.view.touchme.ba;
import com.slideme.sam.manager.view.touchme.bc;

/* compiled from: RegisterActivity */
class C1638b implements ba {
    final /* synthetic */ RegisterActivity f2763a;

    C1638b(RegisterActivity registerActivity) {
        this.f2763a = registerActivity;
    }

    public void mo4243a(bc bcVar) {
        boolean z = false;
        if (bcVar != bc.VERIFIED) {
            this.f2763a.f2746a.setEnabled(false);
            return;
        }
        if ((this.f2763a.f2747e.m6058b() && this.f2763a.f2749g.m6058b() && this.f2763a.f2750h.m6058b() && this.f2763a.f2748f.m6058b() && this.f2763a.f2751i.m6058b()) || ((this.f2763a instanceof UpgradeProfileActivity) && this.f2763a.f2748f.m6058b() && this.f2763a.f2751i.m6058b())) {
            z = true;
        }
        this.f2763a.f2746a.setEnabled(z);
    }
}
