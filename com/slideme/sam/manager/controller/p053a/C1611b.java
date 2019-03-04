package com.slideme.sam.manager.controller.p053a;

import android.accounts.Account;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: AccountSelectionHelper */
class C1611b implements OnClickListener {
    final /* synthetic */ C1610a f2691a;
    private final /* synthetic */ C1612c f2692b;
    private final /* synthetic */ C1613d f2693c;

    C1611b(C1610a c1610a, C1612c c1612c, C1613d c1613d) {
        this.f2691a = c1610a;
        this.f2692b = c1612c;
        this.f2693c = c1613d;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C1922m.m5797b("AccountManager", "onAccountSelected -> " + ((Account) this.f2692b.getItem(i)).name);
        this.f2693c.mo4245a((Account) this.f2692b.getItem(i));
    }
}
