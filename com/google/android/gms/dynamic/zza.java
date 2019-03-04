package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private T zzXN;
    private Bundle zzXO;
    private LinkedList<zza> zzXP;
    private final zzf<T> zzXQ = new C09761(this);

    class C09761 implements zzf<T> {
        final /* synthetic */ zza zzXR;

        C09761(zza com_google_android_gms_dynamic_zza) {
            this.zzXR = com_google_android_gms_dynamic_zza;
        }

        public void zza(T t) {
            this.zzXR.zzXN = t;
            Iterator it = this.zzXR.zzXP.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.zzXR.zzXN);
            }
            this.zzXR.zzXP.clear();
            this.zzXR.zzXO = null;
        }
    }

    interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    final class C09805 implements OnClickListener {
        final /* synthetic */ int zzXY;
        final /* synthetic */ Context zznK;

        C09805(Context context, int i) {
            this.zznK = context;
            this.zzXY = i;
        }

        public void onClick(View view) {
            this.zznK.startActivity(GooglePlayServicesUtil.zzan(this.zzXY));
        }
    }

    class C09816 implements zza {
        final /* synthetic */ zza zzXR;

        C09816(zza com_google_android_gms_dynamic_zza) {
            this.zzXR = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzXR.zzXN.onStart();
        }
    }

    class C09827 implements zza {
        final /* synthetic */ zza zzXR;

        C09827(zza com_google_android_gms_dynamic_zza) {
            this.zzXR = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzXR.zzXN.onResume();
        }
    }

    private void zza(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.zzXN != null) {
            com_google_android_gms_dynamic_zza_zza.zzb(this.zzXN);
            return;
        }
        if (this.zzXP == null) {
            this.zzXP = new LinkedList();
        }
        this.zzXP.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.zzXO == null) {
                this.zzXO = (Bundle) bundle.clone();
            } else {
                this.zzXO.putAll(bundle);
            }
        }
        zza(this.zzXQ);
    }

    public static void zzb(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence zze = GooglePlayServicesUtil.zze(context, isGooglePlayServicesAvailable);
        CharSequence zzf = GooglePlayServicesUtil.zzf(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zze);
        linearLayout.addView(textView);
        if (zzf != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzf);
            linearLayout.addView(button);
            button.setOnClickListener(new C09805(context, isGooglePlayServicesAvailable));
        }
    }

    private void zzdd(int i) {
        while (!this.zzXP.isEmpty() && ((zza) this.zzXP.getLast()).getState() >= i) {
            this.zzXP.removeLast();
        }
    }

    public void onCreate(final Bundle bundle) {
        zza(bundle, new zza(this) {
            final /* synthetic */ zza zzXR;

            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzXR.zzXN.onCreate(bundle);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        zza(bundle, new zza(this) {
            final /* synthetic */ zza zzXR;

            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.zzXR.zzXN.onCreateView(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.zzXN == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzXN != null) {
            this.zzXN.onDestroy();
        } else {
            zzdd(1);
        }
    }

    public void onDestroyView() {
        if (this.zzXN != null) {
            this.zzXN.onDestroyView();
        } else {
            zzdd(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        zza(bundle2, new zza(this) {
            final /* synthetic */ zza zzXR;

            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzXR.zzXN.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        if (this.zzXN != null) {
            this.zzXN.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzXN != null) {
            this.zzXN.onPause();
        } else {
            zzdd(5);
        }
    }

    public void onResume() {
        zza(null, new C09827(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.zzXN != null) {
            this.zzXN.onSaveInstanceState(bundle);
        } else if (this.zzXO != null) {
            bundle.putAll(this.zzXO);
        }
    }

    public void onStart() {
        zza(null, new C09816(this));
    }

    public void onStop() {
        if (this.zzXN != null) {
            this.zzXN.onStop();
        } else {
            zzdd(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> com_google_android_gms_dynamic_zzf_T);

    public T zzlg() {
        return this.zzXN;
    }
}
