package com.slideme.sam.manager.view.actionview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.slideme.sam.manager.auth.AuthData;

/* compiled from: WalletView */
class C1951a extends BroadcastReceiver {
    final /* synthetic */ WalletView f3597a;

    C1951a(WalletView walletView) {
        this.f3597a = walletView;
    }

    public void onReceive(Context context, Intent intent) {
        this.f3597a.setWalletText(AuthData.m4814j(this.f3597a.getContext()));
    }
}
