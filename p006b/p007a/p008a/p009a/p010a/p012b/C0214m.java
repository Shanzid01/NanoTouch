package p006b.p007a.p008a.p009a.p010a.p012b;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.google.android.gms.location.places.Place;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: CommonUtils */
public class C0214m {
    public static final Comparator<File> f785a = new C0215n();
    private static Boolean f786b = null;
    private static final char[] f787c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long f788d = -1;
    private static Boolean f789e = null;

    public static SharedPreferences m1898a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String m1900a(File file, String str) {
        Closeable bufferedReader;
        Throwable e;
        Throwable th;
        String str2 = null;
        if (file.exists()) {
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), Place.TYPE_SUBLOCALITY_LEVEL_2);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                str2 = split[1];
                C0214m.m1913a(bufferedReader, "Failed to close system file reader.");
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                try {
                    C0326f.m2298h().mo519e("Fabric", "Error parsing " + file, e);
                    C0214m.m1913a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    C0214m.m1913a(bufferedReader, "Failed to close system file reader.");
                    throw th;
                }
            } catch (Throwable e4) {
                bufferedReader = null;
                th = e4;
                C0214m.m1913a(bufferedReader, "Failed to close system file reader.");
                throw th;
            }
        }
        return str2;
    }

    public static int m1893a() {
        return C0216o.getValue().ordinal();
    }

    public static synchronized long m1917b() {
        long j;
        synchronized (C0214m.class) {
            if (f788d == -1) {
                j = 0;
                Object a = C0214m.m1900a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String toUpperCase = a.toUpperCase(Locale.US);
                    try {
                        if (toUpperCase.endsWith("KB")) {
                            j = C0214m.m1896a(toUpperCase, "KB", (int) Place.TYPE_SUBLOCALITY_LEVEL_2);
                        } else if (toUpperCase.endsWith("MB")) {
                            j = C0214m.m1896a(toUpperCase, "MB", 1048576);
                        } else if (toUpperCase.endsWith("GB")) {
                            j = C0214m.m1896a(toUpperCase, "GB", 1073741824);
                        } else {
                            C0326f.m2298h().mo511a("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase);
                        }
                    } catch (Throwable e) {
                        C0326f.m2298h().mo519e("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase, e);
                    }
                }
                f788d = j;
            }
            j = f788d;
        }
        return j;
    }

    static long m1896a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo m1897a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String m1901a(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String m1903a(String str) {
        return C0214m.m1904a(str, "SHA-1");
    }

    public static String m1922b(InputStream inputStream) {
        return C0214m.m1902a(inputStream, "SHA-1");
    }

    private static String m1902a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[Place.TYPE_SUBLOCALITY_LEVEL_2];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return C0214m.m1905a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    private static String m1906a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return C0214m.m1905a(instance.digest());
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    private static String m1904a(String str, String str2) {
        return C0214m.m1906a(str.getBytes(), str2);
    }

    public static String m1907a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String append2 = stringBuilder.toString();
        return append2.length() > 0 ? C0214m.m1903a(append2) : null;
    }

    public static long m1918b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long m1919b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    public static float m1923c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
    }

    public static boolean m1927d(Context context) {
        if (C0214m.m1929f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void m1910a(Context context, String str) {
        if (C0214m.m1928e(context)) {
            C0326f.m2298h().mo511a("Fabric", str);
        }
    }

    public static void m1911a(Context context, String str, Throwable th) {
        if (C0214m.m1928e(context)) {
            C0326f.m2298h().mo518e("Fabric", str);
        }
    }

    public static void m1909a(Context context, int i, String str, String str2) {
        if (C0214m.m1928e(context)) {
            C0326f.m2298h().mo510a(i, "Fabric", str2);
        }
    }

    public static boolean m1928e(Context context) {
        if (f786b == null) {
            f786b = Boolean.valueOf(C0214m.m1916a(context, "com.crashlytics.Trace", false));
        }
        return f786b.booleanValue();
    }

    public static boolean m1916a(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return z;
        }
        int a = C0214m.m1894a(context, str, "bool");
        if (a > 0) {
            return resources.getBoolean(a);
        }
        int a2 = C0214m.m1894a(context, str, "string");
        if (a2 > 0) {
            return Boolean.parseBoolean(context.getString(a2));
        }
        return z;
    }

    public static int m1894a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, C0214m.m1933j(context));
    }

    public static boolean m1929f(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean m1930g(Context context) {
        boolean f = C0214m.m1929f(context);
        String str = Build.TAGS;
        if ((!f && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (f || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean m1924c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int m1931h(Context context) {
        int i = 0;
        if (C0214m.m1929f(context)) {
            i = 1;
        }
        if (C0214m.m1930g(context)) {
            i |= 2;
        }
        if (C0214m.m1924c()) {
            return i | 4;
        }
        return i;
    }

    public static int m1895a(Context context, boolean z) {
        float c = C0214m.m1923c(context);
        if (!z) {
            return 1;
        }
        if (z && ((double) c) >= 99.0d) {
            return 3;
        }
        if (!z || ((double) c) >= 99.0d) {
            return 0;
        }
        return 2;
    }

    @SuppressLint({"GetInstance"})
    public static Cipher m1908a(int i, String str) {
        if (str.length() < 32) {
            throw new InvalidKeyException("Key must be at least 32 bytes.");
        }
        Key secretKeySpec = new SecretKeySpec(str.getBytes(), 0, 32, "AES/ECB/PKCS7Padding");
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding");
            instance.init(i, secretKeySpec);
            return instance;
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Could not create Cipher for AES/ECB/PKCS7Padding - should never happen.", e);
            throw new RuntimeException(e);
        }
    }

    public static String m1905a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f787c[i2 >>> 4];
            cArr[(i * 2) + 1] = f787c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean m1932i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String m1921b(Context context, String str) {
        int a = C0214m.m1894a(context, str, "string");
        if (a > 0) {
            return context.getString(a);
        }
        return "";
    }

    public static void m1913a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Fabric", str, e);
            }
        }
    }

    public static void m1914a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Fabric", str, e);
            }
        }
    }

    public static boolean m1926c(String str) {
        return str == null || str.length() == 0;
    }

    public static String m1899a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
    }

    public static String m1933j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void m1915a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String m1920b(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static String m1934k(Context context) {
        Throwable e;
        Throwable th;
        String str = null;
        Closeable openRawResource;
        try {
            openRawResource = context.getResources().openRawResource(C0214m.m1935l(context));
            try {
                String b = C0214m.m1922b((InputStream) openRawResource);
                if (!C0214m.m1926c(b)) {
                    str = b;
                }
                C0214m.m1913a(openRawResource, "Failed to close icon input stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0326f.m2298h().mo519e("Fabric", "Could not calculate hash for app icon.", e);
                    C0214m.m1913a(openRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C0214m.m1913a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            C0326f.m2298h().mo519e("Fabric", "Could not calculate hash for app icon.", e);
            C0214m.m1913a(openRawResource, "Failed to close icon input stream.");
            return str;
        } catch (Throwable e4) {
            openRawResource = null;
            th = e4;
            C0214m.m1913a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
        return str;
    }

    public static int m1935l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m1936m(Context context) {
        int a = C0214m.m1894a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = C0214m.m1894a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        C0326f.m2298h().mo511a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void m1912a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean m1925c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean m1937n(Context context) {
        if (!C0214m.m1925c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
