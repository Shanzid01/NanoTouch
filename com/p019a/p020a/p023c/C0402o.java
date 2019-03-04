package com.p019a.p020a.p023c;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import p006b.p007a.p008a.p009a.p010a.p018g.C0310o;

/* compiled from: CrashlyticsCore */
class C0402o implements Runnable {
    final /* synthetic */ Activity f1359a;
    final /* synthetic */ C0406s f1360b;
    final /* synthetic */ aw f1361c;
    final /* synthetic */ C0310o f1362d;
    final /* synthetic */ C0395h f1363e;

    C0402o(C0395h c0395h, Activity activity, C0406s c0406s, aw awVar, C0310o c0310o) {
        this.f1363e = c0395h;
        this.f1359a = activity;
        this.f1360b = c0406s;
        this.f1361c = awVar;
        this.f1362d = c0310o;
    }

    public void run() {
        Builder builder = new Builder(this.f1359a);
        OnClickListener c0403p = new C0403p(this);
        float f = this.f1359a.getResources().getDisplayMetrics().density;
        int a = this.f1363e.m2759a(f, 5);
        View textView = new TextView(this.f1359a);
        textView.setAutoLinkMask(15);
        textView.setText(this.f1361c.m2566b());
        textView.setTextAppearance(this.f1359a, 16973892);
        textView.setPadding(a, a, a, a);
        textView.setFocusable(false);
        View scrollView = new ScrollView(this.f1359a);
        scrollView.setPadding(this.f1363e.m2759a(f, 14), this.f1363e.m2759a(f, 2), this.f1363e.m2759a(f, 10), this.f1363e.m2759a(f, 12));
        scrollView.addView(textView);
        builder.setView(scrollView).setTitle(this.f1361c.m2565a()).setCancelable(false).setNeutralButton(this.f1361c.m2567c(), c0403p);
        if (this.f1362d.f966d) {
            builder.setNegativeButton(this.f1361c.m2569e(), new C0404q(this));
        }
        if (this.f1362d.f968f) {
            builder.setPositiveButton(this.f1361c.m2568d(), new C0405r(this));
        }
        builder.show();
    }
}
