package com.actionbarsherlock.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.actionbarsherlock.C0414R;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.internal.ActionBarSherlockCompat;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.view.menu.ActionMenuItem;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuView;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.internal.widget.IcsAdapterView.OnItemSelectedListener;
import com.actionbarsherlock.view.CollapsibleActionView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window.Callback;

public class ActionBarView extends AbsActionBarView {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_CUSTOM_GRAVITY = 19;
    public static final int DISPLAY_DEFAULT = 0;
    private static final int DISPLAY_RELAYOUT_MASK = 31;
    private static final String TAG = "ActionBarView";
    private OnNavigationListener mCallback;
    private ActionBarContextView mContextView;
    private View mCustomNavView;
    private int mDisplayOptions = -1;
    View mExpandedActionView;
    private final OnClickListener mExpandedActionViewUpListener = new C04292();
    private HomeView mExpandedHomeLayout;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private HomeView mHomeLayout;
    private Drawable mIcon;
    private boolean mIncludeTabs;
    private int mIndeterminateProgressStyle;
    private IcsProgressBar mIndeterminateProgressView;
    private boolean mIsCollapsable;
    private boolean mIsCollapsed;
    private int mItemPadding;
    private IcsLinearLayout mListNavLayout;
    private Drawable mLogo;
    private ActionMenuItem mLogoNavItem;
    private final OnItemSelectedListener mNavItemSelectedListener = new C04281();
    private int mNavigationMode;
    private MenuBuilder mOptionsMenu;
    private int mProgressBarPadding;
    private int mProgressStyle;
    private IcsProgressBar mProgressView;
    private IcsSpinner mSpinner;
    private SpinnerAdapter mSpinnerAdapter;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private ScrollingTabContainerView mTabScrollView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private int mTitleStyleRes;
    private View mTitleUpView;
    private TextView mTitleView;
    private final OnClickListener mUpClickListener = new C04303();
    private boolean mUserTitle;
    Callback mWindowCallback;

    class C04281 implements OnItemSelectedListener {
        C04281() {
        }

        public void onItemSelected(IcsAdapterView icsAdapterView, View view, int i, long j) {
            if (ActionBarView.this.mCallback != null) {
                ActionBarView.this.mCallback.onNavigationItemSelected(i, j);
            }
        }

        public void onNothingSelected(IcsAdapterView icsAdapterView) {
        }
    }

    class C04292 implements OnClickListener {
        C04292() {
        }

        public void onClick(View view) {
            MenuItemImpl menuItemImpl = ActionBarView.this.mExpandedMenuPresenter.mCurrentExpandedItem;
            if (menuItemImpl != null) {
                menuItemImpl.collapseActionView();
            }
        }
    }

    class C04303 implements OnClickListener {
        C04303() {
        }

        public void onClick(View view) {
            ActionBarView.this.mWindowCallback.onMenuItemSelected(0, ActionBarView.this.mLogoNavItem);
        }
    }

    class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            if (!(this.mMenu == null || this.mCurrentExpandedItem == null)) {
                this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
            }
            this.mMenu = menuBuilder;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void updateMenuView(boolean z) {
            Object obj = null;
            if (this.mCurrentExpandedItem != null) {
                if (this.mMenu != null) {
                    int size = this.mMenu.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }

        public void setCallback(MenuPresenter.Callback callback) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return ActionBarView.DEBUG;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean flagActionItems() {
            return ActionBarView.DEBUG;
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            ActionBarView.this.mExpandedActionView = menuItemImpl.getActionView();
            ActionBarView.this.mExpandedHomeLayout.setIcon(ActionBarView.this.mIcon.getConstantState().newDrawable());
            this.mCurrentExpandedItem = menuItemImpl;
            if (ActionBarView.this.mExpandedActionView.getParent() != ActionBarView.this) {
                ActionBarView.this.addView(ActionBarView.this.mExpandedActionView);
            }
            if (ActionBarView.this.mExpandedHomeLayout.getParent() != ActionBarView.this) {
                ActionBarView.this.addView(ActionBarView.this.mExpandedHomeLayout);
            }
            ActionBarView.this.mHomeLayout.setVisibility(8);
            if (ActionBarView.this.mTitleLayout != null) {
                ActionBarView.this.mTitleLayout.setVisibility(8);
            }
            if (ActionBarView.this.mTabScrollView != null) {
                ActionBarView.this.mTabScrollView.setVisibility(8);
            }
            if (ActionBarView.this.mSpinner != null) {
                ActionBarView.this.mSpinner.setVisibility(8);
            }
            if (ActionBarView.this.mCustomNavView != null) {
                ActionBarView.this.mCustomNavView.setVisibility(8);
            }
            ActionBarView.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) ActionBarView.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) ActionBarView.this.mExpandedActionView).onActionViewCollapsed();
            }
            ActionBarView.this.removeView(ActionBarView.this.mExpandedActionView);
            ActionBarView.this.removeView(ActionBarView.this.mExpandedHomeLayout);
            ActionBarView.this.mExpandedActionView = null;
            if ((ActionBarView.this.mDisplayOptions & 2) != 0) {
                ActionBarView.this.mHomeLayout.setVisibility(0);
            }
            if ((ActionBarView.this.mDisplayOptions & 8) != 0) {
                if (ActionBarView.this.mTitleLayout == null) {
                    ActionBarView.this.initTitle();
                } else {
                    ActionBarView.this.mTitleLayout.setVisibility(0);
                }
            }
            if (ActionBarView.this.mTabScrollView != null && ActionBarView.this.mNavigationMode == 2) {
                ActionBarView.this.mTabScrollView.setVisibility(0);
            }
            if (ActionBarView.this.mSpinner != null && ActionBarView.this.mNavigationMode == 1) {
                ActionBarView.this.mSpinner.setVisibility(0);
            }
            if (!(ActionBarView.this.mCustomNavView == null || (ActionBarView.this.mDisplayOptions & 16) == 0)) {
                ActionBarView.this.mCustomNavView.setVisibility(0);
            }
            ActionBarView.this.mExpandedHomeLayout.setIcon(null);
            this.mCurrentExpandedItem = null;
            ActionBarView.this.requestLayout();
            menuItemImpl.setActionViewExpanded(ActionBarView.DEBUG);
            return true;
        }

        public int getId() {
            return 0;
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }
    }

    public class HomeView extends FrameLayout {
        private ImageView mIconView;
        private View mUpView;
        private int mUpWidth;

        public HomeView(Context context) {
            this(context, null);
        }

        public HomeView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setUp(boolean z) {
            this.mUpView.setVisibility(z ? 0 : 8);
        }

        public void setIcon(Drawable drawable) {
            this.mIconView.setImageDrawable(drawable);
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onPopulateAccessibilityEvent(accessibilityEvent);
            return true;
        }

        public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            if (VERSION.SDK_INT >= 14) {
                super.onPopulateAccessibilityEvent(accessibilityEvent);
            }
            CharSequence contentDescription = getContentDescription();
            if (!TextUtils.isEmpty(contentDescription)) {
                accessibilityEvent.getText().add(contentDescription);
            }
        }

        public boolean dispatchHoverEvent(MotionEvent motionEvent) {
            return onHoverEvent(motionEvent);
        }

        protected void onFinishInflate() {
            this.mUpView = findViewById(C0414R.id.abs__up);
            this.mIconView = (ImageView) findViewById(C0414R.id.abs__home);
        }

        public int getLeftOffset() {
            return this.mUpView.getVisibility() == 8 ? this.mUpWidth : 0;
        }

        protected void onMeasure(int i, int i2) {
            measureChildWithMargins(this.mUpView, i, 0, i2, 0);
            LayoutParams layoutParams = (LayoutParams) this.mUpView.getLayoutParams();
            this.mUpWidth = (layoutParams.leftMargin + this.mUpView.getMeasuredWidth()) + layoutParams.rightMargin;
            int i3 = this.mUpView.getVisibility() == 8 ? 0 : this.mUpWidth;
            int measuredHeight = (layoutParams.topMargin + this.mUpView.getMeasuredHeight()) + layoutParams.bottomMargin;
            measureChildWithMargins(this.mIconView, i, i3, i2, 0);
            layoutParams = (LayoutParams) this.mIconView.getLayoutParams();
            int measuredWidth = i3 + ((layoutParams.leftMargin + this.mIconView.getMeasuredWidth()) + layoutParams.rightMargin);
            measuredHeight = Math.max(measuredHeight, layoutParams.bottomMargin + (layoutParams.topMargin + this.mIconView.getMeasuredHeight()));
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            switch (mode) {
                case Integer.MIN_VALUE:
                    size = Math.min(measuredWidth, size);
                    break;
                case 1073741824:
                    break;
                default:
                    size = measuredWidth;
                    break;
            }
            switch (mode2) {
                case Integer.MIN_VALUE:
                    size2 = Math.min(measuredHeight, size2);
                    break;
                case 1073741824:
                    break;
                default:
                    size2 = measuredHeight;
                    break;
            }
            setMeasuredDimension(size, size2);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams;
            int measuredHeight;
            int measuredWidth;
            int i5;
            int i6 = 0;
            int i7 = (i4 - i2) / 2;
            if (this.mUpView.getVisibility() != 8) {
                layoutParams = (LayoutParams) this.mUpView.getLayoutParams();
                measuredHeight = this.mUpView.getMeasuredHeight();
                measuredWidth = this.mUpView.getMeasuredWidth();
                int i8 = i7 - (measuredHeight / 2);
                this.mUpView.layout(0, i8, measuredWidth, measuredHeight + i8);
                i5 = layoutParams.rightMargin + (layoutParams.leftMargin + measuredWidth);
                i += i5;
                i6 = i5;
            }
            layoutParams = (LayoutParams) this.mIconView.getLayoutParams();
            measuredHeight = this.mIconView.getMeasuredHeight();
            measuredWidth = this.mIconView.getMeasuredWidth();
            i6 += Math.max(layoutParams.leftMargin, ((i3 - i) / 2) - (measuredWidth / 2));
            i5 = Math.max(layoutParams.topMargin, i7 - (measuredHeight / 2));
            this.mIconView.layout(i6, i5, measuredWidth + i6, measuredHeight + i5);
        }
    }

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C04311();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        class C04311 implements Creator<SavedState> {
            C04311() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0 ? true : ActionBarView.DEBUG;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    public ActionBarView(Context context, AttributeSet attributeSet) {
        int loadLogoFromManifest;
        super(context, attributeSet);
        setBackgroundResource(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0414R.styleable.SherlockActionBar, C0414R.attr.actionBarStyle, 0);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        PackageManager packageManager = context.getPackageManager();
        this.mNavigationMode = obtainStyledAttributes.getInt(C0414R.styleable.SherlockActionBar_navigationMode, 0);
        this.mTitle = obtainStyledAttributes.getText(C0414R.styleable.SherlockActionBar_title);
        this.mSubtitle = obtainStyledAttributes.getText(C0414R.styleable.SherlockActionBar_subtitle);
        this.mLogo = obtainStyledAttributes.getDrawable(C0414R.styleable.SherlockActionBar_logo);
        if (this.mLogo == null) {
            if (VERSION.SDK_INT >= 11) {
                if (context instanceof Activity) {
                    try {
                        this.mLogo = packageManager.getActivityLogo(((Activity) context).getComponentName());
                    } catch (Throwable e) {
                        Log.e(TAG, "Activity component name not found!", e);
                    }
                }
                if (this.mLogo == null) {
                    this.mLogo = applicationInfo.loadLogo(packageManager);
                }
            } else if (context instanceof Activity) {
                loadLogoFromManifest = loadLogoFromManifest((Activity) context);
                if (loadLogoFromManifest != 0) {
                    this.mLogo = context.getResources().getDrawable(loadLogoFromManifest);
                }
            }
        }
        this.mIcon = obtainStyledAttributes.getDrawable(C0414R.styleable.SherlockActionBar_icon);
        if (this.mIcon == null) {
            if (context instanceof Activity) {
                try {
                    this.mIcon = packageManager.getActivityIcon(((Activity) context).getComponentName());
                } catch (Throwable e2) {
                    Log.e(TAG, "Activity component name not found!", e2);
                }
            }
            if (this.mIcon == null) {
                this.mIcon = applicationInfo.loadIcon(packageManager);
            }
        }
        LayoutInflater from = LayoutInflater.from(context);
        int resourceId = obtainStyledAttributes.getResourceId(C0414R.styleable.SherlockActionBar_homeLayout, C0414R.layout.abs__action_bar_home);
        this.mHomeLayout = (HomeView) from.inflate(resourceId, this, DEBUG);
        this.mExpandedHomeLayout = (HomeView) from.inflate(resourceId, this, DEBUG);
        this.mExpandedHomeLayout.setUp(true);
        this.mExpandedHomeLayout.setOnClickListener(this.mExpandedActionViewUpListener);
        this.mExpandedHomeLayout.setContentDescription(getResources().getText(C0414R.string.abs__action_bar_up_description));
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(C0414R.styleable.SherlockActionBar_titleTextStyle, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(C0414R.styleable.SherlockActionBar_subtitleTextStyle, 0);
        this.mProgressStyle = obtainStyledAttributes.getResourceId(C0414R.styleable.SherlockActionBar_progressBarStyle, 0);
        this.mIndeterminateProgressStyle = obtainStyledAttributes.getResourceId(C0414R.styleable.SherlockActionBar_indeterminateProgressStyle, 0);
        this.mProgressBarPadding = obtainStyledAttributes.getDimensionPixelOffset(C0414R.styleable.SherlockActionBar_progressBarPadding, 0);
        this.mItemPadding = obtainStyledAttributes.getDimensionPixelOffset(C0414R.styleable.SherlockActionBar_itemPadding, 0);
        setDisplayOptions(obtainStyledAttributes.getInt(C0414R.styleable.SherlockActionBar_displayOptions, 0));
        loadLogoFromManifest = obtainStyledAttributes.getResourceId(C0414R.styleable.SherlockActionBar_customNavigationLayout, 0);
        if (loadLogoFromManifest != 0) {
            this.mCustomNavView = from.inflate(loadLogoFromManifest, this, DEBUG);
            this.mNavigationMode = 0;
            setDisplayOptions(this.mDisplayOptions | 16);
        }
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(C0414R.styleable.SherlockActionBar_height, 0);
        obtainStyledAttributes.recycle();
        this.mLogoNavItem = new ActionMenuItem(context, 0, 16908332, 0, 0, this.mTitle);
        this.mHomeLayout.setOnClickListener(this.mUpClickListener);
        this.mHomeLayout.setClickable(true);
        this.mHomeLayout.setFocusable(true);
    }

    private static int loadLogoFromManifest(Activity activity) {
        int i;
        Exception e;
        try {
            String name = activity.getClass().getName();
            String str = activity.getApplicationInfo().packageName;
            XmlResourceParser openXmlResourceParser = activity.createPackageContext(str, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
            int eventType = openXmlResourceParser.getEventType();
            i = 0;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name2 = openXmlResourceParser.getName();
                    if (!"application".equals(name2)) {
                        if ("activity".equals(name2)) {
                            Object obj = null;
                            String str2 = null;
                            Integer num = null;
                            for (eventType = openXmlResourceParser.getAttributeCount() - 1; eventType >= 0; eventType--) {
                                String attributeName = openXmlResourceParser.getAttributeName(eventType);
                                if (!"logo".equals(attributeName)) {
                                    if ("name".equals(attributeName)) {
                                        str2 = ActionBarSherlockCompat.cleanActivityName(str, openXmlResourceParser.getAttributeValue(eventType));
                                        if (!name.equals(str2)) {
                                            break;
                                        }
                                        int i2 = 1;
                                    }
                                } else {
                                    num = Integer.valueOf(openXmlResourceParser.getAttributeResourceValue(eventType, 0));
                                }
                                if (!(num == null || r4 == null)) {
                                    i = num.intValue();
                                }
                            }
                            if (obj != null) {
                                break;
                            }
                        }
                    }
                    eventType = openXmlResourceParser.getAttributeCount() - 1;
                    while (eventType >= 0) {
                        try {
                            if ("logo".equals(openXmlResourceParser.getAttributeName(eventType))) {
                                eventType = openXmlResourceParser.getAttributeResourceValue(eventType, 0);
                                break;
                            }
                            eventType--;
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                    eventType = i;
                    i = eventType;
                    eventType = openXmlResourceParser.nextToken();
                }
                eventType = i;
                try {
                    i = eventType;
                    eventType = openXmlResourceParser.nextToken();
                } catch (Exception e3) {
                    Exception exception = e3;
                    i = eventType;
                    e = exception;
                }
            }
        } catch (Exception e32) {
            e = e32;
            i = 0;
            e.printStackTrace();
            return i;
        }
        return i;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mTitleView = null;
        this.mSubtitleView = null;
        this.mTitleUpView = null;
        if (this.mTitleLayout != null && this.mTitleLayout.getParent() == this) {
            removeView(this.mTitleLayout);
        }
        this.mTitleLayout = null;
        if ((this.mDisplayOptions & 8) != 0) {
            initTitle();
        }
        if (this.mTabScrollView != null && this.mIncludeTabs) {
            ViewGroup.LayoutParams layoutParams = this.mTabScrollView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = -1;
            }
            this.mTabScrollView.setAllowCollapse(true);
        }
    }

    public void setWindowCallback(Callback callback) {
        this.mWindowCallback = callback;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    public boolean shouldDelayChildPressedState() {
        return DEBUG;
    }

    public void initProgress() {
        this.mProgressView = new IcsProgressBar(this.mContext, null, 0, this.mProgressStyle);
        this.mProgressView.setId(C0414R.id.abs__progress_horizontal);
        this.mProgressView.setMax(10000);
        addView(this.mProgressView);
    }

    public void initIndeterminateProgress() {
        this.mIndeterminateProgressView = new IcsProgressBar(this.mContext, null, 0, this.mIndeterminateProgressStyle);
        this.mIndeterminateProgressView.setId(C0414R.id.abs__progress_circular);
        addView(this.mIndeterminateProgressView);
    }

    public void setSplitActionBar(boolean z) {
        if (this.mSplitActionBar != z) {
            if (this.mMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) this.mMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mMenuView);
                }
                if (!z) {
                    addView(this.mMenuView);
                } else if (this.mSplitView != null) {
                    this.mSplitView.addView(this.mMenuView);
                }
            }
            if (this.mSplitView != null) {
                this.mSplitView.setVisibility(z ? 0 : 8);
            }
            super.setSplitActionBar(z);
        }
    }

    public boolean isSplitActionBar() {
        return this.mSplitActionBar;
    }

    public boolean hasEmbeddedTabs() {
        return this.mIncludeTabs;
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.mTabScrollView != null) {
            removeView(this.mTabScrollView);
        }
        this.mTabScrollView = scrollingTabContainerView;
        this.mIncludeTabs = scrollingTabContainerView != null ? true : DEBUG;
        if (this.mIncludeTabs && this.mNavigationMode == 2) {
            addView(this.mTabScrollView);
            ViewGroup.LayoutParams layoutParams = this.mTabScrollView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void setCallback(OnNavigationListener onNavigationListener) {
        this.mCallback = onNavigationListener;
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (menu != this.mOptionsMenu) {
            ActionMenuView actionMenuView;
            if (this.mOptionsMenu != null) {
                this.mOptionsMenu.removeMenuPresenter(this.mActionMenuPresenter);
                this.mOptionsMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
            }
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            this.mOptionsMenu = menuBuilder;
            if (this.mMenuView != null) {
                ViewGroup viewGroup = (ViewGroup) this.mMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.mMenuView);
                }
            }
            if (this.mActionMenuPresenter == null) {
                this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext);
                this.mActionMenuPresenter.setCallback(callback);
                this.mActionMenuPresenter.setId(C0414R.id.abs__action_menu_presenter);
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            ViewGroup viewGroup2;
            if (this.mSplitActionBar) {
                this.mActionMenuPresenter.setExpandedActionViewsExclusive(DEBUG);
                this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
                this.mActionMenuPresenter.setItemLimit(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                layoutParams.width = -1;
                configPresenters(menuBuilder);
                actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                if (this.mSplitView != null) {
                    viewGroup2 = (ViewGroup) actionMenuView.getParent();
                    if (!(viewGroup2 == null || viewGroup2 == this.mSplitView)) {
                        viewGroup2.removeView(actionMenuView);
                    }
                    actionMenuView.setVisibility(getAnimatedVisibility());
                    this.mSplitView.addView(actionMenuView, layoutParams);
                } else {
                    actionMenuView.setLayoutParams(layoutParams);
                }
            } else {
                this.mActionMenuPresenter.setExpandedActionViewsExclusive(ResourcesCompat.getResources_getBoolean(getContext(), C0414R.bool.abs__action_bar_expanded_action_views_exclusive));
                configPresenters(menuBuilder);
                actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                viewGroup2 = (ViewGroup) actionMenuView.getParent();
                if (!(viewGroup2 == null || viewGroup2 == this)) {
                    viewGroup2.removeView(actionMenuView);
                }
                addView(actionMenuView, layoutParams);
            }
            this.mMenuView = actionMenuView;
        }
    }

    private void configPresenters(MenuBuilder menuBuilder) {
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter);
            return;
        }
        this.mActionMenuPresenter.initForMenu(this.mContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mContext, null);
        this.mActionMenuPresenter.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null) ? DEBUG : true;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        if (this.mExpandedMenuPresenter == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = this.mExpandedMenuPresenter.mCurrentExpandedItem;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void setCustomNavigationView(View view) {
        Object obj = (this.mDisplayOptions & 16) != 0 ? 1 : null;
        if (!(this.mCustomNavView == null || obj == null)) {
            removeView(this.mCustomNavView);
        }
        this.mCustomNavView = view;
        if (this.mCustomNavView != null && obj != null) {
            addView(this.mCustomNavView);
        }
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public void setTitle(CharSequence charSequence) {
        this.mUserTitle = true;
        setTitleImpl(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.mUserTitle) {
            setTitleImpl(charSequence);
        }
    }

    private void setTitleImpl(CharSequence charSequence) {
        int i = 0;
        this.mTitle = charSequence;
        if (this.mTitleView != null) {
            this.mTitleView.setText(charSequence);
            int i2 = (this.mExpandedActionView != null || (this.mDisplayOptions & 8) == 0 || (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle))) ? 0 : 1;
            LinearLayout linearLayout = this.mTitleLayout;
            if (i2 == 0) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
        if (this.mLogoNavItem != null) {
            this.mLogoNavItem.setTitle(charSequence);
        }
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public void setSubtitle(CharSequence charSequence) {
        int i = 0;
        this.mSubtitle = charSequence;
        if (this.mSubtitleView != null) {
            int i2;
            this.mSubtitleView.setText(charSequence);
            this.mSubtitleView.setVisibility(charSequence != null ? 0 : 8);
            if (this.mExpandedActionView != null || (this.mDisplayOptions & 8) == 0 || (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            LinearLayout linearLayout = this.mTitleLayout;
            if (i2 == 0) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
    }

    public void setHomeButtonEnabled(boolean z) {
        this.mHomeLayout.setEnabled(z);
        this.mHomeLayout.setFocusable(z);
        if (!z) {
            this.mHomeLayout.setContentDescription(null);
        } else if ((this.mDisplayOptions & 4) != 0) {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(C0414R.string.abs__action_bar_up_description));
        } else {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(C0414R.string.abs__action_bar_home_description));
        }
    }

    public void setDisplayOptions(int i) {
        int i2 = 8;
        int i3 = -1;
        boolean z = true;
        if (this.mDisplayOptions != -1) {
            i3 = this.mDisplayOptions ^ i;
        }
        this.mDisplayOptions = i;
        if ((i3 & 31) != 0) {
            boolean z2;
            int i4;
            boolean z3;
            if ((i & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && this.mExpandedActionView == null) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            this.mHomeLayout.setVisibility(i4);
            if ((i3 & 4) != 0) {
                z3 = (i & 4) != 0 ? true : DEBUG;
                this.mHomeLayout.setUp(z3);
                if (z3) {
                    setHomeButtonEnabled(true);
                }
            }
            if ((i3 & 1) != 0) {
                z3 = (this.mLogo == null || (i & 1) == 0) ? false : true;
                this.mHomeLayout.setIcon(z3 ? this.mLogo : this.mIcon);
            }
            if ((i3 & 8) != 0) {
                if ((i & 8) != 0) {
                    initTitle();
                } else {
                    removeView(this.mTitleLayout);
                }
            }
            if (!(this.mTitleLayout == null || (i3 & 6) == 0)) {
                if ((this.mDisplayOptions & 4) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                View view = this.mTitleUpView;
                if (!z2) {
                    i2 = z3 ? 0 : 4;
                }
                view.setVisibility(i2);
                LinearLayout linearLayout = this.mTitleLayout;
                if (z2 || !z3) {
                    z = DEBUG;
                }
                linearLayout.setEnabled(z);
            }
            if (!((i3 & 16) == 0 || this.mCustomNavView == null)) {
                if ((i & 16) != 0) {
                    addView(this.mCustomNavView);
                } else {
                    removeView(this.mCustomNavView);
                }
            }
            requestLayout();
        } else {
            invalidate();
        }
        if (!this.mHomeLayout.isEnabled()) {
            this.mHomeLayout.setContentDescription(null);
        } else if ((i & 4) != 0) {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(C0414R.string.abs__action_bar_up_description));
        } else {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(C0414R.string.abs__action_bar_home_description));
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable == null) {
            return;
        }
        if ((this.mDisplayOptions & 1) == 0 || this.mLogo == null) {
            this.mHomeLayout.setIcon(drawable);
        }
    }

    public void setIcon(int i) {
        setIcon(this.mContext.getResources().getDrawable(i));
    }

    public void setLogo(Drawable drawable) {
        this.mLogo = drawable;
        if (drawable != null && (this.mDisplayOptions & 1) != 0) {
            this.mHomeLayout.setIcon(drawable);
        }
    }

    public void setLogo(int i) {
        setLogo(this.mContext.getResources().getDrawable(i));
    }

    public void setNavigationMode(int i) {
        int i2 = this.mNavigationMode;
        if (i != i2) {
            switch (i2) {
                case 1:
                    if (this.mListNavLayout != null) {
                        removeView(this.mListNavLayout);
                        break;
                    }
                    break;
                case 2:
                    if (this.mTabScrollView != null && this.mIncludeTabs) {
                        removeView(this.mTabScrollView);
                        break;
                    }
            }
            switch (i) {
                case 1:
                    if (this.mSpinner == null) {
                        this.mSpinner = new IcsSpinner(this.mContext, null, C0414R.attr.actionDropDownStyle);
                        this.mListNavLayout = (IcsLinearLayout) LayoutInflater.from(this.mContext).inflate(C0414R.layout.abs__action_bar_tab_bar_view, null);
                        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                        layoutParams.gravity = 17;
                        this.mListNavLayout.addView(this.mSpinner, layoutParams);
                    }
                    if (this.mSpinner.getAdapter() != this.mSpinnerAdapter) {
                        this.mSpinner.setAdapter(this.mSpinnerAdapter);
                    }
                    this.mSpinner.setOnItemSelectedListener(this.mNavItemSelectedListener);
                    addView(this.mListNavLayout);
                    break;
                case 2:
                    if (this.mTabScrollView != null && this.mIncludeTabs) {
                        addView(this.mTabScrollView);
                        break;
                    }
            }
            this.mNavigationMode = i;
            requestLayout();
        }
    }

    public void setDropdownAdapter(SpinnerAdapter spinnerAdapter) {
        this.mSpinnerAdapter = spinnerAdapter;
        if (this.mSpinner != null) {
            this.mSpinner.setAdapter(spinnerAdapter);
        }
    }

    public SpinnerAdapter getDropdownAdapter() {
        return this.mSpinnerAdapter;
    }

    public void setDropdownSelectedPosition(int i) {
        this.mSpinner.setSelection(i);
    }

    public int getDropdownSelectedPosition() {
        return this.mSpinner.getSelectedItemPosition();
    }

    public View getCustomNavigationView() {
        return this.mCustomNavView;
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public int getDisplayOptions() {
        return this.mDisplayOptions;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ActionBar.LayoutParams(19);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        addView(this.mHomeLayout);
        if (this.mCustomNavView != null && (this.mDisplayOptions & 16) != 0) {
            ActionBarView parent = this.mCustomNavView.getParent();
            if (parent != this) {
                if (parent instanceof ViewGroup) {
                    parent.removeView(this.mCustomNavView);
                }
                addView(this.mCustomNavView);
            }
        }
    }

    private void initTitle() {
        boolean z = true;
        if (this.mTitleLayout == null) {
            this.mTitleLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(C0414R.layout.abs__action_bar_title_item, this, DEBUG);
            this.mTitleView = (TextView) this.mTitleLayout.findViewById(C0414R.id.abs__action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(C0414R.id.abs__action_bar_subtitle);
            this.mTitleUpView = this.mTitleLayout.findViewById(C0414R.id.abs__up);
            this.mTitleLayout.setOnClickListener(this.mUpClickListener);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
            }
            if (this.mTitle != null) {
                this.mTitleView.setText(this.mTitle);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
            }
            if (this.mSubtitle != null) {
                this.mSubtitleView.setText(this.mSubtitle);
                this.mSubtitleView.setVisibility(0);
            }
            boolean z2 = (this.mDisplayOptions & 4) != 0 ? true : DEBUG;
            boolean z3 = (this.mDisplayOptions & 2) != 0 ? true : DEBUG;
            View view = this.mTitleUpView;
            int i = !z3 ? z2 ? 0 : 4 : 8;
            view.setVisibility(i);
            LinearLayout linearLayout = this.mTitleLayout;
            if (!z2 || z3) {
                z = DEBUG;
            }
            linearLayout.setEnabled(z);
        }
        addView(this.mTitleLayout);
        if (this.mExpandedActionView != null || (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle))) {
            this.mTitleLayout.setVisibility(8);
        }
    }

    public void setContextView(ActionBarContextView actionBarContextView) {
        this.mContextView = actionBarContextView;
    }

    public void setCollapsable(boolean z) {
        this.mIsCollapsable = z;
    }

    public boolean isCollapsed() {
        return this.mIsCollapsed;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r20, int r21) {
        /*
        r19 = this;
        r13 = r19.getChildCount();
        r0 = r19;
        r1 = r0.mIsCollapsable;
        if (r1 == 0) goto L_0x0045;
    L_0x000a:
        r2 = 0;
        r1 = 0;
        r18 = r1;
        r1 = r2;
        r2 = r18;
    L_0x0011:
        if (r2 < r13) goto L_0x0022;
    L_0x0013:
        if (r1 != 0) goto L_0x0045;
    L_0x0015:
        r1 = 0;
        r2 = 0;
        r0 = r19;
        r0.setMeasuredDimension(r1, r2);
        r1 = 1;
        r0 = r19;
        r0.mIsCollapsed = r1;
    L_0x0021:
        return;
    L_0x0022:
        r0 = r19;
        r3 = r0.getChildAt(r2);
        r4 = r3.getVisibility();
        r5 = 8;
        if (r4 == r5) goto L_0x0042;
    L_0x0030:
        r0 = r19;
        r4 = r0.mMenuView;
        if (r3 != r4) goto L_0x0040;
    L_0x0036:
        r0 = r19;
        r3 = r0.mMenuView;
        r3 = r3.getChildCount();
        if (r3 == 0) goto L_0x0042;
    L_0x0040:
        r1 = r1 + 1;
    L_0x0042:
        r2 = r2 + 1;
        goto L_0x0011;
    L_0x0045:
        r1 = 0;
        r0 = r19;
        r0.mIsCollapsed = r1;
        r1 = android.view.View.MeasureSpec.getMode(r20);
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r1 == r2) goto L_0x0079;
    L_0x0052:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r3 = r19.getClass();
        r3 = r3.getSimpleName();
        r3 = java.lang.String.valueOf(r3);
        r2.<init>(r3);
        r3 = " can only be used ";
        r2 = r2.append(r3);
        r3 = "with android:layout_width=\"match_parent\" (or fill_parent)";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x0079:
        r1 = android.view.View.MeasureSpec.getMode(r21);
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r1 == r2) goto L_0x00a8;
    L_0x0081:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r3 = r19.getClass();
        r3 = r3.getSimpleName();
        r3 = java.lang.String.valueOf(r3);
        r2.<init>(r3);
        r3 = " can only be used ";
        r2 = r2.append(r3);
        r3 = "with android:layout_height=\"wrap_content\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x00a8:
        r14 = android.view.View.MeasureSpec.getSize(r20);
        r0 = r19;
        r1 = r0.mContentHeight;
        if (r1 <= 0) goto L_0x02a8;
    L_0x00b2:
        r0 = r19;
        r1 = r0.mContentHeight;
        r3 = r1;
    L_0x00b7:
        r1 = r19.getPaddingTop();
        r2 = r19.getPaddingBottom();
        r15 = r1 + r2;
        r1 = r19.getPaddingLeft();
        r2 = r19.getPaddingRight();
        r10 = r3 - r15;
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r4);
        r1 = r14 - r1;
        r5 = r1 - r2;
        r4 = r5 / 2;
        r0 = r19;
        r1 = r0.mExpandedActionView;
        if (r1 == 0) goto L_0x02af;
    L_0x00dd:
        r0 = r19;
        r1 = r0.mExpandedHomeLayout;
    L_0x00e1:
        r2 = r1.getVisibility();
        r7 = 8;
        if (r2 == r7) goto L_0x03ac;
    L_0x00e9:
        r2 = r1.getLayoutParams();
        r7 = r2.width;
        if (r7 >= 0) goto L_0x02b5;
    L_0x00f1:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2);
    L_0x00f7:
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r7);
        r1.measure(r2, r7);
        r2 = r1.getMeasuredWidth();
        r1 = r1.getLeftOffset();
        r1 = r1 + r2;
        r2 = 0;
        r5 = r5 - r1;
        r2 = java.lang.Math.max(r2, r5);
        r5 = 0;
        r1 = r2 - r1;
        r1 = java.lang.Math.max(r5, r1);
    L_0x0116:
        r0 = r19;
        r5 = r0.mMenuView;
        if (r5 == 0) goto L_0x0141;
    L_0x011c:
        r0 = r19;
        r5 = r0.mMenuView;
        r5 = r5.getParent();
        r0 = r19;
        if (r5 != r0) goto L_0x0141;
    L_0x0128:
        r0 = r19;
        r5 = r0.mMenuView;
        r7 = 0;
        r0 = r19;
        r2 = r0.measureChildView(r5, r2, r6, r7);
        r5 = 0;
        r0 = r19;
        r7 = r0.mMenuView;
        r7 = r7.getMeasuredWidth();
        r4 = r4 - r7;
        r4 = java.lang.Math.max(r5, r4);
    L_0x0141:
        r0 = r19;
        r5 = r0.mIndeterminateProgressView;
        if (r5 == 0) goto L_0x016c;
    L_0x0147:
        r0 = r19;
        r5 = r0.mIndeterminateProgressView;
        r5 = r5.getVisibility();
        r7 = 8;
        if (r5 == r7) goto L_0x016c;
    L_0x0153:
        r0 = r19;
        r5 = r0.mIndeterminateProgressView;
        r7 = 0;
        r0 = r19;
        r2 = r0.measureChildView(r5, r2, r6, r7);
        r5 = 0;
        r0 = r19;
        r6 = r0.mIndeterminateProgressView;
        r6 = r6.getMeasuredWidth();
        r4 = r4 - r6;
        r4 = java.lang.Math.max(r5, r4);
    L_0x016c:
        r0 = r19;
        r5 = r0.mTitleLayout;
        if (r5 == 0) goto L_0x02bf;
    L_0x0172:
        r0 = r19;
        r5 = r0.mTitleLayout;
        r5 = r5.getVisibility();
        r6 = 8;
        if (r5 == r6) goto L_0x02bf;
    L_0x017e:
        r0 = r19;
        r5 = r0.mDisplayOptions;
        r5 = r5 & 8;
        if (r5 == 0) goto L_0x02bf;
    L_0x0186:
        r5 = 1;
    L_0x0187:
        r0 = r19;
        r6 = r0.mExpandedActionView;
        if (r6 != 0) goto L_0x0194;
    L_0x018d:
        r0 = r19;
        r6 = r0.mNavigationMode;
        switch(r6) {
            case 1: goto L_0x02c2;
            case 2: goto L_0x030c;
            default: goto L_0x0194;
        };
    L_0x0194:
        r6 = r1;
        r7 = r2;
    L_0x0196:
        r1 = 0;
        r0 = r19;
        r2 = r0.mExpandedActionView;
        if (r2 == 0) goto L_0x0356;
    L_0x019d:
        r0 = r19;
        r1 = r0.mExpandedActionView;
        r12 = r1;
    L_0x01a2:
        if (r12 == 0) goto L_0x022a;
    L_0x01a4:
        r1 = r12.getLayoutParams();
        r0 = r19;
        r2 = r0.generateLayoutParams(r1);
        r1 = r2 instanceof com.actionbarsherlock.app.ActionBar.LayoutParams;
        if (r1 == 0) goto L_0x036b;
    L_0x01b2:
        r1 = r2;
        r1 = (com.actionbarsherlock.app.ActionBar.LayoutParams) r1;
        r11 = r1;
    L_0x01b6:
        r8 = 0;
        r1 = 0;
        if (r11 == 0) goto L_0x01c4;
    L_0x01ba:
        r1 = r11.leftMargin;
        r8 = r11.rightMargin;
        r8 = r8 + r1;
        r1 = r11.topMargin;
        r9 = r11.bottomMargin;
        r1 = r1 + r9;
    L_0x01c4:
        r0 = r19;
        r9 = r0.mContentHeight;
        if (r9 > 0) goto L_0x036f;
    L_0x01ca:
        r9 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x01cc:
        r16 = 0;
        r0 = r2.height;
        r17 = r0;
        if (r17 < 0) goto L_0x01de;
    L_0x01d4:
        r0 = r2.height;
        r17 = r0;
        r0 = r17;
        r10 = java.lang.Math.min(r0, r10);
    L_0x01de:
        r1 = r10 - r1;
        r0 = r16;
        r16 = java.lang.Math.max(r0, r1);
        r1 = r2.width;
        r10 = -2;
        if (r1 == r10) goto L_0x037f;
    L_0x01eb:
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x01ed:
        r17 = 0;
        r10 = r2.width;
        if (r10 < 0) goto L_0x0383;
    L_0x01f3:
        r10 = r2.width;
        r10 = java.lang.Math.min(r10, r7);
    L_0x01f9:
        r10 = r10 - r8;
        r0 = r17;
        r10 = java.lang.Math.max(r0, r10);
        if (r11 == 0) goto L_0x0386;
    L_0x0202:
        r11 = r11.gravity;
    L_0x0204:
        r11 = r11 & 7;
        r17 = 1;
        r0 = r17;
        if (r11 != r0) goto L_0x03a6;
    L_0x020c:
        r2 = r2.width;
        r11 = -1;
        if (r2 != r11) goto L_0x03a6;
    L_0x0211:
        r2 = java.lang.Math.min(r6, r4);
        r2 = r2 * 2;
    L_0x0217:
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1);
        r0 = r16;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9);
        r12.measure(r1, r2);
        r1 = r12.getMeasuredWidth();
        r1 = r1 + r8;
        r7 = r7 - r1;
    L_0x022a:
        r0 = r19;
        r1 = r0.mExpandedActionView;
        if (r1 != 0) goto L_0x0254;
    L_0x0230:
        if (r5 == 0) goto L_0x0254;
    L_0x0232:
        r0 = r19;
        r1 = r0.mTitleLayout;
        r0 = r19;
        r2 = r0.mContentHeight;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4);
        r4 = 0;
        r0 = r19;
        r0.measureChildView(r1, r7, r2, r4);
        r1 = 0;
        r0 = r19;
        r2 = r0.mTitleLayout;
        r2 = r2.getMeasuredWidth();
        r2 = r6 - r2;
        java.lang.Math.max(r1, r2);
    L_0x0254:
        r0 = r19;
        r1 = r0.mContentHeight;
        if (r1 > 0) goto L_0x039d;
    L_0x025a:
        r2 = 0;
        r1 = 0;
        r3 = r1;
    L_0x025d:
        if (r3 < r13) goto L_0x038a;
    L_0x025f:
        r0 = r19;
        r0.setMeasuredDimension(r14, r2);
    L_0x0264:
        r0 = r19;
        r1 = r0.mContextView;
        if (r1 == 0) goto L_0x0275;
    L_0x026a:
        r0 = r19;
        r1 = r0.mContextView;
        r2 = r19.getMeasuredHeight();
        r1.setContentHeight(r2);
    L_0x0275:
        r0 = r19;
        r1 = r0.mProgressView;
        if (r1 == 0) goto L_0x0021;
    L_0x027b:
        r0 = r19;
        r1 = r0.mProgressView;
        r1 = r1.getVisibility();
        r2 = 8;
        if (r1 == r2) goto L_0x0021;
    L_0x0287:
        r0 = r19;
        r1 = r0.mProgressView;
        r0 = r19;
        r2 = r0.mProgressBarPadding;
        r2 = r2 * 2;
        r2 = r14 - r2;
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r3);
        r3 = r19.getMeasuredHeight();
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r4);
        r1.measure(r2, r3);
        goto L_0x0021;
    L_0x02a8:
        r1 = android.view.View.MeasureSpec.getSize(r21);
        r3 = r1;
        goto L_0x00b7;
    L_0x02af:
        r0 = r19;
        r1 = r0.mHomeLayout;
        goto L_0x00e1;
    L_0x02b5:
        r2 = r2.width;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r7);
        goto L_0x00f7;
    L_0x02bf:
        r5 = 0;
        goto L_0x0187;
    L_0x02c2:
        r0 = r19;
        r6 = r0.mListNavLayout;
        if (r6 == 0) goto L_0x0194;
    L_0x02c8:
        if (r5 == 0) goto L_0x0307;
    L_0x02ca:
        r0 = r19;
        r6 = r0.mItemPadding;
        r6 = r6 * 2;
    L_0x02d0:
        r7 = 0;
        r2 = r2 - r6;
        r2 = java.lang.Math.max(r7, r2);
        r7 = 0;
        r1 = r1 - r6;
        r1 = java.lang.Math.max(r7, r1);
        r0 = r19;
        r6 = r0.mListNavLayout;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r7);
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8);
        r6.measure(r7, r8);
        r0 = r19;
        r6 = r0.mListNavLayout;
        r6 = r6.getMeasuredWidth();
        r7 = 0;
        r2 = r2 - r6;
        r2 = java.lang.Math.max(r7, r2);
        r7 = 0;
        r1 = r1 - r6;
        r1 = java.lang.Math.max(r7, r1);
        r6 = r1;
        r7 = r2;
        goto L_0x0196;
    L_0x0307:
        r0 = r19;
        r6 = r0.mItemPadding;
        goto L_0x02d0;
    L_0x030c:
        r0 = r19;
        r6 = r0.mTabScrollView;
        if (r6 == 0) goto L_0x0194;
    L_0x0312:
        if (r5 == 0) goto L_0x0351;
    L_0x0314:
        r0 = r19;
        r6 = r0.mItemPadding;
        r6 = r6 * 2;
    L_0x031a:
        r7 = 0;
        r2 = r2 - r6;
        r2 = java.lang.Math.max(r7, r2);
        r7 = 0;
        r1 = r1 - r6;
        r1 = java.lang.Math.max(r7, r1);
        r0 = r19;
        r6 = r0.mTabScrollView;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r7);
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8);
        r6.measure(r7, r8);
        r0 = r19;
        r6 = r0.mTabScrollView;
        r6 = r6.getMeasuredWidth();
        r7 = 0;
        r2 = r2 - r6;
        r2 = java.lang.Math.max(r7, r2);
        r7 = 0;
        r1 = r1 - r6;
        r1 = java.lang.Math.max(r7, r1);
        r6 = r1;
        r7 = r2;
        goto L_0x0196;
    L_0x0351:
        r0 = r19;
        r6 = r0.mItemPadding;
        goto L_0x031a;
    L_0x0356:
        r0 = r19;
        r2 = r0.mDisplayOptions;
        r2 = r2 & 16;
        if (r2 == 0) goto L_0x03a9;
    L_0x035e:
        r0 = r19;
        r2 = r0.mCustomNavView;
        if (r2 == 0) goto L_0x03a9;
    L_0x0364:
        r0 = r19;
        r1 = r0.mCustomNavView;
        r12 = r1;
        goto L_0x01a2;
    L_0x036b:
        r1 = 0;
        r11 = r1;
        goto L_0x01b6;
    L_0x036f:
        r9 = r2.height;
        r16 = -2;
        r0 = r16;
        if (r9 == r0) goto L_0x037b;
    L_0x0377:
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x01cc;
    L_0x037b:
        r9 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        goto L_0x01cc;
    L_0x037f:
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        goto L_0x01ed;
    L_0x0383:
        r10 = r7;
        goto L_0x01f9;
    L_0x0386:
        r11 = 19;
        goto L_0x0204;
    L_0x038a:
        r0 = r19;
        r1 = r0.getChildAt(r3);
        r1 = r1.getMeasuredHeight();
        r1 = r1 + r15;
        if (r1 <= r2) goto L_0x03a4;
    L_0x0397:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r1;
        goto L_0x025d;
    L_0x039d:
        r0 = r19;
        r0.setMeasuredDimension(r14, r3);
        goto L_0x0264;
    L_0x03a4:
        r1 = r2;
        goto L_0x0397;
    L_0x03a6:
        r2 = r10;
        goto L_0x0217;
    L_0x03a9:
        r12 = r1;
        goto L_0x01a2;
    L_0x03ac:
        r1 = r4;
        r2 = r5;
        goto L_0x0116;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.internal.widget.ActionBarView.onMeasure(int, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        /*
        r10 = this;
        r1 = r10.getPaddingLeft();
        r2 = r10.getPaddingTop();
        r0 = r15 - r13;
        r3 = r10.getPaddingTop();
        r0 = r0 - r3;
        r3 = r10.getPaddingBottom();
        r3 = r0 - r3;
        if (r3 > 0) goto L_0x0018;
    L_0x0017:
        return;
    L_0x0018:
        r0 = r10.mExpandedActionView;
        if (r0 == 0) goto L_0x011f;
    L_0x001c:
        r0 = r10.mExpandedHomeLayout;
    L_0x001e:
        r4 = r0.getVisibility();
        r5 = 8;
        if (r4 == r5) goto L_0x01d5;
    L_0x0026:
        r4 = r0.getLeftOffset();
        r5 = r1 + r4;
        r0 = r10.positionChild(r0, r5, r2, r3);
        r0 = r0 + r4;
        r0 = r0 + r1;
    L_0x0032:
        r1 = r10.mExpandedActionView;
        if (r1 != 0) goto L_0x0059;
    L_0x0036:
        r1 = r10.mTitleLayout;
        if (r1 == 0) goto L_0x0123;
    L_0x003a:
        r1 = r10.mTitleLayout;
        r1 = r1.getVisibility();
        r4 = 8;
        if (r1 == r4) goto L_0x0123;
    L_0x0044:
        r1 = r10.mDisplayOptions;
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x0123;
    L_0x004a:
        r1 = 1;
    L_0x004b:
        if (r1 == 0) goto L_0x0054;
    L_0x004d:
        r4 = r10.mTitleLayout;
        r4 = r10.positionChild(r4, r0, r2, r3);
        r0 = r0 + r4;
    L_0x0054:
        r4 = r10.mNavigationMode;
        switch(r4) {
            case 0: goto L_0x0126;
            case 1: goto L_0x0129;
            case 2: goto L_0x013f;
            default: goto L_0x0059;
        };
    L_0x0059:
        r1 = r0;
    L_0x005a:
        r0 = r14 - r12;
        r4 = r10.getPaddingRight();
        r0 = r0 - r4;
        r4 = r10.mMenuView;
        if (r4 == 0) goto L_0x0079;
    L_0x0065:
        r4 = r10.mMenuView;
        r4 = r4.getParent();
        if (r4 != r10) goto L_0x0079;
    L_0x006d:
        r4 = r10.mMenuView;
        r10.positionChildInverse(r4, r0, r2, r3);
        r4 = r10.mMenuView;
        r4 = r4.getMeasuredWidth();
        r0 = r0 - r4;
    L_0x0079:
        r4 = r10.mIndeterminateProgressView;
        if (r4 == 0) goto L_0x01d2;
    L_0x007d:
        r4 = r10.mIndeterminateProgressView;
        r4 = r4.getVisibility();
        r5 = 8;
        if (r4 == r5) goto L_0x01d2;
    L_0x0087:
        r4 = r10.mIndeterminateProgressView;
        r10.positionChildInverse(r4, r0, r2, r3);
        r2 = r10.mIndeterminateProgressView;
        r2 = r2.getMeasuredWidth();
        r0 = r0 - r2;
        r2 = r0;
    L_0x0094:
        r0 = 0;
        r3 = r10.mExpandedActionView;
        if (r3 == 0) goto L_0x0155;
    L_0x0099:
        r0 = r10.mExpandedActionView;
        r7 = r0;
    L_0x009c:
        if (r7 == 0) goto L_0x00fb;
    L_0x009e:
        r0 = r7.getLayoutParams();
        r3 = r0 instanceof com.actionbarsherlock.app.ActionBar.LayoutParams;
        if (r3 == 0) goto L_0x0164;
    L_0x00a6:
        r0 = (com.actionbarsherlock.app.ActionBar.LayoutParams) r0;
        r5 = r0;
    L_0x00a9:
        if (r5 == 0) goto L_0x0168;
    L_0x00ab:
        r0 = r5.gravity;
    L_0x00ad:
        r8 = r7.getMeasuredWidth();
        r4 = 0;
        r3 = 0;
        if (r5 == 0) goto L_0x01c9;
    L_0x00b5:
        r3 = r5.leftMargin;
        r4 = r1 + r3;
        r1 = r5.rightMargin;
        r3 = r2 - r1;
        r2 = r5.topMargin;
        r1 = r5.bottomMargin;
        r5 = r2;
        r6 = r3;
        r3 = r4;
        r4 = r1;
    L_0x00c5:
        r1 = r0 & 7;
        r2 = 1;
        if (r1 != r2) goto L_0x0173;
    L_0x00ca:
        r2 = r10.getRight();
        r9 = r10.getLeft();
        r2 = r2 - r9;
        r2 = r2 - r8;
        r2 = r2 / 2;
        if (r2 >= r3) goto L_0x016c;
    L_0x00d8:
        r1 = 3;
        r2 = r1;
    L_0x00da:
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x017a;
            case 2: goto L_0x00de;
            case 3: goto L_0x0189;
            case 4: goto L_0x00de;
            case 5: goto L_0x018c;
            default: goto L_0x00de;
        };
    L_0x00de:
        r2 = r1;
    L_0x00df:
        r1 = r0 & 112;
        r6 = -1;
        if (r0 != r6) goto L_0x00e7;
    L_0x00e4:
        r0 = 16;
        r1 = r0;
    L_0x00e7:
        r0 = 0;
        switch(r1) {
            case 16: goto L_0x0191;
            case 48: goto L_0x01ae;
            case 80: goto L_0x01b5;
            default: goto L_0x00eb;
        };
    L_0x00eb:
        r1 = r7.getMeasuredWidth();
        r4 = r2 + r1;
        r5 = r7.getMeasuredHeight();
        r5 = r5 + r0;
        r7.layout(r2, r0, r4, r5);
        r0 = r3 + r1;
    L_0x00fb:
        r0 = r10.mProgressView;
        if (r0 == 0) goto L_0x0017;
    L_0x00ff:
        r0 = r10.mProgressView;
        r0.bringToFront();
        r0 = r10.mProgressView;
        r0 = r0.getMeasuredHeight();
        r0 = r0 / 2;
        r1 = r10.mProgressView;
        r2 = r10.mProgressBarPadding;
        r3 = -r0;
        r4 = r10.mProgressBarPadding;
        r5 = r10.mProgressView;
        r5 = r5.getMeasuredWidth();
        r4 = r4 + r5;
        r1.layout(r2, r3, r4, r0);
        goto L_0x0017;
    L_0x011f:
        r0 = r10.mHomeLayout;
        goto L_0x001e;
    L_0x0123:
        r1 = 0;
        goto L_0x004b;
    L_0x0126:
        r1 = r0;
        goto L_0x005a;
    L_0x0129:
        r4 = r10.mListNavLayout;
        if (r4 == 0) goto L_0x0059;
    L_0x012d:
        if (r1 == 0) goto L_0x0132;
    L_0x012f:
        r1 = r10.mItemPadding;
        r0 = r0 + r1;
    L_0x0132:
        r1 = r10.mListNavLayout;
        r1 = r10.positionChild(r1, r0, r2, r3);
        r4 = r10.mItemPadding;
        r1 = r1 + r4;
        r0 = r0 + r1;
        r1 = r0;
        goto L_0x005a;
    L_0x013f:
        r4 = r10.mTabScrollView;
        if (r4 == 0) goto L_0x0059;
    L_0x0143:
        if (r1 == 0) goto L_0x0148;
    L_0x0145:
        r1 = r10.mItemPadding;
        r0 = r0 + r1;
    L_0x0148:
        r1 = r10.mTabScrollView;
        r1 = r10.positionChild(r1, r0, r2, r3);
        r4 = r10.mItemPadding;
        r1 = r1 + r4;
        r0 = r0 + r1;
        r1 = r0;
        goto L_0x005a;
    L_0x0155:
        r3 = r10.mDisplayOptions;
        r3 = r3 & 16;
        if (r3 == 0) goto L_0x01cf;
    L_0x015b:
        r3 = r10.mCustomNavView;
        if (r3 == 0) goto L_0x01cf;
    L_0x015f:
        r0 = r10.mCustomNavView;
        r7 = r0;
        goto L_0x009c;
    L_0x0164:
        r0 = 0;
        r5 = r0;
        goto L_0x00a9;
    L_0x0168:
        r0 = 19;
        goto L_0x00ad;
    L_0x016c:
        r2 = r2 + r8;
        if (r2 <= r6) goto L_0x01c6;
    L_0x016f:
        r1 = 5;
        r2 = r1;
        goto L_0x00da;
    L_0x0173:
        r2 = -1;
        if (r0 != r2) goto L_0x01c6;
    L_0x0176:
        r1 = 3;
        r2 = r1;
        goto L_0x00da;
    L_0x017a:
        r1 = r10.getRight();
        r2 = r10.getLeft();
        r1 = r1 - r2;
        r1 = r1 - r8;
        r1 = r1 / 2;
        r2 = r1;
        goto L_0x00df;
    L_0x0189:
        r2 = r3;
        goto L_0x00df;
    L_0x018c:
        r1 = r6 - r8;
        r2 = r1;
        goto L_0x00df;
    L_0x0191:
        r0 = r10.getPaddingTop();
        r1 = r10.getBottom();
        r4 = r10.getTop();
        r1 = r1 - r4;
        r4 = r10.getPaddingBottom();
        r1 = r1 - r4;
        r0 = r1 - r0;
        r1 = r7.getMeasuredHeight();
        r0 = r0 - r1;
        r0 = r0 / 2;
        goto L_0x00eb;
    L_0x01ae:
        r0 = r10.getPaddingTop();
        r0 = r0 + r5;
        goto L_0x00eb;
    L_0x01b5:
        r0 = r10.getHeight();
        r1 = r10.getPaddingBottom();
        r0 = r0 - r1;
        r1 = r7.getMeasuredHeight();
        r0 = r0 - r1;
        r0 = r0 - r4;
        goto L_0x00eb;
    L_0x01c6:
        r2 = r1;
        goto L_0x00da;
    L_0x01c9:
        r5 = r4;
        r6 = r2;
        r4 = r3;
        r3 = r1;
        goto L_0x00c5;
    L_0x01cf:
        r7 = r0;
        goto L_0x009c;
    L_0x01d2:
        r2 = r0;
        goto L_0x0094;
    L_0x01d5:
        r0 = r1;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.internal.widget.ActionBarView.onLayout(boolean, int, int, int, int):void");
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ActionBar.LayoutParams(getContext(), attributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        return layoutParams;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null)) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.expandedMenuItemId == 0 || this.mExpandedMenuPresenter == null || this.mOptionsMenu == null)) {
            MenuItem findItem = this.mOptionsMenu.findItem(savedState.expandedMenuItemId);
            if (findItem != null) {
                findItem.expandActionView();
            }
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }
}
