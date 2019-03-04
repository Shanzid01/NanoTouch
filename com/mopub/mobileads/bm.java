package com.mopub.mobileads;

/* compiled from: MraidProperty */
abstract class bm {
    public abstract String mo4141a();

    bm() {
    }

    private String m4584a(String str) {
        return str != null ? str.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "") : "";
    }

    public String toString() {
        return m4584a(mo4141a());
    }
}
