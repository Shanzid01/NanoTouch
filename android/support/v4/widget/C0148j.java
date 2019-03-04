package android.support.v4.widget;

import android.database.Cursor;

/* compiled from: CursorFilter */
interface C0148j {
    void changeCursor(Cursor cursor);

    CharSequence convertToString(Cursor cursor);

    Cursor getCursor();

    Cursor runQueryOnBackgroundThread(CharSequence charSequence);
}
