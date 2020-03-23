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
		// 월, 일을 입력 받고 월, 일의 100일 후를 출력하세요
		// 월입력: 11 
		// 일입력: 30
		// >> 11월 30일의 100일 후는 3월 9일입니다
		
		/* 100-(n월의 일수-일)-n+1월의 일수 < 0
		 * n+i가 12면 1부터 
		 */
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
		//월, 일을 입력 받아서 1년의 남은 날짜를 계산 for-each 쓰지 말 것
		
		/* ex.
		 * 10월  11 12 10번~10+1번
		 * days[month]+days[x] 
		 */
		
		System.out.printf("월 입력: ");
		month = scan.nextInt();
		System.out.printf("일 입력: ");
		day = scan.nextInt();
	
		total = days[month-1] - day;
		for(int i=1 ; i+month<=12; i++) {
			total += days[i+month-1];
		}
		
		System.out.printf("올해는 %d일 남았습니다.", total);
		
	}
	
	public static void test1(String[] args) {
		//total에 days의 요소값을 저장해서 "1년은 365일입니다" 출력
		
		for(int d : days){
			total += d;
		}
		System.out.printf("1년은 %d월입니다\n", days.length);
		System.out.printf("1년은 %d일입니다\n", total);

	}
}
