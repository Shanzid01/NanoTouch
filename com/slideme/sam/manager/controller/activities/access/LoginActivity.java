package com.slideme.sam.manager.controller.activities.access;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AccountAuthenticatorActivity;
import com.slideme.sam.manager.util.C1922m;

public class LoginActivity extends AccountAuthenticatorActivity {
    protected ProgressDialog f2652b;
    protected boolean f2653c;
    protected C1637a f2654d;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2652b = new ProgressDialog(this);
        this.f2652b.setProgressStyle(0);
        this.f2652b.setCancelable(false);
        this.f2652b.setCanceledOnTouchOutside(false);
    }

    protected void mo4241a(Intent intent) {
        AccountManager accountManager = AccountManager.get(this);
        Object stringExtra = intent.getStringExtra("authAccount");
        String stringExtra2 = intent.getStringExtra("com.slideme.sam.manager.EXTRA_PASSWORD");
        if (!TextUtils.isEmpty(stringExtra)) {
            Account account = new Account(stringExtra, intent.getStringExtra("accountType"));
            if (getIntent().getBooleanExtra("is_adding_new_account", false)) {
                String stringExtra3 = intent.getStringExtra("authtoken");
                accountManager.addAccountExplicitly(account, stringExtra2, intent.getBundleExtra("userdata"));
                accountManager.setAuthToken(account, "Normal user", stringExtra3);
                SAM.f2622o.m4848a(account.name);
                ((SAM) getApplication()).m4776a(stringExtra3);
            } else {
                accountManager.setPassword(account, stringExtra2);
            }
            m4799a(intent.getExtras());
            setResult(-1, intent);
            mo4228a(false);
            if (accountManager.getAccountsByType("com.slideme.user_account").length > 1) {
                C1922m.m5800d(this);
            } else {
                finish();
            }
        }
    }

    protected void m4819a(String str, String str2) {
        if (this.f2654d == null) {
            this.f2654d = new C1637a(this);
            this.f2654d.execute(new String[]{str, str2});
        }
    }

    protected void mo4228a(boolean z) {
        this.f2653c = z;
        if (z) {
            this.f2652b.show();
        } else {
            this.f2652b.dismiss();
        }
    }

    protected void onDestroy() {
        this.f2652b.dismiss();
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("logging_in", this.f2653c ? 1 : 0);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        boolean z = true;
        super.onRestoreInstanceState(bundle);
        if (bundle.getInt("logging_in") != 1) {
            z = false;
        }
        this.f2653c = z;
        mo4228a(this.f2653c);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 != 0) {
            m4799a(intent.getExtras());
            setResult(i2, intent);
            finish();
        }
    }
}
