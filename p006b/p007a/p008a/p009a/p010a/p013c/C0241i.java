package p006b.p007a.p008a.p009a.p010a.p013c;

/* compiled from: AsyncTask */
class C0241i implements Runnable {
    final /* synthetic */ Runnable f841a;
    final /* synthetic */ C0240h f842b;

    C0241i(C0240h c0240h, Runnable runnable) {
        this.f842b = c0240h;
        this.f841a = runnable;
    }

    public void run() {
        try {
            this.f841a.run();
        } finally {
            this.f842b.m1994a();
        }
    }
}
