package p006b.p007a.p008a.p009a.p010a.p012b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p006b.p007a.p008a.p009a.C0326f;

/* compiled from: AdvertisingInfoServiceStrategy */
final class C0212i implements IInterface {
    private final IBinder f784a;

    public boolean m1887b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r2 = android.os.Parcel.obtain();
        r3 = android.os.Parcel.obtain();
        r4 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r2.writeInterfaceToken(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r4 = 1;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r2.writeInt(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r4 = r7.f784a;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r5 = 2;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r6 = 0;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r4.transact(r5, r2, r3, r6);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r3.readException();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r4 = r3.readInt();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        if (r4 == 0) goto L_0x002a;
    L_0x0023:
        r3.recycle();
        r2.recycle();
    L_0x0029:
        return r0;
    L_0x002a:
        r0 = r1;
        goto L_0x0023;
    L_0x002c:
        r0 = move-exception;
        r0 = p006b.p007a.p008a.p009a.C0326f.m2298h();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r4 = "Fabric";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r0.mo511a(r4, r5);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
        r3.recycle();
        r2.recycle();
        r0 = r1;
        goto L_0x0029;
    L_0x0040:
        r0 = move-exception;
        r3.recycle();
        r2.recycle();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.a.a.b.i.b():boolean");
    }

    public C0212i(IBinder iBinder) {
        this.f784a = iBinder;
    }

    public IBinder asBinder() {
        return this.f784a;
    }

    public String m1886a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        String str = null;
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f784a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Exception e) {
            C0326f.m2298h().mo511a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
        return str;
    }
}
