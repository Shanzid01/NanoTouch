package org.lucasr.twowayview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p004b.C0065f;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ak;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Checkable;

public class ItemSelectionSupport {
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int INVALID_POSITION = -1;
    private static final String STATE_KEY_CHECKED_COUNT = "checkedCount";
    private static final String STATE_KEY_CHECKED_ID_STATES = "checkedIdStates";
    private static final String STATE_KEY_CHECKED_STATES = "checkedStates";
    private static final String STATE_KEY_CHOICE_MODE = "choiceMode";
    private int mCheckedCount;
    private CheckedIdStates mCheckedIdStates;
    private CheckedStates mCheckedStates;
    private ChoiceMode mChoiceMode = ChoiceMode.NONE;
    private final RecyclerView mRecyclerView;
    private final TouchListener mTouchListener;

    class CheckedIdStates extends C0065f<Integer> implements Parcelable {
        public static final Creator<CheckedIdStates> CREATOR = new C19931();

        class C19931 implements Creator<CheckedIdStates> {
            C19931() {
            }

            public CheckedIdStates createFromParcel(Parcel parcel) {
                return new CheckedIdStates(parcel);
            }

            public CheckedIdStates[] newArray(int i) {
                return new CheckedIdStates[i];
            }
        }

        private CheckedIdStates(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int size = size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeLong(keyAt(i2));
                parcel.writeInt(((Integer) valueAt(i2)).intValue());
            }
        }
    }

    class CheckedStates extends SparseBooleanArray implements Parcelable {
        public static final Creator<CheckedStates> CREATOR = new C19941();
        private static final int FALSE = 0;
        private static final int TRUE = 1;

        class C19941 implements Creator<CheckedStates> {
            C19941() {
            }

            public CheckedStates createFromParcel(Parcel parcel) {
                return new CheckedStates(parcel);
            }

            public CheckedStates[] newArray(int i) {
                return new CheckedStates[i];
            }
        }

        private CheckedStates(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    boolean z;
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    put(readInt2, z);
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int size = size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                int i3;
                parcel.writeInt(keyAt(i2));
                if (valueAt(i2)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                parcel.writeInt(i3);
            }
        }
    }

    public enum ChoiceMode {
        NONE,
        SINGLE,
        MULTIPLE
    }

    class TouchListener extends ClickItemTouchListener {
        TouchListener(RecyclerView recyclerView) {
            super(recyclerView);
        }

        boolean performItemClick(RecyclerView recyclerView, View view, int i, long j) {
            boolean z = true;
            ak adapter = ItemSelectionSupport.this.mRecyclerView.getAdapter();
            if (ItemSelectionSupport.this.mChoiceMode == ChoiceMode.MULTIPLE) {
                boolean z2 = !ItemSelectionSupport.this.mCheckedStates.get(i, false);
                ItemSelectionSupport.this.mCheckedStates.put(i, z2);
                if (ItemSelectionSupport.this.mCheckedIdStates != null && adapter.m1536b()) {
                    if (z2) {
                        ItemSelectionSupport.this.mCheckedIdStates.put(adapter.m1530b(i), Integer.valueOf(i));
                    } else {
                        ItemSelectionSupport.this.mCheckedIdStates.delete(adapter.m1530b(i));
                    }
                }
                ItemSelectionSupport itemSelectionSupport;
                if (z2) {
                    itemSelectionSupport = ItemSelectionSupport.this;
                    itemSelectionSupport.mCheckedCount = itemSelectionSupport.mCheckedCount + 1;
                } else {
                    itemSelectionSupport = ItemSelectionSupport.this;
                    itemSelectionSupport.mCheckedCount = itemSelectionSupport.mCheckedCount - 1;
                }
            } else if (ItemSelectionSupport.this.mChoiceMode == ChoiceMode.SINGLE) {
                if (!ItemSelectionSupport.this.mCheckedStates.get(i, false)) {
                    ItemSelectionSupport.this.mCheckedStates.clear();
                    ItemSelectionSupport.this.mCheckedStates.put(i, true);
                    if (ItemSelectionSupport.this.mCheckedIdStates != null && adapter.m1536b()) {
                        ItemSelectionSupport.this.mCheckedIdStates.clear();
                        ItemSelectionSupport.this.mCheckedIdStates.put(adapter.m1530b(i), Integer.valueOf(i));
                    }
                    ItemSelectionSupport.this.mCheckedCount = 1;
                } else if (ItemSelectionSupport.this.mCheckedStates.size() == 0 || !ItemSelectionSupport.this.mCheckedStates.valueAt(0)) {
                    ItemSelectionSupport.this.mCheckedCount = 0;
                }
            } else {
                z = false;
            }
            if (z) {
                ItemSelectionSupport.this.updateOnScreenCheckedViews();
            }
            return false;
        }

        boolean performItemLongClick(RecyclerView recyclerView, View view, int i, long j) {
            return true;
        }
    }

    private ItemSelectionSupport(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        this.mTouchListener = new TouchListener(recyclerView);
        recyclerView.addOnItemTouchListener(this.mTouchListener);
    }

    private void updateOnScreenCheckedViews() {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            setViewChecked(childAt, this.mCheckedStates.get(this.mRecyclerView.getChildPosition(childAt)));
        }
    }

    public int getCheckedItemCount() {
        return this.mCheckedCount;
    }

    public boolean isItemChecked(int i) {
        if (this.mChoiceMode == ChoiceMode.NONE || this.mCheckedStates == null) {
            return false;
        }
        return this.mCheckedStates.get(i);
    }

    public int getCheckedItemPosition() {
        if (this.mChoiceMode == ChoiceMode.SINGLE && this.mCheckedStates != null && this.mCheckedStates.size() == 1) {
            return this.mCheckedStates.keyAt(0);
        }
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.mChoiceMode != ChoiceMode.NONE) {
            return this.mCheckedStates;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        int i = 0;
        if (this.mChoiceMode == ChoiceMode.NONE || this.mCheckedIdStates == null || this.mRecyclerView.getAdapter() == null) {
            return new long[0];
        }
        int size = this.mCheckedIdStates.size();
        long[] jArr = new long[size];
        while (i < size) {
            jArr[i] = this.mCheckedIdStates.keyAt(i);
            i++;
        }
        return jArr;
    }

    public void setItemChecked(int i, boolean z) {
        if (this.mChoiceMode != ChoiceMode.NONE) {
            ak adapter = this.mRecyclerView.getAdapter();
            boolean z2;
            if (this.mChoiceMode == ChoiceMode.MULTIPLE) {
                z2 = this.mCheckedStates.get(i);
                this.mCheckedStates.put(i, z);
                if (this.mCheckedIdStates != null && adapter.m1536b()) {
                    if (z) {
                        this.mCheckedIdStates.put(adapter.m1530b(i), Integer.valueOf(i));
                    } else {
                        this.mCheckedIdStates.delete(adapter.m1530b(i));
                    }
                }
                if (z2 != z) {
                    if (z) {
                        this.mCheckedCount++;
                    } else {
                        this.mCheckedCount--;
                    }
                }
            } else {
                z2 = this.mCheckedIdStates != null && adapter.m1536b();
                if (z || isItemChecked(i)) {
                    this.mCheckedStates.clear();
                    if (z2) {
                        this.mCheckedIdStates.clear();
                    }
                }
                if (z) {
                    this.mCheckedStates.put(i, true);
                    if (z2) {
                        this.mCheckedIdStates.put(adapter.m1530b(i), Integer.valueOf(i));
                    }
                    this.mCheckedCount = 1;
                } else if (this.mCheckedStates.size() == 0 || !this.mCheckedStates.valueAt(0)) {
                    this.mCheckedCount = 0;
                }
            }
            updateOnScreenCheckedViews();
        }
    }

    @TargetApi(11)
    public void setViewChecked(View view, boolean z) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z);
        } else if (VERSION.SDK_INT >= 11) {
            view.setActivated(z);
        }
    }

    public void clearChoices() {
        if (this.mCheckedStates != null) {
            this.mCheckedStates.clear();
        }
        if (this.mCheckedIdStates != null) {
            this.mCheckedIdStates.clear();
        }
        this.mCheckedCount = 0;
        updateOnScreenCheckedViews();
    }

    public ChoiceMode getChoiceMode() {
        return this.mChoiceMode;
    }

    public void setChoiceMode(ChoiceMode choiceMode) {
        if (this.mChoiceMode != choiceMode) {
            this.mChoiceMode = choiceMode;
            if (this.mChoiceMode != ChoiceMode.NONE) {
                if (this.mCheckedStates == null) {
                    this.mCheckedStates = new CheckedStates();
                }
                ak adapter = this.mRecyclerView.getAdapter();
                if (this.mCheckedIdStates == null && adapter != null && adapter.m1536b()) {
                    this.mCheckedIdStates = new CheckedIdStates();
                }
            }
        }
    }

    public void onAdapterDataChanged() {
        ak adapter = this.mRecyclerView.getAdapter();
        if (this.mChoiceMode != ChoiceMode.NONE && adapter != null && adapter.m1536b()) {
            int a = adapter.mo4327a();
            this.mCheckedStates.clear();
            int i = 0;
            while (i < this.mCheckedIdStates.size()) {
                long keyAt = this.mCheckedIdStates.keyAt(i);
                int intValue = ((Integer) this.mCheckedIdStates.valueAt(i)).intValue();
                if (keyAt != adapter.m1530b(intValue)) {
                    boolean z;
                    intValue = Math.min(intValue + 20, a);
                    for (int max = Math.max(0, intValue - 20); max < intValue; max++) {
                        if (keyAt == adapter.m1530b(max)) {
                            this.mCheckedStates.put(max, true);
                            this.mCheckedIdStates.setValueAt(i, Integer.valueOf(max));
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.mCheckedIdStates.delete(keyAt);
                        this.mCheckedCount--;
                        i--;
                    }
                } else {
                    this.mCheckedStates.put(intValue, true);
                }
                i++;
            }
        }
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt(STATE_KEY_CHOICE_MODE, this.mChoiceMode.ordinal());
        bundle.putParcelable(STATE_KEY_CHECKED_STATES, this.mCheckedStates);
        bundle.putParcelable(STATE_KEY_CHECKED_ID_STATES, this.mCheckedIdStates);
        bundle.putInt(STATE_KEY_CHECKED_COUNT, this.mCheckedCount);
        return bundle;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.mChoiceMode = ChoiceMode.values()[bundle.getInt(STATE_KEY_CHOICE_MODE)];
        this.mCheckedStates = (CheckedStates) bundle.getParcelable(STATE_KEY_CHECKED_STATES);
        this.mCheckedIdStates = (CheckedIdStates) bundle.getParcelable(STATE_KEY_CHECKED_ID_STATES);
        this.mCheckedCount = bundle.getInt(STATE_KEY_CHECKED_COUNT);
    }

    public static ItemSelectionSupport addTo(RecyclerView recyclerView) {
        ItemSelectionSupport from = from(recyclerView);
        if (from != null) {
            return from;
        }
        from = new ItemSelectionSupport(recyclerView);
        recyclerView.setTag(C1995R.id.twowayview_item_selection_support, from);
        return from;
    }

    public static void removeFrom(RecyclerView recyclerView) {
        ItemSelectionSupport from = from(recyclerView);
        if (from != null) {
            from.clearChoices();
            recyclerView.removeOnItemTouchListener(from.mTouchListener);
            recyclerView.setTag(C1995R.id.twowayview_item_selection_support, null);
        }
    }

    public static ItemSelectionSupport from(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return null;
        }
        return (ItemSelectionSupport) recyclerView.getTag(C1995R.id.twowayview_item_selection_support);
    }
}
