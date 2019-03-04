package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.actionbarsherlock.view.Menu;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@zzgi
public class zzhw {
    public static final Handler zzzG = new Handler(Looper.getMainLooper());

    private void zza(ViewGroup viewGroup, zzba com_google_android_gms_internal_zzba, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int zzb = zzb(context, 3);
            frameLayout.addView(textView, new LayoutParams(com_google_android_gms_internal_zzba.widthPixels - zzb, com_google_android_gms_internal_zzba.heightPixels - zzb, 17));
            viewGroup.addView(frameLayout, com_google_android_gms_internal_zzba.widthPixels, com_google_android_gms_internal_zzba.heightPixels);
        }
    }

    public boolean zzA(Context context) {
        return GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0;
    }

    public String zzX(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }

    public int zza(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public void zza(ViewGroup viewGroup, zzba com_google_android_gms_internal_zzba, String str) {
        zza(viewGroup, com_google_android_gms_internal_zzba, str, -16777216, -1);
    }

    public void zza(ViewGroup viewGroup, zzba com_google_android_gms_internal_zzba, String str, String str2) {
        zzhx.zzac(str2);
        zza(viewGroup, com_google_android_gms_internal_zzba, str, Menu.CATEGORY_MASK, -16777216);
    }

    public int zzb(Context context, int i) {
        return zza(context.getResources().getDisplayMetrics(), i);
    }

    public int zzb(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    public int zzc(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return zzb(displayMetrics, i);
    }

    public boolean zzeB() {
        return Build.DEVICE.startsWith("generic");
    }

    public boolean zzeC() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public String zzz(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || zzeB()) {
            string = "emulator";
        }
        return zzX(string);
    }
}
