package com.slideme.sam.manager.view.touchme;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: VerifyableEditText */
class ay implements TextWatcher {
    final /* synthetic */ VerifyableEditText f3819a;

    ay(VerifyableEditText verifyableEditText) {
        this.f3819a = verifyableEditText;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f3819a.f3760a.removeCallbacks(this.f3819a.f3762c);
        this.f3819a.f3760a.postDelayed(this.f3819a.f3762c, (long) this.f3819a.f3761b);
    }
}
