package com.slideme.sam.manager.view.preference;

import com.slideme.sam.manager.view.touchme.bb;

/* compiled from: PinDialogPreference */
class C1963e implements bb {
    final /* synthetic */ PinDialogPreference f3640a;

    C1963e(PinDialogPreference pinDialogPreference) {
        this.f3640a = pinDialogPreference;
    }

    public boolean mo4244a(CharSequence charSequence) {
        return charSequence.length() != 0 && this.f3640a.f3633a.getText().toString().equals(charSequence.toString());
    }
}
