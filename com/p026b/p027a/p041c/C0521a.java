package com.p026b.p027a.p041c;

import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.google.android.gms.cast.TextTrackStyle;
import com.p026b.p027a.p034b.p035a.C0478f;
import com.p026b.p027a.p034b.p035a.C0484l;
import java.lang.reflect.Field;

/* compiled from: ImageSizeUtils */
public final class C0521a {
    public static C0478f m3146a(ImageView imageView, int i, int i2) {
        int i3 = 0;
        DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
        LayoutParams layoutParams = imageView.getLayoutParams();
        int width = layoutParams.width == -2 ? 0 : imageView.getWidth();
        if (width <= 0) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = C0521a.m3145a(imageView, "mMaxWidth");
        }
        if (width <= 0) {
            width = i;
        }
        if (width <= 0) {
            width = displayMetrics.widthPixels;
        }
        if (layoutParams.height != -2) {
            i3 = imageView.getHeight();
        }
        if (i3 <= 0) {
            i3 = layoutParams.height;
        }
        if (i3 <= 0) {
            i3 = C0521a.m3145a(imageView, "mMaxHeight");
        }
        if (i3 <= 0) {
            i3 = i2;
        }
        if (i3 <= 0) {
            i3 = displayMetrics.heightPixels;
        }
        return new C0478f(width, i3);
    }

    private static int m3145a(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue > 0 && intValue < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                return intValue;
            }
        } catch (Throwable e) {
            C0524d.m3152a(e);
        }
        return 0;
    }

    public static int m3144a(C0478f c0478f, C0478f c0478f2, C0484l c0484l, boolean z) {
        int a = c0478f.m2967a();
        int b = c0478f.m2970b();
        int a2 = c0478f2.m2967a();
        int b2 = c0478f2.m2970b();
        int i = a / a2;
        int i2 = b / b2;
        switch (C0522b.f1594a[c0484l.ordinal()]) {
            case 1:
                if (!z) {
                    b = Math.max(i, i2);
                    break;
                }
                i = a;
                a = b;
                b = 1;
                while (true) {
                    if (i / 2 < a2 && a / 2 < b2) {
                        break;
                    }
                    i /= 2;
                    a /= 2;
                    b *= 2;
                }
                break;
            case 2:
                if (!z) {
                    b = Math.min(i, i2);
                    break;
                }
                i = a;
                a = b;
                b = 1;
                while (i / 2 >= a2 && a / 2 >= b2) {
                    i /= 2;
                    a /= 2;
                    b *= 2;
                }
                break;
            default:
                b = 1;
                break;
        }
        if (b < 1) {
            return 1;
        }
        return b;
    }

    public static float m3147b(C0478f c0478f, C0478f c0478f2, C0484l c0484l, boolean z) {
        int i;
        int a = c0478f.m2967a();
        int b = c0478f.m2970b();
        int a2 = c0478f2.m2967a();
        int b2 = c0478f2.m2970b();
        float f = ((float) a) / ((float) a2);
        float f2 = ((float) b) / ((float) b2);
        if ((c0484l != C0484l.FIT_INSIDE || f < f2) && (c0484l != C0484l.CROP || f >= f2)) {
            i = (int) (((float) a) / f2);
            a2 = b2;
        } else {
            i = a2;
            a2 = (int) (((float) b) / f);
        }
        if ((z || i >= a || r1 >= b) && (!z || i == a || r1 == b)) {
            return TextTrackStyle.DEFAULT_FONT_SCALE;
        }
        return ((float) i) / ((float) a);
    }
}
