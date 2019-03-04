package p006b.p007a.p008a.p009a.p010a.p015d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GZIPQueueFileEventStorage */
public class C0271m extends C0270n {
    public C0271m(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    public OutputStream mo492a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
