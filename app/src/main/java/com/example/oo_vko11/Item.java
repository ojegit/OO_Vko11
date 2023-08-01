package com.example.oo_vko11;

import java.sql.Time;

public class Item {

    private String text;
    private String timeCreated;

    public Item(String text) {this.text = text;}
    public Item(){}

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}
    public String getTimeCreated() {return timeCreated;}
    public void setTimeCreated(String timeCreated) {this.timeCreated = timeCreated;}
}
