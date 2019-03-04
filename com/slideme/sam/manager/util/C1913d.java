package com.slideme.sam.manager.util;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.slideme.sam.manager.model.p054b.C1829c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: DeviceIdentifier */
public abstract class C1913d {
    public static final String m5757a(Context context) {
        return C1913d.m5762b() + '-' + C1913d.m5768d(context);
    }

    public static final String m5763b(Context context) {
        String str = "123";
        try {
            String a = C1913d.m5758a(C1913d.m5757a(context));
            str = a.substring(0, 8) + "-" + a.substring(8, 12) + "-" + a.substring(12, 16) + "-" + a.substring(16, 20) + "-" + a.substring(20, 32);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public static String m5766c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("com.slideme.sam.core.utils.UDID_TOKEN", C1913d.m5757a(context));
    }

    public static void m5760a(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("com.slideme.sam.core.utils.UDID_TOKEN", str).commit();
    }

    private static String m5762b() {
        try {
            return C1913d.m5758a(C1913d.m5765c()).substring(0, 16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String m5768d(Context context) {
        String deviceId;
        StringBuilder stringBuilder = new StringBuilder();
        if (VERSION.SDK_INT >= 9) {
            stringBuilder.append(C1921l.m5783a());
        }
        C1913d.m5761a(stringBuilder);
        String str = "";
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (SecurityException e) {
            Log.d(C1913d.class.getName(), "ID NOT FULL!");
            e.printStackTrace();
            deviceId = str;
        }
        if (C1913d.m5764b(deviceId)) {
            stringBuilder.append(deviceId);
        }
        C1913d.m5761a(stringBuilder);
        str = "";
        try {
            deviceId = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (SecurityException e2) {
            Log.d(C1913d.class.getName(), "ID NOT FULL!");
            e2.printStackTrace();
            deviceId = str;
        }
        if (!(deviceId == null || deviceId.equals(""))) {
            stringBuilder.append(deviceId.replace(":", ""));
        }
        C1913d.m5761a(stringBuilder);
        deviceId = C1913d.m5767d();
        if (C1913d.m5764b(deviceId)) {
            stringBuilder.append(deviceId);
        }
        return stringBuilder.toString();
    }

    private static void m5761a(StringBuilder stringBuilder) {
        stringBuilder.append('-');
    }

    private static String m5765c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C1829c.m5502d());
        stringBuilder.append(C1829c.m5501c());
        if (VERSION.SDK_INT >= 8) {
            stringBuilder.append(C1921l.m5784b());
        }
        stringBuilder.append(C1913d.m5756a());
        return stringBuilder.toString();
    }

    public static String m5756a() {
        StringBuffer stringBuffer = new StringBuffer();
        if (new File("/proc/cpuinfo").exists()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
            Object obj = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.toLowerCase().startsWith("features")) {
                    obj = 1;
                } else {
                    try {
                        if (readLine.toLowerCase().startsWith("serial")) {
                            obj = null;
                        } else if (readLine.toLowerCase().startsWith("cpu part")) {
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (obj != null) {
                    stringBuffer.append(new StringBuilder(String.valueOf(readLine)).append("\n").toString());
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return stringBuffer.toString();
    }

    private static String m5767d() {
        StringBuilder stringBuilder = new StringBuilder();
        if (new File("/proc/cpuinfo").exists()) {
            try {
                String readLine;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    }
                } while (!readLine.toLowerCase().startsWith("serial"));
                bufferedReader.close();
                return readLine.split(":")[1].trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public static String m5758a(String str) {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes("iso-8859-1"), 0, str.length());
        return C1913d.m5759a(instance.digest());
    }

    private static String m5759a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] >>> 4) & 15;
            int i3 = 0;
            while (true) {
                if (i2 < 0 || i2 > 9) {
                    stringBuilder.append((char) ((i2 - 10) + 97));
                } else {
                    stringBuilder.append((char) (i2 + 48));
                }
                int i4 = bArr[i] & 15;
                i2 = i3 + 1;
                if (i3 >= 1) {
                    break;
                }
                i3 = i2;
                i2 = i4;
            }
        }
        return stringBuilder.toString();
    }

    private static boolean m5764b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            int i2;
            if (str.charAt(i) == '0') {
                i2 = 1;
            } else {
                i2 = 0;
            }
            z |= i2;
        }
        return z;
    }
}
