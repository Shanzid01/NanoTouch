package com.slideme.sam.manager.view.p064a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.extensions.ForegroundImageView;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

/* compiled from: ScreenshotGalleryAdapter */
public class C1945p extends BaseAdapter {
    private ApplicationHolder f3582a;
    private Activity f3583b;
    private boolean f3584c;
    private int f3585d;
    private SafeViewFlipper f3586e;
    private C1948s f3587f;
    private int f3588g = 0;

    public C1945p(Activity activity, ApplicationHolder applicationHolder, SafeViewFlipper safeViewFlipper) {
        int f;
        int size;
        int i = 1;
        this.f3583b = activity;
        this.f3582a = applicationHolder;
        this.f3586e = safeViewFlipper;
        this.f3584c = !TextUtils.isEmpty(this.f3582a.app.videoURL);
        if (SAM.f2613f.m5448e()) {
            f = SAM.f2613f.m5449f();
        } else {
            f = -1;
        }
        if (this.f3582a.app.resources.screenshots != null) {
            size = this.f3582a.app.resources.screenshots.size();
        } else {
            size = 0;
        }
        this.f3585d = f == -1 ? size : Math.min(size, f);
        f = this.f3585d;
        if (!this.f3584c) {
            i = 0;
        }
        this.f3585d = f + i;
        this.f3587f = new C1948s();
    }

    public int getCount() {
        return this.f3585d;
    }

    public Object getItem(int i) {
        return this.f3582a.app.resources.screenshots.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View foregroundImageView;
        if (view == null) {
            foregroundImageView = new ForegroundImageView(this.f3583b);
            foregroundImageView.setScaleType(ScaleType.CENTER_INSIDE);
            foregroundImageView.setAdjustViewBounds(true);
            foregroundImageView.setLayoutParams(new LayoutParams(-2, -2));
            foregroundImageView.setFocusable(true);
        } else {
            foregroundImageView = view;
        }
        try {
            if (this.f3584c && i == 0) {
                ((ForegroundImageView) foregroundImageView).setForeground(R.drawable.fg_touchable_video);
                this.f3582a.setImage((ImageView) foregroundImageView, this.f3582a.app.videoThumb, 0, this.f3587f, false);
                foregroundImageView.setOnClickListener(new C1946q(this));
                return foregroundImageView;
            }
            ((ForegroundImageView) foregroundImageView).setForeground(R.drawable.fg_touchable_image);
            if (this.f3584c) {
                i--;
            }
            this.f3582a.setImage((ImageView) foregroundImageView, (String) this.f3582a.app.resources.screenshots.get(i), 0, this.f3587f, false);
            foregroundImageView.setOnClickListener(new C1947r(this, i));
            return foregroundImageView;
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
    }

    private void m5848a() {
        this.f3588g++;
        if (this.f3586e.getDisplayedChild() == 0 && this.f3588g >= getCount()) {
            this.f3586e.setDisplayedChild(1);
        }
    }
}
