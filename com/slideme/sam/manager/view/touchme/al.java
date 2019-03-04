package com.slideme.sam.manager.view.touchme;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.slideme.sam.manager.model.data.test.ScoreCardItem;

/* compiled from: ScorecardView */
class al implements OnCheckedChangeListener {
    final /* synthetic */ aj f3787a;
    private final /* synthetic */ ScoreCardItem f3788b;

    al(aj ajVar, ScoreCardItem scoreCardItem) {
        this.f3787a = ajVar;
        this.f3788b = scoreCardItem;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.f3788b.answer = Integer.valueOf(i);
    }
}
