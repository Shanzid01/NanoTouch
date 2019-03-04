package p006b.p007a.p008a.p009a.p010a.p012b;

/* compiled from: AdvertisingInfo */
class C0203b {
    public final String f774a;
    public final boolean f775b;

    C0203b(String str, boolean z) {
        this.f774a = str;
        this.f775b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0203b c0203b = (C0203b) obj;
        if (this.f775b != c0203b.f775b) {
            return false;
        }
        if (this.f774a != null) {
            if (this.f774a.equals(c0203b.f774a)) {
                return true;
            }
        } else if (c0203b.f774a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f774a != null) {
            hashCode = this.f774a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f775b) {
            i = 1;
        }
        return hashCode + i;
    }
}
