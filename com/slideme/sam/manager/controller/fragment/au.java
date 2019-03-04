package com.slideme.sam.manager.controller.fragment;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: MyAccountFragment */
class au implements AccountManagerCallback<Bundle> {
    final /* synthetic */ at f3062a;
    private final /* synthetic */ Activity f3063b;

    au(at atVar, Activity activity) {
        this.f3062a = atVar;
        this.f3063b = activity;
    }

    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        String str = null;
        try {
            str = ((Bundle) accountManagerFuture.getResult()).getString("authtoken");
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
        if (!TextUtils.isEmpty(str)) {
            ((SAM) this.f3063b.getApplication()).m4776a(str);
        }
    }
}
