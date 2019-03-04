package com.slideme.sam.manager.view.preference;

import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: UnlockParentalPreference */
class C1967i implements TextWatcher {
    final /* synthetic */ UnlockParentalPreference f3645a;

    C1967i(UnlockParentalPreference unlockParentalPreference) {
        this.f3645a = unlockParentalPreference;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        AlertDialog alertDialog = (AlertDialog) this.f3645a.getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setEnabled(this.f3645a.f3636a.getText().length() == 4);
        }
    }
}
