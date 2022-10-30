package com.corona.insertrecords.entity;

import java.util.StringJoiner;

public class RequestDto {

   private String table_name;
   private String file_name;

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "table_name='" + table_name + '\'' +
                ", file_name='" + file_name + '\'' +
                '}';
    }
}
