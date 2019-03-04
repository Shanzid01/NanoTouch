package com.slideme.sam.manager.view.touchme;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: DownloadButton */
class C1973f implements OnFocusChangeListener {
    final /* synthetic */ DownloadButton f3826a;

    C1973f(DownloadButton downloadButton) {
        this.f3826a = downloadButton;
    }

    public void onFocusChange(View view, boolean z) {
        view.getBackground().setAlpha(z ? 180 : 255);
    }
}
