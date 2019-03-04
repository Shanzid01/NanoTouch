package com.slideme.sam.manager.view.featured;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.games.quest.Quests;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.dynamic.child.AdProxyChild;
import com.slideme.sam.manager.model.data.dynamic.child.LayoutChild;
import com.slideme.sam.manager.model.data.dynamic.child.SetChild;
import com.slideme.sam.manager.view.extensions.ForegroundImageView;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* compiled from: DynamicLayoutGridView */
public class C1958c extends BaseAdapter {
    final /* synthetic */ DynamicLayoutGridView f3612a;

    public /* synthetic */ Object getItem(int i) {
        return m5873a(i);
    }

    public C1958c(DynamicLayoutGridView dynamicLayoutGridView) {
        this.f3612a = dynamicLayoutGridView;
    }

    public int getCount() {
        if (this.f3612a.f3604a == null || this.f3612a.f3604a.banners == null) {
            return 0;
        }
        return this.f3612a.f3604a.banners.getSorted().size();
    }

    public LayoutChild m5873a(int i) {
        if (this.f3612a.f3604a == null || this.f3612a.f3604a.banners == null) {
            return null;
        }
        return (LayoutChild) this.f3612a.f3604a.banners.getSorted().get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutChild layoutChild = (LayoutChild) this.f3612a.f3605b.get(i);
        view = (RelativeLayout) view;
        if (view == null) {
            view = new RelativeLayout(this.f3612a.getContext());
            View foregroundImageView = new ForegroundImageView(this.f3612a.getContext());
            foregroundImageView.setLayoutParams(new LayoutParams(-1, -1));
            foregroundImageView.setAdjustViewBounds(true);
            foregroundImageView.setScaleType(ScaleType.FIT_CENTER);
            foregroundImageView.setId(100);
            view.addView(foregroundImageView, new RelativeLayout.LayoutParams(-1, -1));
            foregroundImageView = new TextView(this.f3612a.getContext());
            foregroundImageView.setBackgroundColor(Color.parseColor("#CC000000"));
            foregroundImageView.setGravity(17);
            foregroundImageView.setPadding(0, 4, 0, 4);
            foregroundImageView.setVisibility(8);
            foregroundImageView.setId(Quests.SELECT_COMPLETED_UNCLAIMED);
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            view.addView(foregroundImageView, layoutParams);
        }
        if (layoutChild instanceof AdProxyChild) {
            AdProxyChild adProxyChild = (AdProxyChild) layoutChild;
            if (adProxyChild != null && ((adProxyChild.isReward() || adProxyChild.isShare()) && adProxyChild.payout > 0.0d)) {
                TextView textView = (TextView) view.findViewById(Quests.SELECT_COMPLETED_UNCLAIMED);
                textView.setText(new StringBuilder(String.valueOf(this.f3612a.getResources().getString(R.string.earn))).append(" ").append(SAM.f2616i.m5487a(new BigDecimal(adProxyChild.payout * ((double) (SAM.f2619l.m5428b() / 100.0f))).setScale(2, RoundingMode.HALF_UP).doubleValue())).toString());
                textView.setVisibility(0);
            }
        } else if ((layoutChild instanceof SetChild) && ((SetChild) layoutChild).data.contains("shareandearn")) {
            view.setId(R.id.showcase_item);
        }
        layoutChild.setBanner(this.f3612a.f3606c, (ForegroundImageView) view.findViewById(100), this.f3612a.f3607d);
        return view;
    }
}
