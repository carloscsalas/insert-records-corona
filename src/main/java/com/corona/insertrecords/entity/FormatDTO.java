package com.corona.insertrecords.entity;

import java.io.Serializable;

public class FormatDTO  implements Serializable {

    private String value;
    private Integer size;

    public String getValue() {
        return value;
    }

    public FormatDTO(String value, Integer size) {
        this.value = value;
        this.size = size;
    }

    public FormatDTO() {
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FormatDTO{" +
                "value='" + value + '\'' +
                ", size=" + size +
                '}';
    }
}
