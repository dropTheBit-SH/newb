package com.bit.demo.carpark;

import com.bit.demo.carpark.model.Car;

public class Space {
	
	private Car[] carList;
	
	/* 배열에 대한 처리 CRUD
	 * 배열 안에 저장되는 각 데이터 - 요소
	 * 요소는 정수 번호로 구분되는데 [0] ~ [배열명.length-1] (요소 번호는 위치) 
	 * 요소명 = 배열명[번호]
	 * 배열과 for문 사용 빈도
	 */
	
	
	public Space (int size) { // 생성자를 직접 만들면 space()비어있는 매개변수는 자동으로 만들어지지 않는다
							 // VM이 자동으로 만들기도 함
		carList = new Car[size]; // 배열 고정 길이를 갖는다
	}
	
	public Car selectByNo(String no) { // 차 번호 검색해서 차 정보 반환
		int i = indexOfNo(no);

		if(i == -1) {
			return null;
		}
		
		return carList[i]; 
	}
	
	public int indexOfNo(String no) { // 차 번호를 검색하여 요소 번호 반환 
		for(int i=0; i<carList.length; ++i) { 
					
			if(carList[i] != null && 
					carList[i].getNo().equals(no)) { 
				// 배열의 요소는 car 참조형이다
				// i 참조형(클래스)를 다룰 때는 반드시 null 확인  !!!!!!!!
				// nullPointExecption 오류 주의
				
					// carList[i]: i번 요소 하나, getNo: 그 안의 차번호 
					// 차번호 스트링, 스트링끼리의 비교 이퀄스 
					// 상단의 이어지는 점이 체이닝(배열-카-스트링/점을 찍으면서 바뀌는 타입 주의)
				return i; 
			}
		}	
		return  -1;
	}
	

	private int isEmpty() {
		for(int i=0; i<carList.length; ++i) { // 요소번호를 의미하는 변수가 있기 때문에 for문 사용 (i가 요소변수)
			if(carList[i] == null) { // 빈공간이면
				return i; // 함수를 리턴하여 종료
			}
		}	
//		for(Car c : carList) {} // 번호의 개념이 없음	
		return  -1; // 만차에서는 리턴하여 종료 (-1은 요소번호에 해당하지 않는다)
	}
	
	
	// 주차장에 차가 들어왔다 (삽입)
	public boolean save(Car car) {
		boolean state = false; // boolean 초기값 설정
		int idx = isEmpty(); // 비어 있는 곳을 찾는다 (null값)
		if(idx > -1 ) { // 비어 있는 곳이 있을 때(if) / idx == -1 꽉참
			carList[idx] = car; // 비어 있는 곳에 주차해라
			state = true;
		}
		return state; // return 키워드 조금만 쓰기 
	}
	
	// 나간 차의 자리를 빈 자리로 만든다
	public void clean(int idx) { // 요소번호 idx를 아래에 준다
		carList[idx] = null; // 
	}
	
	public void clean(String no) {
		int idx = indexOfNo(no); 
		carList[idx] = null; 
		
	}

	
}
