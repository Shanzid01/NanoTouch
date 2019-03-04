package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* compiled from: ReviewFilterControlView */
class af implements OnItemSelectedListener {
    final /* synthetic */ ad f3774a;

    af(ad adVar) {
        this.f3774a = adVar;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                this.f3774a.f3772a.f3737e.mo4265a(ag.STARS_5, null);
                return;
            case 1:
                this.f3774a.f3772a.f3737e.mo4265a(ag.STARS_4, null);
                return;
            case 2:
                this.f3774a.f3772a.f3737e.mo4265a(ag.STARS_3, null);
                return;
            case 3:
                this.f3774a.f3772a.f3737e.mo4265a(ag.STARS_2, null);
                return;
            case 4:
                this.f3774a.f3772a.f3737e.mo4265a(ag.STARS_1, null);
                return;
            case 5:
                this.f3774a.f3772a.f3737e.mo4265a(ag.NO_RATING, null);
                return;
            default:
                return;
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
