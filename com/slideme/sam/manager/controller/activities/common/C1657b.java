package com.slideme.sam.manager.controller.activities.common;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.slideme.sam.manager.controller.p053a.C1613d;

/* compiled from: AccountAwareActivity */
class C1657b implements C1613d {
    final /* synthetic */ AccountAwareActivity f2787a;
    private final /* synthetic */ AccountManager f2788b;

    C1657b(AccountAwareActivity accountAwareActivity, AccountManager accountManager) {
        this.f2787a = accountAwareActivity;
        this.f2788b = accountManager;
    }

    public void mo4245a(Account account) {
        Account account2 = account;
        this.f2788b.getAuthToken(account2, "com.slideme.user_account", null, this.f2787a, this.f2787a.f2739a, null);
    }
}
