package com.slideme.sam.manager.controller.p053a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: AccountSelectionHelper */
public class C1610a {
    private Account f2671a;
    private Context f2672b;

    public C1610a(Context context) {
        this.f2672b = context;
    }

    public void m4846a() {
        C1922m.m5797b("AccountManager", "resetAccount");
        m4849a(false);
        m4845e();
        this.f2671a = null;
    }

    public void m4847a(Activity activity, C1613d c1613d, boolean z) {
        C1922m.m5797b("AccountManager", "selectAccount -> autoDefault: " + Boolean.toString(z));
        ListAdapter c1612c = new C1612c(this);
        if (m4850b() == null || !z) {
            new Builder(activity).setTitle(R.string.account_selection_title).setAdapter(c1612c, new C1611b(this, c1612c, c1613d)).show();
        } else {
            c1613d.mo4245a(m4850b());
        }
    }

    public Account m4850b() {
        if (this.f2671a == null) {
            Account[] accountsByType = AccountManager.get(this.f2672b).getAccountsByType("com.slideme.user_account");
            String d = m4844d();
            for (Account account : accountsByType) {
                if (account.name.equals(d)) {
                    this.f2671a = account;
                    return this.f2671a;
                }
            }
        }
        C1922m.m5797b("AccountManager", "getLastUsedAccount -> " + (this.f2671a != null ? this.f2671a.name : "NULL"));
        return this.f2671a;
    }

    public boolean m4851c() {
        boolean z = false;
        Object d = m4844d();
        if (!TextUtils.isEmpty(d)) {
            int i;
            if (VERSION.SDK_INT >= 11) {
                i = 4;
            } else {
                i = 0;
            }
            z = this.f2672b.getSharedPreferences("account_selection", i).getBoolean("account_handled_" + d, false);
        }
        C1922m.m5797b("AccountManager", "isSelectedAccountHandled -> " + Boolean.toString(z));
        return z;
    }

    public void m4849a(boolean z) {
        String d = m4844d();
        if (!TextUtils.isEmpty(d)) {
            C1922m.m5797b("AccountManager", "setSelectedAccountHandled -> " + d + ": " + Boolean.toString(z));
            if (VERSION.SDK_INT >= 11) {
                this.f2672b.getSharedPreferences("account_selection", 0).edit().putBoolean("account_handled_" + d, z).commit();
            } else {
                this.f2672b.getSharedPreferences("account_selection", 0).edit().putBoolean("account_handled_" + d, z).commit();
            }
        }
    }

    private String m4844d() {
        int i = 0;
        if (VERSION.SDK_INT >= 11) {
            i = 4;
        }
        String string = this.f2672b.getSharedPreferences("account_selection", i).getString("account_name", null);
        if (string != null) {
            C1922m.m5797b("AccountManager", "getSelectedAccountName -> " + string);
        }
        return string;
    }

    public void m4848a(String str) {
        this.f2671a = null;
        if (VERSION.SDK_INT >= 11) {
            this.f2672b.getSharedPreferences("account_selection", 0).edit().putString("account_name", str).commit();
            C1922m.m5797b("AccountManager", "setSelectedAccountName -> " + str);
        } else {
            this.f2672b.getSharedPreferences("account_selection", 0).edit().putString("account_name", str).commit();
            C1922m.m5797b("AccountManager", "setSelectedAccountName -> " + str);
        }
    }

    private void m4845e() {
        this.f2671a = null;
        if (VERSION.SDK_INT >= 11) {
            this.f2672b.getSharedPreferences("account_selection", 0).edit().remove("account_name").commit();
        } else {
            this.f2672b.getSharedPreferences("account_selection", 0).edit().remove("account_name").commit();
        }
    }
}
