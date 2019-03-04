package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.slideme.sam.manager.R;

/* compiled from: PinCheckDialog */
public class C1623n extends DialogFragment {
    private EditText f2710a;
    private AlertDialog f2711b;

    public Dialog onCreateDialog(Bundle bundle) {
        m4874a();
        this.f2711b = new Builder(getActivity()).setPositiveButton(17039370, new C1624o(this)).setNegativeButton(17039360, null).setView(this.f2710a).setTitle(R.string.check_pin_title).create();
        this.f2710a.addTextChangedListener(new C1625p(this));
        return this.f2711b;
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.f2711b.getButton(-1).setEnabled(false);
        super.onViewCreated(view, bundle);
    }

    private void m4874a() {
        this.f2710a = new EditText(getActivity());
        this.f2710a.setLayoutParams(new LayoutParams(-1, -2));
        this.f2710a.setFilters(new InputFilter[]{new LengthFilter(4)});
        this.f2710a.setImeOptions(6);
        this.f2710a.setInputType(18);
        this.f2710a.setHint(R.string.pin_hint);
    }
}
