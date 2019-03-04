package p006b.p007a.p008a.p009a.p010a.p012b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: ExecutorUtils */
final class C0225y extends C0205l {
    final /* synthetic */ String f795a;
    final /* synthetic */ ExecutorService f796b;
    final /* synthetic */ long f797c;
    final /* synthetic */ TimeUnit f798d;

    C0225y(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        this.f795a = str;
        this.f796b = executorService;
        this.f797c = j;
        this.f798d = timeUnit;
    }

    public void mo467a() {
        try {
            C0326f.m2298h().mo511a("Fabric", "Executing shutdown hook for " + this.f795a);
            this.f796b.shutdown();
            if (!this.f796b.awaitTermination(this.f797c, this.f798d)) {
                C0326f.m2298h().mo511a("Fabric", this.f795a + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                this.f796b.shutdownNow();
            }
        } catch (InterruptedException e) {
            C0326f.m2298h().mo511a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f795a}));
            this.f796b.shutdownNow();
        }
    }
}
