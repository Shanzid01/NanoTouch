package com.slideme.sam.manager.model.data.cache;

import android.content.SearchRecentSuggestionsProvider;

public class SamSuggestionProvider extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY = "com.slideme.sam.manager.SamSuggestionProvider";
    public static final int MODE = 1;

    public SamSuggestionProvider() {
        setupSuggestions(AUTHORITY, 1);
    }
}
