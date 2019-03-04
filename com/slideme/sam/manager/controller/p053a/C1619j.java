package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.slideme.sam.manager.SAM;

/* compiled from: PasswordCheckDialog */
class C1619j implements OnClickListener {
    final /* synthetic */ C1617h f2707a;

    C1619j(C1617h c1617h) {
        this.f2707a = c1617h;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        SAM.f2614g.m5606a(this.f2707a.getActivity(), this.f2707a.f2701a.getText().toString(), this.f2707a.f2705e);
    }
}
