package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzat;
import com.google.android.gms.internal.zzbp;

public final class AdView extends ViewGroup {
    private final zzbp zzll;

    public AdView(Context context) {
        super(context);
        this.zzll = new zzbp(this);
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzll = new zzbp(this, attributeSet, false);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzll = new zzbp(this, attributeSet, false);
    }

    public void destroy() {
        this.zzll.destroy();
    }

    public AdListener getAdListener() {
        return this.zzll.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzll.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzll.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzll.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzll.getMediationAdapterClassName();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzll.zza(adRequest.zzY());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int i3 = 0;
        View childAt = getChildAt(0);
        AdSize adSize = getAdSize();
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            measuredWidth = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else if (adSize != null) {
            Context context = getContext();
            measuredWidth = adSize.getWidthInPixels(context);
            i3 = adSize.getHeightInPixels(context);
        } else {
            measuredWidth = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zzll.pause();
    }

    public void resume() {
        this.zzll.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzll.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzat)) {
            this.zzll.zza((zzat) adListener);
        } else if (adListener == null) {
            this.zzll.zza(null);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzll.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzll.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zzll.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.zzll.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }
}
