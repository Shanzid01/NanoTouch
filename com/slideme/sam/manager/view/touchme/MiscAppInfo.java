package com.slideme.sam.manager.view.touchme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.ApplicationHolder;

public class MiscAppInfo extends FrameLayout {
    private ApplicationHolder f3713a;

    public MiscAppInfo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5978b();
    }

    private void m5978b() {
        addView(inflate(getContext(), R.layout.widget_misc_info, null));
    }

    public void m5980a(ApplicationHolder applicationHolder) {
        this.f3713a = applicationHolder;
        m5979a();
    }

    public void m5979a() {
        int i;
        findViewById(R.id.includesAds).setVisibility(this.f3713a.app.advertisement == 0 ? 8 : 0);
        View findViewById = findViewById(R.id.virusFree);
        if (this.f3713a.app.antivirus == null || this.f3713a.app.antivirus.clamScan != 1) {
            i = 8;
        } else {
            i = 0;
        }
        findViewById.setVisibility(i);
        for (int i2 = 0; i2 < 3; i2++) {
            switch (i2) {
                case 0:
                    findViewById(R.id.smartphone).setVisibility(this.f3713a.app.compatibility.optimizedFor.charAt(i2) == 'Y' ? 0 : 8);
                    break;
                case 1:
                    findViewById(R.id.tablet).setVisibility(this.f3713a.app.compatibility.optimizedFor.charAt(i2) == 'Y' ? 0 : 8);
                    break;
                case 2:
                    findViewById(R.id.television).setVisibility(this.f3713a.app.compatibility.optimizedFor.charAt(i2) == 'Y' ? 0 : 8);
                    break;
                default:
                    break;
            }
        }
    }
}
