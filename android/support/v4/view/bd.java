package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

/* compiled from: ViewCompat */
class bd extends bc {
    bd() {
    }

    long mo282a() {
        return bm.m745a();
    }

    public float mo267f(View view) {
        return bm.m744a(view);
    }

    public void mo250a(View view, int i, Paint paint) {
        bm.m747a(view, i, paint);
    }

    public int mo269g(View view) {
        return bm.m748b(view);
    }

    public void mo251a(View view, Paint paint) {
        mo250a(view, mo269g(view), paint);
        view.invalidate();
    }

    public float mo275m(View view) {
        return bm.m750c(view);
    }

    public float mo276n(View view) {
        return bm.m752d(view);
    }

    public void mo257b(View view, float f) {
        bm.m746a(view, f);
    }

    public void mo260c(View view, float f) {
        bm.m749b(view, f);
    }

    public void mo264d(View view, float f) {
        bm.m751c(view, f);
    }

    public void mo266e(View view, float f) {
        bm.m753d(view, f);
    }

    public void mo268f(View view, float f) {
        bm.m755e(view, f);
    }

    public float mo277o(View view) {
        return bm.m754e(view);
    }
}
