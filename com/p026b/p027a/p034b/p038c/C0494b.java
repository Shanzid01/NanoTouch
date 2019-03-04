package com.p026b.p027a.p034b.p038c;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: FadeInBitmapDisplayer */
public class C0494b implements C0493a {
    private final int f1453a;

    public Bitmap mo935a(Bitmap bitmap, ImageView imageView) {
        imageView.setImageBitmap(bitmap);
        C0494b.m3007a(imageView, this.f1453a);
        return bitmap;
    }

    public static void m3007a(ImageView imageView, int i) {
        Animation alphaAnimation = new AlphaAnimation(0.0f, TextTrackStyle.DEFAULT_FONT_SCALE);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        imageView.startAnimation(alphaAnimation);
    }
}
