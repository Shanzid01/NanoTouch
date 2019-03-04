package com.slideme.sam.manager.auth;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.slideme.sam.manager.SAM;

/* compiled from: SlidemeAuthenticator */
public class C1607i extends AbstractAccountAuthenticator {
    private Context f2669a;

    public C1607i(Context context) {
        super(context);
        this.f2669a = context;
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        Parcelable intent = new Intent(this.f2669a, AuthenticatorActivity.class);
        intent.putExtra("account_type", str);
        intent.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str2);
        intent.putExtra("is_adding_new_account", true);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        return null;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        return null;
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        AccountManager accountManager = AccountManager.get(this.f2669a);
        Object peekAuthToken = accountManager.peekAuthToken(account, str);
        if (TextUtils.isEmpty(peekAuthToken)) {
            String password = accountManager.getPassword(account);
            if (password != null) {
                AuthData a = SAM.f2614g.m5590a(account.name, password, str, false);
                if (a != null) {
                    peekAuthToken = a.m4817b();
                }
            }
        }
        if (TextUtils.isEmpty(peekAuthToken)) {
            accountManager.invalidateAuthToken(account.type, accountManager.peekAuthToken(account, str));
            Parcelable intent = new Intent(this.f2669a, AuthenticatorActivity.class);
            intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            intent.putExtra("account_type", account.type);
            intent.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("intent", intent);
            return bundle2;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("authAccount", account.name);
        bundle3.putString("accountType", account.type);
        bundle3.putString("authtoken", peekAuthToken);
        return bundle3;
    }

    public String getAuthTokenLabel(String str) {
        return null;
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        return null;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        return null;
    }
}
