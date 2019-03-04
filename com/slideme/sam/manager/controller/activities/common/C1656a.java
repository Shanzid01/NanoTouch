package com.slideme.sam.manager.controller.activities.common;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import android.text.TextUtils;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: AccountAwareActivity */
class C1656a implements AccountManagerCallback<Bundle> {
    final /* synthetic */ AccountAwareActivity f2786a;

    C1656a(AccountAwareActivity accountAwareActivity) {
        this.f2786a = accountAwareActivity;
    }

    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        try {
            Bundle bundle = (Bundle) accountManagerFuture.getResult();
            String string = bundle.getString("authtoken");
            Account account = new Account(bundle.getString("authAccount"), bundle.getString("accountType"));
            if (TextUtils.isEmpty(string)) {
                C1922m.m5797b("AccountManager", "AccountManagerCallback authToken: not found, calling getAuthToken()");
                AccountManager.get(this.f2786a).getAuthToken(account, "Normal user", null, this.f2786a, this, null);
                return;
            }
            C1922m.m5797b("AccountManager", "AccountManagerCallback authToken: " + string);
            SAM.f2622o.m4848a(account.name);
            ((SAM) this.f2786a.getApplication()).m4776a(string);
            SAM.f2622o.m4849a(true);
            this.f2786a.mo4239a();
        } catch (Exception e) {
            C1922m.m5790a(e);
            this.f2786a.finish();
        }
    }
}
