package com.slideme.sam.manager.controller.fragment.p056a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.slideme.sam.manager.R;

/* compiled from: AdProxyApplicationsListFragment */
class C1714d implements OnClickListener {
    final /* synthetic */ C1709a f2947a;
    private final /* synthetic */ TextView f2948b;

    C1714d(C1709a c1709a, TextView textView) {
        this.f2947a = c1709a;
        this.f2948b = textView;
    }

    public void onClick(View view) {
        if (this.f2947a.f2921l) {
            this.f2948b.setText(this.f2947a.getResources().getString(R.string.sharearn_prompt));
            this.f2948b.setGravity(17);
        } else {
            this.f2948b.setText(this.f2947a.getResources().getString(R.string.sharearn_help));
            this.f2948b.setGravity(19);
        }
        this.f2947a.f2921l = !this.f2947a.f2921l;
    }
}
