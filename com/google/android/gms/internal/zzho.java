package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.location.places.Place;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgi
public class zzho {
    private final Object zznh = new Object();
    private String zzyW;
    private boolean zzzq = true;
    private boolean zzzr = false;

    final class zza extends BroadcastReceiver {
        final /* synthetic */ zzho zzzs;

        private zza(zzho com_google_android_gms_internal_zzho) {
            this.zzzs = com_google_android_gms_internal_zzho;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.zzzs.zzzq = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.zzzs.zzzq = false;
            }
        }
    }

    private JSONArray zza(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : collection) {
            zza(jSONArray, zza);
        }
        return jSONArray;
    }

    private void zza(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(zzg((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzw((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(zza((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private void zza(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzg((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzw((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private JSONObject zzg(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public String zzS(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    public int zzT(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            zzhx.zzac("Could not parse value:" + e);
            return 0;
        }
    }

    public boolean zzU(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, z);
    }

    public String zza(Context context, View view, zzba com_google_android_gms_internal_zzba) {
        String str = null;
        if (((Boolean) zzca.zzqM.get()).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", com_google_android_gms_internal_zzba.width);
                jSONObject2.put("height", com_google_android_gms_internal_zzba.height);
                jSONObject.put("size", jSONObject2);
                jSONObject.put("activity", zzy(context));
                if (!com_google_android_gms_internal_zzba.zzpb) {
                    JSONArray jSONArray = new JSONArray();
                    while (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent != null) {
                            int i = -1;
                            if (parent instanceof ViewGroup) {
                                i = ((ViewGroup) parent).indexOfChild(view);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("type", parent.getClass().getName());
                            jSONObject3.put("index_of_child", i);
                            jSONArray.put(jSONObject3);
                        }
                        View view2 = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                        view = view2;
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("parents", jSONArray);
                    }
                }
                str = jSONObject.toString();
            } catch (Throwable e) {
                zzhx.zzd("Fail to get view hierarchy json", e);
            }
        }
        return str;
    }

    public String zza(Context context, zzk com_google_android_gms_internal_zzk, String str) {
        if (com_google_android_gms_internal_zzk != null) {
            try {
                Uri parse = Uri.parse(str);
                if (com_google_android_gms_internal_zzk.zzc(parse)) {
                    parse = com_google_android_gms_internal_zzk.zza(parse, context);
                }
                str = parse.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public String zza(InputStreamReader inputStreamReader) {
        StringBuilder stringBuilder = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    JSONArray zza(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : objArr) {
            zza(jSONArray, zza);
        }
        return jSONArray;
    }

    public void zza(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public void zza(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(zze(context, str));
    }

    public void zza(Context context, String str, List<String> list) {
        for (String com_google_android_gms_internal_zzhu : list) {
            new zzhu(context, str, com_google_android_gms_internal_zzhu).start();
        }
    }

    public void zza(Context context, String str, List<String> list, String str2) {
        for (String com_google_android_gms_internal_zzhu : list) {
            new zzhu(context, str, com_google_android_gms_internal_zzhu, str2).start();
        }
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        zza(context, str, z, httpURLConnection, false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, String str2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", str2);
        httpURLConnection.setUseCaches(false);
    }

    public void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zze(context, str));
        httpURLConnection.setUseCaches(z2);
    }

    public boolean zza(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    public String zzb(zzic com_google_android_gms_internal_zzic, String str) {
        return zza(com_google_android_gms_internal_zzic.getContext(), com_google_android_gms_internal_zzic.zzeI(), str);
    }

    public void zzc(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, arrayList);
    }

    public Map<String, String> zzd(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : zzab.zzaO().zze(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    public String zze(final Context context, String str) {
        String str2;
        synchronized (this.zznh) {
            if (this.zzyW != null) {
                str2 = this.zzyW;
            } else {
                try {
                    this.zzyW = zzab.zzaO().getDefaultUserAgent(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.zzyW)) {
                    if (zzbe.zzbD().zzeC()) {
                        try {
                            this.zzyW = zzv(context);
                        } catch (Exception e2) {
                            this.zzyW = zzet();
                        }
                    } else {
                        this.zzyW = null;
                        zzhw.zzzG.post(new Runnable(this) {
                            final /* synthetic */ zzho zzzs;

                            public void run() {
                                synchronized (this.zzzs.zznh) {
                                    this.zzzs.zzyW = this.zzzs.zzv(context);
                                    this.zzzs.zznh.notifyAll();
                                }
                            }
                        });
                        while (this.zzyW == null) {
                            try {
                                this.zznh.wait();
                            } catch (InterruptedException e3) {
                                this.zzyW = zzet();
                                zzhx.zzac("Interrupted, use default user agent: " + this.zzyW);
                            }
                        }
                    }
                }
                this.zzyW += " (Mobile; " + str + ")";
                str2 = this.zzyW;
            }
        }
        return str2;
    }

    public boolean zzes() {
        return this.zzzq;
    }

    String zzet() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public String zzeu() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public String zzev() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    protected int[] zzew() {
        return new int[]{0, 0};
    }

    public int[] zzg(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return zzew();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    public Bitmap zzh(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public int[] zzh(Activity activity) {
        int[] zzg = zzg(activity);
        return new int[]{zzbe.zzbD().zzc(activity, zzg[0]), zzbe.zzbD().zzc(activity, zzg[1])};
    }

    public int[] zzi(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return zzew();
        }
        return new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
    }

    public int[] zzj(Activity activity) {
        int[] zzi = zzi(activity);
        return new int[]{zzbe.zzbD().zzc(activity, zzi[0]), zzbe.zzbD().zzc(activity, zzi[1])};
    }

    public int zzk(Activity activity) {
        if (activity == null) {
            zzhx.zzac("Fail to get AdActivity type since it is null");
            return 0;
        }
        zzeo zzb = zzeo.zzb(activity.getIntent());
        if (zzb == null) {
            zzhx.zzac("Fail to get AdOverlayInfo");
            return 0;
        }
        switch (zzb.zzuw) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 0;
        }
    }

    public boolean zzt(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            zzhx.zzac("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & Place.TYPE_SUBLOCALITY_LEVEL_2) == 0) {
            zzhx.zzac(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        zzhx.zzac(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public boolean zzu(Context context) {
        if (this.zzzr) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zza(), intentFilter);
        this.zzzr = true;
        return true;
    }

    protected String zzv(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public Builder zzw(Context context) {
        return new Builder(context);
    }

    public JSONObject zzw(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public zzbu zzx(Context context) {
        return new zzbu(context);
    }

    public String zzy(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        List runningTasks = activityManager.getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
            if (!(runningTaskInfo == null || runningTaskInfo.topActivity == null)) {
                return runningTaskInfo.topActivity.getClassName();
            }
        }
        return null;
    }
}
