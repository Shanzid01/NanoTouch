package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.slideme.sam.manager.R;

/* compiled from: ReviewFilterControlView */
class ad implements OnItemSelectedListener {
    final /* synthetic */ ReviewFilterControlView f3772a;

    ad(ReviewFilterControlView reviewFilterControlView) {
        this.f3772a = reviewFilterControlView;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                this.f3772a.f3737e.mo4265a(ag.SHOW_ALL, null);
                this.f3772a.f3735c.setVisibility(8);
                return;
            case 1:
                this.f3772a.f3737e.mo4265a(ag.PROMOTED, null);
                this.f3772a.f3735c.setVisibility(8);
                return;
            case 2:
                this.f3772a.setEntries(new String[]{this.f3772a.getResources().getString(R.string.currentVersion), "TBAdded"});
                this.f3772a.f3735c.setVisibility(0);
                this.f3772a.f3734b.setOnItemSelectedListener(new ae(this));
                return;
            case 3:
                this.f3772a.setEntries(this.f3772a.getResources().getStringArray(R.array.filter_secondary_rating));
                this.f3772a.f3735c.setVisibility(0);
                this.f3772a.f3734b.setOnItemSelectedListener(new af(this));
                this.f3772a.f3734b.setSelection(0);
                return;
            default:
                this.f3772a.f3737e.mo4265a(ag.SHOW_ALL, null);
                this.f3772a.f3735c.setVisibility(8);
                return;
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
