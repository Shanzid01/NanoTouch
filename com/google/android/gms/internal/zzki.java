package com.google.android.gms.internal;

public abstract class zzki<T> {
    private static zza zzNG = null;
    private static int zzNH = 0;
    private static final Object zzmz = new Object();
    private T zzNI = null;
    protected final String zzqd;
    protected final T zzqe;

    final class C12561 extends zzki<Boolean> {
        C12561(String str, Boolean bool) {
            super(str, bool);
        }

        protected /* synthetic */ Object zzaV(String str) {
            return zzaW(str);
        }

        protected Boolean zzaW(String str) {
            return zzki.zzNG.zzb(this.zzqd, (Boolean) this.zzqe);
        }
    }

    final class C12572 extends zzki<Long> {
        C12572(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object zzaV(String str) {
            return zzaX(str);
        }

        protected Long zzaX(String str) {
            return zzki.zzNG.getLong(this.zzqd, (Long) this.zzqe);
        }
    }

    final class C12583 extends zzki<Integer> {
        C12583(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object zzaV(String str) {
            return zzaY(str);
        }

        protected Integer zzaY(String str) {
            return zzki.zzNG.zzb(this.zzqd, (Integer) this.zzqe);
        }
    }

    final class C12594 extends zzki<String> {
        C12594(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object zzaV(String str) {
            return zzaZ(str);
        }

        protected String zzaZ(String str) {
            return zzki.zzNG.getString(this.zzqd, (String) this.zzqe);
        }
    }

    interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zzb(String str, Boolean bool);

        Integer zzb(String str, Integer num);
    }

    protected zzki(String str, T t) {
        this.zzqd = str;
        this.zzqe = t;
    }

    public static boolean isInitialized() {
        return zzNG != null;
    }

    public static zzki<Integer> zza(String str, Integer num) {
        return new C12583(str, num);
    }

    public static zzki<Long> zza(String str, Long l) {
        return new C12572(str, l);
    }

    public static zzki<Boolean> zzg(String str, boolean z) {
        return new C12561(str, Boolean.valueOf(z));
    }

    public static int zzis() {
        return zzNH;
    }

    public static zzki<String> zzp(String str, String str2) {
        return new C12594(str, str2);
    }

    public final T get() {
        return this.zzNI != null ? this.zzNI : zzaV(this.zzqd);
    }

    protected abstract T zzaV(String str);
}
