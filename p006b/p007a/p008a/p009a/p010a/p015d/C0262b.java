package p006b.p007a.p008a.p009a.p010a.p015d;

import android.content.Context;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;

/* compiled from: EnabledEventsStrategy */
public abstract class C0262b<T> implements C0260j<T> {
    protected final Context f857g;
    protected final C0264d<T> f858h;
    final ScheduledExecutorService f859i;
    final AtomicReference<ScheduledFuture<?>> f860j;
    volatile int f861k = -1;

    public C0262b(Context context, ScheduledExecutorService scheduledExecutorService, C0264d<T> c0264d) {
        this.f857g = context;
        this.f859i = scheduledExecutorService;
        this.f858h = c0264d;
        this.f860j = new AtomicReference();
    }

    public void m2064f() {
        if ((this.f861k != -1 ? 1 : null) != null) {
            m2058a((long) this.f861k, (long) this.f861k);
        }
    }

    public void mo479b() {
        m2065g();
    }

    public void mo481d() {
        if (this.f860j.get() != null) {
            C0214m.m1910a(this.f857g, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f860j.get()).cancel(false);
            this.f860j.set(null);
        }
    }

    public void mo480c() {
        this.f858h.m2078f();
    }

    public void m2059a(T t) {
        C0214m.m1910a(this.f857g, t.toString());
        try {
            this.f858h.m2072a((Object) t);
        } catch (Throwable e) {
            C0214m.m1911a(this.f857g, "Failed to write event.", e);
        }
        m2064f();
    }

    public boolean mo482e() {
        try {
            return this.f858h.m2076d();
        } catch (Throwable e) {
            C0214m.m1911a(this.f857g, "Failed to roll file over.", e);
            return false;
        }
    }

    protected void m2057a(int i) {
        this.f861k = i;
        m2058a(0, (long) this.f861k);
    }

    void m2058a(long j, long j2) {
        if ((this.f860j.get() == null ? 1 : null) != null) {
            Runnable c0272o = new C0272o(this.f857g, this);
            C0214m.m1910a(this.f857g, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f860j.set(this.f859i.scheduleAtFixedRate(c0272o, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                C0214m.m1911a(this.f857g, "Failed to schedule time based file roll over", e);
            }
        }
    }

    void m2065g() {
        C0269l a = mo478a();
        if (a == null) {
            C0214m.m1910a(this.f857g, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C0214m.m1910a(this.f857g, "Sending all files");
        List e = this.f858h.m2077e();
        int i = 0;
        while (e.size() > 0) {
            int size;
            C0214m.m1910a(this.f857g, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e.size())}));
            boolean a2 = a.mo538a(e);
            if (a2) {
                size = e.size() + i;
                try {
                    this.f858h.m2073a(e);
                    i = size;
                } catch (Exception e2) {
                    Throwable e3 = e2;
                }
            }
            if (!a2) {
                break;
            }
            try {
                e = this.f858h.m2077e();
            } catch (Throwable e4) {
                Throwable th = e4;
                size = i;
                e3 = th;
            }
        }
        if (i == 0) {
            this.f858h.m2079g();
        }
        C0214m.m1911a(this.f857g, "Failed to send batch of analytics files to server: " + e3.getMessage(), e3);
        i = size;
        if (i == 0) {
            this.f858h.m2079g();
        }
    }
}
