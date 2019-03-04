package com.slideme.sam.manager.controller.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.wrappers.C1905r;
import java.io.File;

/* compiled from: SAMUpdateTaskFragment */
public class bc extends Fragment {
    private bf f3109a;
    private C1905r f3110b;
    private File f3111c;
    private Activity f3112d;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3112d = activity;
        this.f3109a = (bf) activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f3110b = new C1905r((SAM) this.f3112d.getApplication());
        this.f3110b.m5706a(new bd(this));
        new Thread(new be(this)).start();
    }

    public void onDetach() {
        super.onDetach();
        this.f3109a = null;
        this.f3112d = null;
    }
}
