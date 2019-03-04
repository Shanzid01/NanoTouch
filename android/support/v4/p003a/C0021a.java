package android.support.v4.p003a;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

/* compiled from: ParcelableCompat */
public class C0021a {
    public static <T> Creator<T> m47a(C0023c<T> c0023c) {
        if (VERSION.SDK_INT >= 13) {
            C0025e.m50a(c0023c);
        }
        return new C0022b(c0023c);
    }
}
