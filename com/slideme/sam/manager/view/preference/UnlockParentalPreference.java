package com.slideme.sam.manager.view.preference;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.util.C1920k;

public class UnlockParentalPreference extends DialogPreference {
    private EditText f3636a;

    public UnlockParentalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UnlockParentalPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected View onCreateDialogView() {
        return m5896a();
    }

    private EditText m5896a() {
        this.f3636a = new EditText(getContext());
        this.f3636a.setLayoutParams(new LayoutParams(-1, -2));
        this.f3636a.setFilters(new InputFilter[]{new LengthFilter(4)});
        this.f3636a.setImeOptions(6);
        this.f3636a.setInputType(18);
        this.f3636a.setHint(R.string.pin_hint);
        this.f3636a.addTextChangedListener(new C1967i(this));
        return this.f3636a;
    }

    protected void showDialog(Bundle bundle) {
        super.showDialog(bundle);
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setEnabled(this.f3636a.getText().length() == 4);
        }
    }

    protected void onDialogClosed(boolean z) {
        if (!z) {
            super.onDialogClosed(z);
        } else if (SAM.f2617j.m5517a(this.f3636a.getText().toString())) {
            SAM.f2617j.m5515a(false);
        } else {
            SAM.f2617j.m5515a(true);
            C1920k.m5781a(getContext(), (int) R.string.incorrect_pin, 0).show();
        }
    }
}
