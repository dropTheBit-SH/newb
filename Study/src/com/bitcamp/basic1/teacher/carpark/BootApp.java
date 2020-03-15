package com.bit.demo.carpark;

import java.util.Scanner;

import com.bit.demo.carpark.model.Car;

/**
 * Java 프로그래밍의 시작은 class 를 만드는 것부터...
 * - 클래스 { 필드, 메서드 }
 * 	- 메서드 : 함수 - 동작, 처리
 * 	- 필드 : 메서드에서 처리할 자료(data)
 * @author BIT02-00
 *
 */
public class BootApp {

	/**
	 * 콘솔 환경에서 실행하기 위한 시작함수 - main
	 * - public : 공개
	 * - static : 정적, 클래스멤버, 클래스명.main() 으로 사용가능
	 * - void : 없음, 반환없음
	 * 
	 * 콘솔 입출력 담당
	 * @param args : 문자열 여러 개 ( 배열 )
	 * @return 
	 */
	public static void main(String[] args) {
		// 초기화
		ParkService service = new ParkService();
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("[1]In [2]Out [3]Exit > ");
			String menu = input.nextLine();
			if(menu.equals("3")) {
				System.out.println("잘 가");
				break;
			}
			if(menu.equals("2")) {
				System.out.println("요금 정산:차 나갈때");
				System.out.println("차량번호 : ");
				String carno = input.nextLine();
				// 검색 - inTime
				Car car = service.getCar( carno );
				if( car == null ) {
					System.out.println("등록된 차량이 아님...");
				}else {
					System.out.println("나시간");
					int outTime = Integer.parseInt(
							input.nextLine()
							);
					car.setOuttime(outTime);
					System.out.println("요금 : ");
					double price = service.getPrice(car);
					System.out.println(price);
					System.out.println("나갔네 청소하기");
					service.outCome(car);
				}
			}
			if(menu.equals("1")) {
				Car car = new Car();
				System.out.println("시간 기록:차 들어올때");
				System.out.println("차량번호 : ");
				String carno = input.nextLine();
				car.setNo(carno);
				// 사용자 HHmm 숫자 입력
				System.out.println("들시간 : ");
				int inTime = Integer.parseInt(
						input.nextLine());
				car.setIntime(inTime);
				System.out.println(car);//.toString()
				service.comeIn(car);
			}
		}// 실제 실행 내용 while

		// 닫기 : 정리
		if(input != null) { input.close();}
	}// main end

}
