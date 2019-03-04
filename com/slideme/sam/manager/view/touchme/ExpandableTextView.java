package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.slideme.sam.manager.C1608b;
import com.slideme.sam.manager.R;

public class ExpandableTextView extends JellyBeanSpanFixTextView {
    private int f3673a = 350;
    private boolean f3674b;
    private CharSequence f3675c;
    private Drawable f3676d;

    public ExpandableTextView(Context context) {
        super(context);
        m5944a(null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5944a(attributeSet);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5944a(attributeSet);
    }

    private void m5944a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1608b.ExpandableTextView);
            this.f3673a = obtainStyledAttributes.getInt(2, this.f3673a);
            setTextAppearance(getContext(), obtainStyledAttributes.getResourceId(0, 16842817));
            setTextColor(obtainStyledAttributes.getColor(1, 16842806));
            obtainStyledAttributes.recycle();
        }
        setLinkTextColor(getResources().getColor(R.color.accent));
        m5947b();
    }

    public void setCollapsedCharacterCount(int i) {
        this.f3673a = i;
    }

    public void m5946a() {
        this.f3674b = true;
        m5945a(BufferType.NORMAL);
    }

    public void m5947b() {
        this.f3674b = false;
        m5945a(BufferType.NORMAL);
    }

    public void m5948c() {
        if (this.f3674b) {
            m5947b();
        } else {
            m5946a();
        }
    }

    public boolean m5949d() {
        return this.f3674b;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        this.f3675c = charSequence;
        m5945a(bufferType);
        if (getBackground() != null) {
            this.f3676d = getBackground();
        }
        if (this.f3676d == null) {
            return;
        }
        if (m5950e()) {
            setBackgroundDrawable(this.f3676d);
        } else {
            setBackgroundDrawable(null);
        }
    }

    private void m5945a(BufferType bufferType) {
        CharSequence charSequence;
        int i = 0;
        if (!m5950e()) {
            charSequence = this.f3675c;
        } else if (this.f3674b) {
            charSequence = this.f3675c;
        } else {
            Object obj = this.f3675c.subSequence(0, this.f3673a) + "...";
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        Linkify.addLinks(spannableStringBuilder, 1);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
        int length = uRLSpanArr.length;
        while (i < length) {
            URLSpan uRLSpan = uRLSpanArr[i];
            int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
            int spanFlags = spannableStringBuilder.getSpanFlags(uRLSpan);
            C1977j c1977j = new C1977j(this, uRLSpan);
            spannableStringBuilder.removeSpan(uRLSpan);
            spannableStringBuilder.setSpan(c1977j, spanStart, spanEnd, spanFlags);
            i++;
        }
        if (((uRLSpanArr.length == 0 || this.f3674b) && uRLSpanArr.length != 0) || !m5950e()) {
            super.setText(spannableStringBuilder, bufferType);
            if (uRLSpanArr.length > 0) {
                setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
            return;
        }
        super.setText(charSequence, bufferType);
    }

    protected boolean m5950e() {
        return this.f3675c.length() > this.f3673a;
    }
}
