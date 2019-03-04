package com.google.android.gms.tagmanager;

class zzdd extends Number implements Comparable<zzdd> {
    private double zzaBi;
    private long zzaBj;
    private boolean zzaBk = false;

    private zzdd(double d) {
        this.zzaBi = d;
    }

    private zzdd(long j) {
        this.zzaBj = j;
    }

    public static zzdd zzI(long j) {
        return new zzdd(j);
    }

    public static zzdd zza(Double d) {
        return new zzdd(d.doubleValue());
    }

    public static zzdd zzdn(String str) {
        try {
            return new zzdd(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new zzdd(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zza((zzdd) obj);
    }

    public double doubleValue() {
        return zztV() ? (double) this.zzaBj : this.zzaBi;
    }

    public boolean equals(Object obj) {
        return (obj instanceof zzdd) && zza((zzdd) obj) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return zztX();
    }

    public long longValue() {
        return zztW();
    }

    public short shortValue() {
        return zztY();
    }

    public String toString() {
        return zztV() ? Long.toString(this.zzaBj) : Double.toString(this.zzaBi);
    }

    public int zza(zzdd com_google_android_gms_tagmanager_zzdd) {
        return (zztV() && com_google_android_gms_tagmanager_zzdd.zztV()) ? new Long(this.zzaBj).compareTo(Long.valueOf(com_google_android_gms_tagmanager_zzdd.zzaBj)) : Double.compare(doubleValue(), com_google_android_gms_tagmanager_zzdd.doubleValue());
    }

    public boolean zztU() {
        return !zztV();
    }

    public boolean zztV() {
        return this.zzaBk;
    }

    public long zztW() {
        return zztV() ? this.zzaBj : (long) this.zzaBi;
    }

    public int zztX() {
        return (int) longValue();
    }

    public short zztY() {
        return (short) ((int) longValue());
    }
}
