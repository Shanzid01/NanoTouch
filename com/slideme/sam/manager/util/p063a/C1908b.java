package com.slideme.sam.manager.util.p063a;

import android.animation.LayoutTransition;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.view.ViewGroup;
import java.util.Set;

/* compiled from: HoneycombCompatHelper */
public abstract class C1908b {
    public static final boolean m5750a(Vibrator vibrator) {
        return vibrator.hasVibrator();
    }

    public static final void m5748a(Editor editor, String str, Set<String> set) {
        editor.putStringSet(str, set);
    }

    public static final Set<String> m5747a(SharedPreferences sharedPreferences, String str, Set<String> set) {
        return sharedPreferences.getStringSet(str, set);
    }

    public static final void m5749a(ViewGroup viewGroup) {
        viewGroup.setLayoutTransition(new LayoutTransition());
        if (VERSION.SDK_INT >= 16) {
            C1909c.m5752a(viewGroup.getLayoutTransition(), 4);
        }
    }
}
