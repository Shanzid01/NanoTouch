package com.slideme.sam.manager.controller.p053a;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PinCheckDialog */
class C1625p implements TextWatcher {
    final /* synthetic */ C1623n f2713a;

    C1625p(C1623n c1623n) {
        this.f2713a = c1623n;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f2713a.f2711b.getButton(-1).setEnabled(this.f2713a.f2710a.getText().length() == 4);
    }
}
