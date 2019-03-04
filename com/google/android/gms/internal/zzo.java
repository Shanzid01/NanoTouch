package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class zzo {
    private final SecureRandom zzkZ;
    private final zzm zzkx;

    public class zza extends Exception {
        final /* synthetic */ zzo zzla;

        public zza(zzo com_google_android_gms_internal_zzo) {
            this.zzla = com_google_android_gms_internal_zzo;
        }

        public zza(zzo com_google_android_gms_internal_zzo, Throwable th) {
            this.zzla = com_google_android_gms_internal_zzo;
            super(th);
        }
    }

    public zzo(zzm com_google_android_gms_internal_zzm, SecureRandom secureRandom) {
        this.zzkx = com_google_android_gms_internal_zzm;
        this.zzkZ = secureRandom;
    }

    static void zzc(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] zzb(String str) {
        try {
            byte[] zza = this.zzkx.zza(str, false);
            if (zza.length != 32) {
                throw new zza(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(zza, 4, 16).get(bArr);
            zzc(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new zza(this, e);
        }
    }

    public byte[] zzc(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new zza(this);
        }
        try {
            byte[] zza = this.zzkx.zza(str, false);
            if (zza.length <= 16) {
                throw new zza(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(zza.length);
            allocate.put(zza);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            zza = new byte[(zza.length - 16)];
            allocate.get(bArr2);
            allocate.get(zza);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(zza);
        } catch (Throwable e) {
            throw new zza(this, e);
        } catch (Throwable e2) {
            throw new zza(this, e2);
        } catch (Throwable e22) {
            throw new zza(this, e22);
        } catch (Throwable e222) {
            throw new zza(this, e222);
        } catch (Throwable e2222) {
            throw new zza(this, e2222);
        } catch (Throwable e22222) {
            throw new zza(this, e22222);
        } catch (Throwable e222222) {
            throw new zza(this, e222222);
        }
    }
}
