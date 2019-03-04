package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.auth.AuthData;
import com.slideme.sam.manager.model.data.test.ScoreCardData;
import com.slideme.sam.manager.model.data.test.ScoreCardItem;
import com.slideme.sam.manager.util.C1922m;
import java.util.ArrayList;

/* compiled from: ScorecardView */
public class aj extends BaseAdapter {
    final /* synthetic */ ScorecardView f3776a;
    private Context f3777b;
    private ArrayList<ScoreCardItem> f3778c;
    private ArrayList<ScoreCardItem> f3779d;
    private ArrayList<ScoreCardItem> f3780e;
    private int f3781f = 0;
    private int f3782g = 0;
    private int f3783h = 0;

    public /* synthetic */ Object getItem(int i) {
        return m6070a(i);
    }

    public aj(ScorecardView scorecardView, Context context, ArrayList<ScoreCardItem> arrayList, ArrayList<ScoreCardItem> arrayList2, ArrayList<ScoreCardItem> arrayList3) {
        this.f3776a = scorecardView;
        this.f3777b = context;
        if (arrayList != null) {
            this.f3778c = arrayList;
            this.f3781f = arrayList.size();
        }
        if (arrayList2 != null) {
            this.f3779d = arrayList2;
            this.f3782g = arrayList2.size();
        }
        if (arrayList3 != null) {
            this.f3780e = arrayList3;
            this.f3783h = arrayList3.size();
        }
    }

    public ScoreCardData m6069a() {
        ScoreCardData scoreCardData = new ScoreCardData();
        scoreCardData.uid = Integer.parseInt(AuthData.m4810f(this.f3777b));
        scoreCardData.developer = this.f3779d;
        scoreCardData.tester = this.f3780e;
        scoreCardData.global = this.f3778c;
        return scoreCardData;
    }

    public int getCount() {
        return (this.f3781f + this.f3782g) + this.f3783h;
    }

    public ScoreCardItem m6070a(int i) {
        if (i <= this.f3781f - 1) {
            return (ScoreCardItem) this.f3778c.get(i);
        }
        if (i <= (this.f3781f + this.f3782g) - 1) {
            return (ScoreCardItem) this.f3779d.get(i - this.f3781f);
        }
        if (i <= ((this.f3781f + this.f3782g) + this.f3783h) - 1) {
            return (ScoreCardItem) this.f3780e.get((i - this.f3781f) - this.f3782g);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) m6070a(i).id;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ScoreCardItem a = m6070a(i);
        if (ScoreCardItem.TYPE_SLIDER.equals(a.type)) {
            view = ((LayoutInflater) this.f3776a.getContext().getSystemService("layout_inflater")).inflate(R.layout.listitem_scorecard_slider, null);
            TextView textView = (TextView) view.findViewById(R.id.scoreText);
            if (a.answer != null) {
                textView.setText(a.answer + " / 10");
                ((SeekBar) view.findViewById(R.id.score)).setProgress(a.answer.intValue());
            }
            ((SeekBar) view.findViewById(R.id.score)).setOnSeekBarChangeListener(new ak(this, a, textView));
        } else if (ScoreCardItem.TYPE_RADIO.equals(a.type) && !C1922m.m5794a(a.options)) {
            view = ((LayoutInflater) this.f3776a.getContext().getSystemService("layout_inflater")).inflate(R.layout.listitem_scorecard_radio, null);
            RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
            int i2 = 0;
            while (i2 < a.options.size()) {
                boolean z;
                String str = (String) a.options.get(i2);
                if (a.answer == null || a.answer.intValue() != i2) {
                    z = false;
                } else {
                    z = true;
                }
                radioGroup.addView(m6068a(str, i2, z));
                i2++;
            }
            radioGroup.setOnCheckedChangeListener(new al(this, a));
        }
        ((TextView) view.findViewById(R.id.title)).setText(a.title);
        ((TextView) view.findViewById(R.id.descr)).setText(a.description);
        return view;
    }

    private RadioButton m6068a(String str, int i, boolean z) {
        RadioButton radioButton = new RadioButton(this.f3777b);
        radioButton.setText(str);
        radioButton.setId(i);
        radioButton.setSelected(z);
        return radioButton;
    }
}
