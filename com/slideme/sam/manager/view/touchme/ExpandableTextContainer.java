package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.slideme.sam.manager.R;

public class ExpandableTextContainer extends LinearLayout {
    private ExpandableTextView f3670a;
    private TextView f3671b;

    public ExpandableTextContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5934a(attributeSet);
    }

    private void m5934a(AttributeSet attributeSet) {
        setOrientation(1);
        this.f3670a = new ExpandableTextView(getContext(), attributeSet);
        this.f3670a.setLayoutParams(new LayoutParams(-1, -2));
        this.f3670a.setClickable(false);
        this.f3670a.setDuplicateParentStateEnabled(false);
        this.f3670a.setPadding(0, 0, 0, 0);
        this.f3670a.setOnClickListener(new C1975h(this));
        this.f3671b = new TextView(getContext());
        this.f3671b.setLayoutParams(new LayoutParams(-1, -2));
        this.f3671b.setGravity(5);
        addView(this.f3670a);
        addView(this.f3671b);
        setClickable(true);
        setOnClickListener(new C1976i(this));
        setOrientation(1);
        this.f3670a.m5947b();
        this.f3671b.setText(R.string.expandable_more);
        this.f3671b.setVisibility(8);
    }

    public void m5936a(CharSequence charSequence) {
        this.f3670a.setText(charSequence);
        boolean e = this.f3670a.m5950e();
        this.f3671b.setVisibility(e ? 0 : 8);
        setClickable(e);
        setFocusable(e);
    }

    public void setText(int i) {
        m5936a(getContext().getString(i));
    }
}
