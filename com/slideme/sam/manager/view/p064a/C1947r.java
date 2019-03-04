package com.slideme.sam.manager.view.p064a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.activities.market.product.ScreenshotActivity;

/* compiled from: ScreenshotGalleryAdapter */
class C1947r implements OnClickListener {
    final /* synthetic */ C1945p f3590a;
    private final /* synthetic */ int f3591b;

    C1947r(C1945p c1945p, int i) {
        this.f3590a = c1945p;
        this.f3591b = i;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f3590a.f3583b, ScreenshotActivity.class);
        intent.putExtra("com.slideme.sam.manager.EXTRA_SCREENSHOT_INDEX", this.f3591b);
        intent.putExtra("com.slideme.sam.manager.EXTRA_APPHOLDER", this.f3590a.f3582a);
        this.f3590a.f3583b.startActivity(intent);
    }
}
