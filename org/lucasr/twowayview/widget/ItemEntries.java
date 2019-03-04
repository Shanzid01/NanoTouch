package org.lucasr.twowayview.widget;

import java.util.Arrays;
import org.lucasr.twowayview.widget.BaseLayoutManager.ItemEntry;

class ItemEntries {
    private static final int MIN_SIZE = 10;
    private int mAdapterSize;
    private ItemEntry[] mItemEntries;
    private boolean mRestoringItem;

    ItemEntries() {
    }

    private int sizeForPosition(int i) {
        int length = this.mItemEntries.length;
        while (length <= i) {
            length *= 2;
        }
        if (this.mRestoringItem || length <= this.mAdapterSize) {
            return length;
        }
        return this.mAdapterSize;
    }

    private void ensureSize(int i) {
        if (this.mItemEntries == null) {
            this.mItemEntries = new ItemEntry[(Math.max(i, 10) + 1)];
            Arrays.fill(this.mItemEntries, null);
        } else if (i >= this.mItemEntries.length) {
            Object obj = this.mItemEntries;
            this.mItemEntries = new ItemEntry[sizeForPosition(i)];
            System.arraycopy(obj, 0, this.mItemEntries, 0, obj.length);
            Arrays.fill(this.mItemEntries, obj.length, this.mItemEntries.length, null);
        }
    }

    public ItemEntry getItemEntry(int i) {
        if (this.mItemEntries == null || i >= this.mItemEntries.length) {
            return null;
        }
        return this.mItemEntries[i];
    }

    public void putItemEntry(int i, ItemEntry itemEntry) {
        ensureSize(i);
        this.mItemEntries[i] = itemEntry;
    }

    public void restoreItemEntry(int i, ItemEntry itemEntry) {
        this.mRestoringItem = true;
        putItemEntry(i, itemEntry);
        this.mRestoringItem = false;
    }

    public int size() {
        return this.mItemEntries != null ? this.mItemEntries.length : 0;
    }

    public void setAdapterSize(int i) {
        this.mAdapterSize = i;
    }

    public void invalidateItemLanesAfter(int i) {
        if (this.mItemEntries != null && i < this.mItemEntries.length) {
            while (i < this.mItemEntries.length) {
                ItemEntry itemEntry = this.mItemEntries[i];
                if (itemEntry != null) {
                    itemEntry.invalidateLane();
                }
                i++;
            }
        }
    }

    public void clear() {
        if (this.mItemEntries != null) {
            Arrays.fill(this.mItemEntries, null);
        }
    }

    void offsetForRemoval(int i, int i2) {
        if (this.mItemEntries != null && i < this.mItemEntries.length) {
            ensureSize(i + i2);
            System.arraycopy(this.mItemEntries, i + i2, this.mItemEntries, i, (this.mItemEntries.length - i) - i2);
            Arrays.fill(this.mItemEntries, this.mItemEntries.length - i2, this.mItemEntries.length, null);
        }
    }

    void offsetForAddition(int i, int i2) {
        if (this.mItemEntries != null && i < this.mItemEntries.length) {
            ensureSize(i + i2);
            System.arraycopy(this.mItemEntries, i, this.mItemEntries, i + i2, (this.mItemEntries.length - i) - i2);
            Arrays.fill(this.mItemEntries, i, i + i2, null);
        }
    }
}
