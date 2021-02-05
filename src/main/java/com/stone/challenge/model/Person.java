package com.stone.challenge.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("Items")
	@Expose
	private List<Item> items = null;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Person [email=" + email + ", id=" + id + ", items=" + items + "]";
	}

}
