package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.util.AttributeSet;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.view.extensions.ForegroundImageView;

public class YoutubePreviewButton extends ForegroundImageView {
    public YoutubePreviewButton(Context context) {
        super(context);
        m6061a();
    }

    public YoutubePreviewButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6061a();
    }

    private void m6061a() {
        m5865a(getResources().getDrawable(R.drawable.fg_touchable_video));
    }
}
