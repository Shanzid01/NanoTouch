package com.slideme.sam.manager;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;

/* compiled from: SAM */
class C1809k implements OnAccountsUpdateListener {
    final /* synthetic */ SAM f3241a;

    C1809k(SAM sam) {
        this.f3241a = sam;
    }

    public void onAccountsUpdated(Account[] accountArr) {
        Account b = SAM.f2622o.m4850b();
        if (b != null) {
            int i = 0;
            for (Account equals : accountArr) {
                i |= equals.equals(b);
            }
            if (i == 0) {
                this.f3241a.m4777a(false);
            }
        }
    }
}
