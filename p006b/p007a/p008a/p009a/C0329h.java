package p006b.p007a.p008a.p009a;

import java.util.concurrent.CountDownLatch;

/* compiled from: Fabric */
class C0329h implements C0328l {
    final CountDownLatch f1021a = new CountDownLatch(this.f1022b);
    final /* synthetic */ int f1022b;
    final /* synthetic */ C0326f f1023c;

    C0329h(C0326f c0326f, int i) {
        this.f1023c = c0326f;
        this.f1022b = i;
    }

    public void mo524a(Object obj) {
        this.f1021a.countDown();
        if (this.f1021a.getCount() == 0) {
            this.f1023c.f1018n.set(true);
            this.f1023c.f1013i.mo524a(this.f1023c);
        }
    }

    public void mo523a(Exception exception) {
        this.f1023c.f1013i.mo523a(exception);
    }
}
