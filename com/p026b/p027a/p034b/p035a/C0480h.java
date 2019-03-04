package com.p026b.p027a.p034b.p035a;

import java.util.Comparator;

/* compiled from: MemoryCacheUtil */
final class C0480h implements Comparator<String> {
    C0480h() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2973a((String) obj, (String) obj2);
    }

    public int m2973a(String str, String str2) {
        return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
    }
}
