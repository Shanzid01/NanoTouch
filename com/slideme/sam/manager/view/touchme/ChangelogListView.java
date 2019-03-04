package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Changelog;
import com.slideme.sam.manager.view.C1950a;
import java.util.ArrayList;
import java.util.Date;

public class ChangelogListView extends LinearLayout {
    private Changelog f3657a;

    public ChangelogListView(Context context) {
        super(context);
    }

    public ChangelogListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangelogListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void m5914a(Changelog changelog) {
        this.f3657a = changelog;
    }

    public void m5913a() {
        removeAllViews();
        ArrayList changes = this.f3657a.getChanges();
        for (int i = 0; i < this.f3657a.getCount(); i++) {
            String[] strArr = (String[]) changes.get(i);
            ViewGroup viewGroup = (ViewGroup) inflate(getContext(), R.layout.permission_item, null);
            TextView textView = (TextView) viewGroup.findViewById(R.id.permDesc);
            ((TextView) viewGroup.findViewById(R.id.permLab)).setText(C1950a.m5859a(getContext(), new Date(Long.valueOf(strArr[0]).longValue() * 1000)));
            textView.setText(C1950a.m5855a(strArr[1]));
            addView(viewGroup);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("STATE_SUPERSTATE", super.onSaveInstanceState());
        bundle.putParcelable("STATE_CHANGELOG", this.f3657a);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("STATE_SUPERSTATE"));
            this.f3657a = (Changelog) bundle.getParcelable("STATE_CHANGELOG");
        }
    }
}
