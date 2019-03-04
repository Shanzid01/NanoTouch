package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.util.AttributeSet;

public class ThemePreference extends SamListPreference {
    public ThemePreference(Context context) {
        super(context);
        m5895a();
    }

    public ThemePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5895a();
    }

    private void m5895a() {
        setOnPreferenceChangeListener(new C1966h(this));
    }
}
