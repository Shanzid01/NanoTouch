package com.slideme.sam.manager.controller.fragment.p056a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.slideme.sam.manager.R;

/* compiled from: AdProxyApplicationsListFragment */
class C1713c implements OnClickListener {
    final /* synthetic */ C1709a f2945a;
    private final /* synthetic */ TextView f2946b;

    C1713c(C1709a c1709a, TextView textView) {
        this.f2945a = c1709a;
        this.f2946b = textView;
    }

    public void onClick(View view) {
        if (this.f2945a.f2921l) {
            this.f2946b.setText(this.f2945a.getResources().getString(R.string.reward_prompt));
            this.f2946b.setGravity(17);
        } else {
            this.f2946b.setText(this.f2945a.getResources().getString(R.string.reward_help));
            this.f2946b.setGravity(19);
        }
        this.f2945a.f2921l = !this.f2945a.f2921l;
    }
}
