package com.wiki.enums;

import java.util.HashMap;
import java.util.Map;

public enum Language {
    ENGLISH("English", "en", "English", "house"),
    FRENCH("French", "fr", "Français", "maison"),
    GERMAN("German", "de", "Deutsch", "haus");

    private String name;
    private String code;
    private String linkTitle;
    private String searchText;

    Language(String name, String code, String linkTitle, String searchText) {
        this.name = name;
        this.code = code;
        this.linkTitle = linkTitle;
        this.searchText = searchText;
    }

    public String getName() { return name; }

    public String getCode() { return code; }

    public String getLinkTitle() { return linkTitle; }

    public String getSearchText() { return searchText; }

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
