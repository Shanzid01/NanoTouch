package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Review;

/* compiled from: ReviewDialog */
class C1633x implements OnClickListener {
    final /* synthetic */ C1632w f2729a;
    private final /* synthetic */ View f2730b;

    C1633x(C1632w c1632w, View view) {
        this.f2729a = c1632w;
        this.f2730b = view;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        float f = 0.5f;
        Review a = this.f2729a.f2724c;
        if (this.f2729a.f2726e.getRating() >= 0.5f) {
            f = this.f2729a.f2726e.getRating();
        }
        a.rating = f;
        this.f2729a.f2724c.text = ((EditText) this.f2730b.findViewById(R.id.review)).getText().toString();
        this.f2729a.f2724c.video = ((EditText) this.f2730b.findViewById(R.id.video)).getText().toString();
        this.f2729a.f2724c.appUid = this.f2729a.f2723b;
        this.f2729a.m4888c();
    }
}
