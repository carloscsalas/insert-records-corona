package com.corona.insertrecords.entity;


import java.io.Serializable;

public class DateConditionDTO implements Serializable {

	public DateConditionDTO(String value, Long intervalDays) {
		this.value = value;
		this.intervalDays = intervalDays;
	}

	public DateConditionDTO() {
	}

	private String value;
	private Long intervalDays;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getIntervalDays() {
		return intervalDays;
	}

	public void setIntervalDays(Long intervalDays) {
		this.intervalDays = intervalDays;
	}

	@Override
	public String toString() {
		return "DateConditionDTO{" +
				"value='" + value + '\'' +
				", intervalDays=" + intervalDays +
				'}';
	}
}
