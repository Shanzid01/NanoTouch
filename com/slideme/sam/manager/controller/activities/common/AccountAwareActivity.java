package com.slideme.sam.manager.controller.activities.common;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.os.Bundle;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.util.C1914e;
import com.slideme.sam.manager.util.C1922m;

public abstract class AccountAwareActivity extends FlipperFragmentActivity {
    private AccountManagerCallback<Bundle> f2739a = new C1656a(this);

    public abstract void mo4239a();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!SAM.f2622o.m4851c() && this.k) {
            mo4242b();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (SAM.f2622o.m4851c()) {
            mo4239a();
        }
    }

    private void mo4242b() {
        AccountManager accountManager = AccountManager.get(this);
        Account[] accountsByType = accountManager.getAccountsByType("com.slideme.user_account");
        if (C1914e.f3493a) {
            C1922m.m5797b("AccountManager", "handleAccount -> " + String.valueOf(accountsByType.length) + " accounts");
        }
        switch (accountsByType.length) {
            case 0:
                accountManager.addAccount("com.slideme.user_account", "Normal user", null, null, this, this.f2739a, null);
                return;
            case 1:
                accountManager.getAuthToken(accountsByType[0], "com.slideme.user_account", null, this, this.f2739a, null);
                return;
            default:
                SAM.f2622o.m4847a(this, new C1657b(this, accountManager), true);
                return;
        }
    }
}
