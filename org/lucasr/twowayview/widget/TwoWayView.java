package org.lucasr.twowayview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.at;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.lang.reflect.Constructor;
import org.lucasr.twowayview.TwoWayLayoutManager;
import org.lucasr.twowayview.TwoWayLayoutManager.Orientation;

public class TwoWayView extends RecyclerView {
    private static final String LOGTAG = "TwoWayView";
    private static final Class<?>[] sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
    final Object[] sConstructorArgs;

    public TwoWayView(Context context) {
        this(context, null);
    }

    public TwoWayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoWayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sConstructorArgs = new Object[2];
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2000R.styleable.twowayview_TwoWayView, i, 0);
        Object string = obtainStyledAttributes.getString(C2000R.styleable.twowayview_TwoWayView_twowayview_layoutManager);
        if (!TextUtils.isEmpty(string)) {
            loadLayoutManagerFromName(context, attributeSet, string);
        }
        obtainStyledAttributes.recycle();
    }

    private void loadLayoutManagerFromName(Context context, AttributeSet attributeSet, String str) {
        try {
            int indexOf = str.indexOf(46);
            if (indexOf == -1) {
                str = "org.lucasr.twowayview.widget." + str;
            } else if (indexOf == 0) {
                str = context.getPackageName() + "." + str;
            }
            Constructor constructor = context.getClassLoader().loadClass(str).asSubclass(TwoWayLayoutManager.class).getConstructor(sConstructorSignature);
            this.sConstructorArgs[0] = context;
            this.sConstructorArgs[1] = attributeSet;
            setLayoutManager((at) constructor.newInstance(this.sConstructorArgs));
        } catch (Throwable e) {
            throw new IllegalStateException("Could not load TwoWayLayoutManager from class: " + str, e);
        }
    }

    public void setLayoutManager(at atVar) {
        if (atVar instanceof TwoWayLayoutManager) {
            super.setLayoutManager(atVar);
            return;
        }
        throw new IllegalArgumentException("TwoWayView can only use TwoWayLayoutManager subclasses as its layout manager");
    }

    public Orientation getOrientation() {
        return ((TwoWayLayoutManager) getLayoutManager()).getOrientation();
    }

    public void setOrientation(Orientation orientation) {
        ((TwoWayLayoutManager) getLayoutManager()).setOrientation(orientation);
    }

    public int getFirstVisiblePosition() {
        return ((TwoWayLayoutManager) getLayoutManager()).getFirstVisiblePosition();
    }

    public int getLastVisiblePosition() {
        return ((TwoWayLayoutManager) getLayoutManager()).getLastVisiblePosition();
    }
}
