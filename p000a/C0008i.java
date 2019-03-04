package p000a;

import java.util.concurrent.Executor;

/* compiled from: BoltsExecutors */
class C0008i implements Executor {
    private ThreadLocal<Integer> f15a;

    private C0008i() {
        this.f15a = new ThreadLocal();
    }

    private int m7a() {
        Integer num = (Integer) this.f15a.get();
        if (num == null) {
            num = Integer.valueOf(0);
        }
        int intValue = num.intValue() + 1;
        this.f15a.set(Integer.valueOf(intValue));
        return intValue;
    }

    private int m8b() {
        Integer num = (Integer) this.f15a.get();
        if (num == null) {
            num = Integer.valueOf(0);
        }
        int intValue = num.intValue() - 1;
        if (intValue == 0) {
            this.f15a.remove();
        } else {
            this.f15a.set(Integer.valueOf(intValue));
        }
        return intValue;
    }

    public void execute(Runnable runnable) {
        if (m7a() <= 15) {
            try {
                runnable.run();
            } catch (Throwable th) {
                m8b();
            }
        } else {
            C0006g.m4a().execute(runnable);
        }
        m8b();
    }
}
