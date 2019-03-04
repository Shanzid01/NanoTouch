package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class ViewGestureDetector extends GestureDetector {
    private final View f2386a;
    private AdAlertGestureListener f2387b;
    private UserClickListener f2388c;

    interface UserClickListener {
        void onResetUserClick();

        void onUserClick();

        boolean wasClicked();
    }

    public ViewGestureDetector(Context context, View view, AdConfiguration adConfiguration) {
        this(context, view, new AdAlertGestureListener(view, adConfiguration));
    }

    private ViewGestureDetector(Context context, View view, AdAlertGestureListener adAlertGestureListener) {
        super(context, adAlertGestureListener);
        this.f2387b = adAlertGestureListener;
        this.f2386a = view;
        setIsLongpressEnabled(false);
    }

    void m4467a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                onTouchEvent(motionEvent);
                return;
            case 1:
                if (this.f2388c != null) {
                    this.f2388c.onUserClick();
                } else {
                    Log.d("MoPub", "View's onUserClick() is not registered.");
                }
                this.f2387b.m4167a();
                return;
            case 2:
                if (m4465a(motionEvent, this.f2386a)) {
                    onTouchEvent(motionEvent);
                    return;
                } else {
                    m4466a();
                    return;
                }
            default:
                return;
        }
    }

    void m4468a(UserClickListener userClickListener) {
        this.f2388c = userClickListener;
    }

    void m4466a() {
        this.f2387b.m4168b();
    }

    private boolean m4465a(MotionEvent motionEvent, View view) {
        if (motionEvent == null || view == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (x < 0.0f || x > ((float) view.getWidth()) || y < 0.0f || y > ((float) view.getHeight())) {
            return false;
        }
        return true;
    }
}
