package com.corona.insertrecords.entity;

import java.util.StringJoiner;

public class RequestDto {

   private String table_name;

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RequestDto.class.getSimpleName() + "[", "]")
                .add("table_name='" + table_name + "'")
                .toString();
    }
}
