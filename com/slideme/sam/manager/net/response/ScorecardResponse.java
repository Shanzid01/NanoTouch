package com.slideme.sam.manager.net.response;

import com.google.p043a.p044a.C0670c;
import com.slideme.sam.manager.model.data.test.ScoreCardItem;
import java.util.ArrayList;
import java.util.Iterator;

public class ScorecardResponse extends BaseNetworkResponse {
    public ArrayList<ScoreCardItem> developer;
    public ArrayList<ScoreCardItem> global;
    @C0670c(a = "_id")
    public String id;
    public String packageName;
    public ArrayList<ScoreCardItem> tester;
    public int uid;
    public long version;

    public static ScoreCardItem find(ArrayList<ScoreCardItem> arrayList, int i) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ScoreCardItem scoreCardItem = (ScoreCardItem) it.next();
            if (scoreCardItem.id == i) {
                return scoreCardItem;
            }
        }
        return null;
    }
}
