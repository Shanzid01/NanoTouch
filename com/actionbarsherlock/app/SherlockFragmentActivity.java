package com.actionbarsherlock.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Watson;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.MenuInflater;

public class SherlockFragmentActivity extends Watson implements OnActionModeFinishedListener, OnActionModeStartedListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "SherlockFragmentActivity";
    private boolean mIgnoreNativeCreate = DEBUG;
    private boolean mIgnoreNativePrepare = DEBUG;
    private boolean mIgnoreNativeSelected = DEBUG;
    private ActionBarSherlock mSherlock;

    protected final ActionBarSherlock getSherlock() {
        if (this.mSherlock == null) {
            this.mSherlock = ActionBarSherlock.wrap(this, 1);
        }
        return this.mSherlock;
    }

    public ActionBar getSupportActionBar() {
        return getSherlock().getActionBar();
    }

    public ActionMode startActionMode(Callback callback) {
        return getSherlock().startActionMode(callback);
    }

    public void onActionModeStarted(ActionMode actionMode) {
    }

    public void onActionModeFinished(ActionMode actionMode) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getSherlock().dispatchConfigurationChanged(configuration);
    }

    protected void onPostResume() {
        super.onPostResume();
        getSherlock().dispatchPostResume();
    }

    protected void onPause() {
        getSherlock().dispatchPause();
        super.onPause();
    }

    protected void onStop() {
        getSherlock().dispatchStop();
        super.onStop();
    }

    protected void onDestroy() {
        getSherlock().dispatchDestroy();
        super.onDestroy();
    }

    protected void onPostCreate(Bundle bundle) {
        getSherlock().dispatchPostCreate(bundle);
        super.onPostCreate(bundle);
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        getSherlock().dispatchTitleChanged(charSequence, i);
        super.onTitleChanged(charSequence, i);
    }

    public final boolean onMenuOpened(int i, Menu menu) {
        if (getSherlock().dispatchMenuOpened(i, menu)) {
            return true;
        }
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        getSherlock().dispatchPanelClosed(i, menu);
        super.onPanelClosed(i, menu);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (getSherlock().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getSherlock().dispatchSaveInstanceState(bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        getSherlock().dispatchRestoreInstanceState(bundle);
    }

    public MenuInflater getSupportMenuInflater() {
        return getSherlock().getMenuInflater();
    }

    public void invalidateOptionsMenu() {
        getSherlock().dispatchInvalidateOptionsMenu();
    }

    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || this.mIgnoreNativeCreate) {
            return super.onCreatePanelMenu(i, menu);
        }
        this.mIgnoreNativeCreate = true;
        boolean dispatchCreateOptionsMenu = getSherlock().dispatchCreateOptionsMenu(menu);
        this.mIgnoreNativeCreate = DEBUG;
        return dispatchCreateOptionsMenu;
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public final boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || this.mIgnoreNativePrepare) {
            return super.onPreparePanel(i, view, menu);
        }
        this.mIgnoreNativePrepare = true;
        boolean dispatchPrepareOptionsMenu = getSherlock().dispatchPrepareOptionsMenu(menu);
        this.mIgnoreNativePrepare = DEBUG;
        return dispatchPrepareOptionsMenu;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (i != 0 || this.mIgnoreNativeSelected) {
            return super.onMenuItemSelected(i, menuItem);
        }
        this.mIgnoreNativeSelected = true;
        boolean dispatchOptionsItemSelected = getSherlock().dispatchOptionsItemSelected(menuItem);
        this.mIgnoreNativeSelected = DEBUG;
        return dispatchOptionsItemSelected;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        return DEBUG;
    }

    public void openOptionsMenu() {
        if (!getSherlock().dispatchOpenOptionsMenu()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        if (!getSherlock().dispatchCloseOptionsMenu()) {
            super.closeOptionsMenu();
        }
    }

    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        return true;
    }

    public boolean onPrepareOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem menuItem) {
        return DEBUG;
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getSherlock().addContentView(view, layoutParams);
    }

    public void setContentView(int i) {
        getSherlock().setContentView(i);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getSherlock().setContentView(view, layoutParams);
    }

    public void setContentView(View view) {
        getSherlock().setContentView(view);
    }

    public void requestWindowFeature(long j) {
        getSherlock().requestFeature((int) j);
    }

    public void setSupportProgress(int i) {
        getSherlock().setProgress(i);
    }

    public void setSupportProgressBarIndeterminate(boolean z) {
        getSherlock().setProgressBarIndeterminate(z);
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
        getSherlock().setProgressBarIndeterminateVisibility(z);
    }

    public void setSupportProgressBarVisibility(boolean z) {
        getSherlock().setProgressBarVisibility(z);
    }

    public void setSupportSecondaryProgress(int i) {
        getSherlock().setSecondaryProgress(i);
    }
}
