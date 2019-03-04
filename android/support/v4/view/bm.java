package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* compiled from: ViewCompatHC */
class bm {
    static long m745a() {
        return ValueAnimator.getFrameDelay();
    }

    public static float m744a(View view) {
        return view.getAlpha();
    }

    public static void m747a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m748b(View view) {
        return view.getLayerType();
    }

    public static float m750c(View view) {
        return view.getTranslationX();
    }

    public static float m752d(View view) {
        return view.getTranslationY();
    }

    public static float m754e(View view) {
        return view.getScaleX();
    }

    public static void m746a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void m749b(View view, float f) {
        view.setTranslationY(f);
    }

    public static void m751c(View view, float f) {
        view.setAlpha(f);
    }

    public static void m753d(View view, float f) {
        view.setScaleX(f);
    }

    public static void m755e(View view, float f) {
        view.setScaleY(f);
    }
}
