package p006b.p007a.p008a.p009a.p010a.p012b;

import com.google.android.gms.games.quest.Quests;

/* compiled from: IdManager */
public enum aa {
    WIFI_MAC_ADDRESS(1),
    BLUETOOTH_MAC_ADDRESS(2),
    FONT_TOKEN(53),
    ANDROID_ID(100),
    ANDROID_DEVICE_ID(Quests.SELECT_COMPLETED_UNCLAIMED),
    ANDROID_SERIAL(102),
    ANDROID_ADVERTISING_ID(Quests.SELECT_RECENTLY_FAILED);
    
    public final int protobufIndex;

    private aa(int i) {
        this.protobufIndex = i;
    }
}
