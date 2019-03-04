package com.slideme.sam.manager.controller.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.slideme.sam.manager.R;

/* compiled from: DynamicLayoutFragment */
class ah implements OnClickListener {
    final /* synthetic */ ae f3041a;
    private final /* synthetic */ TextView f3042b;

    ah(ae aeVar, TextView textView) {
        this.f3041a = aeVar;
        this.f3042b = textView;
    }

    public void onClick(View view) {
        if (this.f3041a.f3034h) {
            this.f3042b.setText(this.f3041a.getResources().getString(R.string.sharearn_prompt));
            this.f3042b.setGravity(17);
        } else {
            this.f3042b.setText(this.f3041a.getResources().getString(R.string.sharearn_help));
            this.f3042b.setGravity(19);
        }
        this.f3041a.f3034h = !this.f3041a.f3034h;
    }
}
