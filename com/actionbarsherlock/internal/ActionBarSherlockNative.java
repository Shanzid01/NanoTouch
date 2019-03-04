package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.ActionMode.Callback;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock.Implementation;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.MenuInflater;

@Implementation(api = 14)
public class ActionBarSherlockNative extends ActionBarSherlock {
    private ActionBarWrapper mActionBar;
    private ActionModeWrapper mActionMode;
    private MenuWrapper mMenu;

    class ActionModeCallbackWrapper implements Callback {
        private final ActionMode.Callback mCallback;

        public ActionModeCallbackWrapper(ActionMode.Callback callback) {
            this.mCallback = callback;
        }

        public boolean onCreateActionMode(android.view.ActionMode actionMode, Menu menu) {
            ActionBarSherlockNative.this.mActionMode = new ActionModeWrapper(actionMode);
            return this.mCallback.onCreateActionMode(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu());
        }

        public boolean onPrepareActionMode(android.view.ActionMode actionMode, Menu menu) {
            return this.mCallback.onPrepareActionMode(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu());
        }

        public boolean onActionItemClicked(android.view.ActionMode actionMode, MenuItem menuItem) {
            return this.mCallback.onActionItemClicked(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu().findItem(menuItem));
        }

        public void onDestroyActionMode(android.view.ActionMode actionMode) {
            this.mCallback.onDestroyActionMode(ActionBarSherlockNative.this.mActionMode);
            if (ActionBarSherlockNative.this.mActivity instanceof OnActionModeFinishedListener) {
                ((OnActionModeFinishedListener) ActionBarSherlockNative.this.mActivity).onActionModeFinished(ActionBarSherlockNative.this.mActionMode);
            }
        }
    }

    class ActionModeWrapper extends ActionMode {
        private final android.view.ActionMode mActionMode;
        private MenuWrapper mMenu = null;

        ActionModeWrapper(android.view.ActionMode actionMode) {
            this.mActionMode = actionMode;
        }

        public void setTitle(CharSequence charSequence) {
            this.mActionMode.setTitle(charSequence);
        }

        public void setTitle(int i) {
            this.mActionMode.setTitle(i);
        }

        public void setSubtitle(CharSequence charSequence) {
            this.mActionMode.setSubtitle(charSequence);
        }

        public void setSubtitle(int i) {
            this.mActionMode.setSubtitle(i);
        }

        public void setCustomView(View view) {
            this.mActionMode.setCustomView(view);
        }

        public void invalidate() {
            this.mActionMode.invalidate();
        }

        public void finish() {
            this.mActionMode.finish();
        }

        public MenuWrapper getMenu() {
            if (this.mMenu == null) {
                this.mMenu = new MenuWrapper(this.mActionMode.getMenu());
            }
            return this.mMenu;
        }

        public CharSequence getTitle() {
            return this.mActionMode.getTitle();
        }

        public CharSequence getSubtitle() {
            return this.mActionMode.getSubtitle();
        }

        public View getCustomView() {
            return this.mActionMode.getCustomView();
        }

        public MenuInflater getMenuInflater() {
            return ActionBarSherlockNative.this.getMenuInflater();
        }

        public void setTag(Object obj) {
            this.mActionMode.setTag(obj);
        }

        public Object getTag() {
            return this.mActionMode.getTag();
        }
    }

    public ActionBarSherlockNative(Activity activity, int i) {
        super(activity, i);
    }

    public ActionBar getActionBar() {
        initActionBar();
        return this.mActionBar;
    }

    private void initActionBar() {
        if (this.mActionBar == null && this.mActivity.getActionBar() != null) {
            this.mActionBar = new ActionBarWrapper(this.mActivity);
        }
    }

    public void dispatchInvalidateOptionsMenu() {
        this.mActivity.getWindow().invalidatePanelMenu(0);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu) {
        if (this.mMenu == null || menu != this.mMenu.unwrap()) {
            this.mMenu = new MenuWrapper(menu);
        }
        return callbackCreateOptionsMenu(this.mMenu);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return callbackPrepareOptionsMenu(this.mMenu);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return callbackOptionsItemSelected(this.mMenu.findItem(menuItem));
    }

    public boolean hasFeature(int i) {
        return this.mActivity.getWindow().hasFeature(i);
    }

    public boolean requestFeature(int i) {
        return this.mActivity.getWindow().requestFeature(i);
    }

    public void setUiOptions(int i) {
        this.mActivity.getWindow().setUiOptions(i);
    }

    public void setUiOptions(int i, int i2) {
        this.mActivity.getWindow().setUiOptions(i, i2);
    }

    public void setContentView(int i) {
        this.mActivity.getWindow().setContentView(i);
        initActionBar();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        this.mActivity.getWindow().setContentView(view, layoutParams);
        initActionBar();
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        this.mActivity.getWindow().addContentView(view, layoutParams);
        initActionBar();
    }

    public void setTitle(CharSequence charSequence) {
        this.mActivity.getWindow().setTitle(charSequence);
    }

    public void setProgressBarVisibility(boolean z) {
        this.mActivity.setProgressBarVisibility(z);
    }

    public void setProgressBarIndeterminateVisibility(boolean z) {
        this.mActivity.setProgressBarIndeterminateVisibility(z);
    }

    public void setProgressBarIndeterminate(boolean z) {
        this.mActivity.setProgressBarIndeterminate(z);
    }

    public void setProgress(int i) {
        this.mActivity.setProgress(i);
    }

    public void setSecondaryProgress(int i) {
        this.mActivity.setSecondaryProgress(i);
    }

    protected Context getThemedContext() {
        Context context = this.mActivity;
        TypedValue typedValue = new TypedValue();
        this.mActivity.getTheme().resolveAttribute(16843671, typedValue, true);
        if (typedValue.resourceId != 0) {
            return new ContextThemeWrapper(context, typedValue.resourceId);
        }
        return context;
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        Callback actionModeCallbackWrapper;
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        if (callback != null) {
            actionModeCallbackWrapper = new ActionModeCallbackWrapper(callback);
        } else {
            actionModeCallbackWrapper = null;
        }
        if (this.mActivity.startActionMode(actionModeCallbackWrapper) == null) {
            this.mActionMode = null;
        }
        if ((this.mActivity instanceof OnActionModeStartedListener) && this.mActionMode != null) {
            ((OnActionModeStartedListener) this.mActivity).onActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }
}
