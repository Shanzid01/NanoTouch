package com.slideme.sam.manager.view.touchme;

import java.util.concurrent.CountDownLatch;

/* compiled from: Masonry */
class C1984r implements Runnable {
    final /* synthetic */ Masonry f3841a;

    C1984r(Masonry masonry) {
        this.f3841a = masonry;
    }

    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(this.f3841a.f3711h.size());
        for (C1988v c1988v : this.f3841a.f3711h) {
            C1987u c1987u = c1988v.f3851b;
            this.f3841a.post(new C1985s(this, c1988v.f3850a, c1987u, countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
