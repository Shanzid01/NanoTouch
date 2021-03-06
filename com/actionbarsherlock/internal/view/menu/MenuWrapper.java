package com.actionbarsherlock.internal.view.menu;

import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.SubMenu;
import java.util.WeakHashMap;

public class MenuWrapper implements Menu {
    private final WeakHashMap<MenuItem, com.actionbarsherlock.view.MenuItem> mNativeMap = new WeakHashMap();
    private final android.view.Menu mNativeMenu;

    public MenuWrapper(android.view.Menu menu) {
        this.mNativeMenu = menu;
    }

    public android.view.Menu unwrap() {
        return this.mNativeMenu;
    }

    private com.actionbarsherlock.view.MenuItem addInternal(MenuItem menuItem) {
        com.actionbarsherlock.view.MenuItem menuItemWrapper = new MenuItemWrapper(menuItem);
        this.mNativeMap.put(menuItem, menuItemWrapper);
        return menuItemWrapper;
    }

    public com.actionbarsherlock.view.MenuItem add(CharSequence charSequence) {
        return addInternal(this.mNativeMenu.add(charSequence));
    }

    public com.actionbarsherlock.view.MenuItem add(int i) {
        return addInternal(this.mNativeMenu.add(i));
    }

    public com.actionbarsherlock.view.MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(this.mNativeMenu.add(i, i2, i3, charSequence));
    }

    public com.actionbarsherlock.view.MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(this.mNativeMenu.add(i, i2, i3, i4));
    }

    private SubMenu addInternal(android.view.SubMenu subMenu) {
        SubMenu subMenuWrapper = new SubMenuWrapper(subMenu);
        this.mNativeMap.put(subMenu.getItem(), subMenuWrapper.getItem());
        return subMenuWrapper;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addInternal(this.mNativeMenu.addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return addInternal(this.mNativeMenu.addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(this.mNativeMenu.addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addInternal(this.mNativeMenu.addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, com.actionbarsherlock.view.MenuItem[] menuItemArr) {
        if (menuItemArr == null) {
            return this.mNativeMenu.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, null);
        }
        MenuItem[] menuItemArr2 = new MenuItem[menuItemArr.length];
        int addIntentOptions = this.mNativeMenu.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        int length = menuItemArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            menuItemArr[i5] = new MenuItemWrapper(menuItemArr2[i5]);
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        this.mNativeMenu.removeItem(i);
    }

    public void removeGroup(int i) {
        this.mNativeMenu.removeGroup(i);
    }

    public void clear() {
        this.mNativeMap.clear();
        this.mNativeMenu.clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.mNativeMenu.setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        this.mNativeMenu.setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        this.mNativeMenu.setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return this.mNativeMenu.hasVisibleItems();
    }

    public com.actionbarsherlock.view.MenuItem findItem(int i) {
        return findItem(this.mNativeMenu.findItem(i));
    }

    public com.actionbarsherlock.view.MenuItem findItem(MenuItem menuItem) {
        if (menuItem == null) {
            return null;
        }
        com.actionbarsherlock.view.MenuItem menuItem2 = (com.actionbarsherlock.view.MenuItem) this.mNativeMap.get(menuItem);
        return menuItem2 == null ? addInternal(menuItem) : menuItem2;
    }

    public int size() {
        return this.mNativeMenu.size();
    }

    public com.actionbarsherlock.view.MenuItem getItem(int i) {
        return findItem(this.mNativeMenu.getItem(i));
    }

    public void close() {
        this.mNativeMenu.close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.mNativeMenu.performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.mNativeMenu.isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return this.mNativeMenu.performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        this.mNativeMenu.setQwertyMode(z);
    }
}
