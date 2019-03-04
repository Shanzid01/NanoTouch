package com.p019a.p020a.p022b;

import java.io.InputStream;
import java.util.Properties;

/* compiled from: BuildProperties */
class C0374f {
    public final String f1169a;
    public final String f1170b;
    public final String f1171c;
    public final String f1172d;

    C0374f(String str, String str2, String str3, String str4) {
        this.f1169a = str;
        this.f1170b = str2;
        this.f1171c = str3;
        this.f1172d = str4;
    }

    public static C0374f m2538a(Properties properties) {
        return new C0374f(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static C0374f m2537a(InputStream inputStream) {
        Properties properties = new Properties();
        properties.load(inputStream);
        return C0374f.m2538a(properties);
    }
}
