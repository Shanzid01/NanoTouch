package com.slideme.sam.manager.controller.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.slideme.sam.manager.auth.AuthData;

/* compiled from: MyAccountFragment */
class ar extends BroadcastReceiver {
    final /* synthetic */ aq f3059a;

    ar(aq aqVar) {
        this.f3059a = aqVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.f3059a.m5266a(AuthData.m4814j(this.f3059a.getActivity()));
    }
}
