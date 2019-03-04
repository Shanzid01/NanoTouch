package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.slideme.sam.manager.R;

public class ScreenshotsSeekBarPreference extends SeekBarPreference {
    public ScreenshotsSeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScreenshotsSeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void mo4332a() {
        this.a = getContext().getResources().getInteger(R.integer.default_settings_general_screenshot_count);
        this.b = 2;
        super.mo4332a();
    }
}
