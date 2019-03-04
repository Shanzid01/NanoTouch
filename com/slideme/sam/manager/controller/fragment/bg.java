package com.slideme.sam.manager.controller.fragment;

import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.p026b.p027a.p034b.C0506d;
import com.p026b.p027a.p034b.C0509f;
import com.p026b.p027a.p034b.C0510g;
import com.p026b.p027a.p034b.p035a.C0477e;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.model.data.Application.ImageSize;
import com.slideme.sam.manager.model.data.ApplicationHolder;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;

/* compiled from: ViewScreenshotFragment */
public class bg extends Fragment {
    private ApplicationHolder f3115a = null;
    private int f3116b = 0;
    private SafeViewFlipper f3117c;
    private ImageView f3118d;
    private C0506d f3119e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3119e = new C0509f().m3079b().m3076a(Config.RGB_565).m3077a(C0477e.IN_SAMPLE_INT).m3080c();
        this.f3115a = (ApplicationHolder) getArguments().getParcelable("com.slideme.sam.manager.EXTRA_APPHOLDER");
        this.f3116b = getArguments().getInt("com.slideme.sam.manager.EXTRA_SCREENSHOT_INDEX");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_screenshot, null);
        this.f3117c = (SafeViewFlipper) inflate.findViewById(R.id.flipper);
        this.f3118d = (ImageView) inflate.findViewById(R.id.screenshot);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        C0510g.m3081a().m3084a(this.f3115a.getScaledScreenshotUrl(this.f3116b, ImageSize.values()[getActivity().getResources().getInteger(R.integer.ordinal_screenshot_view)]), this.f3118d, this.f3119e, new bh(this));
    }
}
