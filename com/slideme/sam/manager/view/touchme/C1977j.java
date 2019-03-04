package com.slideme.sam.manager.view.touchme;

import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;

/* compiled from: ExpandableTextView */
class C1977j extends ClickableSpan {
    final /* synthetic */ ExpandableTextView f3831a;
    private final /* synthetic */ URLSpan f3832b;

    C1977j(ExpandableTextView expandableTextView, URLSpan uRLSpan) {
        this.f3831a = expandableTextView;
        this.f3832b = uRLSpan;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.f3832b.getURL()));
        this.f3831a.getContext().startActivity(intent);
    }
}
