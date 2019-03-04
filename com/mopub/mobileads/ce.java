package com.mopub.mobileads;

import com.mopub.common.C1511s;

/* compiled from: VastVideoViewController */
class ce implements Runnable {
    final /* synthetic */ VastVideoViewController f2496a;

    ce(VastVideoViewController vastVideoViewController) {
        this.f2496a = vastVideoViewController;
    }

    public void run() {
        float duration = (float) this.f2496a.f2371e.getDuration();
        float currentPosition = (float) this.f2496a.f2371e.getCurrentPosition();
        if (duration > 0.0f) {
            duration = currentPosition / duration;
            if (!this.f2496a.f2379m && currentPosition >= 1000.0f) {
                this.f2496a.f2379m = true;
                C1511s.m4152a(this.f2496a.f2368b.m4691b());
            }
            if (!this.f2496a.f2380n && duration > 0.25f) {
                this.f2496a.f2380n = true;
                C1511s.m4152a(this.f2496a.f2368b.m4694c());
            }
            if (!this.f2496a.f2381o && duration > 0.5f) {
                this.f2496a.f2381o = true;
                C1511s.m4152a(this.f2496a.f2368b.m4697d());
            }
            if (!this.f2496a.f2382p && duration > 0.75f) {
                this.f2496a.f2382p = true;
                C1511s.m4152a(this.f2496a.f2368b.m4699e());
            }
            if (this.f2496a.m4422a(this.f2496a.f2371e.getDuration())) {
                this.f2496a.f2370d.m4636b(this.f2496a.f2377k - this.f2496a.f2371e.getCurrentPosition());
            }
            if (this.f2496a.m4449n()) {
                this.f2496a.m4446m();
            }
        }
        this.f2496a.f2370d.m4634a(this.f2496a.f2371e.getDuration() - this.f2496a.f2371e.getCurrentPosition());
        if (this.f2496a.f2376j) {
            this.f2496a.f2374h.postDelayed(this.f2496a.f2375i, 50);
        }
    }
}
