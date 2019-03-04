package android.support.v4.app;

public class DialogFragmentAllowingStateLoss extends DialogFragment {
    public int showAllowingStateLoss(FragmentTransaction fragmentTransaction, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.add((Fragment) this, str);
        this.mViewDestroyed = false;
        this.mBackStackId = fragmentTransaction.commitAllowingStateLoss();
        return this.mBackStackId;
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commitAllowingStateLoss();
    }
}
