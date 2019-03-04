package com.google.p043a;

import com.google.p043a.p045b.C0704a;
import com.google.p043a.p045b.C0725v;
import java.math.BigInteger;

/* compiled from: JsonPrimitive */
public final class ab extends C0675w {
    private static final Class<?>[] f1667a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object f1668b;

    public ab(Boolean bool) {
        m3280a((Object) bool);
    }

    public ab(Number number) {
        m3280a((Object) number);
    }

    public ab(String str) {
        m3280a((Object) str);
    }

    void m3280a(Object obj) {
        if (obj instanceof Character) {
            this.f1668b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || ab.m3278b(obj);
        C0704a.m3574a(z);
        this.f1668b = obj;
    }

    public boolean m3287o() {
        return this.f1668b instanceof Boolean;
    }

    Boolean mo1119n() {
        return (Boolean) this.f1668b;
    }

    public boolean mo1118f() {
        if (m3287o()) {
            return mo1119n().booleanValue();
        }
        return Boolean.parseBoolean(mo1114b());
    }

    public boolean m3288p() {
        return this.f1668b instanceof Number;
    }

    public Number mo1113a() {
        return this.f1668b instanceof String ? new C0725v((String) this.f1668b) : (Number) this.f1668b;
    }

    public boolean m3289q() {
        return this.f1668b instanceof String;
    }

    public String mo1114b() {
        if (m3288p()) {
            return mo1113a().toString();
        }
        if (m3287o()) {
            return mo1119n().toString();
        }
        return (String) this.f1668b;
    }

    public double mo1115c() {
        return m3288p() ? mo1113a().doubleValue() : Double.parseDouble(mo1114b());
    }

    public long mo1116d() {
        return m3288p() ? mo1113a().longValue() : Long.parseLong(mo1114b());
    }

    public int mo1117e() {
        return m3288p() ? mo1113a().intValue() : Integer.parseInt(mo1114b());
    }

    private static boolean m3278b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : f1667a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f1668b == null) {
            return 31;
        }
        long longValue;
        if (ab.m3277a(this)) {
            longValue = mo1113a().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f1668b instanceof Number)) {
            return this.f1668b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(mo1113a().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ab abVar = (ab) obj;
        if (this.f1668b == null) {
            if (abVar.f1668b != null) {
                return false;
            }
            return true;
        } else if (ab.m3277a(this) && ab.m3277a(abVar)) {
            if (mo1113a().longValue() != abVar.mo1113a().longValue()) {
                return false;
            }
            return true;
        } else if (!(this.f1668b instanceof Number) || !(abVar.f1668b instanceof Number)) {
            return this.f1668b.equals(abVar.f1668b);
        } else {
            double doubleValue = mo1113a().doubleValue();
            double doubleValue2 = abVar.mo1113a().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        }
    }

    private static boolean m3277a(ab abVar) {
        if (!(abVar.f1668b instanceof Number)) {
            return false;
        }
        Number number = (Number) abVar.f1668b;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
