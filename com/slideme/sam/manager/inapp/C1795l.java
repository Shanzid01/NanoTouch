package com.slideme.sam.manager.inapp;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: MissingSAMDialog */
public class C1795l {
    static HashMap<String, String> f3224a = C1795l.m5374a();
    static HashMap<String, String> f3225b = C1795l.m5375b();
    static HashMap<String, String> f3226c = C1795l.m5376c();
    static String f3227d;

    public static Dialog m5373a(Activity activity, boolean z) {
        String language = Locale.getDefault().getLanguage();
        String str;
        if (z) {
            if (f3224a.containsKey(language)) {
                str = (String) f3224a.get(Locale.getDefault().getLanguage());
            } else {
                str = (String) f3224a.get("en");
            }
            f3227d = str;
        } else {
            Object obj;
            if (f3226c.containsKey(language)) {
                obj = (String) f3226c.get(Locale.getDefault().getLanguage());
            } else {
                String str2 = (String) f3226c.get("en");
            }
            if (f3225b.containsKey(language)) {
                str = (String) f3225b.get(Locale.getDefault().getLanguage());
            } else {
                str = (String) f3225b.get("en");
            }
            f3227d = new StringBuilder(String.valueOf(obj)).append("\n\n").append(str).toString();
        }
        Dialog create = new Builder(activity).setMessage(f3227d).setPositiveButton(17039370, new C1796m(z, activity)).setNegativeButton(17039360, null).create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    private static HashMap<String, String> m5374a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("en", "SlideME update is required!");
        hashMap.put("zh-rCN", "要求SlideME更新。");
        hashMap.put("zh-rTW", "需要SlideME更新。");
        hashMap.put("sk", "Aktualizácia pre SlideME je potrebná.");
        hashMap.put("el", "Απαιτείται ενημέρωση του SlideME.");
        hashMap.put("fi", "SlideME-päivitys on tarpeen.");
        hashMap.put("da", "SlideME opdatering kræves.");
        hashMap.put("ro", "Este necesară actualizarea SlideME.");
        hashMap.put("pl", "Aktualizacja SlideME jest wymagana.");
        hashMap.put("no", "SlideME oppdatering er nødvendig.");
        hashMap.put("ru", "Требуется обновление SlideME.");
        hashMap.put("pt", "A atualização do SlideME é necessária.");
        hashMap.put("cs", "Aktualizace SlideME je k dispozici.");
        hashMap.put("ar", "يتطلب تحديث SlideME");
        hashMap.put("es", "Hay una actualización de SlideME disponible.");
        hashMap.put("de", "SlideME-Aktualisierung erforderlich.");
        hashMap.put("fr", "Une mise à jour de SlideME est disponible.");
        hashMap.put("ko", "SlideME 업데이트가 필요합니다.");
        hashMap.put("id", "Diperlukan pembaruan SlideME.");
        hashMap.put("hu", "A SlideME frissítése szükséges.");
        hashMap.put("hi", "SlideME अपडेट की जरूरत है.");
        hashMap.put("iw", "נדרש עדכון עבור SlideME.");
        hashMap.put("hr", "SlideME je potrebno ažurirati.");
        hashMap.put("ja", "SlideMEの更新が必要です。");
        hashMap.put("it", "È richiesto l'aggiornamento di SlideME.");
        hashMap.put("vi", "Cập nhật SlideME được yêu cầu.");
        hashMap.put("uk", "Потрібне оновлення SlideME.");
        hashMap.put("tr", "SlideME güncellemesi gerekiyor.");
        hashMap.put("th", "จำเป็นต้องอัปเดต SlideME");
        hashMap.put("sv", "SlideME-uppdatering krävs.");
        hashMap.put("nl", "SlideME update is vereist.");
        return hashMap;
    }

    private static HashMap<String, String> m5375b() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("en", "This action requires the SlideME application");
        hashMap.put("es", "Necesitas la aplicación SlideME para ejecutar esta acción");
        hashMap.put("de", "Für diese Aktion ist die SlideME-App erforderlich");
        hashMap.put("fr", "Pour cela l'application SlideME est nécessaire");
        hashMap.put("ar", "يتطلب هذا الإجراء تطبيق SlideME");
        hashMap.put("cs", "Tato akce vyžaduje aplikaci SlideMe");
        hashMap.put("sk", "Táto akcia si vyžaduje aplikáciu SlideME");
        hashMap.put("da", "Denne handling kræver SlideME applikationen");
        hashMap.put("el", "Αυτή η ενέργεια απαιτεί την εφαρμογή SlideME");
        hashMap.put("fi", "Toiminta vaatii SlideME-sovelluksen");
        hashMap.put("iw", "פעולה זו מחייבת את היישום SlideME");
        hashMap.put("hi", "इस कार्य के लिए SlideME एप्लिकेशन की आवश्यकता है");
        hashMap.put("hr", "Za ovaj korak potrebna je aplikacija SlideME");
        hashMap.put("hu", "Ehhez a mûvelethez a SlideME alkalmazásra van szükség");
        hashMap.put("id", "Tindakan ini memerlukan aplikasi SlideME");
        hashMap.put("it", "Questa azione richiede l'applicazione SlideME");
        hashMap.put("ja", "このアクションにはSlideMEアプリケーションが必要です。");
        hashMap.put("ko", "이 작업을 하려면 SlideME 앱이 필요합니다");
        hashMap.put("nl", "Deze actie vereist de SlideME applicatie");
        hashMap.put("no", "Denne handlingen krever SlideMe-applikasjonen");
        hashMap.put("pl", "Niniejsza czynność wymaga aplikacji SlideME");
        hashMap.put("pt", "Esta ação requer o aplicativo SlideME");
        hashMap.put("ro", "Această acţiune trebuie efectuată cu aplicaţia SlideME");
        hashMap.put("ru", "Для выполнения этого действия требуется приложение SlideME");
        hashMap.put("sv", "Denna åtgärd kräver SlideME-applikationen");
        hashMap.put("th", "ต้องการแอปพลิเคชัน SlideME เพื่อดำเนินการต่อ");
        hashMap.put("tr", "Bu eylem için SlideME uygulaması gerekir");
        hashMap.put("uk", "Для виконання цієї дії потрібна програма SlideME");
        hashMap.put("vi", "Thao tác này cần có ứng dụng SlideME");
        hashMap.put("zh-rCN", "该操作需要SlideME应用。");
        hashMap.put("zh-rTW", "該操作需要SlideME應用。");
        return hashMap;
    }

    private static HashMap<String, String> m5376c() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("en", "Continue to download");
        hashMap.put("es", "Continuar con la descarga");
        hashMap.put("de", "Zum Herunterladen fortfahren");
        hashMap.put("fr", "Pour télécharger continuer");
        hashMap.put("ar", "تابع للتنزيل");
        hashMap.put("cs", "Pokračovat ke stažení");
        hashMap.put("sk", "Pokračujte a prevezmite aplikáciu");
        hashMap.put("da", "Fortsæt med download");
        hashMap.put("el", "Συνεχίστε για λήψη");
        hashMap.put("fi", "Jatka ladataksesi");
        hashMap.put("iw", "המשך כדי להוריד");
        hashMap.put("hi", "डाउनलोड करने के लिए जारी रखें");
        hashMap.put("hr", "Nastavite za preuzimanje");
        hashMap.put("hu", "Lépjen tovább a letöltéshez");
        hashMap.put("id", "Lanjutkan untuk mengunduh");
        hashMap.put("it", "Per scaricarla, continua");
        hashMap.put("ja", "ダウンロードして続行。");
        hashMap.put("ko", "계속하여 다운로드하세요");
        hashMap.put("nl", "Ga door met downloaden");
        hashMap.put("no", "Fortsett med nedlastingen");
        hashMap.put("pl", "Kontynuuj pobieranie");
        hashMap.put("pt", "Continue o download");
        hashMap.put("ro", "Continuaţi descărcarea");
        hashMap.put("ru", "Продолжайте, чтобы загрузить его");
        hashMap.put("sv", "Fortsätt för att ladda ner");
        hashMap.put("th", "ดำเนินการต่อไปเพื่อดาวน์โหลด");
        hashMap.put("tr", "Devam edin ve indirin");
        hashMap.put("uk", "Продовжуйте, щоб завантажити її");
        hashMap.put("vi", "Tiếp tục để tải về");
        hashMap.put("zh-rCN", "继续下载。");
        hashMap.put("zh-rTW", "繼續下載。");
        return hashMap;
    }
}
