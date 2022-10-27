package com.corona.insertrecords.entity;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class ConditionParametryDTO {

    private Integer parameter_condition_num_id;
    private String parametry_type;
    private String amount_condition_type;
    private String value_date_condition_type;
    private String in_our_favr_amdf_cond_ind_type;
    private String result_type;
    private Integer ex_rg_date_vl_diff_days_number;
    private Double items_difference_limit_amount;
    private LocalDateTime condition_vldy_limit_date;
    private Double max_amount;
    private String condition_status_ind_type;
    private String creation_user_id;
    private LocalDateTime creation_date;
    private String user_audit_id;
    private LocalDateTime audit_date;

    public Integer getParameter_condition_num_id() {
        return parameter_condition_num_id;
    }

    public void setParameter_condition_num_id(Integer parameter_condition_num_id) {
        this.parameter_condition_num_id = parameter_condition_num_id;
    }

    public String getParametry_type() {
        return parametry_type;
    }

    public void setParametry_type(String parametry_type) {
        this.parametry_type = parametry_type;
    }

    public String getAmount_condition_type() {
        return amount_condition_type;
    }

    public void setAmount_condition_type(String amount_condition_type) {
        this.amount_condition_type = amount_condition_type;
    }

    public String getValue_date_condition_type() {
        return value_date_condition_type;
    }

    public void setValue_date_condition_type(String value_date_condition_type) {
        this.value_date_condition_type = value_date_condition_type;
    }

    public String getIn_our_favr_amdf_cond_ind_type() {
        return in_our_favr_amdf_cond_ind_type;
    }

    public void setIn_our_favr_amdf_cond_ind_type(String in_our_favr_amdf_cond_ind_type) {
        this.in_our_favr_amdf_cond_ind_type = in_our_favr_amdf_cond_ind_type;
    }

    public String getResult_type() {
        return result_type;
    }

    public void setResult_type(String result_type) {
        this.result_type = result_type;
    }

    public Integer getEx_rg_date_vl_diff_days_number() {
        return ex_rg_date_vl_diff_days_number;
    }

    public void setEx_rg_date_vl_diff_days_number(Integer ex_rg_date_vl_diff_days_number) {
        this.ex_rg_date_vl_diff_days_number = ex_rg_date_vl_diff_days_number;
    }

    public Double getItems_difference_limit_amount() {
        return items_difference_limit_amount;
    }

    public void setItems_difference_limit_amount(Double items_difference_limit_amount) {
        this.items_difference_limit_amount = items_difference_limit_amount;
    }

    public LocalDateTime getCondition_vldy_limit_date() {
        return condition_vldy_limit_date;
    }

    public void setCondition_vldy_limit_date(LocalDateTime condition_vldy_limit_date) {
        this.condition_vldy_limit_date = condition_vldy_limit_date;
    }

    public Double getMax_amount() {
        return max_amount;
    }

    public void setMax_amount(Double max_amount) {
        this.max_amount = max_amount;
    }

    public String getCondition_status_ind_type() {
        return condition_status_ind_type;
    }

    public void setCondition_status_ind_type(String condition_status_ind_type) {
        this.condition_status_ind_type = condition_status_ind_type;
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
        return new StringJoiner(", ", ConditionParametryDTO.class.getSimpleName() + "[", "]")
                .add("parameter_condition_num_id=" + parameter_condition_num_id)
                .add("parametry_type='" + parametry_type + "'")
                .add("amount_condition_type='" + amount_condition_type + "'")
                .add("value_date_condition_type='" + value_date_condition_type + "'")
                .add("in_our_favr_amdf_cond_ind_type='" + in_our_favr_amdf_cond_ind_type + "'")
                .add("result_type='" + result_type + "'")
                .add("ex_rg_date_vl_diff_days_number=" + ex_rg_date_vl_diff_days_number)
                .add("items_difference_limit_amount=" + items_difference_limit_amount)
                .add("condition_vldy_limit_date=" + condition_vldy_limit_date)
                .add("max_amount=" + max_amount)
                .add("condition_status_ind_type='" + condition_status_ind_type + "'")
                .add("creation_user_id='" + creation_user_id + "'")
                .add("creation_date=" + creation_date)
                .add("user_audit_id='" + user_audit_id + "'")
                .add("audit_date=" + audit_date)
                .toString();
    }
}
