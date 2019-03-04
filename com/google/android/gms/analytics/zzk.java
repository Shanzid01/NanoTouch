package com.google.android.gms.analytics;

import android.content.Context;
import com.facebook.AppEventsConstants;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzra;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class zzk implements zzq {
    private final zzra zzAM;
    private volatile String zzBC;
    private Future<String> zzBD;

    class C07891 implements Callable<String> {
        final /* synthetic */ zzk zzBE;

        C07891(zzk com_google_android_gms_analytics_zzk) {
            this.zzBE = com_google_android_gms_analytics_zzk;
        }

        public /* synthetic */ Object call() {
            return zzfA();
        }

        public String zzfA() {
            return this.zzBE.zzfx();
        }
    }

    class C07902 implements Callable<String> {
        final /* synthetic */ zzk zzBE;

        C07902(zzk com_google_android_gms_analytics_zzk) {
            this.zzBE = com_google_android_gms_analytics_zzk;
        }

        public /* synthetic */ Object call() {
            return zzfA();
        }

        public String zzfA() {
            return this.zzBE.zzfy();
        }
    }

    protected zzk(zzra com_google_android_gms_internal_zzra) {
        zzx.zzl(com_google_android_gms_internal_zzra);
        this.zzAM = com_google_android_gms_internal_zzra;
        this.zzBD = com_google_android_gms_internal_zzra.zza(new C07891(this));
    }

    protected static String zzC(Context context) {
        FileInputStream openFileInput;
        FileInputStream fileInputStream;
        Throwable th;
        zzx.zzbe("ClientId should be loaded from worker thread");
        try {
            openFileInput = context.openFileInput("gaClientId");
            try {
                byte[] bArr = new byte[36];
                int read = openFileInput.read(bArr, 0, bArr.length);
                if (openFileInput.available() > 0) {
                    zzae.zzZ("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e) {
                        zzae.zzZ("Failed to close clientId reading stream: " + e);
                        return null;
                    }
                } else if (read < 14) {
                    zzae.zzZ("clientId file seems empty, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2) {
                        zzae.zzZ("Failed to close clientId reading stream: " + e2);
                        return null;
                    }
                } else {
                    openFileInput.close();
                    String str = new String(bArr, 0, read);
                    zzae.zzab("Loaded client id from disk.");
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e3) {
                            zzae.zzZ("Failed to close clientId reading stream: " + e3);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = openFileInput;
                if (fileInputStream != null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e22) {
                    zzae.zzZ("Failed to close clientId reading stream: " + e22);
                    return null;
                }
            } catch (IOException e5) {
                try {
                    zzae.zzZ("Error reading clientId file, deleting it.");
                    context.deleteFile("gaClientId");
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e222) {
                        zzae.zzZ("Failed to close clientId reading stream: " + e222);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e2222) {
                            zzae.zzZ("Failed to close clientId reading stream: " + e2222);
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (IOException e7) {
            openFileInput = null;
            zzae.zzZ("Error reading clientId file, deleting it.");
            context.deleteFile("gaClientId");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    private static boolean zzf(Context context, String str) {
        boolean z = false;
        zzx.zzbn(str);
        zzx.zzbe("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zzae.zzab("Storing clientId.");
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            z = true;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    zzae.zzZ("Failed to close clientId writing stream: " + e);
                }
            }
        } catch (FileNotFoundException e2) {
            zzae.zzZ("Error creating clientId file.");
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zzae.zzZ("Failed to close clientId writing stream: " + e3);
                }
            }
        } catch (IOException e4) {
            zzae.zzZ("Error writing to clientId file.");
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e32) {
                    zzae.zzZ("Failed to close clientId writing stream: " + e32);
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e322) {
                    zzae.zzZ("Failed to close clientId writing stream: " + e322);
                }
            }
        }
        return z;
    }

    private String zzfy() {
        String zzfz = zzfz();
        try {
            return !zzf(this.zzAM.getContext(), zzfz) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : zzfz;
        } catch (Exception e) {
            zzae.zzZ("Error saving clientId file: " + e);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    public String getValue(String str) {
        return "&cid".equals(str) ? zzfv() : null;
    }

    public boolean zzaj(String str) {
        return "&cid".equals(str);
    }

    protected String zzfv() {
        String str;
        synchronized (this) {
            if (this.zzBD != null) {
                try {
                    this.zzBC = (String) this.zzBD.get();
                } catch (InterruptedException e) {
                    zzae.zzZ("Exception while waiting for clientId: " + e);
                    this.zzBC = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } catch (ExecutionException e2) {
                    zzae.zzZ("Exception while waiting for clientId: " + e2);
                    this.zzBC = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                zzae.zzab("Loaded clientId");
                this.zzBD = null;
            }
            str = this.zzBC;
        }
        return str;
    }

    String zzfw() {
        synchronized (this) {
            this.zzBC = null;
            this.zzBD = this.zzAM.zza(new C07902(this));
        }
        return zzfv();
    }

    String zzfx() {
        String zzC = zzC(this.zzAM.getContext());
        return zzC == null ? zzfy() : zzC;
    }

    protected String zzfz() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
