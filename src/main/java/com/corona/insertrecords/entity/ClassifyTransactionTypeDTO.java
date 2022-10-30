package com.corona.insertrecords.entity;


import java.io.Serializable;

public class ClassifyTransactionTypeDTO implements Serializable {


	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public ClassifyTransactionTypeDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public ClassifyTransactionTypeDTO() {
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassifyTransactionTypeDTO{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
