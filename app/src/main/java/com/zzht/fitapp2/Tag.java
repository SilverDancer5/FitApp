package com.zzht.fitapp2;

public class Tag {
    private String tagName;
    private String value;

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Tag(String tagName, String defaultValue) {
        this.tagName = tagName;
        this.value = defaultValue;
    }

    public String getTagName() {
        return tagName;
    }

    public String getValue() {
        return value;
    }
}
