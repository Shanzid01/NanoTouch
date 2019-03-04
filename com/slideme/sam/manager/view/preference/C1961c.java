package com.slideme.sam.manager.view.preference;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.SAM;

/* compiled from: PinDialogPreference */
class C1961c implements OnClickListener {
    final /* synthetic */ PinDialogPreference f3638a;

    C1961c(PinDialogPreference pinDialogPreference) {
        this.f3638a = pinDialogPreference;
    }

    public void onClick(View view) {
        SAM.f2617j.m5518b();
        this.f3638a.getDialog().dismiss();
    }
}
