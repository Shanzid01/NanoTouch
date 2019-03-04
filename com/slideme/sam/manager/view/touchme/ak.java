package com.slideme.sam.manager.view.touchme;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.slideme.sam.manager.model.data.test.ScoreCardItem;

/* compiled from: ScorecardView */
class ak implements OnSeekBarChangeListener {
    final /* synthetic */ aj f3784a;
    private final /* synthetic */ ScoreCardItem f3785b;
    private final /* synthetic */ TextView f3786c;

    ak(aj ajVar, ScoreCardItem scoreCardItem, TextView textView) {
        this.f3784a = ajVar;
        this.f3785b = scoreCardItem;
        this.f3786c = textView;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f3785b.answer = Integer.valueOf(i + 1);
        this.f3786c.setText((i + 1) + " / 10");
    }
}
