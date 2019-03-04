package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.slideme.sam.manager.R;

public class AppsSeekBarPreference extends SeekBarPreference {
    public AppsSeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppsSeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void mo4332a() {
        this.a = getContext().getResources().getInteger(R.integer.default_settings_general_apps_per_page);
        this.b = 2;
        super.mo4332a();
    }
}
