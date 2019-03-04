package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: VastVideoViewController */
class ci implements OnErrorListener {
    final /* synthetic */ VastVideoViewController f2501a;

    ci(VastVideoViewController vastVideoViewController) {
        this.f2501a = vastVideoViewController;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.f2501a.m4459a(mediaPlayer, i, i2)) {
            return true;
        }
        this.f2501a.m4455q();
        this.f2501a.m4446m();
        this.f2501a.m4283a(false);
        return false;
    }
}
