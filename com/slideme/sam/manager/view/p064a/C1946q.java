package com.slideme.sam.manager.view.p064a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ScreenshotGalleryAdapter */
class C1946q implements OnClickListener {
    final /* synthetic */ C1945p f3589a;

    C1946q(C1945p c1945p) {
        this.f3589a = c1945p;
    }

    public void onClick(View view) {
        this.f3589a.f3583b.startActivity(this.f3589a.f3582a.getVideoIntent());
    }
}
