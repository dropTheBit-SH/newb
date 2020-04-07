package chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class c7_1to4 {
	static Scanner scan = new Scanner(System.in);

	public static void Q1(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		System.out.print("정수(-1이 입력될 때까지)>> ");
		while(true) {
			int input = scan.nextInt();
			if(input==-1) break;
			v.add(input);
		}
		int big = v.get(0);
		for(int i=1; i<v.size(); i++) {
			big = (big<v.get(i))? v.get(i) : big;
		}
		System.out.printf("가장 큰 수는 %d", big);
	}
	
	public static void Q2(String[] args) {
		ArrayList<Character> al = new ArrayList<Character>();
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/E/F)>> ");
		for(int i=0; i<6; i++) {
			al.add(scan.next().charAt(0));
		}
		double sum = 0;
		for(int i=0; i<6; i++) {
			switch(al.get(i)) {
			case 'A': sum += 4.0; break;
			case 'B': sum += 3.0; break;
			case 'C': sum += 2.0; break;
			case 'D': sum += 1.0; break;
			case 'F': sum += 0; break;
			}
		}
		System.out.println(sum/6);
	}
	
	public static void Q3(String[] args) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		System.out.println("나라 이름과 인구를 입력하세요.(예: Koera 5000)");
		while(true) {
			System.out.print("나라 이름, 인구 >> ");
			String nation = scan.next();
			if(nation.equals("그만")) break;
			Integer population = scan.nextInt();
			nations.put(nation, population);
		}
		while(true) {
			System.out.print("인구 검색 >> ");
			String nation = scan.next();
			if(nation.equals("그만")) break;
			if(nations.get(nation)!=null)
				System.out.printf("%s의 인구는 %d\n", nation, nations.get(nation));
			else	System.out.println(nation+" 나라는 없습니다.");
		}
	}
	
	public static void Q4(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		int sum = 0;
		while(true) {
			System.out.print("강수량 입력(0 입력시 종료)>> ");
			int amount = scan.nextInt();
			if(amount == 0) break;
			v.add(amount);
			sum += amount;
			for(int i=0; i<v.size(); i++)	System.out.print(v.get(i)+" ");
			System.out.printf("\n현재 평균 %d\n",sum/(v.size()));
		}
	}
}
