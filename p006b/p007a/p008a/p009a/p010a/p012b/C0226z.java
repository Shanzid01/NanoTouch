package p006b.p007a.p008a.p009a.p010a.p012b;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.json.JSONObject;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;

/* compiled from: IdManager */
public class C0226z {
    private static final Pattern f799d = Pattern.compile("[^\\p{Alnum}]");
    private static final String f800e = Pattern.quote("/");
    C0204c f801a;
    C0203b f802b;
    boolean f803c;
    private final ReentrantLock f804f = new ReentrantLock();
    private final ab f805g;
    private final boolean f806h;
    private final boolean f807i;
    private final Context f808j;
    private final String f809k;
    private final String f810l;
    private final Collection<C0337q> f811m;

    public C0226z(Context context, String str, String str2, Collection<C0337q> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.f808j = context;
            this.f809k = str;
            this.f810l = str2;
            this.f811m = collection;
            this.f805g = new ab();
            this.f801a = new C0204c(context);
            this.f806h = C0214m.m1916a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f806h) {
                C0326f.m2298h().mo511a("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f807i = C0214m.m1916a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f807i) {
                C0326f.m2298h().mo511a("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        }
    }

    public String m1957a(String str, String str2) {
        try {
            Cipher a = C0214m.m1908a(1, C0214m.m1903a(str + str2.replaceAll("\\.", new StringBuilder(new String(new char[]{'s', 'l', 'c'})).reverse().toString())));
            JSONObject jSONObject = new JSONObject();
            m1950a(jSONObject);
            m1953b(jSONObject);
            m1955c(jSONObject);
            m1956d(jSONObject);
            String str3 = "";
            if (jSONObject.length() <= 0) {
                return str3;
            }
            try {
                return C0214m.m1905a(a.doFinal(jSONObject.toString().getBytes()));
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Fabric", "Could not encrypt IDs", e);
                return str3;
            }
        } catch (Throwable e2) {
            C0326f.m2298h().mo519e("Fabric", "Could not create cipher to encrypt headers.", e2);
            return "";
        }
    }

    private void m1950a(JSONObject jSONObject) {
        try {
            jSONObject.put("APPLICATION_INSTALLATION_UUID".toLowerCase(Locale.US), m1959b());
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Could not write application id to JSON", e);
        }
    }

    private void m1953b(JSONObject jSONObject) {
        for (Entry entry : m1964g().entrySet()) {
            try {
                jSONObject.put(((aa) entry.getKey()).name().toLowerCase(Locale.US), entry.getValue());
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Fabric", "Could not write value to JSON: " + ((aa) entry.getKey()).name(), e);
            }
        }
    }

    private void m1955c(JSONObject jSONObject) {
        try {
            jSONObject.put("os_version", m1961d());
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Could not write OS version to JSON", e);
        }
    }

    private void m1956d(JSONObject jSONObject) {
        try {
            jSONObject.put("model", m1962e());
        } catch (Throwable e) {
            C0326f.m2298h().mo519e("Fabric", "Could not write model to JSON", e);
        }
    }

    public boolean m1958a() {
        return this.f807i;
    }

    private boolean m1951a(String str) {
        return this.f808j.checkCallingPermission(str) == 0;
    }

    private String m1952b(String str) {
        return str == null ? null : f799d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String m1959b() {
        String str = this.f810l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = C0214m.m1898a(this.f808j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m1948a(a);
        }
        return str;
    }

    public String m1960c() {
        return this.f809k;
    }

    public String m1961d() {
        return String.format(Locale.US, "%s/%s", new Object[]{m1954c(VERSION.RELEASE), m1954c(VERSION.INCREMENTAL)});
    }

    public String m1962e() {
        return String.format(Locale.US, "%s/%s", new Object[]{m1954c(Build.MANUFACTURER), m1954c(Build.MODEL)});
    }

    private String m1954c(String str) {
        return str.replaceAll(f800e, "");
    }

    public String m1963f() {
        String str = "";
        if (!this.f806h) {
            return str;
        }
        str = m1969l();
        if (str != null) {
            return str;
        }
        SharedPreferences a = C0214m.m1898a(this.f808j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m1948a(a);
        }
        return str;
    }

    private String m1948a(SharedPreferences sharedPreferences) {
        this.f804f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m1952b(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.f804f.unlock();
            return string;
        } catch (Throwable th) {
            this.f804f.unlock();
        }
    }

    public Map<aa, String> m1964g() {
        Map hashMap = new HashMap();
        for (C0337q c0337q : this.f811m) {
            if (c0337q instanceof C0221u) {
                for (Entry entry : ((C0221u) c0337q).mo549e().entrySet()) {
                    m1949a(hashMap, (aa) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m1949a(hashMap, aa.ANDROID_ID, m1969l());
        m1949a(hashMap, aa.ANDROID_DEVICE_ID, m1970m());
        m1949a(hashMap, aa.ANDROID_SERIAL, m1973p());
        m1949a(hashMap, aa.WIFI_MAC_ADDRESS, m1971n());
        m1949a(hashMap, aa.BLUETOOTH_MAC_ADDRESS, m1972o());
        m1949a(hashMap, aa.ANDROID_ADVERTISING_ID, m1968k());
        return Collections.unmodifiableMap(hashMap);
    }

    public String m1965h() {
        return this.f805g.m1828a(this.f808j);
    }

    synchronized C0203b m1966i() {
        if (!this.f803c) {
            this.f802b = this.f801a.m1872a();
            this.f803c = true;
        }
        return this.f802b;
    }

    public Boolean m1967j() {
        if (!this.f806h) {
            return null;
        }
        C0203b i = m1966i();
        if (i != null) {
            return Boolean.valueOf(i.f775b);
        }
        return null;
    }

    public String m1968k() {
        if (!this.f806h) {
            return null;
        }
        C0203b i = m1966i();
        if (i != null) {
            return i.f774a;
        }
        return null;
    }

    private void m1949a(Map<aa, String> map, aa aaVar, String str) {
        if (str != null) {
            map.put(aaVar, str);
        }
    }

    public String m1969l() {
        if (!this.f806h) {
            return null;
        }
        String string = Secure.getString(this.f808j.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return m1952b(string);
    }

    public String m1970m() {
        if (this.f806h && m1951a("android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f808j.getSystemService("phone");
            if (telephonyManager != null) {
                return m1952b(telephonyManager.getDeviceId());
            }
        }
        return null;
    }

    public String m1971n() {
        if (this.f806h && m1951a("android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) this.f808j.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    return m1952b(connectionInfo.getMacAddress());
                }
            }
        }
        return null;
    }

    public String m1972o() {
        if (this.f806h && m1951a("android.permission.BLUETOOTH")) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    m1952b(defaultAdapter.getAddress());
                }
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Fabric", "Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()", e);
            }
        }
        return null;
    }

    public String m1973p() {
        if (this.f806h && VERSION.SDK_INT >= 9) {
            try {
                return m1952b((String) Build.class.getField("SERIAL").get(null));
            } catch (Throwable e) {
                C0326f.m2298h().mo519e("Fabric", "Could not retrieve android.os.Build.SERIAL value", e);
            }
        }
        return null;
    }
}
