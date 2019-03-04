package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0783R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzwb;
import com.google.android.gms.internal.zzwj;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzPt = this;
    private MaskedWallet zzaEA;
    private Boolean zzaEB;
    private zzb zzaEt;
    private final zzh zzaEu = zzh.zza(this);
    private final zzc zzaEv = new zzc();
    private zza zzaEw = new zza(this);
    private WalletFragmentOptions zzaEx;
    private WalletFragmentInitParams zzaEy;
    private MaskedWalletRequest zzaEz;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    class zza extends com.google.android.gms.internal.zzwc.zza {
        private OnStateChangedListener zzaEC;
        private final SupportWalletFragment zzaED;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzaED = supportWalletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaEC != null) {
                this.zzaEC.onStateChanged(this.zzaED, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaEC = onStateChangedListener;
        }
    }

    class zzb implements LifecycleDelegate {
        private final zzwb zzaEE;

        private zzb(zzwb com_google_android_gms_internal_zzwb) {
            this.zzaEE = com_google_android_gms_internal_zzwb;
        }

        private int getState() {
            try {
                return this.zzaEE.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams walletFragmentInitParams) {
            try {
                this.zzaEE.initialize(walletFragmentInitParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int i, int i2, Intent intent) {
            try {
                this.zzaEE.onActivityResult(i, i2, intent);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean z) {
            try {
                this.zzaEE.setEnabled(z);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzaEE.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            try {
                this.zzaEE.updateMaskedWalletRequest(maskedWalletRequest);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            try {
                this.zzaEE.onCreate(bundle);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzf(this.zzaEE.onCreateView(zze.zzn(layoutInflater), zze.zzn(viewGroup), bundle));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.zzaEE.zza(zze.zzn(activity), (WalletFragmentOptions) bundle.getParcelable("extraWalletFragmentOptions"), bundle2);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.zzaEE.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaEE.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzaEE.onSaveInstanceState(bundle);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.zzaEE.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.zzaEE.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    class zzc extends com.google.android.gms.dynamic.zza<zzb> implements OnClickListener {
        final /* synthetic */ SupportWalletFragment zzaEF;

        private zzc(SupportWalletFragment supportWalletFragment) {
            this.zzaEF = supportWalletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzaEF.zzPt.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzaEF.zzPt.getActivity());
            button.setText(C0783R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzaEF.zzaEx != null) {
                WalletFragmentStyle fragmentStyle = this.zzaEF.zzaEx.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzaEF.zzPt.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb) {
            Activity activity = this.zzaEF.zzPt.getActivity();
            if (this.zzaEF.zzaEt == null && this.zzaEF.mCreated && activity != null) {
                try {
                    this.zzaEF.zzaEt = new zzb(zzwj.zza(activity, this.zzaEF.zzaEu, this.zzaEF.zzaEx, this.zzaEF.zzaEw));
                    this.zzaEF.zzaEx = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb.zza(this.zzaEF.zzaEt);
                    if (this.zzaEF.zzaEy != null) {
                        this.zzaEF.zzaEt.initialize(this.zzaEF.zzaEy);
                        this.zzaEF.zzaEy = null;
                    }
                    if (this.zzaEF.zzaEz != null) {
                        this.zzaEF.zzaEt.updateMaskedWalletRequest(this.zzaEF.zzaEz);
                        this.zzaEF.zzaEz = null;
                    }
                    if (this.zzaEF.zzaEA != null) {
                        this.zzaEF.zzaEt.updateMaskedWallet(this.zzaEF.zzaEA);
                        this.zzaEF.zzaEA = null;
                    }
                    if (this.zzaEF.zzaEB != null) {
                        this.zzaEF.zzaEt.setEnabled(this.zzaEF.zzaEB.booleanValue());
                        this.zzaEF.zzaEB = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions walletFragmentOptions) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletFragmentOptions);
        supportWalletFragment.zzPt.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.zzaEt != null ? this.zzaEt.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
        if (this.zzaEt != null) {
            this.zzaEt.initialize(walletFragmentInitParams);
            this.zzaEy = null;
        } else if (this.zzaEy == null) {
            this.zzaEy = walletFragmentInitParams;
            if (this.zzaEz != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaEA != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.zzaEt != null) {
            this.zzaEt.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaEy != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzaEy = walletFragmentInitParams;
            }
            if (this.zzaEz == null) {
                this.zzaEz = (MaskedWalletRequest) bundle.getParcelable("maskedWalletRequest");
            }
            if (this.zzaEA == null) {
                this.zzaEA = (MaskedWallet) bundle.getParcelable("maskedWallet");
            }
            if (bundle.containsKey("walletFragmentOptions")) {
                this.zzaEx = (WalletFragmentOptions) bundle.getParcelable("walletFragmentOptions");
            }
            if (bundle.containsKey("enabled")) {
                this.zzaEB = Boolean.valueOf(bundle.getBoolean("enabled"));
            }
        } else if (this.zzPt.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzPt.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzao(this.zzPt.getActivity());
                this.zzaEx = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaEv.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.zzaEv.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        if (this.zzaEx == null) {
            this.zzaEx = WalletFragmentOptions.zza((Context) activity, attributeSet);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("attrKeyWalletFragmentOptions", this.zzaEx);
        this.zzaEv.onInflate(activity, bundle2, bundle);
    }

    public void onPause() {
        super.onPause();
        this.zzaEv.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaEv.onResume();
        FragmentManager supportFragmentManager = this.zzPt.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzPt.getActivity()), this.zzPt.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaEv.onSaveInstanceState(bundle);
        if (this.zzaEy != null) {
            bundle.putParcelable("walletFragmentInitParams", this.zzaEy);
            this.zzaEy = null;
        }
        if (this.zzaEz != null) {
            bundle.putParcelable("maskedWalletRequest", this.zzaEz);
            this.zzaEz = null;
        }
        if (this.zzaEA != null) {
            bundle.putParcelable("maskedWallet", this.zzaEA);
            this.zzaEA = null;
        }
        if (this.zzaEx != null) {
            bundle.putParcelable("walletFragmentOptions", this.zzaEx);
            this.zzaEx = null;
        }
        if (this.zzaEB != null) {
            bundle.putBoolean("enabled", this.zzaEB.booleanValue());
            this.zzaEB = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzaEv.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaEv.onStop();
    }

    public void setEnabled(boolean z) {
        if (this.zzaEt != null) {
            this.zzaEt.setEnabled(z);
            this.zzaEB = null;
            return;
        }
        this.zzaEB = Boolean.valueOf(z);
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.zzaEw.zza(onStateChangedListener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaEt != null) {
            this.zzaEt.updateMaskedWallet(maskedWallet);
            this.zzaEA = null;
            return;
        }
        this.zzaEA = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
        if (this.zzaEt != null) {
            this.zzaEt.updateMaskedWalletRequest(maskedWalletRequest);
            this.zzaEz = null;
            return;
        }
        this.zzaEz = maskedWalletRequest;
    }
}
