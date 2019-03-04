package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;

/* compiled from: ReportDialog */
class C1631v implements OnClickListener {
    final /* synthetic */ C1629t f2719a;
    private final /* synthetic */ Spinner f2720b;
    private final /* synthetic */ EditText f2721c;

    C1631v(C1629t c1629t, Spinner spinner, EditText editText) {
        this.f2719a = c1629t;
        this.f2720b = spinner;
        this.f2721c = editText;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2719a.m4878a(this.f2720b.getSelectedItemPosition(), this.f2721c.getText().toString());
        this.f2719a.dismiss();
    }
}
