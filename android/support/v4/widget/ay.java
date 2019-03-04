package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: SlidingPaneLayout */
class ay extends ax {
    private Method f446a;
    private Field f447b;

    ay() {
        try {
            this.f446a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.f447b = View.class.getDeclaredField("mRecreateDisplayList");
            this.f447b.setAccessible(true);
        } catch (Throwable e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    public void mo360a(SlidingPaneLayout slidingPaneLayout, View view) {
        if (this.f446a == null || this.f447b == null) {
            view.invalidate();
            return;
        }
        try {
            this.f447b.setBoolean(view, true);
            this.f446a.invoke(view, (Object[]) null);
        } catch (Throwable e) {
            Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
        }
        super.mo360a(slidingPaneLayout, view);
    }
}
