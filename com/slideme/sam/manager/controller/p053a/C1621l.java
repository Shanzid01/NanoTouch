package com.slideme.sam.manager.controller.p053a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

/* compiled from: PasswordCheckDialog */
class C1621l implements TextWatcher {
    final /* synthetic */ C1617h f2709a;

    C1621l(C1617h c1617h) {
        this.f2709a = c1617h;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        boolean z = true;
        Button button = this.f2709a.f2702b.getButton(-1);
        if (this.f2709a.f2701a.getText().length() <= 1) {
            z = false;
        }
        button.setEnabled(z);
    }
}
