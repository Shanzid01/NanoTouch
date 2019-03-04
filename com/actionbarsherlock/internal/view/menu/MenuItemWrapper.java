package com.actionbarsherlock.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.actionbarsherlock.internal.view.ActionProviderWrapper;
import com.actionbarsherlock.internal.widget.CollapsibleActionViewWrapper;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.CollapsibleActionView;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnActionExpandListener;
import com.actionbarsherlock.view.SubMenu;

public class MenuItemWrapper implements OnMenuItemClickListener, MenuItem {
    private OnActionExpandListener mActionExpandListener = null;
    private MenuItem.OnMenuItemClickListener mMenuItemClickListener = null;
    private android.view.MenuItem.OnActionExpandListener mNativeActionExpandListener = null;
    private final android.view.MenuItem mNativeItem;
    private SubMenu mSubMenu = null;

    class C04251 implements android.view.MenuItem.OnActionExpandListener {
        C04251() {
        }

        public boolean onMenuItemActionExpand(android.view.MenuItem menuItem) {
            if (MenuItemWrapper.this.mActionExpandListener != null) {
                return MenuItemWrapper.this.mActionExpandListener.onMenuItemActionExpand(MenuItemWrapper.this);
            }
            return false;
        }

        public boolean onMenuItemActionCollapse(android.view.MenuItem menuItem) {
            if (MenuItemWrapper.this.mActionExpandListener != null) {
                return MenuItemWrapper.this.mActionExpandListener.onMenuItemActionCollapse(MenuItemWrapper.this);
            }
            return false;
        }
    }

    public MenuItemWrapper(android.view.MenuItem menuItem) {
        if (menuItem == null) {
            throw new IllegalStateException("Wrapped menu item cannot be null.");
        }
        this.mNativeItem = menuItem;
    }

    public int getItemId() {
        return this.mNativeItem.getItemId();
    }

    public int getGroupId() {
        return this.mNativeItem.getGroupId();
    }

    public int getOrder() {
        return this.mNativeItem.getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mNativeItem.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.mNativeItem.setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return this.mNativeItem.getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mNativeItem.setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return this.mNativeItem.getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        this.mNativeItem.setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.mNativeItem.setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return this.mNativeItem.getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        this.mNativeItem.setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return this.mNativeItem.getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        this.mNativeItem.setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.mNativeItem.setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return this.mNativeItem.getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.mNativeItem.setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.mNativeItem.getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        this.mNativeItem.setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return this.mNativeItem.isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        this.mNativeItem.setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return this.mNativeItem.isChecked();
    }

    public MenuItem setVisible(boolean z) {
        this.mNativeItem.setVisible(z);
        return this;
    }

    public boolean isVisible() {
        return this.mNativeItem.isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        this.mNativeItem.setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return this.mNativeItem.isEnabled();
    }

    public boolean hasSubMenu() {
        return this.mNativeItem.hasSubMenu();
    }

    public SubMenu getSubMenu() {
        if (hasSubMenu() && this.mSubMenu == null) {
            this.mSubMenu = new SubMenuWrapper(this.mNativeItem.getSubMenu());
        }
        return this.mSubMenu;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
        this.mNativeItem.setOnMenuItemClickListener(this);
        return this;
    }

    public boolean onMenuItemClick(android.view.MenuItem menuItem) {
        if (this.mMenuItemClickListener != null) {
            return this.mMenuItemClickListener.onMenuItemClick(this);
        }
        return false;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.mNativeItem.getMenuInfo();
    }

    public void setShowAsAction(int i) {
        this.mNativeItem.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.mNativeItem.setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view != null && (view instanceof CollapsibleActionView)) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.mNativeItem.setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        this.mNativeItem.setActionView(i);
        if (i != 0) {
            View actionView = this.mNativeItem.getActionView();
            if (actionView instanceof CollapsibleActionView) {
                this.mNativeItem.setActionView(new CollapsibleActionViewWrapper(actionView));
            }
        }
        return this;
    }

    public View getActionView() {
        View actionView = this.mNativeItem.getActionView();
        if (actionView instanceof CollapsibleActionViewWrapper) {
            return ((CollapsibleActionViewWrapper) actionView).unwrap();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        this.mNativeItem.setActionProvider(new ActionProviderWrapper(actionProvider));
        return this;
    }

    public ActionProvider getActionProvider() {
        android.view.ActionProvider actionProvider = this.mNativeItem.getActionProvider();
        if (actionProvider == null || !(actionProvider instanceof ActionProviderWrapper)) {
            return null;
        }
        return ((ActionProviderWrapper) actionProvider).unwrap();
    }

    public boolean expandActionView() {
        return this.mNativeItem.expandActionView();
    }

    public boolean collapseActionView() {
        return this.mNativeItem.collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return this.mNativeItem.isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.mActionExpandListener = onActionExpandListener;
        if (this.mNativeActionExpandListener == null) {
            this.mNativeActionExpandListener = new C04251();
            this.mNativeItem.setOnActionExpandListener(this.mNativeActionExpandListener);
        }
        return this;
    }
}
