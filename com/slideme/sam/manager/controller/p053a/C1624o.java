package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.slideme.sam.manager.SAM;

/* compiled from: PinCheckDialog */
class C1624o implements OnClickListener {
    final /* synthetic */ C1623n f2712a;

    C1624o(C1623n c1623n) {
        this.f2712a = c1623n;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        ((C1626q) this.f2712a.getActivity()).mo4247a(SAM.f2617j.m5517a(this.f2712a.f2710a.getText().toString()));
    }
}
