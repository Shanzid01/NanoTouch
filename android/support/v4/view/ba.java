package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
class ba implements bi {
    WeakHashMap<View, cr> f226a = null;

    ba() {
    }

    public boolean mo256a(View view, int i) {
        return false;
    }

    public boolean mo259b(View view, int i) {
        return false;
    }

    public int mo247a(View view) {
        return 2;
    }

    public void mo252a(View view, C0120a c0120a) {
    }

    public boolean mo258b(View view) {
        return false;
    }

    public boolean mo262c(View view) {
        return false;
    }

    public void mo263d(View view) {
        view.invalidate();
    }

    public void mo249a(View view, int i, int i2, int i3, int i4) {
        view.invalidate(i, i2, i3, i4);
    }

    public void mo253a(View view, Runnable runnable) {
        view.postDelayed(runnable, mo282a());
    }

    public void mo254a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, mo282a() + j);
    }

    long mo282a() {
        return 10;
    }

    public int mo265e(View view) {
        return 0;
    }

    public void mo261c(View view, int i) {
    }

    public float mo267f(View view) {
        return TextTrackStyle.DEFAULT_FONT_SCALE;
    }

    public void mo250a(View view, int i, Paint paint) {
    }

    public int mo269g(View view) {
        return 0;
    }

    public void mo251a(View view, Paint paint) {
    }

    public int mo270h(View view) {
        return 0;
    }

    public ViewParent mo271i(View view) {
        return view.getParent();
    }

    public boolean mo272j(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public int mo273k(View view) {
        return view.getPaddingLeft();
    }

    public int mo274l(View view) {
        return view.getPaddingRight();
    }

    public float mo275m(View view) {
        return 0.0f;
    }

    public float mo276n(View view) {
        return 0.0f;
    }

    public float mo277o(View view) {
        return 0.0f;
    }

    public int mo278p(View view) {
        return 0;
    }

    public int mo279q(View view) {
        return 0;
    }

    public cr mo280r(View view) {
        return new cr(view);
    }

    public void mo257b(View view, float f) {
    }

    public void mo260c(View view, float f) {
    }

    public void mo264d(View view, float f) {
    }

    public void mo266e(View view, float f) {
    }

    public void mo268f(View view, float f) {
    }

    public void mo248a(View view, float f) {
    }

    public void mo255a(ViewGroup viewGroup, boolean z) {
    }

    public boolean mo281s(View view) {
        return false;
    }
}
