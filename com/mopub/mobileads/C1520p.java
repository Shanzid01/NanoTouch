package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.mopub.common.p050b.C1486i;

/* compiled from: BaseVideoPlayerActivity */
class C1520p extends Activity {
    C1520p() {
    }

    static void m4376a(Context context, String str, AdConfiguration adConfiguration) {
        try {
            context.startActivity(C1520p.m4377b(context, str, adConfiguration));
        } catch (ActivityNotFoundException e) {
            C1486i.m4076a("Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    static Intent m4377b(Context context, String str, AdConfiguration adConfiguration) {
        Intent intent = new Intent(context, MraidVideoPlayerActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtra("video_view_class_name", "mraid");
        intent.putExtra("video_url", str);
        intent.putExtra("Ad-Configuration", adConfiguration);
        return intent;
    }
}
