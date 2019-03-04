package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: PasswordCheckDialog */
class C1620k implements OnClickListener {
    final /* synthetic */ C1617h f2708a;

    C1620k(C1617h c1617h) {
        this.f2708a = c1617h;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2708a.getActivity() != null) {
            this.f2708a.getActivity().finish();
        }
    }
}
