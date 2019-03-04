package com.mopub.mobileads;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class AdAlertGestureListener extends SimpleOnGestureListener {
    private static /* synthetic */ int[] f2204k;
    private float f2205a = 100.0f;
    private float f2206b;
    private boolean f2207c;
    private boolean f2208d;
    private AdAlertReporter f2209e;
    private int f2210f;
    private float f2211g;
    private C1532a f2212h = C1532a.UNSET;
    private View f2213i;
    private AdConfiguration f2214j;

    static /* synthetic */ int[] m4161c() {
        int[] iArr = f2204k;
        if (iArr == null) {
            iArr = new int[C1532a.values().length];
            try {
                iArr[C1532a.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C1532a.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C1532a.GOING_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C1532a.GOING_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C1532a.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            f2204k = iArr;
        }
        return iArr;
    }

    AdAlertGestureListener(View view, AdConfiguration adConfiguration) {
        if (view != null && view.getWidth() > 0) {
            this.f2205a = Math.min(100.0f, ((float) view.getWidth()) / 3.0f);
        }
        this.f2213i = view;
        this.f2214j = adConfiguration;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f2212h == C1532a.FINISHED) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        if (m4158a(motionEvent.getY(), motionEvent2.getY())) {
            this.f2212h = C1532a.FAILED;
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        switch (m4161c()[this.f2212h.ordinal()]) {
            case 1:
                this.f2211g = motionEvent.getX();
                m4157a(motionEvent2.getX());
                break;
            case 2:
                m4159b(motionEvent2.getX());
                break;
            case 3:
                m4160c(motionEvent2.getX());
                break;
        }
        this.f2206b = motionEvent2.getX();
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    void m4167a() {
        if (this.f2212h == C1532a.FINISHED) {
            this.f2209e = new AdAlertReporter(this.f2213i.getContext(), this.f2213i, this.f2214j);
            this.f2209e.m4180a();
        }
        m4168b();
    }

    void m4168b() {
        this.f2210f = 0;
        this.f2212h = C1532a.UNSET;
    }

    private boolean m4158a(float f, float f2) {
        return Math.abs(f2 - f) > 50.0f;
    }

    private void m4157a(float f) {
        if (f > this.f2211g) {
            this.f2212h = C1532a.GOING_RIGHT;
        }
    }

    private void m4159b(float f) {
        if (m4163d(f) && m4166g(f)) {
            this.f2212h = C1532a.GOING_LEFT;
            this.f2211g = f;
        }
    }

    private void m4160c(float f) {
        if (m4164e(f) && m4165f(f)) {
            this.f2212h = C1532a.GOING_RIGHT;
            this.f2211g = f;
        }
    }

    private void m4162d() {
        this.f2210f++;
        if (this.f2210f >= 4) {
            this.f2212h = C1532a.FINISHED;
        }
    }

    private boolean m4163d(float f) {
        if (this.f2208d) {
            return true;
        }
        if (f < this.f2211g + this.f2205a) {
            return false;
        }
        this.f2207c = false;
        this.f2208d = true;
        return true;
    }

    private boolean m4164e(float f) {
        if (this.f2207c) {
            return true;
        }
        if (f > this.f2211g - this.f2205a) {
            return false;
        }
        this.f2208d = false;
        this.f2207c = true;
        m4162d();
        return true;
    }

    private boolean m4165f(float f) {
        return f > this.f2206b;
    }

    private boolean m4166g(float f) {
        return f < this.f2206b;
    }
}
