package com.slideme.sam.manager.controller.fragment;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p053a.C1613d;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: MyAccountFragment */
class at implements C1613d {
    final /* synthetic */ aq f3061a;

    at(aq aqVar) {
        this.f3061a = aqVar;
    }

    public void mo4245a(Account account) {
        Context activity = this.f3061a.getActivity();
        SAM.f2622o.m4848a(account.name);
        AccountManager.get(activity).getAuthToken(account, "Normal user", null, this.f3061a.getActivity(), new au(this, activity), null);
        C1922m.m5801e(activity);
    }
}
