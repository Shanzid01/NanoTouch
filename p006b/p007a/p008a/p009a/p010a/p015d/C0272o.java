package p006b.p007a.p008a.p009a.p010a.p015d;

import android.content.Context;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;

/* compiled from: TimeBasedFileRollOverRunnable */
public class C0272o implements Runnable {
    private final Context f878a;
    private final C0259k f879b;

    public C0272o(Context context, C0259k c0259k) {
        this.f878a = context;
        this.f879b = c0259k;
    }

    public void run() {
        try {
            C0214m.m1910a(this.f878a, "Performing time based file roll over.");
            if (!this.f879b.mo482e()) {
                this.f879b.mo481d();
            }
        } catch (Throwable e) {
            C0214m.m1911a(this.f878a, "Failed to roll over file", e);
        }
    }
}
