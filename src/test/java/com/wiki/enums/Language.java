package com.wiki.enums;

import java.util.HashMap;
import java.util.Map;

public enum Language {
    ENGLISH("English", "en", "car"),
    FRENCH("French", "fr", "voiture");

    private String name;
    private String code;
    private String searchText;

    Language(String name, String code, String searchText) {
        this.name = name;
        this.code = code;
        this.searchText = searchText;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSearchText() {
        return searchText;
    }

    private static final Map<String, Language> lookup = new HashMap<>();

    static {
        for (Language language : Language.values()) {
            lookup.put(language.getName(), language);
        }
    }

    public static Language lookUp(String description) {
        return lookup.get(description);
    }
}
