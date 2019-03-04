package com.slideme.sam.manager.controller.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.slideme.sam.manager.R;

/* compiled from: DynamicLayoutFragment */
class ag implements OnClickListener {
    final /* synthetic */ ae f3039a;
    private final /* synthetic */ TextView f3040b;

    ag(ae aeVar, TextView textView) {
        this.f3039a = aeVar;
        this.f3040b = textView;
    }

    public void onClick(View view) {
        if (this.f3039a.f3034h) {
            this.f3040b.setText(this.f3039a.getResources().getString(R.string.reward_prompt));
            this.f3040b.setGravity(17);
        } else {
            this.f3040b.setText(this.f3039a.getResources().getString(R.string.reward_help));
            this.f3040b.setGravity(19);
        }
        this.f3039a.f3034h = !this.f3039a.f3034h;
    }
}
