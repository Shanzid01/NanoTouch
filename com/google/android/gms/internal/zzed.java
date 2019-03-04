package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0783R;
import java.util.Map;

@zzgi
public class zzed extends zzeg {
    private final Context mContext;
    private final Map<String, String> zzsZ;

    class C11982 implements OnClickListener {
        final /* synthetic */ zzed zztz;

        C11982(zzed com_google_android_gms_internal_zzed) {
            this.zztz = com_google_android_gms_internal_zzed;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zztz.zzH("User canceled the download.");
        }
    }

    public zzed(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        super(com_google_android_gms_internal_zzic, "storePicture");
        this.zzsZ = map;
        this.mContext = com_google_android_gms_internal_zzic.zzeD();
    }

    public void execute() {
        if (this.mContext == null) {
            zzH("Activity context is not available");
        } else if (zzab.zzaM().zzx(this.mContext).zzbR()) {
            final String str = (String) this.zzsZ.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzH("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                final String zzG = zzG(str);
                if (zzab.zzaM().zzU(zzG)) {
                    Builder zzw = zzab.zzaM().zzw(this.mContext);
                    zzw.setTitle(zzab.zzaP().zzc(C0783R.string.store_picture_title, "Save image"));
                    zzw.setMessage(zzab.zzaP().zzc(C0783R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    zzw.setPositiveButton(zzab.zzaP().zzc(C0783R.string.accept, "Accept"), new OnClickListener(this) {
                        final /* synthetic */ zzed zztz;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                ((DownloadManager) this.zztz.mContext.getSystemService("download")).enqueue(this.zztz.zzf(str, zzG));
                            } catch (IllegalStateException e) {
                                this.zztz.zzH("Could not store picture.");
                            }
                        }
                    });
                    zzw.setNegativeButton(zzab.zzaP().zzc(C0783R.string.decline, "Decline"), new C11982(this));
                    zzw.create().show();
                    return;
                }
                zzH("Image type not recognized: " + zzG);
            } else {
                zzH("Invalid image url: " + str);
            }
        } else {
            zzH("Feature is not supported by the device.");
        }
    }

    String zzG(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    Request zzf(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzab.zzaO().zza(request);
        return request;
    }
}
