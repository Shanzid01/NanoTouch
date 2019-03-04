package android.support.v4.view.p005a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.google.android.gms.location.places.Place;

/* compiled from: AccessibilityNodeInfoCompat */
public class C0098e {
    private static final C0099h f205a;
    private final Object f206b;

    static {
        if (VERSION.SDK_INT >= 21) {
            f205a = new C0105f();
        } else if (VERSION.SDK_INT >= 19) {
            f205a = new C0104k();
        } else if (VERSION.SDK_INT >= 18) {
            f205a = new C0103j();
        } else if (VERSION.SDK_INT >= 16) {
            f205a = new C0102i();
        } else if (VERSION.SDK_INT >= 14) {
            f205a = new C0101g();
        } else {
            f205a = new C0100l();
        }
    }

    static C0098e m236a(Object obj) {
        if (obj != null) {
            return new C0098e(obj);
        }
        return null;
    }

    public C0098e(Object obj) {
        this.f206b = obj;
    }

    public Object m239a() {
        return this.f206b;
    }

    public static C0098e m235a(C0098e c0098e) {
        return C0098e.m236a(f205a.mo179a(c0098e.f206b));
    }

    public void m242a(View view) {
        f205a.mo195c(this.f206b, view);
    }

    public void m248b(View view) {
        f205a.mo182a(this.f206b, view);
    }

    public int m245b() {
        return f205a.mo186b(this.f206b);
    }

    public void m240a(int i) {
        f205a.mo180a(this.f206b, i);
    }

    public void m246b(int i) {
        f205a.mo187b(this.f206b, i);
    }

    public int m252c() {
        return f205a.mo219r(this.f206b);
    }

    public void m254c(View view) {
        f205a.mo189b(this.f206b, view);
    }

    public void m241a(Rect rect) {
        f205a.mo181a(this.f206b, rect);
    }

    public void m247b(Rect rect) {
        f205a.mo194c(this.f206b, rect);
    }

    public void m253c(Rect rect) {
        f205a.mo188b(this.f206b, rect);
    }

    public void m258d(Rect rect) {
        f205a.mo199d(this.f206b, rect);
    }

    public boolean m260d() {
        return f205a.mo206g(this.f206b);
    }

    public boolean m262e() {
        return f205a.mo208h(this.f206b);
    }

    public boolean m264f() {
        return f205a.mo212k(this.f206b);
    }

    public void m244a(boolean z) {
        f205a.mo197c(this.f206b, z);
    }

    public boolean m266g() {
        return f205a.mo213l(this.f206b);
    }

    public void m251b(boolean z) {
        f205a.mo200d(this.f206b, z);
    }

    public boolean m268h() {
        return f205a.mo220s(this.f206b);
    }

    public void m257c(boolean z) {
        f205a.mo207h(this.f206b, z);
    }

    public boolean m270i() {
        return f205a.mo221t(this.f206b);
    }

    public void m259d(boolean z) {
        f205a.mo209i(this.f206b, z);
    }

    public boolean m271j() {
        return f205a.mo217p(this.f206b);
    }

    public void m261e(boolean z) {
        f205a.mo205g(this.f206b, z);
    }

    public boolean m272k() {
        return f205a.mo210i(this.f206b);
    }

    public void m263f(boolean z) {
        f205a.mo185a(this.f206b, z);
    }

    public boolean m273l() {
        return f205a.mo214m(this.f206b);
    }

    public void m265g(boolean z) {
        f205a.mo202e(this.f206b, z);
    }

    public boolean m274m() {
        return f205a.mo211j(this.f206b);
    }

    public void m267h(boolean z) {
        f205a.mo192b(this.f206b, z);
    }

    public boolean m275n() {
        return f205a.mo215n(this.f206b);
    }

    public boolean m276o() {
        return f205a.mo216o(this.f206b);
    }

    public void m269i(boolean z) {
        f205a.mo204f(this.f206b, z);
    }

    public CharSequence m277p() {
        return f205a.mo201e(this.f206b);
    }

    public void m243a(CharSequence charSequence) {
        f205a.mo196c(this.f206b, charSequence);
    }

    public CharSequence m278q() {
        return f205a.mo193c(this.f206b);
    }

    public void m249b(CharSequence charSequence) {
        f205a.mo183a(this.f206b, charSequence);
    }

    public CharSequence m279r() {
        return f205a.mo203f(this.f206b);
    }

    public CharSequence m280s() {
        return f205a.mo198d(this.f206b);
    }

    public void m255c(CharSequence charSequence) {
        f205a.mo190b(this.f206b, charSequence);
    }

    public void m281t() {
        f205a.mo218q(this.f206b);
    }

    public String m282u() {
        return f205a.mo222u(this.f206b);
    }

    public void m250b(Object obj) {
        f205a.mo184a(this.f206b, ((C0106m) obj).f207a);
    }

    public void m256c(Object obj) {
        f205a.mo191b(this.f206b, ((C0107n) obj).f208a);
    }

    public int hashCode() {
        return this.f206b == null ? 0 : this.f206b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0098e c0098e = (C0098e) obj;
        if (this.f206b == null) {
            if (c0098e.f206b != null) {
                return false;
            }
            return true;
        } else if (this.f206b.equals(c0098e.f206b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m241a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m253c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m277p());
        stringBuilder.append("; className: ").append(m278q());
        stringBuilder.append("; text: ").append(m279r());
        stringBuilder.append("; contentDescription: ").append(m280s());
        stringBuilder.append("; viewId: ").append(m282u());
        stringBuilder.append("; checkable: ").append(m260d());
        stringBuilder.append("; checked: ").append(m262e());
        stringBuilder.append("; focusable: ").append(m264f());
        stringBuilder.append("; focused: ").append(m266g());
        stringBuilder.append("; selected: ").append(m271j());
        stringBuilder.append("; clickable: ").append(m272k());
        stringBuilder.append("; longClickable: ").append(m273l());
        stringBuilder.append("; enabled: ").append(m274m());
        stringBuilder.append("; password: ").append(m275n());
        stringBuilder.append("; scrollable: " + m276o());
        stringBuilder.append("; [");
        int b = m245b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0098e.m237c(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m237c(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case Place.TYPE_SUBLOCALITY_LEVEL_2 /*1024*/:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
