package p006b.p007a.p008a.p009a.p010a.p018g;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.C0337q;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;
import p006b.p007a.p008a.p009a.p010a.p017f.C0291b;

/* compiled from: DefaultCachedSettingsIo */
class C0302i implements C0300g {
    private final C0337q f947a;

    public C0302i(C0337q c0337q) {
        this.f947a = c0337q;
    }

    public JSONObject mo504a() {
        Throwable e;
        Closeable closeable = null;
        C0326f.m2298h().mo511a("Fabric", "Reading cached settings...");
        Closeable fileInputStream;
        try {
            JSONObject jSONObject;
            File file = new File(new C0291b(this.f947a).mo499a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(C0214m.m1901a((InputStream) fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0326f.m2298h().mo519e("Fabric", "Failed to fetch cached settings", e);
                        C0214m.m1913a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        C0214m.m1913a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            C0326f.m2298h().mo511a("Fabric", "No cached settings found.");
            jSONObject = null;
            C0214m.m1913a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C0326f.m2298h().mo519e("Fabric", "Failed to fetch cached settings", e);
            C0214m.m1913a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            C0214m.m1913a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public void mo505a(long j, JSONObject jSONObject) {
        Closeable fileWriter;
        Throwable e;
        C0326f.m2298h().mo511a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(new File(new C0291b(this.f947a).mo499a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    C0214m.m1913a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0326f.m2298h().mo519e("Fabric", "Failed to cache settings", e);
                        C0214m.m1913a(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileWriter;
                        C0214m.m1913a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
                C0326f.m2298h().mo519e("Fabric", "Failed to cache settings", e);
                C0214m.m1913a(fileWriter, "Failed to close settings writer.");
            } catch (Throwable th2) {
                e = th2;
                C0214m.m1913a(closeable, "Failed to close settings writer.");
                throw e;
            }
        }
    }
}
