package chapter7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

class Nation{
	private String country;
	private String capital;
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}
	public String getCountry() {
		return country;
	}
	public String getCapital() {
		return capital;
	}
}
public class c7_11 {
	//(2)
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		HashMap<String, String> cityMap = new HashMap<>();
		
		
		{
			cityMap.put("한국", "서울");
			cityMap.put("그리스", "아테네");
			cityMap.put("호주", "시드니");
			cityMap.put("이탈리아", "로마");
			cityMap.put("독일", "베를린");
			cityMap.put("멕시코", "멕시코시티");
			cityMap.put("영국", "런던");
			cityMap.put("중국", "베이징");
			cityMap.put("일본", "도쿄");
		}
		
		System.out.println("**** 수도 맞추기 게임을 시작합니다. *****");
		while(true){
			System.out.print("입력:1, 퀴즈:2, 종료:3 >> ");
			switch (scan.nextInt()) {
			case 1:
				System.out.printf("현재 %d개 나라와 수도가 입력되어 있습니다.\n", cityMap.size());
				while(true){
					System.out.printf("나라와 수도 입력%d>> ", cityMap.size()+1);
					String country = scan.next();
					if(country.equals("그만")) break;
					String capital = scan.next();
					cityMap.put(country, capital);
				}
				break;
			case 2:
				while(true){
					Set<String> keys = cityMap.keySet();
					Object[] arr = keys.toArray();
					int idx = rand.nextInt(arr.length);
					String country = (String)arr[idx] ;
					System.out.printf("%s의 수도는? ", country);
					String capital = scan.next();
					if(capital.equals("그만")) break;
					if(capital.equals(cityMap.get(country))){
						System.out.println("정답!!");
					}else{
						System.out.println("아닙니다!!");
					}
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				System.exit(0);
				break;
			}
		}
		
	}
	
	//(1)
	public static void test(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		Vector<Nation> v = new Vector<>();
		
		{
			v.add(new Nation("한국", "서울"));
			v.add(new Nation("그리스", "아테네"));
			v.add(new Nation("호주", "시드니"));
			v.add(new Nation("이탈리아", "로마"));
			v.add(new Nation("독일", "베를린"));
			v.add(new Nation("멕시코", "멕시코시티"));
			v.add(new Nation("영국", "런던"));
			v.add(new Nation("중국", "베이징"));
			v.add(new Nation("일본", "도쿄"));
		}
		
		System.out.println("**** 수도 맞추기 게임을 시작합니다. *****");
		while(true){
			System.out.print("입력:1, 퀴즈:2, 종료:3 >> ");
			switch (scan.nextInt()) {
			case 1:
				System.out.printf("현재 %d개 나라와 수도가 입력되어 있습니다.\n", v.size());
				while(true){
					System.out.printf("나라와 수도 입력%d>> ", v.size()+1);
					String country = scan.next();
					if(country.equals("그만")) break;
					String capital = scan.next();
					v.add(new Nation(country, capital));
				}
				break;
			case 2:
				while(true){
					int idx = rand.nextInt(v.size());
					String country = v.get(idx).getCountry();
					System.out.printf("%s의 수도는? ", country);
					String capital = scan.next();
					if(capital.equals("그만")) break;
					if(capital.equals(v.get(idx).getCapital())){
						System.out.println("정답!!");
					}else{
						System.out.println("아닙니다!!");
					}
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				System.exit(0);
				break;
			}
		}
		
	}
}

