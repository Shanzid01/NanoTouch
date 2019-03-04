package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class zzi extends zzh {
    private static long startTime = 0;
    private static Method zzkA;
    private static Method zzkB;
    private static Method zzkC;
    private static Method zzkD;
    private static Method zzkE;
    private static Method zzkF;
    private static Method zzkG;
    private static Method zzkH;
    private static String zzkI;
    private static String zzkJ;
    private static String zzkK;
    private static zzo zzkL;
    static boolean zzkM = false;
    private static Method zzkz;

    class zza extends Exception {
        public zza(Throwable th) {
            super(th);
        }
    }

    protected zzi(Context context, zzm com_google_android_gms_internal_zzm, zzn com_google_android_gms_internal_zzn) {
        super(context, com_google_android_gms_internal_zzm, com_google_android_gms_internal_zzn);
    }

    static String zza(Context context, zzm com_google_android_gms_internal_zzm) {
        if (zzkJ != null) {
            return zzkJ;
        }
        if (zzkC == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zzkC.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new zza();
            }
            zzkJ = com_google_android_gms_internal_zzm.zza(byteBuffer.array(), true);
            return zzkJ;
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zza(MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        if (zzkD == null || motionEvent == null) {
            throw new zza();
        }
        try {
            return (ArrayList) zzkD.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    protected static synchronized void zza(String str, Context context, zzm com_google_android_gms_internal_zzm) {
        synchronized (zzi.class) {
            if (!zzkM) {
                try {
                    zzkL = new zzo(com_google_android_gms_internal_zzm, null);
                    zzkI = str;
                    zzg(context);
                    startTime = zzw().longValue();
                    zzkM = true;
                } catch (zza e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static String zzb(Context context, zzm com_google_android_gms_internal_zzm) {
        if (zzkK != null) {
            return zzkK;
        }
        if (zzkF == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zzkF.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new zza();
            }
            zzkK = com_google_android_gms_internal_zzm.zza(byteBuffer.array(), true);
            return zzkK;
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    private static String zzb(byte[] bArr, String str) {
        try {
            return new String(zzkL.zzc(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static String zzd(Context context) {
        if (zzkE == null) {
            throw new zza();
        }
        try {
            String str = (String) zzkE.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new zza();
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zze(Context context) {
        if (zzkG == null) {
            throw new zza();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) zzkG.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new zza();
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static int[] zzf(Context context) {
        if (zzkH == null) {
            throw new zza();
        }
        try {
            return (int[]) zzkH.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    private static void zzg(Context context) {
        File file;
        File createTempFile;
        try {
            byte[] zzb = zzkL.zzb(zzq.getKey());
            byte[] zzc = zzkL.zzc(zzb, zzq.zzE());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new zza();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(zzb(zzb, zzq.zzH()));
            Class loadClass2 = dexClassLoader.loadClass(zzb(zzb, zzq.zzT()));
            Class loadClass3 = dexClassLoader.loadClass(zzb(zzb, zzq.zzN()));
            Class loadClass4 = dexClassLoader.loadClass(zzb(zzb, zzq.zzL()));
            Class loadClass5 = dexClassLoader.loadClass(zzb(zzb, zzq.zzV()));
            Class loadClass6 = dexClassLoader.loadClass(zzb(zzb, zzq.zzJ()));
            Class loadClass7 = dexClassLoader.loadClass(zzb(zzb, zzq.zzR()));
            Class loadClass8 = dexClassLoader.loadClass(zzb(zzb, zzq.zzP()));
            Class loadClass9 = dexClassLoader.loadClass(zzb(zzb, zzq.zzF()));
            zzkz = loadClass.getMethod(zzb(zzb, zzq.zzI()), new Class[0]);
            zzkA = loadClass2.getMethod(zzb(zzb, zzq.zzU()), new Class[0]);
            zzkB = loadClass3.getMethod(zzb(zzb, zzq.zzO()), new Class[0]);
            zzkC = loadClass4.getMethod(zzb(zzb, zzq.zzM()), new Class[]{Context.class});
            zzkD = loadClass5.getMethod(zzb(zzb, zzq.zzW()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            zzkE = loadClass6.getMethod(zzb(zzb, zzq.zzK()), new Class[]{Context.class});
            zzkF = loadClass7.getMethod(zzb(zzb, zzq.zzS()), new Class[]{Context.class});
            zzkG = loadClass8.getMethod(zzb(zzb, zzq.zzQ()), new Class[]{Context.class});
            zzkH = loadClass9.getMethod(zzb(zzb, zzq.zzG()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        } catch (Throwable e22) {
            throw new zza(e22);
        } catch (Throwable e222) {
            throw new zza(e222);
        } catch (Throwable e2222) {
            throw new zza(e2222);
        } catch (Throwable e22222) {
            throw new zza(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    static String zzv() {
        if (zzkI != null) {
            return zzkI;
        }
        throw new zza();
    }

    static Long zzw() {
        if (zzkz == null) {
            throw new zza();
        }
        try {
            return (Long) zzkz.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static String zzx() {
        if (zzkB == null) {
            throw new zza();
        }
        try {
            return (String) zzkB.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    static Long zzy() {
        if (zzkA == null) {
            throw new zza();
        }
        try {
            return (Long) zzkA.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new zza(e);
        } catch (Throwable e2) {
            throw new zza(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zzb(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = zzx();	 Catch:{ zza -> 0x00a1, IOException -> 0x0090 }
        r6.zza(r0, r1);	 Catch:{ zza -> 0x00a1, IOException -> 0x0090 }
    L_0x0008:
        r0 = 2;
        r1 = zzv();	 Catch:{ zza -> 0x009e, IOException -> 0x0090 }
        r6.zza(r0, r1);	 Catch:{ zza -> 0x009e, IOException -> 0x0090 }
    L_0x0010:
        r0 = zzw();	 Catch:{ zza -> 0x009c, IOException -> 0x0090 }
        r0 = r0.longValue();	 Catch:{ zza -> 0x009c, IOException -> 0x0090 }
        r2 = 25;
        r6.zza(r2, r0);	 Catch:{ zza -> 0x009c, IOException -> 0x0090 }
        r2 = startTime;	 Catch:{ zza -> 0x009c, IOException -> 0x0090 }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r4 = startTime;	 Catch:{ zza -> 0x009c, IOException -> 0x0090 }
        r0 = r0 - r4;
        r6.zza(r2, r0);	 Catch:{ zza -> 0x009c, IOException -> 0x0090 }
        r0 = 23;
        r2 = startTime;	 Catch:{ zza -> 0x009c, IOException -> 0x0090 }
        r6.zza(r0, r2);	 Catch:{ zza -> 0x009c, IOException -> 0x0090 }
    L_0x0034:
        r1 = zze(r7);	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
        r2 = 31;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
        r0 = (java.lang.Long) r0;	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
        r4 = r0.longValue();	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
        r6.zza(r2, r4);	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
        r2 = 32;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
        r0 = (java.lang.Long) r0;	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
        r0 = r0.longValue();	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
        r6.zza(r2, r0);	 Catch:{ zza -> 0x009a, IOException -> 0x0090 }
    L_0x0058:
        r0 = 33;
        r1 = zzy();	 Catch:{ zza -> 0x0098, IOException -> 0x0090 }
        r2 = r1.longValue();	 Catch:{ zza -> 0x0098, IOException -> 0x0090 }
        r6.zza(r0, r2);	 Catch:{ zza -> 0x0098, IOException -> 0x0090 }
    L_0x0065:
        r0 = 27;
        r1 = r6.zzkx;	 Catch:{ zza -> 0x0096, IOException -> 0x0090 }
        r1 = zza(r7, r1);	 Catch:{ zza -> 0x0096, IOException -> 0x0090 }
        r6.zza(r0, r1);	 Catch:{ zza -> 0x0096, IOException -> 0x0090 }
    L_0x0070:
        r0 = 29;
        r1 = r6.zzkx;	 Catch:{ zza -> 0x0094, IOException -> 0x0090 }
        r1 = zzb(r7, r1);	 Catch:{ zza -> 0x0094, IOException -> 0x0090 }
        r6.zza(r0, r1);	 Catch:{ zza -> 0x0094, IOException -> 0x0090 }
    L_0x007b:
        r0 = zzf(r7);	 Catch:{ zza -> 0x0092, IOException -> 0x0090 }
        r1 = 5;
        r2 = 0;
        r2 = r0[r2];	 Catch:{ zza -> 0x0092, IOException -> 0x0090 }
        r2 = (long) r2;	 Catch:{ zza -> 0x0092, IOException -> 0x0090 }
        r6.zza(r1, r2);	 Catch:{ zza -> 0x0092, IOException -> 0x0090 }
        r1 = 6;
        r2 = 1;
        r0 = r0[r2];	 Catch:{ zza -> 0x0092, IOException -> 0x0090 }
        r2 = (long) r0;	 Catch:{ zza -> 0x0092, IOException -> 0x0090 }
        r6.zza(r1, r2);	 Catch:{ zza -> 0x0092, IOException -> 0x0090 }
    L_0x008f:
        return;
    L_0x0090:
        r0 = move-exception;
        goto L_0x008f;
    L_0x0092:
        r0 = move-exception;
        goto L_0x008f;
    L_0x0094:
        r0 = move-exception;
        goto L_0x007b;
    L_0x0096:
        r0 = move-exception;
        goto L_0x0070;
    L_0x0098:
        r0 = move-exception;
        goto L_0x0065;
    L_0x009a:
        r0 = move-exception;
        goto L_0x0058;
    L_0x009c:
        r0 = move-exception;
        goto L_0x0034;
    L_0x009e:
        r0 = move-exception;
        goto L_0x0010;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzi.zzb(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zzc(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = zzv();	 Catch:{ zza -> 0x0065, IOException -> 0x005d }
        r6.zza(r0, r1);	 Catch:{ zza -> 0x0065, IOException -> 0x005d }
    L_0x0008:
        r0 = 1;
        r1 = zzx();	 Catch:{ zza -> 0x0063, IOException -> 0x005d }
        r6.zza(r0, r1);	 Catch:{ zza -> 0x0063, IOException -> 0x005d }
    L_0x0010:
        r0 = 25;
        r1 = zzw();	 Catch:{ zza -> 0x0061, IOException -> 0x005d }
        r2 = r1.longValue();	 Catch:{ zza -> 0x0061, IOException -> 0x005d }
        r6.zza(r0, r2);	 Catch:{ zza -> 0x0061, IOException -> 0x005d }
    L_0x001d:
        r0 = r6.zzkv;	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r1 = r6.zzkw;	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r1 = zza(r0, r1);	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r4 = r0.longValue();	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r6.zza(r2, r4);	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r4 = r0.longValue();	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r6.zza(r2, r4);	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r0 = r1.size();	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r2 = 3;
        if (r0 < r2) goto L_0x005c;
    L_0x004c:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r0 = r0.longValue();	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
        r6.zza(r2, r0);	 Catch:{ zza -> 0x005f, IOException -> 0x005d }
    L_0x005c:
        return;
    L_0x005d:
        r0 = move-exception;
        goto L_0x005c;
    L_0x005f:
        r0 = move-exception;
        goto L_0x005c;
    L_0x0061:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0065:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzi.zzc(android.content.Context):void");
    }
}
