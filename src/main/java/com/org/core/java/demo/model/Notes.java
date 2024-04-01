package com.org.core.java.demo.model;

import java.util.Objects;

public class Notes {
    private int id;
    private String tagName;
    private long tagId;

    public Notes(){}

    public Notes(int id, String tagName, long tagId) {
        this.id = id;
        this.tagName = tagName;
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notes notes)) return false;
        return getId() == notes.getId() && getTagId() == notes.getTagId() && Objects.equals(getTagName(), notes.getTagName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTagName(), getTagId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

}
