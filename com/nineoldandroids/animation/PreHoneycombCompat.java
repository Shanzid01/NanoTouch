package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class PreHoneycombCompat {
    static Property<View, Float> ALPHA = new C15761("alpha");
    static Property<View, Float> PIVOT_X = new C15772("pivotX");
    static Property<View, Float> PIVOT_Y = new C15783("pivotY");
    static Property<View, Float> ROTATION = new C15816("rotation");
    static Property<View, Float> ROTATION_X = new C15827("rotationX");
    static Property<View, Float> ROTATION_Y = new C15838("rotationY");
    static Property<View, Float> SCALE_X = new C15849("scaleX");
    static Property<View, Float> SCALE_Y = new AnonymousClass10("scaleY");
    static Property<View, Integer> SCROLL_X = new AnonymousClass11("scrollX");
    static Property<View, Integer> SCROLL_Y = new AnonymousClass12("scrollY");
    static Property<View, Float> TRANSLATION_X = new C15794("translationX");
    static Property<View, Float> TRANSLATION_Y = new C15805("translationY");
    static Property<View, Float> f2601X = new AnonymousClass13("x");
    static Property<View, Float> f2602Y = new AnonymousClass14("y");

    class AnonymousClass10 extends FloatProperty<View> {
        AnonymousClass10(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setScaleY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleY());
        }
    }

    class AnonymousClass11 extends IntProperty<View> {
        AnonymousClass11(String str) {
            super(str);
        }

        public void setValue(View view, int i) {
            AnimatorProxy.wrap(view).setScrollX(i);
        }

        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
        }
    }

    class AnonymousClass12 extends IntProperty<View> {
        AnonymousClass12(String str) {
            super(str);
        }

        public void setValue(View view, int i) {
            AnimatorProxy.wrap(view).setScrollY(i);
        }

        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollY());
        }
    }

    class AnonymousClass13 extends FloatProperty<View> {
        AnonymousClass13(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getX());
        }
    }

    class AnonymousClass14 extends FloatProperty<View> {
        AnonymousClass14(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getY());
        }
    }

    class C15761 extends FloatProperty<View> {
        C15761(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setAlpha(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getAlpha());
        }
    }

    class C15772 extends FloatProperty<View> {
        C15772(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setPivotX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotX());
        }
    }

    class C15783 extends FloatProperty<View> {
        C15783(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setPivotY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotY());
        }
    }

    class C15794 extends FloatProperty<View> {
        C15794(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setTranslationX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationX());
        }
    }

    class C15805 extends FloatProperty<View> {
        C15805(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setTranslationY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationY());
        }
    }

    class C15816 extends FloatProperty<View> {
        C15816(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotation(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotation());
        }
    }

    class C15827 extends FloatProperty<View> {
        C15827(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotationX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationX());
        }
    }

    class C15838 extends FloatProperty<View> {
        C15838(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setRotationY(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationY());
        }
    }

    class C15849 extends FloatProperty<View> {
        C15849(String str) {
            super(str);
        }

        public void setValue(View view, float f) {
            AnimatorProxy.wrap(view).setScaleX(f);
        }

        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleX());
        }
    }

    private PreHoneycombCompat() {
    }
}
