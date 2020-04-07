package chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class c7_5 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Student[] stdArr = new Student[4];
		HashMap<String, Student> stdMgmt = new HashMap<String, Student>();
		System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
		for(int i=0; i<stdArr.length; i++) {
			System.out.print(">> ");
			StringTokenizer st = new StringTokenizer(scan.nextLine(), ",");
			String name = st.nextToken();
			String major = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
			double grade = Double.parseDouble(st.nextToken());
			stdArr[i] = new Student(name,major,number,grade);
			stdMgmt.put(name,stdArr[i]);
		}
		Set<String> key = stdMgmt.keySet();
		Iterator<String> it = key.iterator();
		while(it.hasNext()) {
			System.out.println("----------------------------");
			System.out.println(stdMgmt.get(it.next()).toString());
		}
		System.out.println("----------------------------");
		
		while(true) {
			System.out.print("학생 이름>> ");
			String name = scan.next();
			if(name.equals("그만")) break;
			Student std = stdMgmt.get(name);
			if(stdMgmt.get(name).getName().equals(name)) {
				System.out.println(stdMgmt.get(name).getName()+" "+stdMgmt.get(name).getMajor()+" "+stdMgmt.get(name).getNumber()+" "+stdMgmt.get(name).getGrade());
			}
		}
	}
	
	public static void Q5_1(String[] args) {
		Student[] stdArr = new Student[4];
		ArrayList<Student> stdMgmt = new ArrayList<Student>();
		System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
		for(int i=0; i<stdArr.length; i++) {
			System.out.print(">> ");
			StringTokenizer st = new StringTokenizer(scan.nextLine(), ",");
			String name = st.nextToken();
			String major = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
			double grade = Double.parseDouble(st.nextToken());
			stdArr[i] = new Student(name,major,number,grade);
			stdMgmt.add(stdArr[i]);
		}
		for(int i=0; i<stdMgmt.size(); i++) {
			System.out.println("----------------------------");
			System.out.println(stdArr[i].toString());
		}
		System.out.println("----------------------------");
		
		while(true) {
			System.out.print("학생 이름>> ");
			String name = scan.next();
			if(name.equals("그만")) break;
			for(int i=0; i<stdMgmt.size(); i++) {
				if(stdMgmt.get(i).getName().equals(name)) {
					System.out.println(stdMgmt.get(i).getName()+" "+stdMgmt.get(i).getMajor()+" "+stdMgmt.get(i).getGrade()+" "+stdMgmt.get(i).getNumber());
				}
			}
		}
	}
}

class Student{
	private String name;
	private String major;
	private int number;
	private double grade;
	public Student(String name, String major, int number, double grade) {
		this.name = name;
		this.major = major;
		this.number = number;
		this.grade = grade;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "이름: "+name+"\n학과: "+major+"\n학번: "+number+"\n학점평균: "+grade;
	}
}
