package com.slideme.sam.manager.view.preference;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PinDialogPreference */
class C1962d implements TextWatcher {
    final /* synthetic */ PinDialogPreference f3639a;

    C1962d(PinDialogPreference pinDialogPreference) {
        this.f3639a = pinDialogPreference;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f3639a.f3634b.m6059c();
    }
}
