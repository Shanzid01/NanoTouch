package com.actionbarsherlock.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.actionbarsherlock.C0414R;

public final class ResourcesCompat {
    private ResourcesCompat() {
    }

    public static boolean getResources_getBoolean(Context context, int i) {
        if (VERSION.SDK_INT >= 13) {
            return context.getResources().getBoolean(i);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) / displayMetrics.density;
        float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.density;
        if (f < f2) {
            f2 = f;
        }
        if (i == C0414R.bool.abs__action_bar_embed_tabs) {
            if (f >= 480.0f) {
                return true;
            }
            return false;
        } else if (i == C0414R.bool.abs__split_action_bar_is_narrow) {
            if (f >= 480.0f) {
                return false;
            }
            return true;
        } else if (i == C0414R.bool.abs__action_bar_expanded_action_views_exclusive) {
            if (f2 >= 600.0f) {
                return false;
            }
            return true;
        } else if (i != C0414R.bool.abs__config_allowActionMenuItemTextWithIcon) {
            throw new IllegalArgumentException("Unknown boolean resource ID " + i);
        } else if (f >= 480.0f) {
            return true;
        } else {
            return false;
        }
    }

    public static int getResources_getInteger(Context context, int i) {
        if (VERSION.SDK_INT >= 13) {
            return context.getResources().getInteger(i);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) / displayMetrics.density;
        if (i != C0414R.integer.abs__max_action_buttons) {
            throw new IllegalArgumentException("Unknown integer resource ID " + i);
        } else if (f >= 600.0f) {
            return 5;
        } else {
            if (f >= 500.0f) {
                return 4;
            }
            if (f >= 360.0f) {
                return 3;
            }
            return 2;
        }
    }
}
