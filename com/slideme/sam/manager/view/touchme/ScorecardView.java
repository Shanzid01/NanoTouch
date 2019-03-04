package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.slideme.sam.manager.model.data.test.ScoreCardData;
import com.slideme.sam.manager.model.data.test.ScoreCardItem;
import java.util.ArrayList;

public class ScorecardView extends ListView {
    public ScorecardView(Context context) {
        super(context);
    }

    public ScorecardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScorecardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void m6027a(Context context, ArrayList<ScoreCardItem> arrayList, ArrayList<ScoreCardItem> arrayList2, ArrayList<ScoreCardItem> arrayList3) {
        setAdapter(new aj(this, context, arrayList, arrayList2, arrayList3));
    }

    public ScoreCardData m6026a() {
        return ((aj) getAdapter()).m6069a();
    }
}
