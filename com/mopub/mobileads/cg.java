package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

/* compiled from: VastVideoViewController */
class cg implements OnPreparedListener {
    final /* synthetic */ VastVideoViewController f2498a;

    cg(VastVideoViewController vastVideoViewController) {
        this.f2498a = vastVideoViewController;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.f2498a.f2371e.getDuration() < 16000) {
            this.f2498a.f2377k = this.f2498a.f2371e.getDuration();
        }
    }
}
