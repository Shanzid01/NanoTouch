package p006b.p007a.p008a.p009a.p010a.p012b;

import java.io.File;
import java.util.Comparator;

/* compiled from: CommonUtils */
final class C0215n implements Comparator<File> {
    C0215n() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m1938a((File) obj, (File) obj2);
    }

    public int m1938a(File file, File file2) {
        return (int) (file.lastModified() - file2.lastModified());
    }
}
