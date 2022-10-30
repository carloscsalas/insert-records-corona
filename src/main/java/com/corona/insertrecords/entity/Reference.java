package com.corona.insertrecords.entity;

import java.io.Serializable;

public class Reference  implements Serializable {

    public Reference(Integer position, String transactionOrigin) {
        this.position = position;
        this.transactionOrigin = transactionOrigin;
    }

    public Reference() {
    }

    private Integer position;
    private String transactionOrigin;

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

    @Override
    public String toString() {
        return "Reference{" +
                "position=" + position +
                ", transactionOrigin='" + transactionOrigin + '\'' +
                '}';
    }
}
