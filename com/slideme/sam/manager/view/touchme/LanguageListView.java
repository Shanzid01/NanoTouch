package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.util.C1919j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class LanguageListView extends LinearLayout {
    private List<String> f3703a;

    public LanguageListView(Context context) {
        super(context);
    }

    public LanguageListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LanguageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void m5974a(List<String> list) {
        if (list == null) {
            list = new ArrayList();
        }
        this.f3703a = list;
        Collections.sort(this.f3703a, new C1983q(this));
        C1919j.m5777a(this.f3703a);
        m5973a();
    }

    public void m5973a() {
        for (String str : this.f3703a) {
            Locale locale;
            View textView = new TextView(getContext());
            int applyDimension = (int) TypedValue.applyDimension(1, 8.0f, getResources().getDisplayMetrics());
            textView.setPadding(applyDimension, applyDimension / 2, applyDimension, applyDimension / 2);
            String[] split = str.split("_");
            switch (split.length) {
                case 1:
                    locale = new Locale(split[0]);
                    textView.setText(locale.getDisplayLanguage());
                    break;
                case 2:
                    locale = new Locale(split[0], split[1]);
                    textView.setText(locale.getDisplayLanguage() + " (" + locale.getDisplayCountry() + ")");
                    break;
                case 3:
                    locale = new Locale(split[0], split[1], split[2]);
                    textView.setText(locale.getDisplayLanguage() + " (" + locale.getDisplayCountry() + "-" + locale.getDisplayVariant() + ")");
                    break;
                default:
                    continue;
            }
            if (locale.getISO3Language().equals(Locale.getDefault().getISO3Language())) {
                textView.setTextAppearance(getContext(), R.style.TextAppearance.Large.Slideme);
                textView.setTypeface(textView.getTypeface(), 1);
            } else {
                textView.setTextAppearance(getContext(), R.style.TextAppearance.Medium.Slideme);
            }
            addView(textView);
        }
    }
}
