package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.android.gms.internal.zzwb;
import com.google.android.gms.internal.zzwj;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private boolean mCreated = false;
    private final Fragment zzXZ = this;
    private MaskedWallet zzaEA;
    private Boolean zzaEB;
    private zzb zzaEG;
    private final com.google.android.gms.dynamic.zzb zzaEH = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzaEI = new zzc();
    private zza zzaEJ = new zza(this);
    private WalletFragmentOptions zzaEx;
    private WalletFragmentInitParams zzaEy;
    private MaskedWalletRequest zzaEz;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    class zza extends com.google.android.gms.internal.zzwc.zza {
        private OnStateChangedListener zzaEK;
        private final WalletFragment zzaEL;

        zza(WalletFragment walletFragment) {
            this.zzaEL = walletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaEK != null) {
                this.zzaEK.onStateChanged(this.zzaEL, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaEK = onStateChangedListener;
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
        final /* synthetic */ WalletFragment zzaEM;

        private zzc(WalletFragment walletFragment) {
            this.zzaEM = walletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzaEM.zzXZ.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzaEM.zzXZ.getActivity());
            button.setText(C0783R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzaEM.zzaEx != null) {
                WalletFragmentStyle fragmentStyle = this.zzaEM.zzaEx.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzaEM.zzXZ.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_WalletFragment_zzb) {
            Activity activity = this.zzaEM.zzXZ.getActivity();
            if (this.zzaEM.zzaEG == null && this.zzaEM.mCreated && activity != null) {
                try {
                    this.zzaEM.zzaEG = new zzb(zzwj.zza(activity, this.zzaEM.zzaEH, this.zzaEM.zzaEx, this.zzaEM.zzaEJ));
                    this.zzaEM.zzaEx = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_WalletFragment_zzb.zza(this.zzaEM.zzaEG);
                    if (this.zzaEM.zzaEy != null) {
                        this.zzaEM.zzaEG.initialize(this.zzaEM.zzaEy);
                        this.zzaEM.zzaEy = null;
                    }
                    if (this.zzaEM.zzaEz != null) {
                        this.zzaEM.zzaEG.updateMaskedWalletRequest(this.zzaEM.zzaEz);
                        this.zzaEM.zzaEz = null;
                    }
                    if (this.zzaEM.zzaEA != null) {
                        this.zzaEM.zzaEG.updateMaskedWallet(this.zzaEM.zzaEA);
                        this.zzaEM.zzaEA = null;
                    }
                    if (this.zzaEM.zzaEB != null) {
                        this.zzaEM.zzaEG.setEnabled(this.zzaEM.zzaEB.booleanValue());
                        this.zzaEM.zzaEB = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions walletFragmentOptions) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletFragmentOptions);
        walletFragment.zzXZ.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.zzaEG != null ? this.zzaEG.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
        if (this.zzaEG != null) {
            this.zzaEG.initialize(walletFragmentInitParams);
            this.zzaEy = null;
        } else if (this.zzaEy == null) {
            this.zzaEy = walletFragmentInitParams;
            if (this.zzaEz != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaEA != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.zzaEG != null) {
            this.zzaEG.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaEy != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.zzXZ.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzXZ.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzao(this.zzXZ.getActivity());
                this.zzaEx = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaEI.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.zzaEI.onCreateView(layoutInflater, viewGroup, bundle);
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
        this.zzaEI.onInflate(activity, bundle2, bundle);
    }

    public void onPause() {
        super.onPause();
        this.zzaEI.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaEI.onResume();
        FragmentManager fragmentManager = this.zzXZ.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzXZ.getActivity()), this.zzXZ.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaEI.onSaveInstanceState(bundle);
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
        this.zzaEI.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaEI.onStop();
    }

    public void setEnabled(boolean z) {
        if (this.zzaEG != null) {
            this.zzaEG.setEnabled(z);
            this.zzaEB = null;
            return;
        }
        this.zzaEB = Boolean.valueOf(z);
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.zzaEJ.zza(onStateChangedListener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaEG != null) {
            this.zzaEG.updateMaskedWallet(maskedWallet);
            this.zzaEA = null;
            return;
        }
        this.zzaEA = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
        if (this.zzaEG != null) {
            this.zzaEG.updateMaskedWalletRequest(maskedWalletRequest);
            this.zzaEz = null;
            return;
        }
        this.zzaEz = maskedWalletRequest;
    }
}
