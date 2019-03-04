package p006b.p007a.p008a.p009a;

import android.util.Log;

/* compiled from: DefaultLogger */
public class C0325e implements C0324t {
    private int f1004a;

    public C0325e(int i) {
        this.f1004a = i;
    }

    public C0325e() {
        this.f1004a = 4;
    }

    public boolean mo513a(String str, int i) {
        return this.f1004a <= i;
    }

    public void mo512a(String str, String str2, Throwable th) {
        if (mo513a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void m2281b(String str, String str2, Throwable th) {
        if (mo513a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void m2283c(String str, String str2, Throwable th) {
        if (mo513a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void mo517d(String str, String str2, Throwable th) {
        if (mo513a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void mo519e(String str, String str2, Throwable th) {
        if (mo513a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void mo511a(String str, String str2) {
        mo512a(str, str2, null);
    }

    public void mo514b(String str, String str2) {
        m2281b(str, str2, null);
    }

    public void mo515c(String str, String str2) {
        m2283c(str, str2, null);
    }

    public void mo516d(String str, String str2) {
        mo517d(str, str2, null);
    }

    public void mo518e(String str, String str2) {
        mo519e(str, str2, null);
    }

    public void mo510a(int i, String str, String str2) {
        m2276a(i, str, str2, false);
    }

    public void m2276a(int i, String str, String str2, boolean z) {
        if (z || mo513a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
