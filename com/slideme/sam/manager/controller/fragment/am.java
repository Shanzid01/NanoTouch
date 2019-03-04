package com.slideme.sam.manager.controller.fragment;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import com.actionbarsherlock.app.SherlockFragment;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.fragment.p056a.C1728t;
import com.slideme.sam.manager.controller.fragment.p056a.C1729u;
import com.slideme.sam.manager.controller.fragment.p056a.C1730v;
import com.slideme.sam.manager.controller.fragment.p056a.C1731w;
import com.slideme.sam.manager.controller.fragment.p056a.C1732x;
import com.slideme.sam.manager.controller.fragment.p056a.C1733y;
import com.slideme.sam.manager.util.p063a.C1908b;

/* compiled from: FilterControlFragment */
public class am extends SherlockFragment {
    private Spinner f3047a;
    private Spinner f3048b;
    private Spinner f3049c;
    private Spinner f3050d;
    private Spinner f3051e;
    private Spinner f3052f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!(getActivity() instanceof ap)) {
            throw new RuntimeException("Parent Activity of FilterControlFragment needs to implement the FilterControlListener interface");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_filter_control, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f3047a = (Spinner) view.findViewById(R.id.sort);
        this.f3048b = (Spinner) view.findViewById(R.id.price);
        this.f3049c = (Spinner) view.findViewById(R.id.screen_size);
        this.f3050d = (Spinner) view.findViewById(R.id.parental_rating);
        this.f3051e = (Spinner) view.findViewById(R.id.google_play);
        this.f3052f = (Spinner) view.findViewById(R.id.vibrate);
        Button button = (Button) view.findViewById(R.id.positive);
        Button button2 = (Button) view.findViewById(R.id.negative);
        m5252b();
        button.setOnClickListener(new an(this));
        button.setText(R.string.apply);
        button2.setOnClickListener(new ao(this));
        button2.setText(R.string.reset);
    }

    private void m5252b() {
        int i = 0;
        this.f3047a.setSelection(0);
        this.f3048b.setSelection(0);
        this.f3049c.setSelection(0);
        this.f3050d.setEnabled(!SAM.f2617j.m5516a());
        this.f3050d.setSelection(0);
        this.f3051e.setSelection(SAM.f2615h.m5512c() ? C1729u.ANY.ordinal() : C1729u.NOT_REQUIRED.ordinal());
        if (!m5264a()) {
            i = 8;
        }
        getView().findViewById(R.id.vibrate_title).setVisibility(i);
        this.f3052f.setVisibility(i);
    }

    private C1732x m5254c() {
        return C1732x.values()[this.f3047a.getSelectedItemPosition()];
    }

    private C1730v m5256d() {
        return C1730v.values()[this.f3048b.getSelectedItemPosition()];
    }

    private C1731w m5258e() {
        return C1731w.values()[this.f3049c.getSelectedItemPosition()];
    }

    private C1728t m5259f() {
        return C1728t.values()[this.f3050d.getSelectedItemPosition()];
    }

    private C1729u m5261g() {
        return C1729u.values()[this.f3051e.getSelectedItemPosition()];
    }

    private C1733y m5263h() {
        return C1733y.values()[this.f3052f.getSelectedItemPosition()];
    }

    public boolean m5264a() {
        Vibrator vibrator = (Vibrator) getActivity().getSystemService("vibrator");
        if (vibrator == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            return C1908b.m5750a(vibrator);
        }
        return true;
    }
}
