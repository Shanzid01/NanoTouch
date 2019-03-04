package com.slideme.sam.manager.view.preference;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.view.touchme.VerifyableEditText;

public class PinDialogPreference extends DialogPreference {
    private EditText f3633a;
    private VerifyableEditText f3634b;
    private Button f3635c;

    public PinDialogPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PinDialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected View onCreateDialogView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_preference_manage_pin, null);
        this.f3633a = (EditText) inflate.findViewById(R.id.set_pin_text);
        this.f3634b = (VerifyableEditText) inflate.findViewById(R.id.set_pin_verify);
        this.f3635c = (Button) inflate.findViewById(R.id.remove_pin_button);
        this.f3635c.setOnClickListener(new C1961c(this));
        this.f3633a.addTextChangedListener(new C1962d(this));
        this.f3634b.m6055a(new C1963e(this));
        this.f3634b.setUnverifiedText(R.string.verify_pin_wrong);
        this.f3634b.setDelay(100);
        this.f3634b.m6054a(new C1964f(this));
        this.f3634b.setFilters(this.f3633a.getFilters());
        return inflate;
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        TextView textView = (TextView) view.findViewById(R.id.set_pin_title);
        TextView textView2 = (TextView) view.findViewById(R.id.remove_pin_title);
        if (SAM.f2617j.m5516a()) {
            this.f3633a.setHint(R.string.change_pin_hint);
            textView.setVisibility(0);
            textView2.setVisibility(0);
            this.f3635c.setVisibility(0);
            return;
        }
        this.f3633a.setHint(R.string.pin_hint);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        this.f3635c.setVisibility(8);
    }

    private void m5891a() {
        boolean z = this.f3633a.getText().length() >= 4 && this.f3634b.m6058b();
        if (getDialog() != null && getDialog().isShowing() && ((AlertDialog) getDialog()).getButton(-1) != null) {
            ((AlertDialog) getDialog()).getButton(-1).setEnabled(z);
        }
    }

    protected void showDialog(Bundle bundle) {
        super.showDialog(bundle);
        m5891a();
    }

    protected void onDialogClosed(boolean z) {
        if (z) {
            SAM.f2617j.m5519b(this.f3633a.getText().toString());
        } else {
            super.onDialogClosed(z);
        }
        notifyDependencyChange(shouldDisableDependents());
    }

    public boolean shouldDisableDependents() {
        return !SAM.f2617j.m5516a();
    }
}
