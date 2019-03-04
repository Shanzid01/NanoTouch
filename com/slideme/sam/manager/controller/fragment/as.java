package com.slideme.sam.manager.controller.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.maps.model.GroundOverlayOptions;

/* compiled from: MyAccountFragment */
class as extends BroadcastReceiver {
    final /* synthetic */ aq f3060a;

    as(aq aqVar) {
        this.f3060a = aqVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.f3060a.m5266a(GroundOverlayOptions.NO_DIMENSION);
    }
}
