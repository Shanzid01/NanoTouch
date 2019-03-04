package com.actionbarsherlock.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.C0414R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.actionbarsherlock.app.ActionBar.OnMenuVisibilityListener;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator.AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorListenerAdapter;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet.Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuPopupHelper;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.cast.TextTrackStyle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarImpl extends ActionBar {
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    ActionModeImpl mActionMode;
    private ActionBarView mActionView;
    private Activity mActivity;
    private ActionBarContainer mContainerView;
    private NineFrameLayout mContentView;
    private Context mContext;
    private int mContextDisplayMode;
    private ActionBarContextView mContextView;
    private Animator mCurrentModeAnim;
    private Animator mCurrentShowAnim;
    ActionMode mDeferredDestroyActionMode;
    Callback mDeferredModeDestroyCallback;
    final Handler mHandler = new Handler();
    private boolean mHasEmbeddedTabs;
    final AnimatorListener mHideListener = new C04161();
    private boolean mLastMenuVisibility;
    private ArrayList<OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final AnimatorListener mShowListener = new C04172();
    private ActionBarContainer mSplitView;
    private ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList<TabImpl> mTabs = new ArrayList();
    private Context mThemedContext;
    boolean mWasHiddenBeforeMode;

    class C04161 extends AnimatorListenerAdapter {
        C04161() {
        }

        public void onAnimationEnd(Animator animator) {
            if (ActionBarImpl.this.mContentView != null) {
                ActionBarImpl.this.mContentView.setTranslationY(0.0f);
                ActionBarImpl.this.mContainerView.setTranslationY(0.0f);
            }
            if (ActionBarImpl.this.mSplitView != null && ActionBarImpl.this.mContextDisplayMode == 1) {
                ActionBarImpl.this.mSplitView.setVisibility(8);
            }
            ActionBarImpl.this.mContainerView.setVisibility(8);
            ActionBarImpl.this.mContainerView.setTransitioning(false);
            ActionBarImpl.this.mCurrentShowAnim = null;
            ActionBarImpl.this.completeDeferredDestroyActionMode();
        }
    }

    class C04172 extends AnimatorListenerAdapter {
        C04172() {
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarImpl.this.mCurrentShowAnim = null;
            ActionBarImpl.this.mContainerView.requestLayout();
        }
    }

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private Callback mCallback;
        private WeakReference<View> mCustomView;
        private MenuBuilder mMenu;

        public ActionModeImpl(Callback callback) {
            this.mCallback = callback;
            this.mMenu = new MenuBuilder(ActionBarImpl.this.getThemedContext()).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        public MenuInflater getMenuInflater() {
            return new MenuInflater(ActionBarImpl.this.getThemedContext());
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public void finish() {
            if (ActionBarImpl.this.mActionMode == this) {
                if (ActionBarImpl.this.mWasHiddenBeforeMode) {
                    ActionBarImpl.this.mDeferredDestroyActionMode = this;
                    ActionBarImpl.this.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                ActionBarImpl.this.animateToMode(false);
                ActionBarImpl.this.mContextView.closeMode();
                ActionBarImpl.this.mActionView.sendAccessibilityEvent(32);
                ActionBarImpl.this.mActionMode = null;
                if (ActionBarImpl.this.mWasHiddenBeforeMode) {
                    ActionBarImpl.this.hide();
                }
            }
        }

        public void invalidate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                boolean onCreateActionMode = this.mCallback.onCreateActionMode(this, this.mMenu);
                return onCreateActionMode;
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void setCustomView(View view) {
            ActionBarImpl.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference(view);
        }

        public void setSubtitle(CharSequence charSequence) {
            ActionBarImpl.this.mContextView.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            ActionBarImpl.this.mContextView.setTitle(charSequence);
        }

        public void setTitle(int i) {
            setTitle(ActionBarImpl.this.mContext.getResources().getString(i));
        }

        public void setSubtitle(int i) {
            setSubtitle(ActionBarImpl.this.mContext.getResources().getString(i));
        }

        public CharSequence getTitle() {
            return ActionBarImpl.this.mContextView.getTitle();
        }

        public CharSequence getSubtitle() {
            return ActionBarImpl.this.mContextView.getSubtitle();
        }

        public View getCustomView() {
            return this.mCustomView != null ? (View) this.mCustomView.get() : null;
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (this.mCallback != null) {
                return this.mCallback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(ActionBarImpl.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.mCallback != null) {
                invalidate();
                ActionBarImpl.this.mContextView.showOverflowMenu();
            }
        }
    }

    public class TabImpl extends Tab {
        private TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;

        public Object getTag() {
            return this.mTag;
        }

        public Tab setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public TabListener getCallback() {
            return this.mCallback;
        }

        public Tab setTabListener(TabListener tabListener) {
            this.mCallback = tabListener;
            return this;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Tab setCustomView(View view) {
            this.mCustomView = view;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(ActionBarImpl.this.getThemedContext()).inflate(i, null));
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public void setPosition(int i) {
            this.mPosition = i;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setIcon(int i) {
            return setIcon(ActionBarImpl.this.mContext.getResources().getDrawable(i));
        }

        public Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public Tab setText(int i) {
            return setText(ActionBarImpl.this.mContext.getResources().getText(i));
        }

        public void select() {
            ActionBarImpl.this.selectTab(this);
        }

        public Tab setContentDescription(int i) {
            return setContentDescription(ActionBarImpl.this.mContext.getResources().getText(i));
        }

        public Tab setContentDescription(CharSequence charSequence) {
            this.mContentDesc = charSequence;
            if (this.mPosition >= 0) {
                ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }
    }

    public ActionBarImpl(Activity activity, int i) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if ((i & 512) == 0) {
            this.mContentView = (NineFrameLayout) decorView.findViewById(16908290);
        }
    }

    public ActionBarImpl(Dialog dialog) {
        init(dialog.getWindow().getDecorView());
    }

    private void init(View view) {
        boolean z = true;
        this.mContext = view.getContext();
        this.mActionView = (ActionBarView) view.findViewById(C0414R.id.abs__action_bar);
        this.mContextView = (ActionBarContextView) view.findViewById(C0414R.id.abs__action_context_bar);
        this.mContainerView = (ActionBarContainer) view.findViewById(C0414R.id.abs__action_bar_container);
        this.mSplitView = (ActionBarContainer) view.findViewById(C0414R.id.abs__split_action_bar);
        if (this.mActionView == null || this.mContextView == null || this.mContainerView == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(getClass().getSimpleName())).append(" can only be used ").append("with a compatible window decor layout").toString());
        }
        int i;
        this.mActionView.setContextView(this.mContextView);
        if (this.mActionView.isSplitActionBar()) {
            i = 1;
        } else {
            i = 0;
        }
        this.mContextDisplayMode = i;
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 14) {
            z = false;
        }
        setHomeButtonEnabled(z);
        setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, C0414R.bool.abs__action_bar_embed_tabs));
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, C0414R.bool.abs__action_bar_embed_tabs));
        if (VERSION.SDK_INT < 8) {
            this.mActionView.onConfigurationChanged(configuration);
            if (this.mContextView != null) {
                this.mContextView.onConfigurationChanged(configuration);
            }
        }
    }

    private void setHasEmbeddedTabs(boolean z) {
        boolean z2;
        boolean z3 = true;
        this.mHasEmbeddedTabs = z;
        if (this.mHasEmbeddedTabs) {
            this.mContainerView.setTabContainer(null);
            this.mActionView.setEmbeddedTabView(this.mTabScrollView);
        } else {
            this.mActionView.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        }
        if (getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.mTabScrollView != null) {
            this.mTabScrollView.setVisibility(z2 ? 0 : 8);
        }
        ActionBarView actionBarView = this.mActionView;
        if (this.mHasEmbeddedTabs || !z2) {
            z3 = false;
        }
        actionBarView.setCollapsable(z3);
    }

    private void ensureTabsExist() {
        int i = 0;
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                scrollingTabContainerView.setVisibility(0);
                this.mActionView.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() != 2) {
                    i = 8;
                }
                scrollingTabContainerView.setVisibility(i);
                this.mContainerView.setTabContainer(scrollingTabContainerView);
            }
            this.mTabScrollView = scrollingTabContainerView;
        }
    }

    void completeDeferredDestroyActionMode() {
        if (this.mDeferredModeDestroyCallback != null) {
            this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void setShowHideAnimationEnabled(boolean z) {
        this.mShowHideAnimationEnabled = z;
        if (!z && this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z;
            int size = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < size; i++) {
                ((OnMenuVisibilityListener) this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(z);
            }
        }
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.mActionView, false));
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.mActionView.setHomeButtonEnabled(z);
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public void setSelectedNavigationItem(int i) {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                this.mActionView.setDropdownSelectedPosition(i);
                return;
            case 2:
                selectTab((Tab) this.mTabs.get(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.mTabScrollView != null) {
            this.mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    public void setTitle(CharSequence charSequence) {
        this.mActionView.setTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mActionView.setSubtitle(charSequence);
    }

    public void setDisplayOptions(int i) {
        this.mActionView.setDisplayOptions(i);
    }

    public void setDisplayOptions(int i, int i2) {
        this.mActionView.setDisplayOptions((this.mActionView.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setPrimaryBackground(drawable);
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setStackedBackground(drawable);
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
        if (this.mSplitView != null) {
            this.mSplitView.setSplitBackground(drawable);
        }
    }

    public View getCustomView() {
        return this.mActionView.getCustomNavigationView();
    }

    public CharSequence getTitle() {
        return this.mActionView.getTitle();
    }

    public CharSequence getSubtitle() {
        return this.mActionView.getSubtitle();
    }

    public int getNavigationMode() {
        return this.mActionView.getNavigationMode();
    }

    public int getDisplayOptions() {
        return this.mActionView.getDisplayOptions();
    }

    public ActionMode startActionMode(Callback callback) {
        boolean z;
        if (this.mActionMode != null) {
            z = this.mWasHiddenBeforeMode;
            this.mActionMode.finish();
        } else {
            z = false;
        }
        this.mContextView.killMode();
        ActionMode actionModeImpl = new ActionModeImpl(callback);
        if (!actionModeImpl.dispatchOnCreate()) {
            return null;
        }
        z = !isShowing() || z;
        this.mWasHiddenBeforeMode = z;
        actionModeImpl.invalidate();
        this.mContextView.initForMode(actionModeImpl);
        animateToMode(true);
        if (this.mSplitView != null && this.mContextDisplayMode == 1) {
            this.mSplitView.setVisibility(0);
        }
        this.mContextView.sendAccessibilityEvent(32);
        this.mActionMode = actionModeImpl;
        return actionModeImpl;
    }

    private void configureTab(Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(i);
        this.mTabs.add(i, tabImpl);
        int size = this.mTabs.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((TabImpl) this.mTabs.get(i2)).setPosition(i2);
        }
    }

    public void addTab(Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    public void addTab(Tab tab, boolean z) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, z);
        configureTab(tab, this.mTabs.size());
        if (z) {
            selectTab(tab);
        }
    }

    public void addTab(Tab tab, int i, boolean z) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, i, z);
        configureTab(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public Tab newTab() {
        return new TabImpl();
    }

    public void removeTab(Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if (this.mTabScrollView != null) {
            int position = this.mSelectedTab != null ? this.mSelectedTab.getPosition() : this.mSavedTabPosition;
            this.mTabScrollView.removeTabAt(i);
            TabImpl tabImpl = (TabImpl) this.mTabs.remove(i);
            if (tabImpl != null) {
                tabImpl.setPosition(-1);
            }
            int size = this.mTabs.size();
            for (int i2 = i; i2 < size; i2++) {
                ((TabImpl) this.mTabs.get(i2)).setPosition(i2);
            }
            if (position == i) {
                Tab tab;
                if (this.mTabs.isEmpty()) {
                    tab = null;
                } else {
                    tabImpl = (TabImpl) this.mTabs.get(Math.max(0, i - 1));
                }
                selectTab(tab);
            }
        }
    }

    public void selectTab(Tab tab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            int position;
            if (tab != null) {
                position = tab.getPosition();
            } else {
                position = -1;
            }
            this.mSavedTabPosition = position;
            return;
        }
        FragmentTransaction fragmentTransaction = null;
        if (this.mActivity instanceof FragmentActivity) {
            fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        if (this.mSelectedTab != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, fragmentTransaction);
            }
            this.mSelectedTab = (TabImpl) tab;
            if (this.mSelectedTab != null) {
                this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, fragmentTransaction);
            }
        } else if (this.mSelectedTab != null) {
            this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, fragmentTransaction);
            this.mTabScrollView.animateToTab(tab.getPosition());
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    public Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public void show() {
        show(true);
    }

    void show(boolean z) {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() != 0) {
            this.mContainerView.setVisibility(0);
            if (this.mShowHideAnimationEnabled) {
                this.mContainerView.setAlpha(0.0f);
                Animator animatorSet = new AnimatorSet();
                Builder play = animatorSet.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", TextTrackStyle.DEFAULT_FONT_SCALE));
                if (this.mContentView != null) {
                    play.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", (float) (-this.mContainerView.getHeight()), 0.0f));
                    this.mContainerView.setTranslationY((float) (-this.mContainerView.getHeight()));
                    play.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", 0.0f));
                }
                if (this.mSplitView != null && this.mContextDisplayMode == 1) {
                    this.mSplitView.setAlpha(0.0f);
                    this.mSplitView.setVisibility(0);
                    play.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", TextTrackStyle.DEFAULT_FONT_SCALE));
                }
                animatorSet.addListener(this.mShowListener);
                this.mCurrentShowAnim = animatorSet;
                animatorSet.start();
                return;
            }
            this.mContainerView.setAlpha(TextTrackStyle.DEFAULT_FONT_SCALE);
            this.mContainerView.setTranslationY(0.0f);
            this.mShowListener.onAnimationEnd(null);
        } else if (z) {
            this.mWasHiddenBeforeMode = false;
        }
    }

    public void hide() {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() != 8) {
            if (this.mShowHideAnimationEnabled) {
                this.mContainerView.setAlpha(TextTrackStyle.DEFAULT_FONT_SCALE);
                this.mContainerView.setTransitioning(true);
                Animator animatorSet = new AnimatorSet();
                Builder play = animatorSet.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", 0.0f));
                if (this.mContentView != null) {
                    play.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", 0.0f, (float) (-this.mContainerView.getHeight())));
                    play.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", (float) (-this.mContainerView.getHeight())));
                }
                if (this.mSplitView != null && this.mSplitView.getVisibility() == 0) {
                    this.mSplitView.setAlpha(TextTrackStyle.DEFAULT_FONT_SCALE);
                    play.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", 0.0f));
                }
                animatorSet.addListener(this.mHideListener);
                this.mCurrentShowAnim = animatorSet;
                animatorSet.start();
                return;
            }
            this.mHideListener.onAnimationEnd(null);
        }
    }

    public boolean isShowing() {
        return this.mContainerView.getVisibility() == 0;
    }

    void animateToMode(boolean z) {
        int i;
        int i2 = 8;
        if (z) {
            show(false);
        }
        if (this.mCurrentModeAnim != null) {
            this.mCurrentModeAnim.end();
        }
        this.mActionView.animateToVisibility(z ? 8 : 0);
        ActionBarContextView actionBarContextView = this.mContextView;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        actionBarContextView.animateToVisibility(i);
        if (this.mTabScrollView != null && !this.mActionView.hasEmbeddedTabs() && this.mActionView.isCollapsed()) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (!z) {
                i2 = 0;
            }
            scrollingTabContainerView.animateToVisibility(i2);
        }
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0414R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public void setCustomView(View view) {
        this.mActionView.setCustomNavigationView(view);
    }

    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mActionView.setCustomNavigationView(view);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener) {
        this.mActionView.setDropdownAdapter(spinnerAdapter);
        this.mActionView.setCallback(onNavigationListener);
    }

    public int getSelectedNavigationIndex() {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                return this.mActionView.getDropdownSelectedPosition();
            case 2:
                if (this.mSelectedTab != null) {
                    return this.mSelectedTab.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    public int getNavigationItemCount() {
        switch (this.mActionView.getNavigationMode()) {
            case 1:
                SpinnerAdapter dropdownAdapter = this.mActionView.getDropdownAdapter();
                return dropdownAdapter != null ? dropdownAdapter.getCount() : 0;
            case 2:
                return this.mTabs.size();
            default:
                return 0;
        }
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public void setNavigationMode(int i) {
        boolean z = false;
        switch (this.mActionView.getNavigationMode()) {
            case 2:
                this.mSavedTabPosition = getSelectedNavigationIndex();
                selectTab(null);
                this.mTabScrollView.setVisibility(8);
                break;
        }
        this.mActionView.setNavigationMode(i);
        switch (i) {
            case 2:
                ensureTabsExist();
                this.mTabScrollView.setVisibility(0);
                if (this.mSavedTabPosition != -1) {
                    setSelectedNavigationItem(this.mSavedTabPosition);
                    this.mSavedTabPosition = -1;
                    break;
                }
                break;
        }
        ActionBarView actionBarView = this.mActionView;
        if (i == 2 && !this.mHasEmbeddedTabs) {
            z = true;
        }
        actionBarView.setCollapsable(z);
    }

    public Tab getTabAt(int i) {
        return (Tab) this.mTabs.get(i);
    }

    public void setIcon(int i) {
        this.mActionView.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mActionView.setIcon(drawable);
    }

    public void setLogo(int i) {
        this.mActionView.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.mActionView.setLogo(drawable);
    }
}
