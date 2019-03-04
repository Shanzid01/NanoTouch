package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: GAThread */
class ah extends Thread implements C0758j {
    private static ah f1974i;
    private final LinkedBlockingQueue<Runnable> f1975a = new LinkedBlockingQueue();
    private volatile boolean f1976b = false;
    private volatile boolean f1977c = false;
    private volatile boolean f1978d;
    private volatile List<Command> f1979e;
    private volatile aw f1980f;
    private volatile String f1981g;
    private volatile String f1982h;
    private volatile bj f1983j;
    private final Context f1984k;

    static ah m3753a(Context context) {
        if (f1974i == null) {
            f1974i = new ah(context);
        }
        return f1974i;
    }

    private ah(Context context) {
        super("GAThread");
        if (context != null) {
            this.f1984k = context.getApplicationContext();
        } else {
            this.f1984k = context;
        }
        start();
    }

    private void m3773e() {
        this.f1983j.mo1225e();
        this.f1979e = new ArrayList();
        this.f1979e.add(new Command(Command.APPEND_VERSION, "_v", "ma1b4"));
        this.f1979e.add(new Command(Command.APPEND_QUEUE_TIME, "qt", null));
        this.f1979e.add(new Command(Command.APPEND_CACHE_BUSTER, "z", null));
        this.f1980f = new aw();
        az.m3830a(this.f1980f);
    }

    public void mo1184a(Map<String, String> map) {
        Map hashMap = new HashMap(map);
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("hitTime", Long.toString(currentTimeMillis));
        m3757a(new ai(this, hashMap, currentTimeMillis));
    }

    private String m3762b(Map<String, String> map) {
        String str = (String) map.get("internalHitUrl");
        if (str != null) {
            return str;
        }
        if (map.containsKey("useSecure")) {
            return bq.m3912c((String) map.get("useSecure")) ? "https://ssl.google-analytics.com/collect" : "http://www.google-analytics.com/collect";
        } else {
            return "https://ssl.google-analytics.com/collect";
        }
    }

    private void m3767c(Map<String, String> map) {
        String str = (String) map.get("rawException");
        if (str != null) {
            map.remove("rawException");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bq.m3914e(str)));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject instanceof Throwable) {
                    Throwable th = (Throwable) readObject;
                    map.put("exDescription", new bl(this.f1984k, new ArrayList()).mo1202a((String) map.get("exceptionThreadName"), th));
                }
            } catch (IOException e) {
                av.m3821h("IOException reading exception");
            } catch (ClassNotFoundException e2) {
                av.m3821h("ClassNotFoundException reading exception");
            }
        }
    }

    private boolean m3770d(Map<String, String> map) {
        if (map.get("sampleRate") != null) {
            double b = bq.m3911b((String) map.get("sampleRate"));
            if (b <= 0.0d) {
                return true;
            }
            if (b < 100.0d) {
                String str = (String) map.get("clientId");
                if (str != null && ((double) (Math.abs(str.hashCode()) % 10000)) >= b * 100.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    private void m3774e(Map<String, String> map) {
        String obj;
        PackageManager packageManager = this.f1984k.getPackageManager();
        String packageName = this.f1984k.getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        String str = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.f1984k.getPackageName(), 0);
            if (packageInfo != null) {
                obj = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                try {
                    str = packageInfo.versionName;
                } catch (NameNotFoundException e) {
                    av.m3816c("Error retrieving package info: appName set to " + obj);
                    m3758a(map, "appName", obj);
                    m3758a(map, "appVersion", str);
                    m3758a(map, "appId", packageName);
                    m3758a(map, "appInstallerId", installerPackageName);
                    map.put("apiVersion", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
            }
            obj = packageName;
        } catch (NameNotFoundException e2) {
            obj = packageName;
            av.m3816c("Error retrieving package info: appName set to " + obj);
            m3758a(map, "appName", obj);
            m3758a(map, "appVersion", str);
            m3758a(map, "appId", packageName);
            m3758a(map, "appInstallerId", installerPackageName);
            map.put("apiVersion", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        m3758a(map, "appName", obj);
        m3758a(map, "appVersion", str);
        m3758a(map, "appId", packageName);
        m3758a(map, "appInstallerId", installerPackageName);
        map.put("apiVersion", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    private void m3758a(Map<String, String> map, String str, String str2) {
        if (!map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    private void m3776f(Map<String, String> map) {
        String d = bq.m3913d((String) map.get("campaign"));
        if (!TextUtils.isEmpty(d)) {
            Map a = bq.m3910a(d);
            map.put("campaignContent", a.get("utm_content"));
            map.put("campaignMedium", a.get("utm_medium"));
            map.put("campaignName", a.get("utm_campaign"));
            map.put("campaignSource", a.get("utm_source"));
            map.put("campaignKeyword", a.get("utm_term"));
            map.put("campaignId", a.get("utm_id"));
            map.put("gclid", a.get("gclid"));
            map.put("dclid", a.get("dclid"));
            map.put("gmob_t", a.get("gmob_t"));
        }
    }

    public void mo1181a() {
        m3757a(new aj(this));
    }

    public void mo1182a(ar arVar) {
        m3757a(new ak(this, arVar));
    }

    public void mo1183a(C0759k c0759k) {
        m3757a(new al(this, c0759k));
    }

    private void m3757a(Runnable runnable) {
        this.f1975a.add(runnable);
    }

    private boolean m3777f() {
        return this.f1984k.getFileStreamPath("gaOptOut").exists();
    }

    private boolean m3760a(String str) {
        try {
            FileOutputStream openFileOutput = this.f1984k.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            av.m3816c("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            av.m3816c("Error writing to clientId file.");
            return false;
        }
    }

    private String m3778g() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        if (m3760a(toLowerCase)) {
            return toLowerCase;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO;
    }

    @VisibleForTesting
    String m3785d() {
        String str = null;
        try {
            FileInputStream openFileInput = this.f1984k.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                av.m3816c("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.f1984k.deleteFile("gaInstallData");
            }
            if (read <= 0) {
                av.m3816c("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.f1984k.deleteFile("gaInstallData");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    av.m3816c("Error reading clientId file, deleting it.");
                    this.f1984k.deleteFile("gaInstallData");
                } catch (NumberFormatException e3) {
                    str = str2;
                    av.m3816c("cliendId file doesn't have long value, deleting it.");
                    this.f1984k.deleteFile("gaInstallData");
                }
            }
        } catch (FileNotFoundException e4) {
        } catch (IOException e5) {
            av.m3816c("Error reading clientId file, deleting it.");
            this.f1984k.deleteFile("gaInstallData");
        } catch (NumberFormatException e6) {
            av.m3816c("cliendId file doesn't have long value, deleting it.");
            this.f1984k.deleteFile("gaInstallData");
        }
        if (str == null) {
            return m3778g();
        }
        return str;
    }

    @VisibleForTesting
    static String m3761b(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                av.m3816c("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                av.m3821h("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            av.m3817d("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            av.m3817d("No campaign data found.");
            return null;
        } catch (IOException e2) {
            av.m3816c("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private String m3756a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            av.m3821h("sleep interrupted in GAThread initialize");
        }
        if (this.f1983j == null) {
            this.f1983j = new C0781y(this.f1984k, this);
        }
        m3773e();
        try {
            this.f1978d = m3777f();
            this.f1982h = m3785d();
            this.f1981g = m3761b(this.f1984k);
        } catch (Throwable th) {
            av.m3816c("Error initializing the GAThread: " + m3756a(th));
            av.m3816c("Google Analytics will not start up.");
            this.f1976b = true;
        }
        while (!this.f1977c) {
            try {
                Runnable runnable = (Runnable) this.f1975a.take();
                if (!this.f1976b) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                av.m3817d(e2.toString());
            } catch (Throwable th2) {
                av.m3816c("Error on GAThread: " + m3756a(th2));
                av.m3816c("Google Analytics is shutting down.");
                this.f1976b = true;
            }
        }
    }

    public LinkedBlockingQueue<Runnable> mo1185b() {
        return this.f1975a;
    }

    public Thread mo1186c() {
        return this;
    }
}
