package com.slideme.sam.manager.controller.activities.common;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.drive.DriveFile;

/* compiled from: FlipperFragmentActivity */
class C1661f implements OnClickListener {
    final /* synthetic */ FlipperFragmentActivity f2792a;

    C1661f(FlipperFragmentActivity flipperFragmentActivity) {
        this.f2792a = flipperFragmentActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.settings.WIFI_SETTINGS");
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        this.f2792a.startActivity(intent);
    }
}
