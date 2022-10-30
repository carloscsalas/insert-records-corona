package com.corona.insertrecords.entity;

import java.util.List;

public class RequestMethod {

    private ParameterTypeDTO parameterType;
    private String description;
    private String validityDate;
    private ClassifyTransactionTypeDTO classifyTransactionType;
    private List<ReferenceDTO> references;

    public ParameterTypeDTO getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterTypeDTO parameterType) {
        this.parameterType = parameterType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public ClassifyTransactionTypeDTO getClassifyTransactionType() {
        return classifyTransactionType;
    }

    public void setClassifyTransactionType(ClassifyTransactionTypeDTO classifyTransactionType) {
        this.classifyTransactionType = classifyTransactionType;
    }

    public List<ReferenceDTO> getReferences() {
        return references;
    }

    public void setReferences(List<ReferenceDTO> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "RequestMethod{" +
                "parameterType=" + parameterType +
                ", description='" + description + '\'' +
                ", validityDate='" + validityDate + '\'' +
                ", classifyTransactionType=" + classifyTransactionType +
                ", references=" + references +
                '}';
    }
}
