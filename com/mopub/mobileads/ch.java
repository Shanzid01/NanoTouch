package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.VideoView;
import com.mopub.common.C1511s;

/* compiled from: VastVideoViewController */
class ch implements OnCompletionListener {
    final /* synthetic */ VastVideoViewController f2499a;
    private final /* synthetic */ VideoView f2500b;

    ch(VastVideoViewController vastVideoViewController, VideoView videoView) {
        this.f2499a = vastVideoViewController;
        this.f2500b = videoView;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f2499a.m4455q();
        this.f2499a.m4446m();
        this.f2499a.m4285b(false);
        C1511s.m4152a(this.f2499a.f2368b.m4701f());
        this.f2499a.f2384r = true;
        this.f2500b.setVisibility(8);
        if (this.f2499a.f2372f.getDrawable() != null) {
            this.f2499a.f2372f.setVisibility(0);
        }
    }
}
