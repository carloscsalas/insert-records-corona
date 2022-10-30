package com.corona.insertrecords.entity;

import java.io.Serializable;

public class StatusDTO implements Serializable {


    private String id;
    private String name;

    public StatusDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public StatusDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
