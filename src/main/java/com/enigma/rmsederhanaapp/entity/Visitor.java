package com.enigma.rmsederhanaapp.entity;

public class Visitor {

    private Integer id;
    private String visitorName;

    public Visitor(Integer id, String visitorName) {
        this.id = id;
        this.visitorName = visitorName;
    }

    public Visitor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", visitorName='" + visitorName + '\'' +
                '}';
    }
}
