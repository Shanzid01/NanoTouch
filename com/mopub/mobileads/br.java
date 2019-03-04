package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: MraidVideoViewController */
class br implements OnErrorListener {
    final /* synthetic */ MraidVideoViewController f2465a;

    br(MraidVideoViewController mraidVideoViewController) {
        this.f2465a = mraidVideoViewController;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f2465a.f2351b.setVisibility(0);
        this.f2465a.m4283a(false);
        return false;
    }
}
