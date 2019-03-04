package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.slideme.sam.manager.C1608b;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.view.p064a.C1942l;
import java.util.ArrayList;

public class ReviewListView extends LinearLayout {
    private int f3738a = 2;
    private C1942l f3739b = null;
    private FragmentActivity f3740c = null;
    private ArrayList<Review> f3741d = null;
    private int f3742e = -1;
    private View f3743f = null;

    public ReviewListView(Context context) {
        super(context);
        m6023a(null);
    }

    public ReviewListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6023a(attributeSet);
    }

    public void m6023a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1608b.ReviewsListView);
            this.f3738a = obtainStyledAttributes.getInt(0, this.f3738a);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(17);
    }

    public void m6022a(FragmentActivity fragmentActivity) {
        this.f3740c = fragmentActivity;
    }

    public void setVersionCode(int i) {
        this.f3742e = i;
    }

    private void m6020b() {
        this.f3739b = new C1942l(this.f3740c, this.f3741d, this.f3742e);
    }

    public void m6025a(String str) {
        SAM.f2614g.m5618a(str, 0, 4, new ai(this));
    }

    public void m6024a(View view) {
        this.f3743f = view;
    }

    public void m6021a() {
        if (this.f3739b == null) {
            m6020b();
        }
        removeAllViews();
        if (this.f3739b == null || this.f3739b.getCount() == 0) {
            inflate(getContext(), R.layout.widget_empty_indicator, this);
            ((TextView) findViewById(R.id.indicator)).setText(R.string.empty_reviews);
            if (this.f3743f != null) {
                this.f3743f.setVisibility(8);
                return;
            }
            return;
        }
        int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, getContext().getResources().getDisplayMetrics());
        int[] iArr = new int[2];
        iArr[0] = R.attr.secondaryDivider;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(iArr);
        int color = obtainStyledAttributes.getColor(0, -16777216);
        obtainStyledAttributes.recycle();
        int i = 0;
        while (i < this.f3739b.getCount() && i < this.f3738a) {
            addView(this.f3739b.getView(i, null, null));
            View view = new View(getContext());
            view.setLayoutParams(new LayoutParams(-1, 1));
            view.setPadding(0, applyDimension, 0, applyDimension);
            view.setBackgroundColor(color);
            addView(view);
            i++;
        }
        if (this.f3743f != null) {
            this.f3743f.setVisibility(0);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("STATE_SUPERSTATE", super.onSaveInstanceState());
        bundle.putInt("STATE_NUM_REVIEWS", this.f3738a);
        bundle.putParcelableArrayList("STATE_REVIEWS", this.f3741d);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("STATE_SUPERSTATE"));
            this.f3738a = bundle.getInt("STATE_NUM_REVIEWS");
            this.f3741d = bundle.getParcelableArrayList("STATE_REVIEWS");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
