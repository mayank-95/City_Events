package com.mayank.ok.events.adapter;

import android.widget.TextView;

public class EventModel {

    private String title,date,description,location,creator,id;

    public EventModel()
    {

    }

    public EventModel(String id,String title, String date, String description, String location, String creator) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.location = location;
        this.creator = creator;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getCreator() {
        return creator;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }


}
