package com.slideme.sam.manager.view.touchme;

import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.ArrayList;

/* compiled from: SlidingTabSelector */
class au {
    final /* synthetic */ SlidingTabSelector f3811a;
    private boolean f3812b;
    private long f3813c;
    private ArrayList<av> f3814d;

    private au(SlidingTabSelector slidingTabSelector) {
        this.f3811a = slidingTabSelector;
        this.f3812b = false;
        this.f3814d = new ArrayList();
    }

    public boolean m6102a() {
        return this.f3812b;
    }

    public void m6104b() {
        this.f3812b = true;
        this.f3813c = System.currentTimeMillis();
    }

    public void m6105c() {
        this.f3812b = false;
        this.f3814d = new ArrayList();
    }

    public void m6101a(float f) {
        av avVar = new av(this);
        avVar.f3815a = f;
        this.f3814d.add(avVar);
    }

    public float m6103b(float f) {
        if (this.f3814d.size() <= 0) {
            return GroundOverlayOptions.NO_DIMENSION;
        }
        return (((av) this.f3814d.get(this.f3814d.size() - 1)).f3815a - ((av) this.f3814d.get((int) (((float) this.f3814d.size()) * (TextTrackStyle.DEFAULT_FONT_SCALE - f)))).f3815a) / (((float) (System.currentTimeMillis() - this.f3813c)) * f);
    }
}
