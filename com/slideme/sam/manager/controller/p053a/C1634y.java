package com.slideme.sam.manager.controller.p053a;

import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

/* compiled from: ReviewDialog */
class C1634y implements OnRatingBarChangeListener {
    final /* synthetic */ C1632w f2731a;

    C1634y(C1632w c1632w) {
        this.f2731a = c1632w;
    }

    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        if (f < 0.5f) {
            ratingBar.setRating(0.5f);
            return;
        }
        if (this.f2731a.f2727f.getText().length() == 0 || this.f2731a.f2727f.getText().toString().equals(this.f2731a.m4882a(this.f2731a.f2728g))) {
            this.f2731a.f2727f.setText(this.f2731a.m4882a(f));
        }
        this.f2731a.f2728g = f;
    }
}
