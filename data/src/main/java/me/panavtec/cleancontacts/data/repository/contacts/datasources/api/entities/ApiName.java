package me.panavtec.cleancontacts.data.repository.contacts.datasources.api.entities;

import com.google.gson.annotations.Expose;

public class ApiName {

    @Expose private String title;
    @Expose private String first;
    @Expose private String last;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
