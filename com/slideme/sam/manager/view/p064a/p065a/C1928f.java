package com.slideme.sam.manager.view.p064a.p065a;

import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.model.data.ApplicationHolder;

/* compiled from: VideoListApplicationViewFactory */
class C1928f implements OnClickListener {
    final /* synthetic */ C1927e f3520a;
    private final /* synthetic */ ApplicationHolder f3521b;

    C1928f(C1927e c1927e, ApplicationHolder applicationHolder) {
        this.f3520a = c1927e;
        this.f3521b = applicationHolder;
    }

    public void onClick(View view) {
        this.f3520a.b.startActivity(this.f3521b.getVideoIntent());
    }
}
