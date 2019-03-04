package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: ReviewFilterControlView */
class ae implements OnItemSelectedListener {
    final /* synthetic */ ad f3773a;

    ae(ad adVar) {
        this.f3773a = adVar;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                this.f3773a.f3772a.f3737e.mo4265a(ag.VERSION_LATEST, null);
                return;
            default:
                this.f3773a.f3772a.f3737e.mo4265a(ag.VERSION_OTHER, (String) adapterView.getAdapter().getItem(i));
                return;
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
