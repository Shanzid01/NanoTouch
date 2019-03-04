package com.p019a.p020a.p023c;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: SessionReport */
class ca implements bv {
    private final File f1314a;
    private final Map<String, String> f1315b;

    public ca(File file) {
        this(file, Collections.emptyMap());
    }

    public ca(File file, Map<String, String> map) {
        this.f1314a = file;
        this.f1315b = new HashMap(map);
        if (this.f1314a.length() == 0) {
            this.f1315b.putAll(bw.f1295a);
        }
    }

    public File mo562d() {
        return this.f1314a;
    }

    public String mo560b() {
        return mo562d().getName();
    }

    public String mo561c() {
        String b = mo560b();
        return b.substring(0, b.lastIndexOf(46));
    }

    public Map<String, String> mo563e() {
        return Collections.unmodifiableMap(this.f1315b);
    }

    public boolean mo559a() {
        C0326f.m2298h().mo511a("CrashlyticsCore", "Removing report at " + this.f1314a.getPath());
        return this.f1314a.delete();
    }
}
