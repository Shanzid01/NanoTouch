package com.mopub.mobileads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.mopub.common.p050b.C1481d;
import com.mopub.common.p050b.C1482e;

public class MraidVideoViewController extends BaseVideoViewController {
    private final VideoView f2350a;
    private ImageButton f2351b;
    private int f2352c;
    private int f2353d;

    MraidVideoViewController(Context context, Bundle bundle, long j, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        super(context, j, baseVideoViewControllerListener);
        this.f2350a = new VideoView(context);
        this.f2350a.setOnCompletionListener(new bq(this));
        this.f2350a.setOnErrorListener(new br(this));
        this.f2350a.setVideoPath(bundle.getString("video_url"));
    }

    void mo4124a() {
        super.mo4124a();
        this.f2353d = C1481d.m4060d(50.0f, m4291h());
        this.f2352c = C1481d.m4060d(8.0f, m4291h());
        m4381k();
        this.f2351b.setVisibility(8);
        this.f2350a.start();
    }

    VideoView mo4125b() {
        return this.f2350a;
    }

    void mo4128e() {
    }

    void mo4126c() {
    }

    void mo4127d() {
    }

    private void m4381k() {
        this.f2351b = new ImageButton(m4291h());
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, C1482e.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(m4291h()));
        stateListDrawable.addState(new int[]{16842919}, C1482e.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(m4291h()));
        this.f2351b.setImageDrawable(stateListDrawable);
        this.f2351b.setBackgroundDrawable(null);
        this.f2351b.setOnClickListener(new bs(this));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f2353d, this.f2353d);
        layoutParams.addRule(11);
        layoutParams.setMargins(this.f2352c, 0, this.f2352c, 0);
        m4292i().addView(this.f2351b, layoutParams);
    }
}
