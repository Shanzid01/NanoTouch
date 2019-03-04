package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.model.data.Review.Thumbs;

/* compiled from: ReviewRateDialog */
public class C1635z extends DialogFragment {
    private Review f2732a;
    private Thumbs f2733b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2732a = (Review) getArguments().getParcelable("com.slideme.sam.manager.extra.REVIEW");
        this.f2733b = this.f2732a.userThumbs;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Builder(getActivity()).setTitle(R.string.review_rate_title).setPositiveButton(17039370, new aa(this)).setNegativeButton(17039360, new ab(this)).setSingleChoiceItems(R.array.review_rate, this.f2732a.userThumbs.ordinal() - 1, new ac(this)).create();
    }
}
