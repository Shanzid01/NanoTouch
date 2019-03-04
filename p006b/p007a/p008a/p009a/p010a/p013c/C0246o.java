package p006b.p007a.p008a.p009a.p010a.p013c;

/* compiled from: Priority */
public enum C0246o {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int compareTo(C0247u c0247u, Y y) {
        C0246o b;
        if (y instanceof C0247u) {
            b = ((C0247u) y).mo471b();
        } else {
            b = NORMAL;
        }
        return b.ordinal() - c0247u.mo471b().ordinal();
    }
}
