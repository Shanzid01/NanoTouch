package com.slideme.sam.manager.view.p064a;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.view.C1950a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReviewListAdapter */
public class C1942l extends BaseAdapter {
    private FragmentActivity f3567a;
    private List<Review> f3568b;
    private LayoutInflater f3569c;
    private View f3570d;
    private int f3571e = 0;
    private boolean f3572f = false;

    public void m5847a(boolean z) {
        this.f3572f = z;
    }

    public C1942l(FragmentActivity fragmentActivity, List<Review> list, int i) {
        this.f3567a = fragmentActivity;
        if (list != null) {
            this.f3568b = list;
        } else {
            this.f3568b = new ArrayList();
        }
        this.f3569c = (LayoutInflater) this.f3567a.getSystemService("layout_inflater");
        this.f3571e = i;
        this.f3570d = this.f3569c.inflate(R.layout.listitem_loading_indicator, null);
    }

    public int getCount() {
        int size = this.f3568b.size();
        int i = (this.f3568b.size() <= 0 || !this.f3572f) ? 0 : 1;
        return i + size;
    }

    public Object getItem(int i) {
        return this.f3568b.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        if (i == this.f3568b.size()) {
            return this.f3570d;
        }
        C1944n c1944n;
        int i3;
        if (view == null || (view instanceof LinearLayout)) {
            view = this.f3569c.inflate(R.layout.review_list_item, null);
            c1944n = new C1944n();
            c1944n.f3577c = (TextView) view.findViewById(R.id.versionIndicator);
            c1944n.f3575a = (RatingBar) view.findViewById(R.id.rating);
            c1944n.f3576b = (TextView) view.findViewById(R.id.text);
            c1944n.f3578d = (TextView) view.findViewById(R.id.date);
            c1944n.f3579e = (TextView) view.findViewById(R.id.user);
            c1944n.f3580f = (TextView) view.findViewById(R.id.thumbs);
            view.setTag(c1944n);
        } else {
            c1944n = (C1944n) view.getTag();
        }
        int applyDimension = (int) TypedValue.applyDimension(1, 8.0f, this.f3567a.getResources().getDisplayMetrics());
        view.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        Review review = (Review) this.f3568b.get(i);
        c1944n.f3578d.setText(C1950a.m5859a(this.f3567a, review.lastUpdated));
        c1944n.f3575a.setRating(review.rating / 20.0f);
        c1944n.f3575a.setVisibility(review.rating > 0.0f ? 0 : 4);
        c1944n.f3576b.setText(C1950a.m5855a(review.text).toString().trim());
        c1944n.f3579e.setText(review.username);
        TextView textView = c1944n.f3577c;
        Resources resources = this.f3567a.getResources();
        if (this.f3571e > review.appVersionCode) {
            i3 = R.string.olderVersion;
        } else {
            i3 = R.string.currentVersion;
        }
        textView.setText(resources.getString(i3));
        StringBuilder stringBuilder = new StringBuilder();
        if (review.thumbScore > 0) {
            stringBuilder.append("+");
            stringBuilder.append(review.thumbScore);
        } else if (review.thumbScore == 0) {
            stringBuilder.append(" ");
            stringBuilder.append(review.thumbScore);
        } else {
            stringBuilder.append(review.thumbScore);
        }
        c1944n.f3580f.setText(stringBuilder.toString());
        textView = c1944n.f3580f;
        resources = this.f3567a.getResources();
        i3 = review.thumbScore > 0 ? R.color.green : review.thumbScore == 0 ? 17170448 : R.color.red;
        textView.setTextColor(resources.getColor(i3));
        if (review.promoted) {
            i2 = 1;
        }
        c1944n.f3576b.setTypeface(null, i2);
        c1944n.f3577c.setTypeface(null, i2);
        c1944n.f3578d.setTypeface(null, i2);
        c1944n.f3579e.setTypeface(null, i2);
        c1944n.f3580f.setOnClickListener(new C1943m(this, i));
        return view;
    }
}
