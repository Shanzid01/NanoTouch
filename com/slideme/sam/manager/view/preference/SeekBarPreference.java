package com.slideme.sam.manager.view.preference;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.slideme.sam.manager.R;

public class SeekBarPreference extends DialogPreference {
    protected int f3613a = 1;
    protected int f3614b = 100;
    private int f3615c = this.f3613a;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo4332a();
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo4332a();
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekbar);
        TextView textView = (TextView) view.findViewById(R.id.label);
        int persistedInt = getPersistedInt(this.f3613a);
        seekBar.setProgress((persistedInt / this.f3613a) - 1);
        textView.setText(getPersistedInt(this.f3613a));
        this.f3615c = persistedInt;
    }

    protected View onCreateDialogView() {
        View onCreateDialogView = super.onCreateDialogView();
        SeekBar seekBar = (SeekBar) onCreateDialogView.findViewById(R.id.seekbar);
        TextView textView = (TextView) onCreateDialogView.findViewById(R.id.label);
        seekBar.setMax(this.f3614b);
        seekBar.setOnSeekBarChangeListener(new C1965g(this, textView));
        return onCreateDialogView;
    }

    protected void onDialogClosed(boolean z) {
        if (z) {
            persistInt(this.f3615c);
            setSummary(this.f3615c);
        }
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            setSummary(getPersistedInt(this.f3613a));
        }
    }

    protected void mo4332a() {
        setDialogLayoutResource(R.layout.widget_preference_seekbar);
    }
}
