package com.slideme.sam.manager.controller.p053a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.slideme.sam.manager.R;

/* compiled from: AccountSelectionHelper */
class C1612c extends BaseAdapter {
    final /* synthetic */ C1610a f2694a;
    private AccountManager f2695b;
    private LayoutInflater f2696c;
    private String f2697d;
    private Account[] f2698e = this.f2695b.getAccountsByType("com.slideme.user_account");

    public C1612c(C1610a c1610a) {
        this.f2694a = c1610a;
        this.f2695b = AccountManager.get(c1610a.f2672b);
        this.f2696c = (LayoutInflater) c1610a.f2672b.getSystemService("layout_inflater");
        this.f2697d = c1610a.m4844d();
    }

    public int getCount() {
        return this.f2698e.length;
    }

    public Object getItem(int i) {
        return this.f2698e[i];
    }

    public boolean hasStableIds() {
        return true;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2696c.inflate(R.layout.listitem_account, null);
        }
        Account account = (Account) getItem(i);
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(16908308);
        checkedTextView.setText(account.name);
        checkedTextView.setChecked(account.name.equals(this.f2697d));
        if (VERSION.SDK_INT < 11) {
            checkedTextView.setTextColor(checkedTextView.getResources().getColorStateList(17170435));
        }
        return view;
    }
}
