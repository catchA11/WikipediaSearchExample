package com.wiki.enums;

import java.util.HashMap;
import java.util.Map;

public enum Language {
    ENGLISH("English", "en", "car"),
    FRENCH("French", "fr", "voiture");

    private String description;
    private String languageCode;
    private String searchText;

    Language(String description, String languageCode, String searchText) {
        this.description = description;
        this.languageCode = languageCode;
        this.searchText = searchText;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public String getSearchText() {
        return searchText;
    }

    private static final Map<String, Language> lookup = new HashMap<>();

    static {
        for (Language language : Language.values()) {
            lookup.put(language.getDescription(), language);
        }
    }

    public static Language lookUp(String description) {
        return lookup.get(description);
    }
}
