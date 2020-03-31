package org.comstudy21.model;

public class People {
	private int idx;
	private String name;
	private String phone;
	// 持失切 識情
	public People() {
		this(0, "", "");
	}
	public People(int idx, String name, String phone) {
		this.idx = idx;
		this.name = name;
		this.phone = phone;
	}
	
	// setters, getters
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "People [idx=" + idx + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
