package com.bit.demo.carpark.model;

public class Car {

	private String no;
	private int intime;
	private int outtime;
	
	public int getOuttime() {
		return this.outtime;
	}
	public void setOuttime(int outTime) {
		this.outtime = outTime;
	}
	public String getNo() {
		return this.no;
	}
	public void setNo(String carno) {
		this.no = carno;
	}

	@Override
	public String toString(){
		String s = "";
		s += no + ": ";
		s += intime + " - ";
		s += outtime;
		return s;
	}
	public void setIntime(int inTime2) {
		// TODO Auto-generated method stub
		this.intime = inTime2;
	}
	public int getIntime() {
		// TODO Auto-generated method stub
		return this.intime;
	}

}
