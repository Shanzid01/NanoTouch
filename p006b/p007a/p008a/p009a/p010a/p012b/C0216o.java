package p006b.p007a.p008a.p009a.p010a.p012b;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: CommonUtils */
enum C0216o {
    X86_32,
    X86_64,
    ARM_UNKNOWN,
    PPC,
    PPC64,
    ARMV6,
    ARMV7,
    UNKNOWN,
    ARMV7S,
    ARM64;
    
    private static final Map<String, C0216o> matcher = null;

    static {
        matcher = new HashMap(4);
        matcher.put("armeabi-v7a", ARMV7);
        matcher.put("armeabi", ARMV6);
        matcher.put("x86", X86_32);
    }

    static C0216o getValue() {
        Object obj = Build.CPU_ABI;
        if (TextUtils.isEmpty(obj)) {
            C0326f.m2298h().mo511a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
            return UNKNOWN;
        }
        C0216o c0216o = (C0216o) matcher.get(obj.toLowerCase(Locale.US));
        if (c0216o == null) {
            return UNKNOWN;
        }
        return c0216o;
    }
}
