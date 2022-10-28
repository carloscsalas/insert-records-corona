package com.corona.insertrecords.entity;

public class Corona {
    private Integer codigo;
    private String type_file;
    private String origin;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getType_file() {
        return type_file;
    }

    public void setType_file(String type_file) {
        this.type_file = type_file;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Corona{" +
                "codigo=" + codigo +
                ", type_file='" + type_file + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
