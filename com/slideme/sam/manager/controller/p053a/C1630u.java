package com.slideme.sam.manager.controller.p053a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;

/* compiled from: ReportDialog */
class C1630u implements OnItemSelectedListener {
    final /* synthetic */ C1629t f2717a;
    private final /* synthetic */ EditText f2718b;

    C1630u(C1629t c1629t, EditText editText) {
        this.f2717a = c1629t;
        this.f2718b = editText;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2718b.setVisibility(adapterView.getCount() + -1 == i ? 0 : 8);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
