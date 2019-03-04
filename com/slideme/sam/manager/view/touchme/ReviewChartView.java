package com.slideme.sam.manager.view.touchme;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.nineoldandroids.animation.ObjectAnimator;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.response.BreakdownTag;
import com.slideme.sam.manager.view.C1950a;

public class ReviewChartView extends FrameLayout {
    TableLayout f3726a;
    private BreakdownTag f3727b;
    private SafeViewFlipper f3728c;
    private TextView f3729d;
    private TextView f3730e;
    private RatingBar f3731f;
    private boolean f3732g = false;

    public ReviewChartView(Context context) {
        super(context);
        m6005a();
    }

    public ReviewChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6005a();
    }

    private void m6005a() {
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.widget_review_chart, null);
        this.f3728c = (SafeViewFlipper) inflate.findViewById(R.id.flipper);
        this.f3726a = (TableLayout) inflate.findViewById(R.id.content);
        this.f3729d = (TextView) inflate.findViewById(R.id.averageNumber);
        this.f3730e = (TextView) inflate.findViewById(R.id.averageTotal);
        this.f3731f = (RatingBar) inflate.findViewById(R.id.averageBar);
        this.f3732g = true;
        addView(inflate);
        m6010d();
    }

    public void m6011a(Application application, Activity activity) {
        if (this.f3727b == null) {
            setLoading(true);
            SAM.f2614g.m5633b(application, new ab(this));
            return;
        }
        m6010d();
    }

    private void m6008b() {
        int childCount = this.f3726a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TableRow tableRow = (TableRow) this.f3726a.getChildAt(i);
            int childCount2 = tableRow.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                switch (i2) {
                    case 1:
                        Object obj = (ProgressBar) tableRow.getChildAt(i2);
                        obj.setMax(this.f3727b.getNumReviews());
                        ObjectAnimator.ofInt(obj, "progress", 0, this.f3727b.ratings[i]).setDuration((long) Math.min(this.f3727b.getNumReviews() * 2, 1000)).start();
                        break;
                    case 2:
                        ((TextView) tableRow.getChildAt(i2)).setText(String.valueOf(this.f3727b.ratings[i]));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void m6009c() {
        this.f3729d.setText(String.valueOf(C1950a.m5856a((double) this.f3727b.getAverageIn5())));
        this.f3730e.setText(String.valueOf(this.f3727b.getNumReviews()));
        this.f3731f.setRating(this.f3727b.getAverageIn5());
    }

    public void setLoading(boolean z) {
        this.f3728c.setDisplayedChild(z ? 0 : 1);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("STATE_SUPERSTATE", super.onSaveInstanceState());
        bundle.putParcelable("STATE_REVIEW_DATA", this.f3727b);
        return bundle;
    }

    private void m6010d() {
        if (!this.f3732g) {
            return;
        }
        if (this.f3727b != null) {
            setLoading(false);
            m6008b();
            m6009c();
            return;
        }
        setLoading(true);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("STATE_SUPERSTATE"));
            this.f3727b = (BreakdownTag) bundle.getParcelable("STATE_REVIEW_DATA");
            m6010d();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
