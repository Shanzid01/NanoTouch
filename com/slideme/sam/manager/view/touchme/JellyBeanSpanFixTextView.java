package com.slideme.sam.manager.view.touchme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"WrongCall"})
public class JellyBeanSpanFixTextView extends TextView {
    private static final String f3672a = JellyBeanSpanFixTextView.class.getSimpleName();

    public JellyBeanSpanFixTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public JellyBeanSpanFixTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JellyBeanSpanFixTextView(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException e) {
            m5937a(i, i2);
        }
    }

    private void m5937a(int i, int i2) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            m5939a(new SpannableStringBuilder(text), i, i2);
        } else {
            m5943b(i, i2);
        }
    }

    private void m5939a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        System.currentTimeMillis();
        C1982p b = m5942b(spannableStringBuilder, i, i2);
        if (b.f3837a) {
            m5938a(i, i2, spannableStringBuilder, b);
        } else {
            m5943b(i, i2);
        }
    }

    private C1982p m5942b(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        int i3 = 0;
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
        List arrayList = new ArrayList(spans.length);
        List arrayList2 = new ArrayList(spans.length);
        int length = spans.length;
        while (i3 < length) {
            Object obj = spans[i3];
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            if (m5941a((CharSequence) spannableStringBuilder, spanStart - 1)) {
                spannableStringBuilder.insert(spanStart, " ");
                arrayList.add(obj);
            }
            spanStart = spannableStringBuilder.getSpanEnd(obj);
            if (m5941a((CharSequence) spannableStringBuilder, spanStart)) {
                spannableStringBuilder.insert(spanStart, " ");
                arrayList2.add(obj);
            }
            try {
                m5940a((CharSequence) spannableStringBuilder, i, i2);
                return C1982p.m6112a(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e) {
                i3++;
            }
        }
        return C1982p.m6111a();
    }

    private boolean m5941a(CharSequence charSequence, int i) {
        if (i >= 0 && charSequence.charAt(i) == ' ') {
            return false;
        }
        return true;
    }

    private void m5940a(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        super.onMeasure(i, i2);
    }

    private void m5938a(int i, int i2, SpannableStringBuilder spannableStringBuilder, C1982p c1982p) {
        for (Object spanEnd : c1982p.f3839c) {
            int spanEnd2 = spannableStringBuilder.getSpanEnd(spanEnd);
            spannableStringBuilder.delete(spanEnd2, spanEnd2 + 1);
            try {
                m5940a((CharSequence) spannableStringBuilder, i, i2);
            } catch (IndexOutOfBoundsException e) {
                spannableStringBuilder.insert(spanEnd2, " ");
            }
        }
        Object obj = 1;
        for (Object obj2 : c1982p.f3838b) {
            int spanStart = spannableStringBuilder.getSpanStart(obj2);
            spannableStringBuilder.delete(spanStart - 1, spanStart);
            try {
                m5940a((CharSequence) spannableStringBuilder, i, i2);
                obj2 = null;
            } catch (IndexOutOfBoundsException e2) {
                spannableStringBuilder.insert(spanStart - 1, " ");
                obj2 = 1;
            }
        }
        if (obj2 != null) {
            setText(spannableStringBuilder);
            super.onMeasure(i, i2);
        }
    }

    private void m5943b(int i, int i2) {
        m5940a(getText().toString(), i, i2);
    }
}
