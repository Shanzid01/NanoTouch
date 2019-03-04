package android.support.v4.view.p005a;

import android.os.Build.VERSION;

/* compiled from: AccessibilityRecordCompat */
public class ag {
    private static final aj f203a;
    private final Object f204b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f203a = new ak();
        } else if (VERSION.SDK_INT >= 15) {
            f203a = new ai();
        } else if (VERSION.SDK_INT >= 14) {
            f203a = new ah();
        } else {
            f203a = new al();
        }
    }

    public ag(Object obj) {
        this.f204b = obj;
    }

    public static ag m210a() {
        return new ag(f203a.mo172a());
    }

    public void m212a(boolean z) {
        f203a.mo174a(this.f204b, z);
    }

    public void m211a(int i) {
        f203a.mo175b(this.f204b, i);
    }

    public void m213b(int i) {
        f203a.mo173a(this.f204b, i);
    }

    public void m214c(int i) {
        f203a.mo176c(this.f204b, i);
    }

    public int hashCode() {
        return this.f204b == null ? 0 : this.f204b.hashCode();
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
        ag agVar = (ag) obj;
        if (this.f204b == null) {
            if (agVar.f204b != null) {
                return false;
            }
            return true;
        } else if (this.f204b.equals(agVar.f204b)) {
            return true;
        } else {
            return false;
        }
    }
}
