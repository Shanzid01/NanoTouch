package com.actionbarsherlock.internal.nineoldandroids.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;

public class NineLinearLayout extends LinearLayout {
    private final AnimatorProxy mProxy;

    public NineLinearLayout(Context context, AttributeSet attributeSet) {
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
}
