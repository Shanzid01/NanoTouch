package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzao {
    private static MessageDigest zzoz = null;
    protected Object zznh = new Object();

    protected MessageDigest zzby() {
        MessageDigest messageDigest;
        synchronized (this.zznh) {
            if (zzoz != null) {
                messageDigest = zzoz;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzoz = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzoz;
            }
        }
        return messageDigest;
    }

    abstract byte[] zzl(String str);
}
