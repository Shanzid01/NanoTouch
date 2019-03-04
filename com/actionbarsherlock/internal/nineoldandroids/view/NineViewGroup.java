package com.actionbarsherlock.internal.nineoldandroids.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;

public abstract class NineViewGroup extends ViewGroup {
    private final AnimatorProxy mProxy;

    public NineViewGroup(Context context) {
        super(context);
        this.mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }

    public NineViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }

    public NineViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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

    public float getTranslationX() {
        if (AnimatorProxy.NEEDS_PROXY) {
            return this.mProxy.getTranslationX();
        }
        return super.getTranslationX();
    }

    public void setTranslationX(float f) {
        if (AnimatorProxy.NEEDS_PROXY) {
            this.mProxy.setTranslationX(f);
        } else {
            super.setTranslationX(f);
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
