package com.slideme.sam.manager.view.preference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.DialogPreference;
import android.preference.Preference.BaseSavedState;
import android.util.AttributeSet;
import com.slideme.sam.manager.C1608b;
import com.slideme.sam.manager.model.p061a.C1817e;
import com.slideme.sam.manager.util.p063a.C1908b;
import java.util.HashSet;
import java.util.Set;

public class MultiselectListPreference extends DialogPreference {
    private CharSequence[] f3628a;
    private CharSequence[] f3629b;
    private Set<String> f3630c = new HashSet();
    private Set<String> f3631d = new HashSet();
    private boolean f3632e;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C1960b();
        Set<String> f3627a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3627a = new HashSet();
            for (Object add : m5879a(parcel)) {
                this.f3627a.add(add);
            }
        }

        private String[] m5879a(Parcel parcel) {
            String[] strArr = null;
            int readInt = parcel.readInt();
            if (readInt >= 0) {
                strArr = new String[readInt];
                for (int i = 0; i < readInt; i++) {
                    strArr[i] = parcel.readString();
                }
            }
            return strArr;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeStringArray((String[]) this.f3627a.toArray(new String[0]));
        }
    }

    public MultiselectListPreference(Context context) {
        super(context, null);
    }

    public MultiselectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1608b.MultiSelectListPreference, 0, 0);
        this.f3628a = obtainStyledAttributes.getTextArray(0);
        this.f3629b = obtainStyledAttributes.getTextArray(1);
        obtainStyledAttributes.recycle();
    }

    public void m5887a(Set<String> set) {
        this.f3630c.clear();
        this.f3630c.addAll(set);
        m5888b((Set) set);
    }

    public Set<String> m5886a() {
        return this.f3630c;
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);
        if (this.f3628a == null || this.f3629b == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        builder.setMultiChoiceItems(this.f3628a, m5884b(), new C1959a(this));
        this.f3631d.clear();
        this.f3631d.addAll(this.f3630c);
    }

    private boolean[] m5884b() {
        CharSequence[] charSequenceArr = this.f3629b;
        int length = charSequenceArr.length;
        Set set = this.f3630c;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = set.contains(charSequenceArr[i].toString());
        }
        return zArr;
    }

    protected void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        if (z && this.f3632e) {
            Set set = this.f3631d;
            if (callChangeListener(set)) {
                m5887a(set);
            }
        }
        this.f3632e = false;
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        Set hashSet = new HashSet();
        for (CharSequence charSequence : typedArray.getTextArray(i)) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        if (VERSION.SDK_INT <= 10) {
            z = true;
        }
        m5887a(z ? m5889c(this.f3630c) : (Set) obj);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.f3627a = m5886a();
        return savedState;
    }

    protected boolean m5888b(Set<String> set) {
        if (!shouldPersist()) {
            return false;
        }
        if (set.equals(m5889c(null))) {
            return true;
        }
        Editor editor = getEditor();
        if (VERSION.SDK_INT >= 11) {
            C1908b.m5748a(editor, getKey(), (Set) set);
        } else {
            C1817e.m5440a(editor, getKey(), (Set) set);
        }
        m5880a(editor);
        return true;
    }

    private void m5880a(Editor editor) {
        try {
            editor.commit();
        } catch (AbstractMethodError e) {
            editor.commit();
        }
    }

    protected Set<String> m5889c(Set<String> set) {
        if (!shouldPersist()) {
            return set;
        }
        if (VERSION.SDK_INT >= 11) {
            return C1908b.m5747a(getPreferenceManager().getSharedPreferences(), getKey(), (Set) set);
        }
        return C1817e.m5439a(getPreferenceManager().getSharedPreferences(), getKey(), (Set) set);
    }
}
