package com.google.p043a.p045b;

/* compiled from: Streams */
class aj implements CharSequence {
    char[] f1835a;

    aj() {
    }

    public int length() {
        return this.f1835a.length;
    }

    public char charAt(int i) {
        return this.f1835a[i];
    }

    public CharSequence subSequence(int i, int i2) {
        return new String(this.f1835a, i, i2 - i);
    }
}
