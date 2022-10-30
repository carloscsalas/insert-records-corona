package com.corona.insertrecords.entity;


import java.io.Serializable;

public class ParameterTypeDTO  implements Serializable {

	public ParameterTypeDTO() {
	}

	public ParameterTypeDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	private String id;
	private String name;

	public String getId() {
		return id;
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
		return "ParameterTypeDTO{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
