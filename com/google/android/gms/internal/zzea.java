package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C0783R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

@zzgi
public class zzea extends zzeg {
    private final Context mContext;
    private final Map<String, String> zzsZ;
    private String zzta;
    private long zztb;
    private long zztc;
    private String zztd;
    private String zzte;

    class C11941 implements OnClickListener {
        final /* synthetic */ zzea zztf;

        C11941(zzea com_google_android_gms_internal_zzea) {
            this.zztf = com_google_android_gms_internal_zzea;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zztf.mContext.startActivity(this.zztf.createIntent());
        }
    }

    class C11952 implements OnClickListener {
        final /* synthetic */ zzea zztf;

        C11952(zzea com_google_android_gms_internal_zzea) {
            this.zztf = com_google_android_gms_internal_zzea;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zztf.zzH("Operation denied by user.");
        }
    }

    public zzea(zzic com_google_android_gms_internal_zzic, Map<String, String> map) {
        super(com_google_android_gms_internal_zzic, "createCalendarEvent");
        this.zzsZ = map;
        this.mContext = com_google_android_gms_internal_zzic.zzeD();
        zzcM();
    }

    private String zzE(String str) {
        return TextUtils.isEmpty((CharSequence) this.zzsZ.get(str)) ? "" : (String) this.zzsZ.get(str);
    }

    private long zzF(String str) {
        String str2 = (String) this.zzsZ.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void zzcM() {
        this.zzta = zzE(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.zztd = zzE("summary");
        this.zztb = zzF("start_ticks");
        this.zztc = zzF("end_ticks");
        this.zzte = zzE("location");
    }

    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzta);
        data.putExtra("eventLocation", this.zzte);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zztd);
        if (this.zztb > -1) {
            data.putExtra("beginTime", this.zztb);
        }
        if (this.zztc > -1) {
            data.putExtra("endTime", this.zztc);
        }
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzH("Activity context is not available.");
        } else if (zzab.zzaM().zzx(this.mContext).zzbU()) {
            Builder zzw = zzab.zzaM().zzw(this.mContext);
            zzw.setTitle(zzab.zzaP().zzc(C0783R.string.create_calendar_title, "Create calendar event"));
            zzw.setMessage(zzab.zzaP().zzc(C0783R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            zzw.setPositiveButton(zzab.zzaP().zzc(C0783R.string.accept, "Accept"), new C11941(this));
            zzw.setNegativeButton(zzab.zzaP().zzc(C0783R.string.decline, "Decline"), new C11952(this));
            zzw.create().show();
        } else {
            zzH("This feature is not available on the device.");
        }
    }
}
