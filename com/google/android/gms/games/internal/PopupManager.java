package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.internal.zzme;
import java.lang.ref.WeakReference;

public class PopupManager {
    protected GamesClientImpl zzaft;
    protected PopupLocationInfo zzafu;

    public final class PopupLocationInfo {
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzafv;
        public int zzafw;

        private PopupLocationInfo(int i, IBinder iBinder) {
            this.zzafw = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = i;
            this.zzafv = iBinder;
        }

        public Bundle zzob() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.zzafw);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        private boolean zzadU = false;
        private WeakReference<View> zzafx;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int i) {
            super(gamesClientImpl, i);
        }

        private void zzn(View view) {
            int i = -1;
            if (zzme.zzki()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.zzafu.zzafw = i;
            this.zzafu.zzafv = windowToken;
            this.zzafu.left = iArr[0];
            this.zzafu.top = iArr[1];
            this.zzafu.right = iArr[0] + width;
            this.zzafu.bottom = iArr[1] + height;
            if (this.zzadU) {
                zzoc();
                this.zzadU = false;
            }
        }

        public void onGlobalLayout() {
            if (this.zzafx != null) {
                View view = (View) this.zzafx.get();
                if (view != null) {
                    zzn(view);
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            zzn(view);
        }

        public void onViewDetachedFromWindow(View view) {
            this.zzaft.zznL();
            view.removeOnAttachStateChangeListener(this);
        }

        protected void zzeI(int i) {
            this.zzafu = new PopupLocationInfo(i, null);
        }

        public void zzm(View view) {
            View view2;
            Context context;
            this.zzaft.zznL();
            if (this.zzafx != null) {
                view2 = (View) this.zzafx.get();
                context = this.zzaft.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (zzme.zzkh()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.zzafx = null;
            context = this.zzaft.getContext();
            if (view == null && (context instanceof Activity)) {
                view2 = ((Activity) context).findViewById(16908290);
                if (view2 == null) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                GamesLog.zzr("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
                view = view2;
            }
            if (view != null) {
                zzn(view);
                this.zzafx = new WeakReference(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.zzs("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void zzoc() {
            if (this.zzafu.zzafv != null) {
                super.zzoc();
            } else {
                this.zzadU = this.zzafx != null;
            }
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int i) {
        this.zzaft = gamesClientImpl;
        zzeI(i);
    }

    public static PopupManager zza(GamesClientImpl gamesClientImpl, int i) {
        return zzme.zzke() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void setGravity(int i) {
        this.zzafu.gravity = i;
    }

    protected void zzeI(int i) {
        this.zzafu = new PopupLocationInfo(i, new Binder());
    }

    public void zzm(View view) {
    }

    public void zzoc() {
        this.zzaft.zza(this.zzafu.zzafv, this.zzafu.zzob());
    }

    public Bundle zzod() {
        return this.zzafu.zzob();
    }

    public IBinder zzoe() {
        return this.zzafu.zzafv;
    }

    public PopupLocationInfo zzof() {
        return this.zzafu;
    }
}
