package com.mopub.mobileads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: MraidDisplayController */
class bg implements OnClickListener {
    final /* synthetic */ bb f2444a;
    private final /* synthetic */ String f2445b;

    bg(bb bbVar, String str) {
        this.f2444a = bbVar;
        this.f2445b = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2444a.m4548d(this.f2445b);
    }
}
