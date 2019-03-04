package android.support.v4.widget;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: DrawerLayoutCompatApi21 */
class C0166u implements OnApplyWindowInsetsListener {
    C0166u() {
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((C0146v) view).mo332a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
