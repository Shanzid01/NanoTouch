package com.slideme.sam.manager.view.actionview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.maps.model.GroundOverlayOptions;

/* compiled from: WalletView */
class C1952b extends BroadcastReceiver {
    final /* synthetic */ WalletView f3598a;

    C1952b(WalletView walletView) {
        this.f3598a = walletView;
    }

    public void onReceive(Context context, Intent intent) {
        this.f3598a.setWalletText(GroundOverlayOptions.NO_DIMENSION);
    }
}
