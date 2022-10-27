package com.corona.insertrecords.entity;

import java.time.LocalDateTime;

public class MethodParametryDTO {

    private Integer parameter_method_num_id;
    private String items_comparison_method_type;
    private Integer item_first_ref_star_pos_number;
    private String item_first_ref_format_desc;
    private String item_first_origin_type;
    private Integer item_secnd_ref_star_pos_number;
    private String item_second_ref_format_desc;
    private String item_second_origin_type;
    private Integer format_length_number;
    private String parametry_method_desc;
    private LocalDateTime method_value_time_date;
    private String creation_user_id;
    private LocalDateTime creation_date;
    private String user_audit_id;
    private LocalDateTime audit_date;

    public Integer getParameter_method_num_id() {
        return parameter_method_num_id;
    }

    public void setParameter_method_num_id(Integer parameter_method_num_id) {
        this.parameter_method_num_id = parameter_method_num_id;
    }

    public String getItems_comparison_method_type() {
        return items_comparison_method_type;
    }

    public void setItems_comparison_method_type(String items_comparison_method_type) {
        this.items_comparison_method_type = items_comparison_method_type;
    }

    public Integer getItem_first_ref_star_pos_number() {
        return item_first_ref_star_pos_number;
    }

    public void setItem_first_ref_star_pos_number(Integer item_first_ref_star_pos_number) {
        this.item_first_ref_star_pos_number = item_first_ref_star_pos_number;
    }

    public String getItem_first_ref_format_desc() {
        return item_first_ref_format_desc;
    }

    public void setItem_first_ref_format_desc(String item_first_ref_format_desc) {
        this.item_first_ref_format_desc = item_first_ref_format_desc;
    }

    public String getItem_first_origin_type() {
        return item_first_origin_type;
    }

    public void setItem_first_origin_type(String item_first_origin_type) {
        this.item_first_origin_type = item_first_origin_type;
    }

    public Integer getItem_secnd_ref_star_pos_number() {
        return item_secnd_ref_star_pos_number;
    }

    public void setItem_secnd_ref_star_pos_number(Integer item_secnd_ref_star_pos_number) {
        this.item_secnd_ref_star_pos_number = item_secnd_ref_star_pos_number;
    }

    public String getItem_second_ref_format_desc() {
        return item_second_ref_format_desc;
    }

    public void setItem_second_ref_format_desc(String item_second_ref_format_desc) {
        this.item_second_ref_format_desc = item_second_ref_format_desc;
    }

    public String getItem_second_origin_type() {
        return item_second_origin_type;
    }

    public void setItem_second_origin_type(String item_second_origin_type) {
        this.item_second_origin_type = item_second_origin_type;
    }

    public Integer getFormat_length_number() {
        return format_length_number;
    }

    public void setFormat_length_number(Integer format_length_number) {
        this.format_length_number = format_length_number;
    }

    public String getParametry_method_desc() {
        return parametry_method_desc;
    }

    public void setParametry_method_desc(String parametry_method_desc) {
        this.parametry_method_desc = parametry_method_desc;
    }

    public LocalDateTime getMethod_value_time_date() {
        return method_value_time_date;
    }

    public void setMethod_value_time_date(LocalDateTime method_value_time_date) {
        this.method_value_time_date = method_value_time_date;
    }

    public String getCreation_user_id() {
        return creation_user_id;
    }

    public void setCreation_user_id(String creation_user_id) {
        this.creation_user_id = creation_user_id;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public String getUser_audit_id() {
        return user_audit_id;
    }

    public void setUser_audit_id(String user_audit_id) {
        this.user_audit_id = user_audit_id;
    }

    public LocalDateTime getAudit_date() {
        return audit_date;
    }

    public void setAudit_date(LocalDateTime audit_date) {
        this.audit_date = audit_date;
    }

    @Override
    public String toString() {
        return "MethodParametryDTO{" +
                "parameter_method_num_id=" + parameter_method_num_id +
                ", items_comparison_method_type='" + items_comparison_method_type + '\'' +
                ", item_first_ref_star_pos_number=" + item_first_ref_star_pos_number +
                ", item_first_ref_format_desc='" + item_first_ref_format_desc + '\'' +
                ", item_first_origin_type='" + item_first_origin_type + '\'' +
                ", item_secnd_ref_star_pos_number=" + item_secnd_ref_star_pos_number +
                ", item_second_ref_format_desc='" + item_second_ref_format_desc + '\'' +
                ", item_second_origin_type='" + item_second_origin_type + '\'' +
                ", format_length_number=" + format_length_number +
                ", parametry_method_desc='" + parametry_method_desc + '\'' +
                ", method_value_time_date=" + method_value_time_date +
                ", creation_user_id='" + creation_user_id + '\'' +
                ", creation_date=" + creation_date +
                ", user_audit_id='" + user_audit_id + '\'' +
                ", audit_date=" + audit_date +
                '}';
    }
}
