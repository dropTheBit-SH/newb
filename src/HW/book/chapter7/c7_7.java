package chapter7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class c7_7 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		HashMap<String, Double> scholarship = new HashMap<String, Double>();
		System.out.println("미래장학금관리시스템입니다.");
		for(int i=0; i<5; i++) {
			System.out.print("이름과 학점 >> ");
			String name = scan.next();
			Double score = scan.nextDouble();
			scholarship.put(name, score);
		}
		Set<String> key = scholarship.keySet();
		Iterator<String> it = key.iterator();
		
		System.out.print("장학생 선발 학점 기준 입력 >> ");
		double cutline = scan.nextDouble();
		System.out.print("장학생 명단: ");
		while(it.hasNext()) {
			String name = it.next();
			if(scholarship.get(name) > cutline) System.out.print(name+" ");
		}
		System.out.println();
		
	}
}
