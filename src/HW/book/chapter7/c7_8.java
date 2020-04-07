package chapter7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class c7_8 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		HashMap<String, Integer> pointMgmt = new HashMap<String, Integer>();
		System.out.println("** 포인트 관리 프로그램입니다 **");
		
		while(true) {
			System.out.print("이름과 포인트 입력>> ");
			String name = scan.next();
			if(name.equals("그만")) break;
			int point = scan.nextInt();
			if(pointMgmt.get(name)==null)	pointMgmt.put(name, point);
			else pointMgmt.put(name, point+pointMgmt.get(name));
			
			Set<String> key = pointMgmt.keySet();
			Iterator<String> it = key.iterator();
			while(it.hasNext()) {
				String who = it.next();
				Integer sum = pointMgmt.get(who);
				System.out.printf("(%s,%d)",who,sum);
			}
			System.out.println();
			
			
		}
	}
}
