package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* compiled from: MraidVideoViewController */
class bq implements OnCompletionListener {
    final /* synthetic */ MraidVideoViewController f2464a;

    bq(MraidVideoViewController mraidVideoViewController) {
        this.f2464a = mraidVideoViewController;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f2464a.f2351b.setVisibility(0);
        this.f2464a.m4285b(true);
    }
}
