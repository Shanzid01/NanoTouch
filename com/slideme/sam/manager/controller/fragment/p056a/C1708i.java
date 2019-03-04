package com.slideme.sam.manager.controller.fragment.p056a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.actionbarsherlock.app.SherlockFragment;
import com.google.analytics.tracking.android.C0771n;
import com.p026b.p027a.p034b.C0510g;
import com.p026b.p027a.p034b.p035a.C0481i;
import com.slideme.sam.manager.R;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.controller.p055b.C1698a;
import com.slideme.sam.manager.model.data.Application;
import com.slideme.sam.manager.net.C1599q;
import com.slideme.sam.manager.net.wrappers.Catalog;
import com.slideme.sam.manager.util.C1922m;
import com.slideme.sam.manager.view.p064a.C1940j;
import com.slideme.sam.manager.view.p064a.p065a.C1923a;
import com.slideme.sam.manager.view.p064a.p065a.C1924b;
import com.slideme.sam.manager.view.touchme.SafeViewFlipper;
import java.util.Arrays;

/* compiled from: ApplicationListFragment */
public abstract class C1708i extends SherlockFragment {
    private static int f2904a;
    private SafeViewFlipper f2905b = null;
    GridView f2906c;
    C1940j f2907d;
    int f2908e = 1;
    protected int f2909f = R.layout.fragment_app_list;
    Catalog f2910g;
    protected boolean f2911h = false;
    private boolean f2912i = true;
    private C1599q f2913j = new C1719j(this);
    private SharedPreferences f2914k;
    private OnSharedPreferenceChangeListener f2915l = new C1720k(this);

    protected abstract void mo4257a(Catalog catalog);

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        f2904a = SAM.f2613f.m5446c();
        m5092b();
        mo4261a(bundle);
        this.f2914k = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.f2914k.registerOnSharedPreferenceChangeListener(this.f2915l);
        if (bundle == null) {
            this.f2910g = new Catalog(((SAM) getActivity().getApplication()).m4780d(), f2904a);
            if (getArguments() != null && getArguments().containsKey("com.slideme.sam.manager.EXTRA_PRICE")) {
                this.f2910g.m5674c(getArguments().getInt("com.slideme.sam.manager.EXTRA_PRICE"));
            }
            this.f2910g.m5666a(SAM.f2617j.m5520c());
            this.f2910g.m5684e(SAM.f2613f.m5453j());
        } else {
            bundle.setClassLoader(Catalog.class.getClassLoader());
            this.f2910g = (Catalog) bundle.getParcelable("com.slideme.sam.manager.STATE_CATALOG");
            int[] c = SAM.f2617j.m5520c();
            Arrays.sort(c);
            if (!Arrays.equals(this.f2910g.m5694j(), c)) {
                this.f2910g.m5666a(SAM.f2617j.m5520c());
                m5094c();
            }
            boolean j = SAM.f2613f.m5453j();
            if (this.f2910g.m5695k() != j) {
                this.f2910g.m5684e(j);
                m5094c();
            }
            this.f2911h = bundle.getInt("state_needs_to_reload") == 1;
        }
        Catalog catalog = this.f2910g;
        if (!SAM.f2613f.m5454k()) {
            i = -1;
        }
        catalog.m5678d(i);
    }

    public void onDestroy() {
        this.f2914k.unregisterOnSharedPreferenceChangeListener(this.f2915l);
        super.onDestroy();
    }

    void m5092b() {
        this.f2908e = getActivity().getResources().getInteger(R.integer.gridColumns);
    }

    public void onStart() {
        super.onStart();
        C0771n.m3940b().mo1215c(getClass().getName());
    }

    public void onStop() {
        super.onStop();
    }

    void mo4261a(Bundle bundle) {
        C1923a c1924b = new C1924b(getActivity());
        c1924b.mo4325a(this.f2908e);
        if (bundle != null) {
            c1924b.m5815b(bundle.getInt("state_max_animated"));
        }
        this.f2907d = new C1940j(c1924b, new C1723n(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(this.f2909f, viewGroup, false);
        this.f2905b = (SafeViewFlipper) viewGroup2.findViewById(R.id.flipper);
        this.f2906c = (GridView) viewGroup2.findViewById(R.id.apps);
        this.f2906c.setNumColumns(this.f2908e);
        this.f2906c.setOnScrollListener(new C0481i(C0510g.m3081a(), false, true, new C1721l(this)));
        this.f2906c.setAdapter(this.f2907d);
        this.f2906c.setEmptyView(viewGroup2.findViewById(16908292));
        this.f2906c.setOnItemClickListener(new C1722m(this));
        this.f2910g.m5660a(this.f2913j);
        mo4257a(this.f2910g);
        this.f2907d.m5842a(this.f2910g.m5693i());
        if (this.f2912i && this.f2910g.m5669b() == 0 && !this.f2910g.m5696l() && bundle == null) {
            this.f2910g.m5685f();
        }
        return viewGroup2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if ((this.f2910g.m5669b() == 0 && bundle == null) || this.f2910g.m5696l()) {
            mo4260a(false);
            return;
        }
        mo4260a(true);
        m5086a(bundle.getInt("state_scroll_position"));
    }

    void mo4256a(AdapterView<?> adapterView, int i) {
        if (!this.f2907d.m5844a() || i != this.f2907d.getCount() - 1) {
            Application application = (Application) adapterView.getAdapter().getItem(i);
            C0510g.m3081a().m3088e();
            C1698a.m5055a(getActivity(), application);
        }
    }

    public void mo4260a(boolean z) {
        if (this.f2905b != null) {
            int i = z ? 1 : 0;
            if (this.f2905b.getDisplayedChild() != i) {
                this.f2905b.setDisplayedChild(i);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("com.slideme.sam.manager.STATE_CATALOG", this.f2910g);
        bundle.putInt("state_scroll_position", this.f2906c.getFirstVisiblePosition());
        bundle.putInt("state_needs_to_reload", this.f2911h ? 1 : 0);
        bundle.putInt("state_max_animated", ((C1924b) this.f2907d.m5845b()).m5817d());
    }

    protected final void m5094c() {
        this.f2910g.m5688f(false);
        this.f2910g.m5673c();
        mo4260a(false);
        m5095d();
        try {
            this.f2910g.m5685f();
        } catch (Throwable e) {
            C1922m.m5791a(e);
        }
        this.f2907d.m5842a(this.f2910g.m5693i());
        this.f2911h = false;
    }

    final void m5093b(boolean z) {
        this.f2912i = z;
    }

    boolean mo4258a() {
        return true;
    }

    public void m5095d() {
        m5086a(0);
    }

    protected void m5086a(int i) {
        if (this.f2906c != null && this.f2906c.getCount() >= i) {
            this.f2906c.setSelection(i);
        }
    }

    public void onResume() {
        super.onResume();
        C1940j c1940j = this.f2907d;
        boolean z = !this.f2910g.m5668a() && mo4258a();
        c1940j.m5843a(z);
        this.f2907d.notifyDataSetChanged();
        if (this.f2911h) {
            m5094c();
        }
    }

    public Application[] m5096e() {
        Application[] applicationArr = new Application[this.f2910g.m5693i().size()];
        this.f2910g.m5693i().toArray(applicationArr);
        return applicationArr;
    }
}
