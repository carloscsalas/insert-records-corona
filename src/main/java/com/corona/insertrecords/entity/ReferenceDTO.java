package com.corona.insertrecords.entity;


import java.io.Serializable;

public class ReferenceDTO implements Serializable {

    private Integer position;
    private String transactionOrigin;
    private FormatDTO format;

    public ReferenceDTO(Integer position, String transactionOrigin, FormatDTO format) {
        this.position = position;
        this.transactionOrigin = transactionOrigin;
        this.format = format;
    }

    public ReferenceDTO() {
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTransactionOrigin() {
        return transactionOrigin;
    }

    public void setTransactionOrigin(String transactionOrigin) {
        this.transactionOrigin = transactionOrigin;
    }

    public FormatDTO getFormat() {
        return format;
    }

    public void setFormat(FormatDTO format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "ReferenceDTO{" +
                "position=" + position +
                ", transactionOrigin='" + transactionOrigin + '\'' +
                ", format=" + format +
                '}';
    }
}
