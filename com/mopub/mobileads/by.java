package com.mopub.mobileads;

import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mopub.common.p050b.C1481d;
import com.mopub.common.p050b.C1492o;
import com.mopub.mobileads.resource.TextDrawable;

/* compiled from: ToolbarWidget */
class by extends RelativeLayout {
    private TextView f2472a;
    private ImageView f2473b;
    private final int f2474c;
    private final int f2475d;
    private final int f2476e;

    private by(bz bzVar) {
        super(bzVar.f2477a);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, bzVar.f2478b);
        layoutParams.gravity = bzVar.f2479c;
        setLayoutParams(layoutParams);
        this.f2474c = C1481d.m4058b(5.0f, getContext());
        this.f2475d = C1481d.m4058b(5.0f, getContext());
        this.f2476e = C1481d.m4058b(37.0f, getContext());
        setVisibility(bzVar.f2485i);
        if (bzVar.f2482f && bzVar.f2483g != null) {
            this.f2473b = new ImageView(getContext());
            this.f2473b.setId((int) C1492o.m4089a());
            layoutParams = new RelativeLayout.LayoutParams(this.f2476e, this.f2476e);
            layoutParams.addRule(15);
            layoutParams.addRule(bzVar.f2487k);
            this.f2473b.setPadding(this.f2475d, this.f2475d, this.f2475d, this.f2475d);
            this.f2473b.setBackgroundColor(-16777216);
            this.f2473b.getBackground().setAlpha(0);
            this.f2473b.setImageDrawable(bzVar.f2483g);
            addView(this.f2473b, layoutParams);
        }
        if (bzVar.f2480d) {
            this.f2472a = new TextView(getContext());
            this.f2472a.setSingleLine();
            this.f2472a.setEllipsize(TruncateAt.END);
            this.f2472a.setText(bzVar.f2481e);
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            if (this.f2473b != null) {
                layoutParams.addRule(0, this.f2473b.getId());
            } else {
                layoutParams.addRule(bzVar.f2486j);
            }
            this.f2472a.setPadding(this.f2474c, this.f2474c, this.f2474c, this.f2474c);
            addView(this.f2472a, layoutParams);
        }
        if (bzVar.f2484h != null) {
            setOnTouchListener(bzVar.f2484h);
        }
    }

    void m4604a(String str) {
        if (this.f2472a != null) {
            this.f2472a.setText(str);
        }
    }

    void m4605b(String str) {
        try {
            ((TextDrawable) this.f2473b.getDrawable()).updateText(str);
        } catch (Exception e) {
            Log.d("MoPub", "Unable to update ToolbarWidget text.");
        }
    }
}
