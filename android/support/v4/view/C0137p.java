package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.google.android.gms.cast.TextTrackStyle;

/* compiled from: GestureDetectorCompat */
class C0137p implements C0136o {
    private static final int f261e = ViewConfiguration.getLongPressTimeout();
    private static final int f262f = ViewConfiguration.getTapTimeout();
    private static final int f263g = ViewConfiguration.getDoubleTapTimeout();
    private int f264a;
    private int f265b;
    private int f266c;
    private int f267d;
    private final Handler f268h;
    private final OnGestureListener f269i;
    private OnDoubleTapListener f270j;
    private boolean f271k;
    private boolean f272l;
    private boolean f273m;
    private boolean f274n;
    private boolean f275o;
    private MotionEvent f276p;
    private MotionEvent f277q;
    private boolean f278r;
    private float f279s;
    private float f280t;
    private float f281u;
    private float f282v;
    private boolean f283w;
    private VelocityTracker f284x;

    public C0137p(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.f268h = new C0138q(this, handler);
        } else {
            this.f268h = new C0138q(this);
        }
        this.f269i = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            mo327a((OnDoubleTapListener) onGestureListener);
        }
        m898a(context);
    }

    private void m898a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        } else if (this.f269i == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else {
            this.f283w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f266c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f267d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f264a = scaledTouchSlop * scaledTouchSlop;
            this.f265b = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }
    }

    public void mo327a(OnDoubleTapListener onDoubleTapListener) {
        this.f270j = onDoubleTapListener;
    }

    public void mo328a(boolean z) {
        this.f283w = z;
    }

    public boolean mo329a() {
        return this.f283w;
    }

    public boolean mo330a(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (this.f284x == null) {
            this.f284x = VelocityTracker.obtain();
        }
        this.f284x.addMovement(motionEvent);
        boolean z = (action & 255) == 6;
        int b = z ? ae.m518b(motionEvent) : -1;
        int c = ae.m521c(motionEvent);
        float f = 0.0f;
        float f2 = 0.0f;
        for (i = 0; i < c; i++) {
            if (b != i) {
                f2 += ae.m520c(motionEvent, i);
                f += ae.m522d(motionEvent, i);
            }
        }
        b = z ? c - 1 : c;
        f2 /= (float) b;
        f /= (float) b;
        boolean hasMessages;
        float b2;
        float a;
        switch (action & 255) {
            case 0:
                if (this.f270j != null) {
                    hasMessages = this.f268h.hasMessages(3);
                    if (hasMessages) {
                        this.f268h.removeMessages(3);
                    }
                    if (this.f276p == null || this.f277q == null || !hasMessages || !m900a(this.f276p, this.f277q, motionEvent)) {
                        this.f268h.sendEmptyMessageDelayed(3, (long) f263g);
                    } else {
                        this.f278r = true;
                        b = (this.f270j.onDoubleTap(this.f276p) | 0) | this.f270j.onDoubleTapEvent(motionEvent);
                        this.f279s = f2;
                        this.f281u = f2;
                        this.f280t = f;
                        this.f282v = f;
                        if (this.f276p != null) {
                            this.f276p.recycle();
                        }
                        this.f276p = MotionEvent.obtain(motionEvent);
                        this.f274n = true;
                        this.f275o = true;
                        this.f271k = true;
                        this.f273m = false;
                        this.f272l = false;
                        if (this.f283w) {
                            this.f268h.removeMessages(2);
                            this.f268h.sendEmptyMessageAtTime(2, (this.f276p.getDownTime() + ((long) f262f)) + ((long) f261e));
                        }
                        this.f268h.sendEmptyMessageAtTime(1, this.f276p.getDownTime() + ((long) f262f));
                        return b | this.f269i.onDown(motionEvent);
                    }
                }
                b = 0;
                this.f279s = f2;
                this.f281u = f2;
                this.f280t = f;
                this.f282v = f;
                if (this.f276p != null) {
                    this.f276p.recycle();
                }
                this.f276p = MotionEvent.obtain(motionEvent);
                this.f274n = true;
                this.f275o = true;
                this.f271k = true;
                this.f273m = false;
                this.f272l = false;
                if (this.f283w) {
                    this.f268h.removeMessages(2);
                    this.f268h.sendEmptyMessageAtTime(2, (this.f276p.getDownTime() + ((long) f262f)) + ((long) f261e));
                }
                this.f268h.sendEmptyMessageAtTime(1, this.f276p.getDownTime() + ((long) f262f));
                return b | this.f269i.onDown(motionEvent);
            case 1:
                this.f271k = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.f278r) {
                    hasMessages = this.f270j.onDoubleTapEvent(motionEvent) | 0;
                } else if (this.f273m) {
                    this.f268h.removeMessages(3);
                    this.f273m = false;
                    hasMessages = false;
                } else if (this.f274n) {
                    hasMessages = this.f269i.onSingleTapUp(motionEvent);
                    if (this.f272l && this.f270j != null) {
                        this.f270j.onSingleTapConfirmed(motionEvent);
                    }
                } else {
                    VelocityTracker velocityTracker = this.f284x;
                    int b3 = ae.m519b(motionEvent, 0);
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f267d);
                    b2 = at.m556b(velocityTracker, b3);
                    a = at.m555a(velocityTracker, b3);
                    hasMessages = (Math.abs(b2) > ((float) this.f266c) || Math.abs(a) > ((float) this.f266c)) ? this.f269i.onFling(this.f276p, motionEvent, a, b2) : false;
                }
                if (this.f277q != null) {
                    this.f277q.recycle();
                }
                this.f277q = obtain;
                if (this.f284x != null) {
                    this.f284x.recycle();
                    this.f284x = null;
                }
                this.f278r = false;
                this.f272l = false;
                this.f268h.removeMessages(1);
                this.f268h.removeMessages(2);
                return hasMessages;
            case 2:
                if (this.f273m) {
                    return false;
                }
                a = this.f279s - f2;
                b2 = this.f280t - f;
                if (this.f278r) {
                    return false | this.f270j.onDoubleTapEvent(motionEvent);
                }
                if (this.f274n) {
                    i = (int) (f2 - this.f281u);
                    int i2 = (int) (f - this.f282v);
                    i = (i * i) + (i2 * i2);
                    if (i > this.f264a) {
                        hasMessages = this.f269i.onScroll(this.f276p, motionEvent, a, b2);
                        this.f279s = f2;
                        this.f280t = f;
                        this.f274n = false;
                        this.f268h.removeMessages(3);
                        this.f268h.removeMessages(1);
                        this.f268h.removeMessages(2);
                    } else {
                        hasMessages = false;
                    }
                    if (i > this.f264a) {
                        this.f275o = false;
                    }
                    return hasMessages;
                } else if (Math.abs(a) < TextTrackStyle.DEFAULT_FONT_SCALE && Math.abs(b2) < TextTrackStyle.DEFAULT_FONT_SCALE) {
                    return false;
                } else {
                    boolean onScroll = this.f269i.onScroll(this.f276p, motionEvent, a, b2);
                    this.f279s = f2;
                    this.f280t = f;
                    return onScroll;
                }
            case 3:
                m902b();
                return false;
            case 5:
                this.f279s = f2;
                this.f281u = f2;
                this.f280t = f;
                this.f282v = f;
                m903c();
                return false;
            case 6:
                this.f279s = f2;
                this.f281u = f2;
                this.f280t = f;
                this.f282v = f;
                this.f284x.computeCurrentVelocity(1000, (float) this.f267d);
                int b4 = ae.m518b(motionEvent);
                b = ae.m519b(motionEvent, b4);
                f2 = at.m555a(this.f284x, b);
                float b5 = at.m556b(this.f284x, b);
                for (b = 0; b < c; b++) {
                    if (b != b4) {
                        int b6 = ae.m519b(motionEvent, b);
                        if ((at.m556b(this.f284x, b6) * b5) + (at.m555a(this.f284x, b6) * f2) < 0.0f) {
                            this.f284x.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }

    private void m902b() {
        this.f268h.removeMessages(1);
        this.f268h.removeMessages(2);
        this.f268h.removeMessages(3);
        this.f284x.recycle();
        this.f284x = null;
        this.f278r = false;
        this.f271k = false;
        this.f274n = false;
        this.f275o = false;
        this.f272l = false;
        if (this.f273m) {
            this.f273m = false;
        }
    }

    private void m903c() {
        this.f268h.removeMessages(1);
        this.f268h.removeMessages(2);
        this.f268h.removeMessages(3);
        this.f278r = false;
        this.f274n = false;
        this.f275o = false;
        this.f272l = false;
        if (this.f273m) {
            this.f273m = false;
        }
    }

    private boolean m900a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.f275o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f263g)) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        if ((x * x) + (y * y) < this.f265b) {
            return true;
        }
        return false;
    }

    private void m906d() {
        this.f268h.removeMessages(3);
        this.f272l = false;
        this.f273m = true;
        this.f269i.onLongPress(this.f276p);
    }
}
