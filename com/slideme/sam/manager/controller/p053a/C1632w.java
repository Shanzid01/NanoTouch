package com.slideme.sam.manager.controller.p053a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import com.p019a.p020a.p021a.C0345b;
import com.p019a.p020a.p021a.C0366z;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.activities.market.product.ApplicationDetailsActivity;
import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.util.C1920k;
import com.slideme.sam.manager.view.C1950a;
import com.slideme.sam.manager.view.touchme.MyReview;

/* compiled from: ReviewDialog */
public class C1632w extends DialogFragment {
    private static String[] f2722a;
    private String f2723b;
    private Review f2724c;
    private float f2725d;
    private RatingBar f2726e;
    private TextView f2727f;
    private float f2728g;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2723b = getArguments().getString("com.slideme.sam.manager.EXTRA_BUNDLE_ID");
        this.f2724c = (Review) getArguments().getParcelable("com.slideme.sam.manager.extra.REVIEW");
        this.f2725d = getArguments().getFloat("com.slideme.sam.manager.extra.RATING_AVERAGE");
        f2722a = getResources().getStringArray(R.array.review_defaults);
    }

    private View m4880a() {
        return ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.dialog_review, null);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View a = m4880a();
        this.f2726e = (RatingBar) a.findViewById(R.id.rating);
        this.f2727f = (EditText) a.findViewById(R.id.review);
        this.f2727f.setText(C1950a.m5855a(this.f2724c.text).toString().trim());
        m4885b();
        ((EditText) a.findViewById(R.id.video)).setText(this.f2724c.video);
        return new Builder(getActivity()).setTitle(R.string.review).setView(a).setPositiveButton(17039370, new C1633x(this, a)).create();
    }

    private void m4885b() {
        this.f2726e.setOnRatingBarChangeListener(new C1634y(this));
        if (this.f2724c.rating >= 0.5f) {
            this.f2726e.setRating(this.f2724c.rating);
        } else if (this.f2725d < 0.5f) {
            this.f2726e.setRating(3.0f);
        } else {
            this.f2726e.setRating(this.f2725d);
        }
    }

    private String m4882a(float f) {
        return f2722a[Math.max(0, (int) Math.floor((double) (f - 0.5f)))];
    }

    private void m4888c() {
        if (this.f2724c.text.trim().length() == 0) {
            C1920k.m5781a(getActivity(), (int) R.string.review_length_error, 0).show();
            this.f2724c.rating = 0.0f;
            return;
        }
        SAM.f2614g.m5635b(this.f2724c, new C1600v());
        C0345b.m2427c().m2440a(new C0366z().m2505a((int) this.f2724c.rating).m2508b("App Rating").m2506a(this.f2724c.appUid));
        MyReview b = ((ApplicationDetailsActivity) getActivity()).mo4242b();
        if (b != null) {
            b.m5990d();
        }
        dismiss();
    }
}
