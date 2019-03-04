package com.actionbarsherlock.internal.nineoldandroids.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;

public class NineFrameLayout extends FrameLayout {
    private final AnimatorProxy mProxy;

    public NineFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }

    public void setVisibility(int i) {
        if (this.mProxy != null) {
            if (i == 8) {
                clearAnimation();
            } else if (i == 0) {
                setAnimation(this.mProxy);
            }
        }
        super.setVisibility(i);
    }

    public float getAlpha() {
        if (AnimatorProxy.NEEDS_PROXY) {
            return this.mProxy.getAlpha();
        }
        return super.getAlpha();
    }

    public void setAlpha(float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            this.mProxy.setAlpha(f);
        } else {
            super.setAlpha(f);
        }
    }

    public float getTranslationY() {
        if (AnimatorProxy.NEEDS_PROXY) {
            return this.mProxy.getTranslationY();
        }
        return super.getTranslationY();
    }

    public void setTranslationY(float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            this.mProxy.setTranslationY(f);
        } else {
            super.setTranslationY(f);
        }
    }
}
