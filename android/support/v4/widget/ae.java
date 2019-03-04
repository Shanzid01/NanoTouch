package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* compiled from: MaterialProgressDrawable */
class ae implements Callback {
    final /* synthetic */ ab f415a;

    ae(ab abVar) {
        this.f415a = abVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f415a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f415a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f415a.unscheduleSelf(runnable);
    }
}
