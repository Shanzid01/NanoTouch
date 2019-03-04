package p006b.p007a.p008a.p009a.p010a.p013c;

import android.os.Process;

/* compiled from: AsyncTask */
class C0235c extends C0234k<Params, Result> {
    final /* synthetic */ C0232a f834a;

    C0235c(C0232a c0232a) {
        this.f834a = c0232a;
        super();
    }

    public Result call() {
        this.f834a.f831n.set(true);
        Process.setThreadPriority(10);
        return this.f834a.m1984d(this.f834a.mo525a(this.b));
    }
}
