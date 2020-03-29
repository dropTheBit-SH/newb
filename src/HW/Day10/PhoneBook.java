package day10;

import java.util.*;

class People {
	private int idx;
	private String name;
	private String phone;

	public People(){
		this(0, "no-name", "no-phoe");
	}
	
	public People(int idx, String name, String phone){
		this.idx = idx;
		this.name = name;
		this.phone = phone;
	}
	
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

}

class MenuSwitching{
	private int no = 0;
	
}
class DoSomething{
	
}

public class PhoneBook {

	public static final int MAX = 100;
	private People[] pArr = new People[MAX];
	private int idx = 0; 
	private int delIdx = 0;
	
	private String inputStr = "";
	private int inputInt = 0;
	public static final Scanner scan = new Scanner(System.in);
	
	public PhoneBook() {
		
	}
	
	public static void main(String[] args) {
		PhoneBook mypb = new PhoneBook();
		mypb.();
	}
	
	
		
}
