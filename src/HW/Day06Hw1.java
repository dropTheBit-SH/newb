package day06;
import java.util.Scanner;
public class Day06Hw1 {
	static Scanner scan = new Scanner(System.in);
	
	static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int month = 0;
	static int day = 0;
	static int resultDay = 0;
	static int total = 0;
	
	public static void main(String[] args) {
		// 기준일로부터 n일 후 계산
		int dDay = 0;
		int rMonth= 0;
		int rDay = 0;
		int rDday = 0;
		
		System.out.printf("월 입력: ");
		month = scan.nextInt();
		System.out.printf("일 입력: ");
		day = scan.nextInt();
		System.out.printf("남은 날짜: ");
		dDay = scan.nextInt();
		
		rDday = dDay;
		rMonth = month;
		rDay = day;
				
		while(dDay>=0) {
			dDay -= days[rMonth-1];
			if(dDay<0) {
				dDay += days[rMonth-1];
				break;
			}
			rMonth += rMonth==12? -11 : 1;
		}
		rDay += dDay;
		if(rDay > days[rMonth-1]) {
			rDay -= days[rMonth-1];
			rMonth += rMonth==12? -11 : 1;
		}
		System.out.printf("%d월 %d일의 %d일 후는 %d월 %d일입니다.\n", month, day, rDday, rMonth, rDay);
	
	}
	
	public static void test2(String[] args) {
		// 올해 남은 날 계산
		
		System.out.printf("월 입력: ");
		month = scan.nextInt();
		System.out.printf("일 입력: ");
		day = scan.nextInt();
	
		total = days[month-1] - day;
		for(int i=1 ; month+i<=12; i++) {
			total += days[month-1+i];
		}
		
		System.out.printf("올해는 %d일 남았습니다.", total);
		
	}
	
}
