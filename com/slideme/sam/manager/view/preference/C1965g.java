package com.slideme.sam.manager.view.preference;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/* compiled from: SeekBarPreference */
class C1965g implements OnSeekBarChangeListener {
    final /* synthetic */ SeekBarPreference f3642a;
    private final /* synthetic */ TextView f3643b;

    C1965g(SeekBarPreference seekBarPreference, TextView textView) {
        this.f3642a = seekBarPreference;
        this.f3643b = textView;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int i2 = (i + 1) * this.f3642a.f3613a;
        this.f3643b.setText(i2);
        this.f3642a.f3615c = i2;
    }
}
