package com.google.android.gms.analytics;

public class zzae {
    private static volatile Logger zzEN;

    static {
        setLogger(new zzp());
    }

    static Logger getLogger() {
        return zzEN;
    }

    static void setLogger(Logger logger) {
        zzEN = logger;
    }

    public static void zzZ(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void zzaa(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    public static void zzab(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void zzac(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static boolean zzgw() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }
}
