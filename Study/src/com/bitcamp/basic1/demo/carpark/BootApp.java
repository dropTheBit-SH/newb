package com.bit.demo.carpark;

import java.util.Scanner; //import java.util.*; util안의 모든 내용 (폴더가 달라서 불러오는것)
import com.bit.demo.carpark.model.Car; //명시적으로 선언하여 다른 패키지의 파일을 불러온다

/** (별두개 문서화 작업시 용이)
 * java 프로그래밍의 시작은 class를 만드는 것부터
 * 클래스{필드, 메서드}
 * 퍼블릭 메서드
 * 필드 프라이빗
 * @author BIT02-23

 */
public class BootApp {
	/** 콘솔에서 시작하기 위한 함수 main
	 * public: 공개
	 * static: 정적, 클래스멤버, 클래스명.main(클래스명에 점찍어서 사용하는 것을 인스턴스를 생성하지 않고 사용한다고 표현)
	 * 			(인스턴스를 만든다 = new 명령어 사용)
	 * void: 없음
	 * 
	 * main: 콘솔에서의 입출력을 모두 담당
	 * @param args:
	 * @return
	 */

	public static void main(String[] args) {
		
//		Service service = new Service(10, "car park"); //여러개의 경우 기본 생성자 필요
//		System.out.println(service);
		
		ParkService service = new ParkService();
		//초기화
		Scanner input = new Scanner(System.in); 
					//system.in 등은 변환이 필요하기 때문에 변환해주는 scanner 사용
					//스캐너라는 클래스, 클래스는 자료형, 데이터를 만들어야 읽고 쓰기 가능
					//input은 인스턴스 이름(스캐너라는 클래스의 자료형에 인풋이라는 인스턴스 변수)

		//실제 내용		
		while(true) {
			System.out.println("[1]In [2]Out [3]Exit >");
			String menu = input.nextLine(); //키보드 입력값 한 줄, string
			
			if(menu.equals("3")) { // equals는 좌우 문자열 비교(isEmpty는 길이 0 체크)
				System.out.println("ㅂㅂ");
				break;
			}
			
			
			if(menu.equals("2")) {
				System.out.println("요금 정산: 차 나갈 때");
				System.out.println("차량번호: ");
				String carno = input.nextLine();
				//검색: 나가는 차가 언제 들어왔는가 inTime
				Car car = service.getCar(carno); // object 클래스 안의 메서드 사용 가능, 종종 맞게 바꿔야 사용 가능(라이딩한다= 맞게 변환)
							           // 반환 - Car라고 하는 자료형은 없기 때문에 만들어야 한다
										// getCar 메서드, carno 식별값 (-> 필드로)
				
//				int inTime = car.getIntime; // double~ 뭐시기에서 car를 받기 때문에 불필요한 정보 2)
				
				/* 검색 기능!!
				 * 식별값 확인: null값? 유일한 값?
				 */
				
				if( car == null) { // outtime에서의 널값 에러를 주의하기 위해
					System.out.println("등록된 차량이 아닙니다.");
					
				}else {
					System.out.println("나가는 시간을 입력하세요");
					int outTime = Integer.parseInt(
							input.nextLine());
					car.setOuttime(outTime); // 지금 나가는 차의 시간정보를 저장
											 // 세터 만들기 + outtime 필드가 있구나
											 // null값 에러 조심 
					
					System.out.println("요금: ");
//					int diff = outTime - inTime;
					// 인타임값 아웃타임값의 전달
					double price = service.getPrice(car); //값의 반환: car를 준다 인타임과 아웃타임을 준다 1)
//					price += (diff/10) * 500;
					System.out.println(price); // System.out.println(service.getPrice(car)); 축약 가능
					
					System.out.println("기록 초기화");
							//나간 차량 기록 초기화(실제 주차장과의 차이점 주의, 기록을 비우는 과정 필요)
					service.outCome(car);
					
					
				}
			}
			
			
			if(menu.equals("1")) {
				Car car = new Car(); 
				
				System.out.println("시간 기록: 차 들어올 때");
				System.out.println("차량번호: ");
				
				String carno = input.nextLine();
				car.setNo(carno); // setNo라는 필드에 carno 저장
				
				System.out.println("들어온 시간: "); //사용자가 HHmm 숫자 입력
				int inTime = Integer.parseInt(
						input.nextLine());
						//좌인트 우스트링
						//점 아래 값들은 클래스에서 사용 할 수 있는 값들로 변환 없이 바로 사용
						//parseint 숫자열, radit 진수
				
				car.setIntime(inTime); 
//				int outTime = 0; // HHmm 자바에서는 기본형 변수는 기본값이 0
				
//				String s = " "; 카의 필드값
//				s += carno + "(차랑번호): ";
//				s += inTime + " (들어온 시간)- ";
//				s += outTime + "(나가는 시간)";  // 카의 필드값이라 삭제
				System.out.println(car);
				service.comeIn(car);
				
			}
		}
			

		//닫기 (연결 스트림을 닫아줘야함): 정리
		if(input != null) {input.close();} 
					//.을 찍어서 표현할 때에는 null이 아니어야 함!!!!
		
					
	}
	
	
}
