package com.slideme.sam.manager.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.StatFs;
import android.support.v4.content.C0090q;
import android.text.TextUtils;
import android.util.Log;
import com.p019a.p020a.C0367a;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.model.data.cache.helper.data.InstallReferrerCacheObject;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

/* compiled from: Utils */
public abstract class C1922m {
    public static final boolean m5793a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static final boolean m5798b(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static final void m5789a(Context context, Intent intent, long j) {
        ((AlarmManager) context.getSystemService("alarm")).set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    public static final void m5799c(Context context) {
        C1922m.m5797b("AdProxy", "checking for pending install referrer broadcasts...");
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0);
        HashSet hashSet = new HashSet();
        for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
            hashSet.add(resolveInfo.activityInfo.packageName);
        }
        InstallReferrerCacheObject[] allPending = SAM.f2623p.getAllPending();
        if (allPending != null) {
            C1922m.m5797b("AdProxy", "Found " + String.valueOf(allPending.length) + " pending install referrer broadcasts");
            for (int i = 0; i < allPending.length; i++) {
                if (hashSet.contains(allPending[i].packageName)) {
                    Intent intent = new Intent();
                    intent.setAction("com.android.vending.INSTALL_REFERRER");
                    intent.putExtra("referrer", allPending[i].referrer);
                    intent.setPackage(allPending[i].packageName);
                    intent.setFlags(32);
                    context.sendBroadcast(intent);
                    C1922m.m5797b("AdProxy", "Sended pending install referrer broadcast for app: " + allPending[i].packageName);
                    SAM.f2623p.update(new InstallReferrerCacheObject(allPending[i].packageName, "", InstallReferrerCacheObject.STATE_DONE));
                }
            }
        }
    }

    public static boolean m5794a(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean m5795a(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static Cookie m5788a(CookieStore cookieStore) {
        if (cookieStore != null) {
            for (Cookie cookie : cookieStore.getCookies()) {
                if (cookie.getName().toLowerCase().startsWith("sess")) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static String m5785a(Cookie cookie) {
        if (cookie == null) {
            return null;
        }
        return new StringBuilder(String.valueOf(Uri.decode(cookie.getName()))).append('=').append(Uri.decode(cookie.getValue())).toString();
    }

    public static Cookie m5786a(String str) {
        return C1922m.m5787a(str, ".slideme.org");
    }

    public static Cookie m5787a(String str, String str2) {
        String[] split = str.split("=");
        Cookie basicClientCookie = new BasicClientCookie(split[0], split[1]);
        if (!TextUtils.isEmpty(str2)) {
            basicClientCookie.setDomain(str2);
        }
        return basicClientCookie;
    }

    public static void m5790a(Exception exception) {
        Throwable th = new Throwable("Handled by SAM", exception);
        if (!C1914e.f3494b) {
            C0367a.m2509e().f1149c.m2778a(th);
        }
        C1922m.m5791a((Throwable) exception);
    }

    public static void m5791a(Throwable th) {
        if (C1914e.f3493a) {
            th.printStackTrace();
        }
    }

    public static void m5797b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (C1914e.f3493a) {
                Log.d(str, str2);
            }
            if (C1914e.f3494b) {
                C0367a.m2509e().f1149c.m2776a(new StringBuilder(String.valueOf(str)).append(" - ").append(str2).toString());
            }
        }
    }

    public static boolean m5792a(long j, File file) {
        StatFs statFs = new StatFs(file.getParent());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) >= j;
    }

    public static void m5800d(Context context) {
        C0090q.m145a(context).m150a(new Intent("com.slideme.sam.manager.action.KILL_SAM"));
    }

    public static void m5801e(Context context) {
        C0090q.m145a(context).m150a(new Intent("com.slideme.sam.manager.action.REFRESH_SAM"));
    }

    public static <T> String m5796b(List<T> list) {
        if (list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (T obj : list) {
            stringBuilder.append(obj.toString());
            stringBuilder.append(",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
