package com.corona.insertrecords.entity;



public class ResponseDto {

    private Integer id;
    private String description;

    private String table;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", table='" + table + '\'' +
                '}';
    }
}
