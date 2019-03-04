package com.slideme.sam.manager.model.data;

import java.util.List;

@Deprecated
public class ScorecardData {
    public int bug_free;
    public int download;
    public int full_screen;
    public int installation;
    public int loading;
    public int malware_free;
    public String packages;
    public int quality;
    public int run_test;
    public int screen_rotation;
    public int stability;

    public static ScorecardData fromList(List<Integer> list) {
        ScorecardData scorecardData = new ScorecardData();
        scorecardData.download = ((Integer) list.get(0)).intValue();
        scorecardData.installation = ((Integer) list.get(2)).intValue();
        scorecardData.loading = ((Integer) list.get(2)).intValue();
        scorecardData.full_screen = ((Integer) list.get(3)).intValue();
        scorecardData.screen_rotation = ((Integer) list.get(4)).intValue();
        scorecardData.malware_free = ((Integer) list.get(5)).intValue();
        scorecardData.bug_free = ((Integer) list.get(6)).intValue();
        scorecardData.run_test = ((Integer) list.get(7)).intValue();
        scorecardData.stability = ((Integer) list.get(8)).intValue();
        scorecardData.quality = ((Integer) list.get(9)).intValue();
        return scorecardData;
    }
}
