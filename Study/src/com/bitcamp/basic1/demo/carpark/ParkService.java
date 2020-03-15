package com.bit.demo.carpark;
//같은 패키지 내에서 import 선언이 있었다면 또 하지 않아도 된다
//서비스가 계산하고 확인하는 작업
import com.bit.demo.carpark.model.Car;

public class ParkService {
	
	
	private Space cardao; // 카타입의 배열(스페이스 안의 여러 개의 카) Data Access Object DAO
							// Space 클래스 타입의 cardao의 값은 null이기 때문에 인스턴스 생성 필요
	
	//private int nums; // 누적 등 값을 유지하려면 필드로 vs 함수 안에서 선언하면 계속 0값
	
	public ParkService() {
		cardao = new Space(20); // 주차장 최대 대수 
		
		/* 배열의 길이 두가지
		 * 최대 길이는 대괄호 값 (요소 번호 = 최대 길이 -1)
		 * 현재 길이는 직접 처리해야 한다(실제로 몇개 저장되었는가) / 변수를 따로 만들어 관리한다(배열에는 최대 길이 length 밖에 없음) 
		 */
	}
	
	public Car getCar(String carno) {
		
		return cardao.selectByNo(carno); // parkservic에서 getcar를 호출하면 null
		//selectbyno or indexifno 자료형 때문에 selectbyno
		
	}

	public double getPrice(Car car) {
		int inMint = car.getIntime()%100;
		inMint += car.getIntime()/100*60; 
				// 분을 추출, 시간만 추출하여 분으로 변환
		
		int outMint = car.getOuttime()%100;
		outMint += car.getOuttime()/100*60; 
		
		int diff = (outMint - inMint) / 10;
		return 5000+(diff*500);
	}
	
	/* 메서드를 만든다 = 행동, 처리를 만든다 = 일
	 * 필드 = 단편적인 값들
	 * 합쳐서 클래스
	 */
	

	// add append + 추가
	// insert + (null)저장
	
	public boolean comeIn(Car car) {  //index가 아닌 car 
		//저장하기 - space.car[] 
		
		return cardao.save(car); // 반환처리 필요(결과 보고) 
			// 저장못한 상태, 만차 
	}
	
	
	public boolean outCome(Car car) {
		int idx = cardao.indexOfNo(car.getNo()); // 차번호 주고 요소번호 (요소번호 찾기)
		cardao.clean(idx); // .clean int 타입 필요
		//cardao.clean(car.getNo()); 오버로딩의 개념, 여러 개의 함수 만들 수 있음
		//다른 모습, 같은 결과(단 구체적인 처리 내용은 다르다, 타입이 다르니까)
		
		return true;
	}
	
}
