package com.p019a.p020a.p023c;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import p006b.p007a.p008a.p009a.C0326f;
import p006b.p007a.p008a.p009a.p010a.p012b.C0214m;

/* compiled from: MetaDataStore */
class bc {
    private static final Charset f1252a = Charset.forName("UTF-8");
    private final File f1253b;

    public bc(File file) {
        this.f1253b = file;
    }

    public void m2605a(String str, cb cbVar) {
        Closeable bufferedWriter;
        Throwable e;
        File c = m2600c(str);
        Closeable closeable = null;
        try {
            String a = bc.m2597a(cbVar);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c), f1252a));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                C0214m.m1913a(bufferedWriter, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0326f.m2298h().mo519e("CrashlyticsCore", "Error serializing user metadata.", e);
                    C0214m.m1913a(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    C0214m.m1913a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            C0326f.m2298h().mo519e("CrashlyticsCore", "Error serializing user metadata.", e);
            C0214m.m1913a(bufferedWriter, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            e = th2;
            C0214m.m1913a(closeable, "Failed to close user metadata file.");
            throw e;
        }
    }

    public cb m2604a(String str) {
        Throwable e;
        File c = m2600c(str);
        if (!c.exists()) {
            return cb.f1316a;
        }
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(c);
            try {
                cb e2 = bc.m2602e(C0214m.m1901a((InputStream) fileInputStream));
                C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
                return e2;
            } catch (Exception e3) {
                e = e3;
                try {
                    C0326f.m2298h().mo519e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
                    return cb.f1316a;
                } catch (Throwable th) {
                    e = th;
                    C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            C0326f.m2298h().mo519e("CrashlyticsCore", "Error deserializing user metadata.", e);
            C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
            return cb.f1316a;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    public void m2606a(String str, Map<String, String> map) {
        Closeable bufferedWriter;
        Throwable e;
        File d = m2601d(str);
        Closeable closeable = null;
        try {
            String a = bc.m2598a((Map) map);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d), f1252a));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                C0214m.m1913a(bufferedWriter, "Failed to close key/value metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0326f.m2298h().mo519e("CrashlyticsCore", "Error serializing key/value metadata.", e);
                    C0214m.m1913a(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    C0214m.m1913a(closeable, "Failed to close key/value metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            C0326f.m2298h().mo519e("CrashlyticsCore", "Error serializing key/value metadata.", e);
            C0214m.m1913a(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            e = th2;
            C0214m.m1913a(closeable, "Failed to close key/value metadata file.");
            throw e;
        }
    }

    public Map<String, String> m2607b(String str) {
        Closeable fileInputStream;
        Throwable e;
        File d = m2601d(str);
        if (!d.exists()) {
            return Collections.emptyMap();
        }
        try {
            fileInputStream = new FileInputStream(d);
            try {
                Map<String, String> f = bc.m2603f(C0214m.m1901a((InputStream) fileInputStream));
                C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
                return f;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0326f.m2298h().mo519e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    e = th;
                    C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C0326f.m2298h().mo519e("CrashlyticsCore", "Error deserializing user metadata.", e);
            C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C0214m.m1913a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    private File m2600c(String str) {
        return new File(this.f1253b, str + "user" + ".meta");
    }

    private File m2601d(String str) {
        return new File(this.f1253b, str + "keys" + ".meta");
    }

    private static cb m2602e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new cb(bc.m2599a(jSONObject, "userId"), bc.m2599a(jSONObject, "userName"), bc.m2599a(jSONObject, "userEmail"));
    }

    private static String m2597a(cb cbVar) {
        return new bd(cbVar).toString();
    }

    private static Map<String, String> m2603f(String str) {
        JSONObject jSONObject = new JSONObject(str);
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, bc.m2599a(jSONObject, str2));
        }
        return hashMap;
    }

    private static String m2598a(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static String m2599a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}
